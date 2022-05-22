package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;

public class ActualizarDisponibilidadHabitacionCheckInUseCase extends UseCase<TriggeredEvent<CheckInCreado>, ResponseEvents> {

  @Override
  public void executeUseCase(TriggeredEvent<CheckInCreado> checkInCreadoTriggeredEvent) {
    var checkinId = checkInCreadoTriggeredEvent.getDomainEvent().getCheckInId();
    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarDisponibilidadHabitacion(new Disponibilidad(true));
    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }

}
