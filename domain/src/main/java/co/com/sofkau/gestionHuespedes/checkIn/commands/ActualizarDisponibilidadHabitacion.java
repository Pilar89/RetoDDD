package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;

public class ActualizarDisponibilidadHabitacion extends Command {

  private final CheckInId checkInId;
  private final HabitacionHotelId habitacionHotelId;
  private final Disponibilidad disponibilidad;

  public ActualizarDisponibilidadHabitacion(CheckInId checkInId, HabitacionHotelId habitacionHotelId, Disponibilidad disponibilidad) {
    this.checkInId = checkInId;
    this.habitacionHotelId = habitacionHotelId;
    this.disponibilidad = disponibilidad;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public HabitacionHotelId getHabitacionHotelId() {
    return habitacionHotelId;
  }

  public Disponibilidad getDisponibilidad() {
    return disponibilidad;
  }
}
