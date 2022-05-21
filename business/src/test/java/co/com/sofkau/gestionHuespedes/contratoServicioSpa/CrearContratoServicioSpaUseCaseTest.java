package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.*;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands.CrearContratoServicioSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.ContratoServicioSpaCreado;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.EmpleadoSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.HabitacionSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ServicioSpaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearContratoServicioSpaUseCaseTest {
  private CrearContratoServicioSpaUseCase useCase;

  @BeforeEach
  public void setup() {
    useCase = new CrearContratoServicioSpaUseCase();
  }

  @Test
  public void crearContratoServicioSpaHappyPass() {
    var crearContratoServicioSpaId = ContratoServicioSpaId.of("sppppp");

    //ServicioSpa

    var nombreServicioSpa = new Nombre("terapias con agua");
    var costoServicioSpa = new Costo((double) 100000);
    var servicioSpaID = new ServicioSpaId("sssss");
    var servicioSpa = new ServicioSpa(servicioSpaID, nombreServicioSpa, costoServicioSpa);

    //EmpleadoSpa

    var empleadoSpaId = new EmpleadoSpaId("eeee");
    var nombreEmpleado = new Nombre("Maria");
    var empleadoSpa = new EmpleadoSpa(empleadoSpaId, nombreEmpleado);

    //habitacionHotelId

    var habitacionHotelId = new HabitacionHotelId("hssa");

    //habitacionSpa

    var habitacionSpaId = new HabitacionSpaId("aaagg");
    var nombreHabitacion = new Nombre("Cuarto de aguas");
    var habitacionSpa = new HabitacionSpa(habitacionSpaId, nombreHabitacion);

    var command = new CrearContratoServicioSpa(crearContratoServicioSpaId, servicioSpa, empleadoSpa, habitacionHotelId, habitacionSpa);

    var events = UseCaseHandler.getInstance()
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();

    var contratoServicioSpaCreado = (ContratoServicioSpaCreado) events.get(0);
    Assertions.assertEquals("sppppp", contratoServicioSpaCreado.aggregateRootId());
    Assertions.assertEquals("terapias con agua", contratoServicioSpaCreado.getServicioSpa().nombre.value());
    Assertions.assertEquals(100000.0, contratoServicioSpaCreado.getServicioSpa().costo.value());
    Assertions.assertEquals("Maria", contratoServicioSpaCreado.getEmpleadoSpa().nombre.value());
    Assertions.assertEquals("hssa", contratoServicioSpaCreado.getHabitacionId().value());
    Assertions.assertEquals("Cuarto de aguas", contratoServicioSpaCreado.getHabitacionSpa().nombre.value());


  }


}
