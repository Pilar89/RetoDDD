package co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.EmpleadoSpaId;

public class ActualizarDisponibilidadEmpleadoSpa extends Command {

  private final ContratoServicioSpaId contratoServicioSpaId;
  private final EmpleadoSpaId empleadoSpaId;
  private final Disponibilidad disponibilidad;

  public ActualizarDisponibilidadEmpleadoSpa(ContratoServicioSpaId contratoServicioSpaId, EmpleadoSpaId empleadoSpaId, Disponibilidad disponibilidad) {
    this.contratoServicioSpaId = contratoServicioSpaId;
    this.empleadoSpaId = empleadoSpaId;
    this.disponibilidad = disponibilidad;
  }

  public ContratoServicioSpaId getContratoServicioSpaId() {
    return contratoServicioSpaId;
  }

  public EmpleadoSpaId getEmpleadoSpaId() {
    return empleadoSpaId;
  }

  public Disponibilidad getDisponibilidad() {
    return disponibilidad;
  }
}
