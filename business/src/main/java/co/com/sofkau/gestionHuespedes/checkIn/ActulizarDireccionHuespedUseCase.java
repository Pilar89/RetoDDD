package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarDireccionhuesped;


public class ActulizarDireccionHuespedUseCase  extends UseCase<RequestCommand<ActualizarDireccionhuesped>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarDireccionhuesped> actualizarDireccionhuespedRequestCommand) {
    var command = actualizarDireccionhuespedRequestCommand.getCommand();
    var checkinId = command.getCheckInId();
    var checkin = CheckIn.from(checkinId, repository().getEventsBy(checkinId.value()));
    checkin.actualizarHuespedDireccion(command.getHuespedId(), command.getDireccion());

    emit().onResponse(new ResponseEvents(checkin.getUncommittedChanges()));
  }
}
