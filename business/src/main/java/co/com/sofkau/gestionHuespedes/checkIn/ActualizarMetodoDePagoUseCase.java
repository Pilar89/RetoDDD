package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarMetodoDePago;

public class ActualizarMetodoDePagoUseCase extends UseCase<RequestCommand<ActualizarMetodoDePago>, ResponseEvents>  {

  @Override
  public void executeUseCase(RequestCommand<ActualizarMetodoDePago> actualizarMetodoDePagoRequestCommand) {
    var command = actualizarMetodoDePagoRequestCommand.getCommand();
    var checkIn = CheckIn.from(command.getCheckInId(), repository().getEventsBy(command.getCheckInId().value()));

    checkIn.actualizarMetodoDePago(command.getMetodoDePago());

    emit().onResponse(new ResponseEvents(checkIn.getUncommittedChanges()));
  }


}
