package co.com.sofkau.gestionHuespedes.contratoServicioSpa.values;

import co.com.sofka.domain.generic.Identity;

public class HabitacionSpaId extends Identity {
  public HabitacionSpaId(String id) {
    super(id);
  }

  public static HabitacionSpaId of(String id) {
    return new HabitacionSpaId(id);
  }

}
