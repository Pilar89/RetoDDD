package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.ContratoServicioSpaCreado;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.DisponibilidadEmpleadoSpaActualizada;

public class ContratoServicoSpaEventChange extends EventChange {
  public ContratoServicoSpaEventChange(ContratoServicioSpa contratoServicioSpa) {
    apply((ContratoServicioSpaCreado event) -> {
      contratoServicioSpa.servicioSpa = event.getServicioSpa();
      contratoServicioSpa.empleadoSpa = event.getEmpleadoSpa();
      contratoServicioSpa.habitacionId = event.getHabitacionId();
      contratoServicioSpa.habitacionSpa = event.getHabitacionSpa();
    });

    apply((DisponibilidadEmpleadoSpaActualizada event) -> {
      var empleadoSpaId = event.getEmpleadoSpaId();
      var disponibilidad = event.getDisponibilidad();
      contratoServicioSpa.empleadoSpa.cambiarDisponibilidad(disponibilidad);
    });

  }
}
