package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Descuento;
import co.com.sofkau.gestionHuespedes.checkIn.values.PromocionId;

public class ActualizarValorDescuentoPromocion extends Command {

  private final CheckInId checkInId;
  private final PromocionId promocionId;
  private final Descuento descuento;

  public ActualizarValorDescuentoPromocion(CheckInId checkInId, PromocionId promocionId, Descuento descuento) {
    this.checkInId = checkInId;
    this.promocionId = promocionId;
    this.descuento = descuento;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public PromocionId getPromocionId() {
    return promocionId;
  }

  public Descuento getDescuento() {
    return descuento;
  }
}
