package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands.CrearContratoServicioSpa;

public class CrearContratoServicioSpaUseCase extends UseCase<RequestCommand<CrearContratoServicioSpa>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<CrearContratoServicioSpa> crearContratoServicioSpaRequestCommand) {
    var command = crearContratoServicioSpaRequestCommand.getCommand();

    var contratoSevicioSpa = new ContratoServicioSpa(
      command.getContratoServicioSpaId(),
      command.getServicioSpa(),
      command.getEmpleadoSpa(),
      command.getHabitacionId(),
      command.getHabitacionSpa()
    );

    emit().onResponse(new ResponseEvents(contratoSevicioSpa.getUncommittedChanges()));
  }
}
