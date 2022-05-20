package co.com.sofkau.gestionHuespedes.contratoServicioSpa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.gestionHuespedes.checkIn.Huesped;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.EmpleadoSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.HabitacionSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.ServicioSpa;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;

public class CrearContratoServicioSpa extends Command {

  private final ContratoServicioSpaId contratoServicioSpaId;
  private final ServicioSpa servicioSpa;
  private final EmpleadoSpa empleadoSpa;
  private final HabitacionHotelId habitacionId;
  private final HabitacionSpa habitacionSpa;

  public CrearContratoServicioSpa(ContratoServicioSpaId contratoServicioSpaId, ServicioSpa servicioSpa, EmpleadoSpa empleadoSpa, HabitacionHotelId habitacionId, HabitacionSpa habitacionSpa) {
    this.contratoServicioSpaId = contratoServicioSpaId;
    this.servicioSpa = servicioSpa;
    this.empleadoSpa = empleadoSpa;
    this.habitacionId = habitacionId;
    this.habitacionSpa = habitacionSpa;
  }

  public ContratoServicioSpaId getContratoServicioSpaId() {
    return contratoServicioSpaId;
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
