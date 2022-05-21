package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

public class HuespedActualizado extends DomainEvent {

  private final HuespedId huespedId;
  private final Nombre nombre;

  public HuespedActualizado(HuespedId id, Nombre nombre) {
    super("co.com.sofkau.gestionHuespedes.checkIn.events.HuespedActualizado");
    this.huespedId = id;
    this.nombre = nombre;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Nombre getNombre() {
    return nombre;
  }
}
