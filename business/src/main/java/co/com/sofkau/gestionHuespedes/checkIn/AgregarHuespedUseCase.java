package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.AgregarHuesped;

public class AgregarHuespedUseCase extends UseCase<RequestCommand<AgregarHuesped>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AgregarHuesped> agregarHuespedRequestCommandRequestCommand) {
    var command = agregarHuespedRequestCommandRequestCommand.getCommand();
    var checkIn = CheckIn.from(command.getCheckInId(),repository().getEventsBy(command.getCheckInId().value()));

    checkIn.agregarHuesped(command.getNombre(),command.getTelefono(),command.getDireccion(),command.getCorreo());
    emit().onResponse(new ResponseEvents(checkIn.getUncommittedChanges()));
  }
}
