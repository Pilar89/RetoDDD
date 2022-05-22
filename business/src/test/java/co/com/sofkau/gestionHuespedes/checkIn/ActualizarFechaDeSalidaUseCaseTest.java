package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarFechaDeSalida;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.FechaDeSalidaActualizada;
import co.com.sofkau.gestionHuespedes.checkIn.values.Categoria;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
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
class ActualizarFechaDeSalidaUseCaseTest {

  @InjectMocks
  private ActualizarFechaDeSalidaUseCase useCase;

  @Mock
  private DomainEventRepository repository;

  @Test
  void ActualizarMetodoDePagoHappyPass() {
    var checkInId = CheckInId.of("checkkk");
    var fechaSalida = new Fecha(LocalDateTime.now(),LocalDate.now());
    var command = new ActualizarFechaDeSalida(checkInId,fechaSalida);
    when(repository.getEventsBy("checkkk")).thenReturn(history());
    useCase.addRepository(repository);

    var events= UseCaseHandler.getInstance()
      .syncExecutor(useCase, new RequestCommand<>(command))
      .orElseThrow()
      .getDomainEvents();

    var event = (FechaDeSalidaActualizada)events.get(0);

    Assertions.assertEquals(fechaSalida.value().hora(),event.getFechaDeSalida().value().hora());
    Assertions.assertEquals(fechaSalida.value().dia(),event.getFechaDeSalida().value().dia());
  }

  private List<DomainEvent> history(){
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
