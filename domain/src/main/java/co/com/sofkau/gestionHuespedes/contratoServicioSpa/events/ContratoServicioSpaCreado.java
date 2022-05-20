package co.com.sofkau.gestionHuespedes.contratoServicioSpa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.Huesped;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.ServicioSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;

public class ContratoServicioSpaCreado extends DomainEvent {
  private final ServicioSpa servicioSpa;
  private final Huesped huesped;
  private final HabitacionId habitacionId;

  public ContratoServicioSpaCreado(
                                   ServicioSpa servicioSpa, Huesped huesped, HabitacionId habitacionId){
    super("co.com.sofkau.gestionHuespedes.ContratoServicioSpaCreado");
    this.servicioSpa = servicioSpa;
    this.huesped = huesped;
    this.habitacionId = habitacionId;
  }


  public ServicioSpa getServicioSpa() {
    return servicioSpa;
  }

  public Huesped getHuesped() {
    return huesped;
  }

  public HabitacionId getHabitacionId() {
    return habitacionId;
  }
}
