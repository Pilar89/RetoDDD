package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.commands.AgregarPromocion;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.PromocionAgregada;
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
class AgregarPromocionUseCaseTest {

  @InjectMocks
  private AgregarPromocionUseCase useCase;

  @Mock
  private DomainEventRepository repository;

  @Test
  void agregarPromocionHappyPass() {

    var checkInId = CheckInId.of("ksasaqq121");
    //Descuento
    var promocionId = PromocionId.of("dwed123");
    var nombrePromocion = new Nombre("Oferta dia de la madre");
    var descuento = new Descuento(12.0);
    var command = new AgregarPromocion(checkInId, promocionId, nombrePromocion, descuento);

    when(repository.getEventsBy("ksasaqq121")).thenReturn(history());
    useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
      .setIdentifyExecutor(command.getCheckInId().value())
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();

    var event = (PromocionAgregada) events.get(0);
    Assertions.assertEquals("Oferta dia de la madre", event.getNombre().value());

  }

  private List<DomainEvent> history() {
    var checkInId = CheckInId.of("checkkk");
    var habitacionId = new HabitacionHotelId("HHHH");
    var categoria = new Categoria("Diamante");
    var habitacion = new HabitacionHotel(habitacionId, categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var event = new CheckInCreado(checkInId, habitacion, fecha, fecha, metodoDePago);
    return List.of(event);
  }


}
