package co.com.sofkau.gestionHuespedes.checkout;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.HabitacionHotel;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.DisponibilidadHabitacionActualizada;
import co.com.sofkau.gestionHuespedes.checkIn.values.Categoria;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
import co.com.sofkau.gestionHuespedes.checkOut.Factura;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDisponibilidadHabitacionCheckOutUseCaseTest {

  @Mock
  private DomainEventRepository repository;

  @InjectMocks
  private ActualizarDisponibilidadHabitacionCheckOutUseCase useCase;

  @Test
  void actualizarDisponibilidadHabitacionHappyPass() {
    var checkInId = new CheckInId("checkInId");
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var facturaId = new FacturaId("facturaId");
    var nombre = new Nombre("nombreFactura");
    var factura = new Factura(facturaId, nombre);
    var event = new CheckOutCreado(checkInId, fecha, factura);

    when(repository.getEventsBy("checkInId")).thenReturn(history());
    useCase.addRepository(repository);
    var events = UseCaseHandler.getInstance()
      .syncExecutor(useCase, new TriggeredEvent<>(event))
      .orElseThrow()
      .getDomainEvents();

    var disponibilidadActualizadaEvent = (DisponibilidadHabitacionActualizada)events.get(0);
    Assertions.assertNotNull(disponibilidadActualizadaEvent);
  }

  private List<DomainEvent> history() {
    var checkinId = CheckInId.of("checkInId");
    var habitacionId = new HabitacionHotelId("HHHH");
    var categoria = new Categoria("Diamante");
    var habitacion = new HabitacionHotel(habitacionId, categoria);
    var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
    var metodoDePago = new MetodoDePago("Tarjeta devito");
    var eventCheckin = new CheckInCreado(checkinId, habitacion, fecha, fecha, metodoDePago);

    return List.of(eventCheckin);
  }
}
