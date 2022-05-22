package co.com.sofkau.gestionHuespedes.checkOut.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;

public class NombreClienteFacturaActualizado extends DomainEvent {
  private final FacturaId facturaId;
  private final Nombre nombre;

  public NombreClienteFacturaActualizado(FacturaId facturaId, Nombre nombre){
    super("co.com.sofkau.gestionHuespedes.NombreClienteFacturaActualizado");
    this.facturaId = facturaId;
    this.nombre = nombre;

  }

  public FacturaId getFacturaId() {
    return facturaId;
  }

  public Nombre getNombre() {
    return nombre;
  }
}
