package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarDisponibilidadHabitacion;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarNombreHuesped;
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
class ActualizarDisponibilidadHabitacionUseCaseTest {

  @InjectMocks
  private ActualizarDisponibilidadHabitacionUseCase useCase;

  @Mock
  private DomainEventRepository repository;


  @Test
  void ActualizarDisponibilidadHabitacionHappyPass() {

    var checkinId = CheckInId.of("checkinId");
    var habitacionId = HabitacionHotelId.of("habitacionId");
    var disponibilidad = new Disponibilidad(true);
    var command = new ActualizarDisponibilidadHabitacion(checkinId, habitacionId, disponibilidad);

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
    var habitacion = new HabitacionHotel(habitacionId, categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var eventCheckin = new CheckInCreado(checkinId, habitacion, fecha, fecha, metodoDePago);

    return List.of(eventCheckin);
  }
}

