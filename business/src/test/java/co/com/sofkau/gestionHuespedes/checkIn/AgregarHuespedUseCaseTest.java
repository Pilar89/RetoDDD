package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.commands.AgregarHuesped;
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
class AgregarHuespedUseCaseTest {

  @InjectMocks
  private AgregarHuespedUseCase useCase;

  @Mock
  private DomainEventRepository repository;


  @Test
  void agregarHuespedHappyPass(){

    var checkInId = CheckInId.of("lkjas2232");
    //Huesped
    var nombre = new Nombre("Juan Perez");
    var telefono = new Telefono("983123012");
    var direccion = new Direccion("kr 12 32 3");
    var correo = new Correo("kl@gmail.com");

    var command = new AgregarHuesped(checkInId,nombre,telefono,direccion,correo);

    when(repository.getEventsBy("lkjas2232")).thenReturn(history());
    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .setIdentifyExecutor(command.getCheckInId().value())
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();


    var event = (HuespedAgregado)events.get(0);
    Assertions.assertEquals("Juan Perez",event.getNombre().value());
  }

  private List<DomainEvent>history(){

    var checkInId = CheckInId.of("checkkk");
    var habitacionId = new HabitacionHotelId("HHHH");
    var categoria = new Categoria("Diamante");
    var habitacion = new HabitacionHotel(habitacionId,categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var event =  new CheckInCreado(habitacion,fecha,fecha,metodoDePago);
    event.setAggregateRootId("kjjl1323");
    return List.of(event);



  }

}
