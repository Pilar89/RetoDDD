package co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ServicioSpaId;

public class ActualizarCostoServicioSpa extends Command {

  private final ContratoServicioSpaId contratoServicioSpaId;
  private final ServicioSpaId servicioSpaId;
  private final Costo costo;

  public ActualizarCostoServicioSpa(ContratoServicioSpaId contratoServicioSpaId, ServicioSpaId servicioSpaId, Costo costo) {
    this.contratoServicioSpaId = contratoServicioSpaId;
    this.servicioSpaId = servicioSpaId;
    this.costo = costo;
  }

  public ContratoServicioSpaId getContratoServicioSpaId() {
    return contratoServicioSpaId;
  }

  public ServicioSpaId getServicioSpaId() {
    return servicioSpaId;
  }

  public Costo getCosto() {
    return costo;
  }
}
