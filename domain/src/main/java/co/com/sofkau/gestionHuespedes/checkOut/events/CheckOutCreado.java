package co.com.sofkau.gestionHuespedes.checkOut.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkOut.Factura;

public class CheckOutCreado extends DomainEvent {

  private final CheckInId checkInId;
  private final Fecha fechaCheckOut;
  private final Factura factura;

  public CheckOutCreado(CheckInId checkInId,
                        Fecha fechaCheckOut, Factura factura){
    super("co.com.sofkau.gestionHuespedes.CheckInCreado");
    this.checkInId = checkInId;
    this.fechaCheckOut = fechaCheckOut;
    this.factura = factura;

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
