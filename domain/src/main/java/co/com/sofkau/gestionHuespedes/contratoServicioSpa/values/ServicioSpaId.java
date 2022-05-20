package co.com.sofkau.gestionHuespedes.contratoServicioSpa.values;

import co.com.sofka.domain.generic.Identity;

public class ServicioSpaId extends Identity {
  public ServicioSpaId(String id){
    super(id);
  }
  public static ServicioSpaId of(String id) {
    return new ServicioSpaId(id);
  }
}
