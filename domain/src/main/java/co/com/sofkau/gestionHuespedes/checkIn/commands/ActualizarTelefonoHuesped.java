package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Telefono;

public class ActualizarTelefonoHuesped extends Command {

  private final CheckInId checkInId;
  private final HuespedId huespedId;
  private final Telefono telefono;

  public ActualizarTelefonoHuesped(CheckInId checkInId, HuespedId huespedId, Telefono telefono) {
    this.checkInId = checkInId;
    this.huespedId = huespedId;
    this.telefono = telefono;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Telefono getTelefono() {
    return telefono;
  }
}
