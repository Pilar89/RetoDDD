package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.AgregarPromocion;

public class AgregarPromocionUseCase extends UseCase<RequestCommand<AgregarPromocion>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AgregarPromocion> agregarPromocionRequestCommand) {
    var command = agregarPromocionRequestCommand.getCommand();
    var checkIn = CheckIn.from(command.getCheckInId(),repository().getEventsBy(command.getCheckInId().value()));
    checkIn.agregarPromocion(command.getNombre(),command.getDescuento());

    emit().onResponse(new ResponseEvents(checkIn.getUncommittedChanges()));
  }





}
