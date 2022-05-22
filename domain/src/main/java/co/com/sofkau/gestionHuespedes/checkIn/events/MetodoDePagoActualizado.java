package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.MetodoDePago;

public class MetodoDePagoActualizado extends DomainEvent {
  private final MetodoDePago metodoDePago;

  public MetodoDePagoActualizado(MetodoDePago metodoDePago){

    super("co.com.sofkau.gestionHuespedes.MetodoDePagoActualizado");
    this.metodoDePago = metodoDePago;

  }

  public MetodoDePago getMetodoDePago() {
    return metodoDePago;
  }
}
