package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.Identity;

public class CheckInId extends Identity {

  public CheckInId(String id){
    super(id);
  }

  public static CheckInId of(String id){
    return new CheckInId(id);
  }
}
