package co.com.sofkau.gestionHuespedes.checkOut;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;
import co.com.sofkau.generic.Cobro;


import java.util.HashSet;
import java.util.Set;

public class Factura extends Entity<FacturaId> {
  protected Nombre nombre;
  protected Set<Cobro> cobros;
  protected Costo costoTotal;

  public Factura(FacturaId entityId, Nombre nombre) {
    super(entityId);
    this.nombre = nombre;
    this.costoTotal = new Costo((double) 0);
    this.cobros = new HashSet<>();
  }

  public void agregarCobro(Cobro cobro) {
    this.cobros.add(cobro);
  }

  public void agregarCobros(CobroFactory factory) {
    factory.cobros().forEach(this::agregarCobro);

  }

  public Set<Cobro> cobros() {
    return cobros;
  }

  public Costo calcularCostoTotal() {
    if (this.cobros.isEmpty()) this.costoTotal = new Costo((double) 0);
    this.cobros.forEach((cobro -> {
      var valorCostoTotal = this.costoTotal.value() + cobro.getCosto().value();
      this.costoTotal = new Costo(valorCostoTotal);
    }));
    return costoTotal;
  }


  public Nombre getNombre() {
    return nombre;
  }


}
