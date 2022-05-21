package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkIn.values.Direccion;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

public class DireccionHuespedActualizada extends DomainEvent {

  private final HuespedId huespedId;
  private final Direccion direccion;

  public DireccionHuespedActualizada(HuespedId id, Direccion direccion) {
    super("co.com.sofkau.gestionHuespedes.checkIn.events.DireccionHuespedActualizada");
    this.huespedId = id;
    this.direccion = direccion;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Direccion getDireccion() {
    return direccion;
  }
}
