package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.gestionHuespedes.checkIn.commands.CrearCheckIn;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.values.Categoria;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

class CrearCheckInUseCaseTest  {

  private CrearCheckInUseCase useCase;

  @BeforeEach
  public void setup(){
    useCase = new CrearCheckInUseCase();
  }

  @Test
  public void checkInHappyPass(){
    var checkInId = CheckInId.of("checkkk");
    var habitacionId = new HabitacionHotelId("HHHH");
    var categoria = new Categoria("Diamante");
    var habitacion = new HabitacionHotel(habitacionId,categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var command = new CrearCheckIn(checkInId,habitacion,fecha,fecha,metodoDePago);


    var events = UseCaseHandler.getInstance()
      .syncExecutor(useCase,new RequestCommand<>(command) )
      .orElseThrow()
      .getDomainEvents();

    var checkInCreado = (CheckInCreado)events.get(0);
    Assertions.assertEquals("checkkk",checkInCreado.aggregateRootId());
    Assertions.assertEquals("Diamante", checkInCreado.getHabitacion().categoria.value());
    Assertions.assertEquals("Tarjeta devito",checkInCreado.getMetodoDePago().value());


  }


}
