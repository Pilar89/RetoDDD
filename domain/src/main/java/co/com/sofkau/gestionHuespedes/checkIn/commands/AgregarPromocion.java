package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Descuento;
import co.com.sofkau.gestionHuespedes.checkIn.values.PromocionId;

public class AgregarPromocion extends Command {

  private final CheckInId checkInId;
  private final PromocionId promocionId;
  private final Nombre nombre;
  private final Descuento descuento;

  public AgregarPromocion(CheckInId checkInId, PromocionId promocionId, Nombre nombre, Descuento descuento) {
    this.checkInId = checkInId;
    this.promocionId = promocionId;
    this.nombre = nombre;
    this.descuento = descuento;
  }

  public PromocionId getPromocionId() {
    return promocionId;
  }

  public Nombre getNombre() {
    return nombre;
  }

  public Descuento getDescuento() {
    return descuento;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }
}
