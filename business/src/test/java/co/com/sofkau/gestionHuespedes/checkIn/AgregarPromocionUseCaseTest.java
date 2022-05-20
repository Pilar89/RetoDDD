package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.commands.AgregarPromocion;
import co.com.sofkau.gestionHuespedes.checkIn.events.PromocionAgregada;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Descuento;
import co.com.sofkau.gestionHuespedes.checkIn.values.PromocionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarPromocionUseCaseTest {

  @InjectMocks
  private AgregarPromocionUseCase useCase;

  @Mock
  private DomainEventRepository repository;

  @Test
  void agregarPromocionHappyPass(){

    var checkInId = CheckInId.of("ksasaqq121");
    //Descuento
    var promocionId = PromocionId.of("dwed123");
    var nombrePromocion = new Nombre("Oferta dia de la madre");
    var descuento =  new Descuento(12.0);
    var command = new AgregarPromocion(checkInId,promocionId,nombrePromocion,descuento);

    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .setIdentifyExecutor(command.getCheckInId().value())
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();

    var promocionAgregada = (PromocionAgregada)events.get(0);
    Assertions.assertEquals("ksasaqq121", promocionAgregada.aggregateRootId());
    Assertions.assertEquals("Oferta dia de la madre",promocionAgregada.getNombre().value());
    Assertions.assertEquals(12.0,promocionAgregada.getDescuento().value());


  }


}
