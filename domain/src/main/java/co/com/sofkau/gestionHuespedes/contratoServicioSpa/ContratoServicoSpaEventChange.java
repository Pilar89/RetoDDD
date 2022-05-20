package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.ContratoServicioSpaCreado;

public class ContratoServicoSpaEventChange extends EventChange {
  public ContratoServicoSpaEventChange(ContratoServicioSpa contratoServicioSpa){
    apply((ContratoServicioSpaCreado event)->{
      contratoServicioSpa.servicioSpa = event.getServicioSpa();
      contratoServicioSpa.huesped = event.getHuesped();
      contratoServicioSpa.habitacionId = event.getHabitacionId();
    });
  }
}
