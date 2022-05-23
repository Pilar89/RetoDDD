package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands.ActualizarCostoServicioSpa;


public class ActualizarCostoServicioSpaUseCase extends UseCase<RequestCommand<ActualizarCostoServicioSpa>, ResponseEvents> {
  @Override
  public void executeUseCase(RequestCommand<ActualizarCostoServicioSpa> actualizarCostoServicioSpaRequestCommand) {
    var command = actualizarCostoServicioSpaRequestCommand.getCommand();
    var contratoServicioSpaId  = command.getContratoServicioSpaId();
    var servicioSpaId = command.getServicioSpaId();
    var costo = command.getCosto();

    var contratoServicioSpa =ContratoServicioSpa.from(contratoServicioSpaId, repository().getEventsBy(contratoServicioSpaId.value()));
    contratoServicioSpa.atualizarCostoServicioSpa(servicioSpaId,costo);

    emit().onResponse(new ResponseEvents(contratoServicioSpa.getUncommittedChanges()));
  }
}
