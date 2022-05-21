package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.Identity;

public class PromocionId extends Identity {
  public PromocionId(String id) {
    super(id);
  }

  public PromocionId() {

  }

  //Constructor por defecto
  public static PromocionId of(String id) {
    return new PromocionId(id);
  }

}
