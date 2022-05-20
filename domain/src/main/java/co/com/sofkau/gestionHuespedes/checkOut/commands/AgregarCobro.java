package co.com.sofkau.gestionHuespedes.checkOut.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.Cobro;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;


public class AgregarCobro extends Command {
  private final CheckOutId checkOutId;
  private final FacturaId facturaId;
  private final Cobro cobro;

  public AgregarCobro(CheckOutId checkOutId, FacturaId facturaId, Cobro cobro) {
    this.checkOutId = checkOutId;
    this.facturaId = facturaId;
    this.cobro = cobro;
  }

  public CheckOutId getCheckOutId() {
    return checkOutId;
  }

  public FacturaId getFacturaId() {
    return facturaId;
  }

  public Cobro getCobro() {
    return cobro;
  }
}


