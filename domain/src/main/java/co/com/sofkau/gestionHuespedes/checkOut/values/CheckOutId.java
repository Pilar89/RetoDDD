package co.com.sofkau.gestionHuespedes.checkOut.values;


import co.com.sofka.domain.generic.Identity;

public class CheckOutId extends Identity {
  public CheckOutId(String id) {
    super(id);
  }

  public CheckOutId() {

  }

  //Constructor por defecto
  public static CheckOutId of(String id) {
    return new CheckOutId(id);
  }
}
