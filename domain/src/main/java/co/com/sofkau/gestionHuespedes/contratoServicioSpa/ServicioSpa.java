package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ServicioSpaId;

public class ServicioSpa extends Entity<ServicioSpaId> {
  protected Nombre nombre;
  protected Costo costo;

  public ServicioSpa(ServicioSpaId entityId, Nombre nombre, Costo costo) {
    super(entityId);
    this.nombre = nombre;
    this.costo = costo;
  }
}
