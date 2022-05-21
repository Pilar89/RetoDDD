package co.com.sofkau.gestionHuespedes.checkOut;

import co.com.sofkau.generic.Cobro;

import java.util.HashSet;
import java.util.Set;

public class CobroFactory {

  private final Set<Cobro> cobros;

  private CobroFactory() {
    this.cobros = new HashSet<>();
  }

  public CobroFactory agregarCobro(Cobro cobro) {
    cobros.add(cobro);
    return this;
  }

  public static CobroFactory builder() {
    return new CobroFactory();
  }

  public Set<Cobro> cobros() {
    return cobros;
  }
}
