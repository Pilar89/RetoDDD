package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.Identity;

public class HuespedId extends Identity {

  public HuespedId(String id){
    super(id);
  }

  public HuespedId(){

  }

  //Constructor por defecto
  public static HuespedId of(String id) {
    return new HuespedId(id);
  }



}
