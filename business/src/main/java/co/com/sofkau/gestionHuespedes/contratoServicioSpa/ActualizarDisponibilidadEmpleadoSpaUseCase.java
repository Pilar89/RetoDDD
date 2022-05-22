package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands.ActualizarDisponibilidadEmpleadoSpa;

public class ActualizarDisponibilidadEmpleadoSpaUseCase extends UseCase<RequestCommand<ActualizarDisponibilidadEmpleadoSpa>, ResponseEvents> {

  @Override
  public void executeUseCase(RequestCommand<ActualizarDisponibilidadEmpleadoSpa> actualizarDisponibilidadEmpleadoSpaRequestCommandn) {
    var command = actualizarDisponibilidadEmpleadoSpaRequestCommandn.getCommand();
    var contratoServicioSpaId  = command.getContratoServicioSpaId();
    var empleadoSpaId = command.getEmpleadoSpaId();
    var disponibilidad = command.getDisponibilidad();

    var contratoServicioSpa =ContratoServicioSpa.from(contratoServicioSpaId, repository().getEventsBy(contratoServicioSpaId.value()));
    contratoServicioSpa.actualizarDisponibilidadEmpleadoSpa(empleadoSpaId,disponibilidad);

    emit().onResponse(new ResponseEvents(contratoServicioSpa.getUncommittedChanges()));
  }


}
