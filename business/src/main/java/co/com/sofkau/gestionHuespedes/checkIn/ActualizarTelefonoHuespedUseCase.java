package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarTelefonoHuesped;

public class ActualizarTelefonoHuespedUseCase extends UseCase<RequestCommand<ActualizarTelefonoHuesped>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarTelefonoHuesped> actualizarTelefonoHuespedRequestCommand) {
    var command =  actualizarTelefonoHuespedRequestCommand.getCommand();
    var checkinId = command.getCheckInId();
    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarHuespedTelefono(command.getHuespedId(),command.getTelefono());

    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }
}
