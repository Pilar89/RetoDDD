package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.EmpleadoSpaId;

public class EmpleadoSpa extends Entity<EmpleadoSpaId> {
  protected Nombre nombre;
  protected Disponibilidad disponibilidad;

  public EmpleadoSpa(EmpleadoSpaId entityId, Nombre nombre) {
    super(entityId);
    this.nombre = nombre;
    this.disponibilidad = new Disponibilidad(true);
  }

  public void cambiarDisponibilidad(Disponibilidad disponibilidad) {
    this.disponibilidad = disponibilidad;
  }
}
