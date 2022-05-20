package co.com.sofkau.gestionHuespedes.checkIn.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Categoria implements ValueObject<String> {
  private final String value;

  public Categoria(String value) {
    //TODO: validacions
    this.value = Objects.requireNonNull(value);
  }

  @Override
  public String value() {
    return value;
  }
}
