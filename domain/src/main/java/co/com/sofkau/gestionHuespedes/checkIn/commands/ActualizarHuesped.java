package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.CheckIn;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

public class ActualizarHuesped extends Command {

  private final CheckInId checkInId;
  private final HuespedId huespedId;
  private final Nombre nombre;

  public ActualizarHuesped(CheckInId checkInId, HuespedId huespedId, Nombre nombre) {
    this.checkInId = checkInId;
    this.huespedId = huespedId;
    this.nombre = nombre;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Nombre getNombre() {
    return nombre;
  }
}
