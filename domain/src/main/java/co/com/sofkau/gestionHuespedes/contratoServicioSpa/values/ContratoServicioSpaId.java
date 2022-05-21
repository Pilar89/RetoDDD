package co.com.sofkau.gestionHuespedes.contratoServicioSpa.values;

import co.com.sofka.domain.generic.Identity;

public class ContratoServicioSpaId extends Identity {
  public ContratoServicioSpaId(String id) {
    super(id);
  }

  public static ContratoServicioSpaId of(String id) {
    return new ContratoServicioSpaId(id);
  }
}
