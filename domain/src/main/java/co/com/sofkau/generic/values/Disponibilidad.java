package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Disponibilidad implements ValueObject<Boolean> {
  private final Boolean value;

  public Disponibilidad(Boolean value) {
    //TODO: validacions
    this.value = Objects.requireNonNull(value);
  }

  @Override
  public Boolean value() {
    return value;
  }


}
