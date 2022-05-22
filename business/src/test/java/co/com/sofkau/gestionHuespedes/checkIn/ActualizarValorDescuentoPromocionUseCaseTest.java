package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.*;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarValorDescuentoPromocion;
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
class ActualizarValorDescuentoPromocionUseCaseTest {

  @InjectMocks
  private ActualizarValorDescuentoPromocionUseCase useCase;

  @Mock
  private DomainEventRepository repository;


  @Test
  void ActualizarDisponibilidadHabitacionHappyPass() {

    var checkInId = CheckInId.of("checkkk");
    var promocionId  = PromocionId.of("promocionId");
    var decuento = new Descuento(16.0);
    var command = new ActualizarValorDescuentoPromocion(checkInId,promocionId,decuento);


    when(repository.getEventsBy("checkkk")).thenReturn(history());
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
    var checkInId = CheckInId.of("checkkk");
    var habitacionId = new HabitacionHotelId("HHHH");
    var categoria = new Categoria("Diamante");
    var habitacion = new HabitacionHotel(habitacionId, categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var eventCheckIn = new CheckInCreado(checkInId, habitacion, fecha, fecha, metodoDePago);

    var promocionId = PromocionId.of("promocionId");
    var nombrePromocion = new Nombre("Dia de la madre");
    var descuento = new Descuento(17.0);
    var eventPromocion = new PromocionAgregada(promocionId,nombrePromocion,descuento);
    return List.of(eventCheckIn,eventPromocion);
  }


}
