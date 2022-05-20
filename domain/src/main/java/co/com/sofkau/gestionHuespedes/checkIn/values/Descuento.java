package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descuento implements ValueObject<Double> {
  private final Double value;

  public Descuento(Double value) {
    this.value = Objects.requireNonNull(value);

  }

  @Override
  public Double value() {
    return value;
  }
}
