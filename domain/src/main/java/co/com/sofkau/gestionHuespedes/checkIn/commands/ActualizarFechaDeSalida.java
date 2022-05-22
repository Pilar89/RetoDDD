package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;

public class ActualizarFechaDeSalida extends Command {

  private final CheckInId checkInId;
  private final Fecha fechaDeSalida;

  public ActualizarFechaDeSalida(CheckInId checkInId, Fecha fechaDeSalida) {
    this.checkInId = checkInId;
    this.fechaDeSalida = fechaDeSalida;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public Fecha getFechaDeSalida() {
    return fechaDeSalida;
  }
}
