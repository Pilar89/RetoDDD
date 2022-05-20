package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Costo implements ValueObject<Double> {

  private final Double value;

  public Costo(Double value) {
    this.value = Objects.requireNonNull(value);

  }

  @Override
  public Double value() {
    return value;
  }
}
