package co.com.sofkau.gestionHuespedes.checkOut.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {
  public FacturaId(String id){
    super(id);
  }

  //Constructor por defecto
  public static FacturaId of(String id) {
    return new FacturaId(id);
  }
}
