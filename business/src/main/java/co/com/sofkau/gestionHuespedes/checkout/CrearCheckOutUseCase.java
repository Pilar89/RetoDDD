package co.com.sofkau.gestionHuespedes.checkout;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkOut.CheckOut;
import co.com.sofkau.gestionHuespedes.checkOut.commands.CrearCheckOut;

public class CrearCheckOutUseCase extends UseCase<RequestCommand<CrearCheckOut>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CrearCheckOut> crearCheckOutRequestCommand){
    var command = crearCheckOutRequestCommand.getCommand();

    var checkOut = new CheckOut(
      command.getCheckOutId(),
      command.getCheckInId(),
      command.getFechaCheckOut(),
      command.getFactura()
    );
    emit().onResponse(new ResponseEvents(checkOut.getUncommittedChanges()));
  }



}
