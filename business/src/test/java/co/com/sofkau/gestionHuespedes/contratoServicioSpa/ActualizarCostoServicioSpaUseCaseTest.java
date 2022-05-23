package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands.ActualizarCostoServicioSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.ContratoServicioSpaCreado;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.EmpleadoSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.HabitacionSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ServicioSpaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCostoServicioSpaUseCaseTest {

  @InjectMocks
  private ActualizarCostoServicioSpaUseCase useCase;

  @Mock
  private DomainEventRepository repository;


  @Test
  void ActualizarCostoServicioSpaHappyPass() {

    var contratoServicioSpaId = ContratoServicioSpaId.of("sssss");
    var servicioSpaId  = ServicioSpaId.of("sevicioSpaId");
    var costo = new Costo(120000.0);
    var command = new ActualizarCostoServicioSpa(contratoServicioSpaId,servicioSpaId,costo);

    when(repository.getEventsBy("sssss")).thenReturn(history());
    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .setIdentifyExecutor(command.getContratoServicioSpaId().value())
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();


    var event = events.get(0);
    Assertions.assertNotNull(event);
  }

  private List<DomainEvent> history() {


    //ServicioSpa
    var contratoServicioSpaId = ContratoServicioSpaId.of("sssss");
    var nombreServicioSpa = new Nombre("terapias con agua");
    var costoServicioSpa = new Costo((double) 100000);
    var servicioSpaID = new ServicioSpaId("sevicioSpaId");
    var servicioSpa = new ServicioSpa(servicioSpaID, nombreServicioSpa, costoServicioSpa);

    //EmpleadoSpa

    var empleadoId  = EmpleadoSpaId.of("empleadoId");
    var nombreEmpleado = new Nombre("Maria");
    var empleadoSpa = new EmpleadoSpa(empleadoId, nombreEmpleado);

    //habitacionHotelId

    var habitacionHotelId = new HabitacionHotelId("hssa");

    //habitacionSpa

    var habitacionSpaId = new HabitacionSpaId("aaagg");
    var nombreHabitacion = new Nombre("Cuarto de aguas");
    var habitacionSpa = new HabitacionSpa(habitacionSpaId, nombreHabitacion);


    var eventContratoServicioSpa = new ContratoServicioSpaCreado(servicioSpa,empleadoSpa,habitacionHotelId,habitacionSpa);
    return List.of(eventContratoServicioSpa);
  }



}
