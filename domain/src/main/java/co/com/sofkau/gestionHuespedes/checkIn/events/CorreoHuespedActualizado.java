package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkIn.values.Correo;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

public class CorreoHuespedActualizado extends DomainEvent {
  private final HuespedId huespedId;
  private final Correo correo;

  public CorreoHuespedActualizado(HuespedId id, Correo correo) {
    super("co.com.sofkau.gestionHuespedes.checkIn.events.CorreoHuespedActualizado");
    this.huespedId = id;
    this.correo= correo;
  }

  public HuespedId getHuespedId() {
    return huespedId;
  }

  public Correo getCorreo() {
    return correo;
  }
}
