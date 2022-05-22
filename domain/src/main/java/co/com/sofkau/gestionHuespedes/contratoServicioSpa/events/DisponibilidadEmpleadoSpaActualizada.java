package co.com.sofkau.gestionHuespedes.contratoServicioSpa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.EmpleadoSpaId;

public class DisponibilidadEmpleadoSpaActualizada extends DomainEvent {

  private final EmpleadoSpaId empleadoSpaId;
  private final Disponibilidad disponibilidad;

  public DisponibilidadEmpleadoSpaActualizada(EmpleadoSpaId empleadoSpaId, Disponibilidad disponibilidad) {
    super("co.com.sofkau.gestionHuespedes.DisponibilidadEmpleadoSpaActualizada");
    this.empleadoSpaId = empleadoSpaId;
    this.disponibilidad = disponibilidad;
  }

  public EmpleadoSpaId getEmpleadoSpaId() {
    return empleadoSpaId;
  }

  public Disponibilidad getDisponibilidad() {
    return disponibilidad;
  }
}
