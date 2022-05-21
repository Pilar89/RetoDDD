package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetodoDePago implements ValueObject<String> {
  private final String value;

  public MetodoDePago(String value) {
    this.value = Objects.requireNonNull(value);
    if (this.value.isBlank()) {
      throw new IllegalArgumentException("El metodo de pago no puede estar en blanco");
    }

  }

  @Override
  public String value() {
    return value;
  }
}
