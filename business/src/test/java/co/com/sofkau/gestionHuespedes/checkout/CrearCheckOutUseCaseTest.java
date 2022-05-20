package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkOut.Factura;
import co.com.sofkau.gestionHuespedes.checkOut.commands.CrearCheckOut;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearCheckOutUseCaseTest {

  private CrearCheckOutUseCase useCase;

  @BeforeEach
  public void setup(){
    useCase = new CrearCheckOutUseCase();
  }

  @Test
  public void crearCheckOutHappyPass(){
    var checkOutId = new CheckOutId("kssaaa");
    var checkInId = new CheckInId("ckkkk");
    var fecha =  new Fecha(LocalDateTime.now(), LocalDate.now());

    //factura
    var facturaId = new FacturaId("800.197.268-4");
    var nombre = new Nombre("Consultores asociados");
    var factura = new Factura(facturaId,nombre);
    var command = new CrearCheckOut(checkOutId,checkInId,fecha,factura);

    var events = UseCaseHandler.getInstance()
      .syncExecutor(useCase,new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();

    var checkOutCreado = (CheckOutCreado)events.get(0);
    Assertions.assertEquals("kssaaa",checkOutCreado.aggregateRootId());
    Assertions.assertEquals("ckkkk",checkOutCreado.getCheckInId().value());
    Assertions.assertEquals("Consultores asociados",checkOutCreado.getFactura().getNombre().value());


  }


}
