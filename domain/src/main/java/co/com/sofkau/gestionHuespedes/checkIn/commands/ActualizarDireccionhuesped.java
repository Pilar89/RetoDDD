package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Direccion;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

public class ActualizarDireccionhuesped extends Command {

  private final CheckInId checkInId;
  private final HuespedId huespedId;
  private final Direccion direccion;

  public ActualizarDireccionhuesped(CheckInId checkInId, HuespedId huespedId, Direccion direccion) {
    this.checkInId = checkInId;
    this.huespedId = huespedId;
    this.direccion = direccion;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Direccion getDireccion() {
    return direccion;
  }
}
