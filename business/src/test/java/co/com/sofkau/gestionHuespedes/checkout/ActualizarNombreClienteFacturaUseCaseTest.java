package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.*;
import co.com.sofkau.gestionHuespedes.checkOut.Factura;
import co.com.sofkau.gestionHuespedes.checkOut.commands.ActualizarNombreClienteFactura;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreClienteFacturaUseCaseTest {

  @InjectMocks
  private ActualizarNombreClienteFacturaUseCase useCase;

  @Mock
  private DomainEventRepository repository;


  @Test
  void ActualizarDisponibilidadHabitacionHappyPass() {

    var checkOutId = CheckOutId.of("checkkk");
    var facturaId  = FacturaId.of("facturaId");
    var nombre = new Nombre("Consultores Asocioado");
    var command = new ActualizarNombreClienteFactura(checkOutId,facturaId,nombre);

    when(repository.getEventsBy("checkkk")).thenReturn(history());
    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .setIdentifyExecutor(command.getCheckOutId().value())
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();


    var event = events.get(0);
    Assertions.assertNotNull(event);
  }


  private List<DomainEvent> history() {
    var checkInId = new CheckInId("checkkk");
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());

    //factura
    var facturaId = new FacturaId("facturaId");
    var nombre = new Nombre("Consultores ltda");
    var factura = new Factura(facturaId, nombre);

    return List.of(new CheckOutCreado(checkInId, fecha, factura));
  }



}
