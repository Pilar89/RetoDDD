package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Correo;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

public class ActualizarCorreohuesped extends Command {
  private final CheckInId checkInId;
  private final HuespedId huespedId;
  private final Correo correo;

  public ActualizarCorreohuesped(CheckInId checkInId, HuespedId huespedId, Correo correo) {
    this.checkInId = checkInId;
    this.huespedId = huespedId;
    this.correo = correo;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Correo getCorreo() {
    return correo;
  }
}
