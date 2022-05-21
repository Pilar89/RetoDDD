package co.com.sofkau.gestionHuespedes.contratoServicioSpa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkIn.Huesped;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.EmpleadoSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.HabitacionSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.ServicioSpa;

public class ContratoServicioSpaCreado extends DomainEvent {
  private final ServicioSpa servicioSpa;
  private final EmpleadoSpa empleadoSpa;
  private final HabitacionHotelId habitacionId;
  private final HabitacionSpa habitacionSpa;


  public ContratoServicioSpaCreado(
    ServicioSpa servicioSpa, EmpleadoSpa empleadoSpa, HabitacionHotelId habitacionId, HabitacionSpa habitacionSpa) {
    super("co.com.sofkau.gestionHuespedes.ContratoServicioSpaCreado");
    this.servicioSpa = servicioSpa;
    this.empleadoSpa = empleadoSpa;
    this.habitacionId = habitacionId;
    this.habitacionSpa = habitacionSpa;
  }

  public ServicioSpa getServicioSpa() {
    return servicioSpa;
  }

  public EmpleadoSpa getEmpleadoSpa() {
    return empleadoSpa;
  }

  public HabitacionHotelId getHabitacionId() {
    return habitacionId;
  }

  public HabitacionSpa getHabitacionSpa() {
    return habitacionSpa;
  }
}
