package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;

public class DisponibilidadHabitacionActualizada extends DomainEvent {

  private final HabitacionHotelId habitacionHotelId;
  private final Disponibilidad disponibilidad;

  public DisponibilidadHabitacionActualizada(HabitacionHotelId habitacionId, Disponibilidad disponibilidad) {
    super("co.com.sofkau.gestionHuespedes.DisponibilidadHabitacionActualizada");
    this.habitacionHotelId = habitacionId;
    this.disponibilidad = disponibilidad;
  }

  public HabitacionHotelId getHabitacionHotelId() {
    return habitacionHotelId;
  }

  public Disponibilidad getDisponibilidad() {
    return disponibilidad;
  }
}
