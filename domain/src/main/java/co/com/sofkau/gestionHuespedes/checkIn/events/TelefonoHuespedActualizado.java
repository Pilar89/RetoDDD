package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Telefono;

public class TelefonoHuespedActualizado extends DomainEvent {
  private final HuespedId huespedId;
  private final Telefono telefono;

  public TelefonoHuespedActualizado(HuespedId id, Telefono telefono) {
    super("co.com.sofkau.gestionHuespedes.checkIn.events.TelefonoHuespedActualizado");
    this.huespedId = id;
    this.telefono = telefono;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Telefono getTelefono() {
    return telefono;
  }
}
