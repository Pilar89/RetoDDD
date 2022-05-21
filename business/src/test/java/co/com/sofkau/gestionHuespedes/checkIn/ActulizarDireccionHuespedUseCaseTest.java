package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarDireccionhuesped;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.HuespedAgregado;
import co.com.sofkau.gestionHuespedes.checkIn.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActulizarDireccionHuespedUseCaseTest {

  @InjectMocks
  private ActulizarDireccionHuespedUseCase useCase;

  @Mock
  private DomainEventRepository repository;


  @Test
  void actualizarHuespedHappyPass() {

    var checkInId = CheckInId.of("checkinId");
    var huespedId = HuespedId.of("huespedId");
    var direccion = new Direccion("direccion");
    var command = new ActualizarDireccionhuesped(checkInId, huespedId, direccion);

    when(repository.getEventsBy("checkinId")).thenReturn(history());
    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .setIdentifyExecutor(command.getCheckInId().value())
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();


    var event = events.get(0);
    Assertions.assertNotNull(event);
  }

  private List<DomainEvent> history() {
    var checkinId = CheckInId.of("checkinId");
    var habitacionId = new HabitacionHotelId("HHHH");
    var categoria = new Categoria("Diamante");
    var habitacion = new HabitacionHotel(habitacionId,categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var eventCheckin =  new CheckInCreado(checkinId,habitacion,fecha,fecha,metodoDePago);

    var huespedId = HuespedId.of("huespedId");
    var nombre = new Nombre("nombre");
    var telefono = new Telefono("telefono");
    var direccion = new Direccion("direccion");
    var correo = new Correo("correo");
    var eventHuesped = new HuespedAgregado(checkinId, huespedId, nombre, telefono, direccion, correo);

    return List.of(eventCheckin, eventHuesped);
  }
}
