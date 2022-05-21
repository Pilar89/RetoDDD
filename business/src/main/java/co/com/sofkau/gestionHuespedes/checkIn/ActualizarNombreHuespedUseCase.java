package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarNombreHuesped;

public class ActualizarNombreHuespedUseCase extends UseCase<RequestCommand<ActualizarNombreHuesped>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarNombreHuesped> actualizarHuespedCommand) {
    var command = actualizarHuespedCommand.getCommand();
    var checkinId = command.getCheckInId();
    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarHuespedNombre(command.getHuespedId(), command.getNombre());

    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }
}
