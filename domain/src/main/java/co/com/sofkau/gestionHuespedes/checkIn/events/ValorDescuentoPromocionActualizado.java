package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkIn.values.Descuento;
import co.com.sofkau.gestionHuespedes.checkIn.values.PromocionId;

public class ValorDescuentoPromocionActualizado extends DomainEvent {

  private final PromocionId promocionId;
  private final Descuento descuento;

  public ValorDescuentoPromocionActualizado(PromocionId promocionId, Descuento descuento){
    super("co.com.sofkau.gestionHuespedes.ValorDescuentoPromocionActualizado");
    this.promocionId = promocionId;
    this.descuento = descuento;

  }

  public PromocionId getPromocionId() {
    return promocionId;
  }

  public Descuento getDescuento() {
    return descuento;
  }
}
