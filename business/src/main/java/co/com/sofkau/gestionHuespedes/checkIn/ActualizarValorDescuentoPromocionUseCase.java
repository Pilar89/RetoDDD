package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.ActualizarValorDescuentoPromocion;


public class ActualizarValorDescuentoPromocionUseCase  extends UseCase<RequestCommand<ActualizarValorDescuentoPromocion>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarValorDescuentoPromocion> actualizarValorDescuentoPromocionRequestCommand) {
    var command = actualizarValorDescuentoPromocionRequestCommand.getCommand();
    var checkInId  = command.getCheckInId();
    var promocionId = command.getPromocionId();
    var descuento = command.getDescuento();
    var checkIn = CheckIn.from(checkInId, repository().getEventsBy(checkInId.value()));
    checkIn.actualizarValorDescuentoPromocion(promocionId,descuento);

    emit().onResponse(new ResponseEvents(checkIn.getUncommittedChanges()));
  }
}
