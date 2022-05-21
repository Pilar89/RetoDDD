package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.Cobro;
import co.com.sofkau.generic.values.CobroId;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkOut.Factura;
import co.com.sofkau.gestionHuespedes.checkOut.commands.AgregarCobro;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
import co.com.sofkau.gestionHuespedes.checkOut.events.CobroAgregadoAFactura;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;
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
class AgregarCobroUsecaseTest {

  @InjectMocks
  private AgregarCobroUsecase usecase;

  @Mock
  private DomainEventRepository repository;

  @Test
  void agregarCobroHappyPass() {
    CheckOutId checkOutId = CheckOutId.of("dwdmwk");
    FacturaId facturaId = FacturaId.of("lklkñlk");
    //Se ingresa un cobro por spa
    var cobroId = new CobroId("kdsads");
    var checkInId = new CheckInId("");
    var contratoServicioSpaId = new ContratoServicioSpaId("lklñlkñ");
    var costo = new Costo(10000.0);

    Cobro cobro = new Cobro(cobroId, checkInId, contratoServicioSpaId, costo);
    var command = new AgregarCobro(checkOutId, facturaId, cobro);

    when(repository.getEventsBy("dwdmwk")).thenReturn(history());
    usecase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .syncExecutor(usecase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();
    var event = (CobroAgregadoAFactura) events.get(0);
    Assertions.assertEquals(10000.0, event.getCosto().value());

  }

  @Test

  private List<DomainEvent> history() {

    var checkInId = new CheckInId("ckkkk");
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());

    //factura
    var facturaId = new FacturaId("800.197.268-4");
    var nombre = new Nombre("Consultores asociados");
    var factura = new Factura(facturaId, nombre);

    return List.of(new CheckOutCreado(checkInId, fecha, factura));

  }


}
