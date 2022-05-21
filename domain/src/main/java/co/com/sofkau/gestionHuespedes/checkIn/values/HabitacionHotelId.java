package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.Identity;

public class HabitacionHotelId extends Identity {
  public HabitacionHotelId(String id) {
    super(id);
  }

  public static HabitacionHotelId of(String id) {
    return new HabitacionHotelId(id);
  }
}
