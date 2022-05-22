package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkOut.CheckOut;
import co.com.sofkau.gestionHuespedes.checkOut.commands.ActualizarNombreClienteFactura;

public class ActualizarNombreClienteFacturaUseCase extends UseCase<RequestCommand<ActualizarNombreClienteFactura>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarNombreClienteFactura> actualizarNombreClienteFacturaRequestCommand) {
    var command = actualizarNombreClienteFacturaRequestCommand.getCommand();
    var checkOutId  = command.getCheckOutId();
    var facturaId = command.getFacturaId();
    var nombre = command.getNombreCliente();
    var checkOut = CheckOut.form(checkOutId, repository().getEventsBy(checkOutId.value()));
    checkOut.actualizarNombreCienteFactura(facturaId,nombre);

    emit().onResponse(new ResponseEvents(checkOut.getUncommittedChanges()));
  }
}
