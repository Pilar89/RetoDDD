package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.checkIn.commands.CrearCheckIn;

public class CrearCheckInUseCase extends UseCase<RequestCommand<CrearCheckIn>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CrearCheckIn>crearCheckInRequestCommand){
    var command = crearCheckInRequestCommand.getCommand();
    var checkIn = new CheckIn(command.getCheckInId(),
      command.getHabitacion(),command.getFechaLlegada(),command.getFechaSalida(),
      command.getMetodoDePago());
    emit().onResponse(new ResponseEvents(checkIn.getUncommittedChanges()));
  }




}
