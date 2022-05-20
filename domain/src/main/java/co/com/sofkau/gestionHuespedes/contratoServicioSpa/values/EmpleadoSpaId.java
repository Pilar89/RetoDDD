package co.com.sofkau.gestionHuespedes.contratoServicioSpa.values;

import co.com.sofka.domain.generic.Identity;

public class EmpleadoSpaId extends Identity {

  public EmpleadoSpaId(String id){
    super(id);
  }
  public static EmpleadoSpaId of(String id) {
    return new EmpleadoSpaId(id);
  }
}
