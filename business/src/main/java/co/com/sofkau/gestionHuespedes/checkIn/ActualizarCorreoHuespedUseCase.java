package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarCorreohuesped;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarNombreHuesped;

public class ActualizarCorreoHuespedUseCase extends UseCase<RequestCommand<ActualizarCorreohuesped>, ResponseEvents> {
  @Override
  public void executeUseCase(RequestCommand<ActualizarCorreohuesped> actualizarCorreohuespedRequestCommand) {
    var command = actualizarCorreohuespedRequestCommand.getCommand();
    var checkinId = command.getCheckInId();
    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarHuespedCorreo(command.getHuespedId(), command.getCorreo());

    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }
}
