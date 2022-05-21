package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarDireccionhuesped;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarDisponibilidadHabitacion;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;

public class ActualizarDisponibilidadHabitacionUseCase extends UseCase<RequestCommand<ActualizarDisponibilidadHabitacion>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarDisponibilidadHabitacion> actualizarDisponibilidadHabitacion) {
    var command = actualizarDisponibilidadHabitacion.getCommand();
    var checkinId = command.getCheckInId();
    var habitacionId = command.getHabitacionHotelId();
    var disponibilidad = command.getDisponibilidad();

    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarDisponibilidadHabitacion(habitacionId, disponibilidad);

    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }
}
