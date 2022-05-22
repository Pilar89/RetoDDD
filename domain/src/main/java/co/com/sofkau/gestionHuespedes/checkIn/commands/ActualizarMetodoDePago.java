package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;


public class ActualizarMetodoDePago extends Command {
  private final CheckInId checkInId;
  private final MetodoDePago metodoDePago;

  public ActualizarMetodoDePago(CheckInId checkInId, MetodoDePago metodoDePago) {
    this.checkInId = checkInId;
    this.metodoDePago = metodoDePago;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public MetodoDePago getMetodoDePago() {
    return metodoDePago;
  }
}
