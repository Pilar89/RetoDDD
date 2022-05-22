package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.checkIn.CheckIn;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;

public class ActualizarDisponibilidadHabitacionCheckOutUseCase extends UseCase<TriggeredEvent<CheckOutCreado>, ResponseEvents> {
  @Override
  public void executeUseCase(TriggeredEvent<CheckOutCreado> triggeredEvent) {
    var checkinId = triggeredEvent.getDomainEvent().getCheckInId();
    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarDisponibilidadHabitacion(new Disponibilidad(true));

    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }
}
