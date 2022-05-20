package co.com.sofkau.gestionHuespedes.checkOut.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkOut.Factura;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;

public class CrearCheckOut extends Command {
  private final CheckOutId checkOutId;
  private final CheckInId checkInId;
  private final  Fecha fechaCheckOut;
  private final  Factura factura;

  public CrearCheckOut(CheckOutId checkOutId, CheckInId checkInId, Fecha fechaCheckOut, Factura factura) {
    this.checkOutId = checkOutId;
    this.checkInId = checkInId;
    this.fechaCheckOut = fechaCheckOut;
    this.factura = factura;
  }

  public CheckOutId getCheckOutId() {
    return checkOutId;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public Fecha getFechaCheckOut() {
    return fechaCheckOut;
  }

  public Factura getFactura() {
    return factura;
  }
}
