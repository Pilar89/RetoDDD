package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.Identity;

public class CobroId extends Identity {

  public CobroId(String value) {
    super(value);
  }

  public CobroId() {

  }

  public static CobroId of(String value) {
    return new CobroId(value);
  }
}
