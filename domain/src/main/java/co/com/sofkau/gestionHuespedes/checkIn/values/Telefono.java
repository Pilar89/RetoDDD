package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
  private final String value;

  public Telefono(String value) {
    this.value = Objects.requireNonNull(value);
    if (this.value.isBlank()) {
      throw new IllegalArgumentException("Este valor no puede estar en blanco");
    }

    if (this.value.length() > 20) {
      throw new IllegalArgumentException("Este valor no permite mas de 20 caracteres");
    }
  }

  @Override
  public String value() {
    return value;
  }

}
