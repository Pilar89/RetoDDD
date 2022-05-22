package co.com.sofkau.gestionHuespedes.checkOut.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;
import co.com.sofkau.gestionHuespedes.checkOut.values.FacturaId;

public class ActualizarNombreClienteFactura extends Command {

  private final CheckOutId checkOutId;
  private final FacturaId facturaId;
  private final Nombre nombreCliente;

  public ActualizarNombreClienteFactura(CheckOutId checkOutId, FacturaId facturaId, Nombre nombreCliente) {
    this.checkOutId = checkOutId;
    this.facturaId = facturaId;
    this.nombreCliente = nombreCliente;
  }

  public CheckOutId getCheckOutId() {
    return checkOutId;
  }

  public FacturaId getFacturaId() {
    return facturaId;
  }

  public Nombre getNombreCliente() {
    return nombreCliente;
  }
}
