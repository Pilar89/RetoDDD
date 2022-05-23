package co.com.sofkau.gestionHuespedes.contratoServicioSpa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ServicioSpaId;

public class CostoServicioSpaAtualizado extends DomainEvent {

  private final ServicioSpaId servicioSpaId;
  private final Costo costo;

  public CostoServicioSpaAtualizado(ServicioSpaId servicioSpaId, Costo costo){
    super("co.com.sofkau.gestionHuespedes.CostoServicioSpaAtualizado");
    this.servicioSpaId = servicioSpaId;
    this.costo = costo;
  }

  public ServicioSpaId getServicioSpaId() {
    return servicioSpaId;
  }

  public Costo getCosto() {
    return costo;
  }
}
