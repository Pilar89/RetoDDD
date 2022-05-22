package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarFechaDeSalida;

public class ActualizarFechaDeSalidaUseCase extends UseCase<RequestCommand<ActualizarFechaDeSalida>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarFechaDeSalida>actualizarFechaDeSalidaRequestCommand) {
    var command = actualizarFechaDeSalidaRequestCommand.getCommand();
    var checkIn = CheckIn.from(command.getCheckInId(), repository().getEventsBy(command.getCheckInId().value()));

    checkIn.actualizarFechaDeSalida(command.getFechaDeSalida());

    emit().onResponse(new ResponseEvents(checkIn.getUncommittedChanges()));
  }
}
