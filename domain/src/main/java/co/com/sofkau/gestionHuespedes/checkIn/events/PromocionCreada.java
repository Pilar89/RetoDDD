package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.Descuento;
import co.com.sofkau.gestionHuespedes.checkIn.values.PromocionId;

public class PromocionCreada extends DomainEvent {

  private final PromocionId promocionId;
  private final Nombre nombre;
  private final Descuento descuento;

  public PromocionCreada(PromocionId promocionId, Nombre nombre,
                         Descuento descuento){
    super("co.com.sofkau.gestionHuespedes.PromocionCreada");
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
}
