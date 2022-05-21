package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkOut.CheckOut;
import co.com.sofkau.gestionHuespedes.checkOut.CobroFactory;
import co.com.sofkau.gestionHuespedes.checkOut.commands.AgregarCobro;

public class AgregarCobroUsecase extends UseCase<RequestCommand<AgregarCobro>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<AgregarCobro> agregarCobroRequestCommand){

    var command = agregarCobroRequestCommand.getCommand();
    var checkOut = CheckOut.form(command.getCheckOutId(),repository().getEventsBy(command.getCheckOutId().value()));

   CobroFactory factory = CobroFactory.builder().agregarCobro(command.getCobro());
   checkOut.agregarCobrosAfactura(command.getFacturaId(),factory);

   emit().onResponse(new ResponseEvents(checkOut.getUncommittedChanges()));
  }
}
