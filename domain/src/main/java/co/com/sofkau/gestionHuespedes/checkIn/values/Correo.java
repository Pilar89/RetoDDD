package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Correo implements ValueObject<String> {
  private final String value;

  public Correo(String value) {
    this.value = Objects.requireNonNull(value);
    if (this.value.isBlank()) {
      throw new IllegalArgumentException("El correo no puede estae en blanco");
    }

    if (this.value.length() > 200) {
      throw new IllegalArgumentException("El correo  no permite mas de 200 caracteres");
    }
  }

  @Override
  public String value() {
    return value;
  }
}
