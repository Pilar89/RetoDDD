package co.com.sofkau.gestionHuespedes.checkOut.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkOut.CobroFactory;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;

public class CobrosAgregadosAFactura extends DomainEvent {
  private final FacturaId facturaId;
  private final CobroFactory factory;

  public CobrosAgregadosAFactura(FacturaId facturaId, CobroFactory factory) {
    super("co.com.sofkau.gestionHuespedes.CobrosAgregadosAFactura");
    this.facturaId = facturaId;
    this.factory = factory;
  }

  public FacturaId getFacturaId() {
    return facturaId;
  }

  public CobroFactory getFactory() {
    return factory;
  }
}
