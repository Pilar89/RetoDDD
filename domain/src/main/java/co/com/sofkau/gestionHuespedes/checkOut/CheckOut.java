package co.com.sofkau.gestionHuespedes.checkOut;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.CobroId;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
import co.com.sofkau.gestionHuespedes.checkOut.events.CobroAgregadoAFactura;
import co.com.sofkau.gestionHuespedes.checkOut.values.CheckOutId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;

import java.util.List;

public class CheckOut extends AggregateEvent<CheckOutId> {

  protected CheckInId checkInId;
  protected Fecha fechaCheckOut;
  protected Factura factura;

  public CheckOut(CheckOutId checkOutId, CheckInId checkInId,
                  Fecha fechaCheckOut, Factura factura ){
    super(checkOutId);
    appendChange(new CheckOutCreado(checkInId,fechaCheckOut,factura)).apply();
    subscribe(new CheckOutEventChange(this));

  }

  private CheckOut(CheckOutId checkOutId){
    super(checkOutId);
    subscribe(new CheckOutEventChange(this));
  }

  public static CheckOut form(CheckOutId checkOutId,
                              List<DomainEvent>events){
    var checkOut = new CheckOut(checkOutId);
    events.forEach(checkOut::applyEvent);
    return checkOut;
  }

  public void agregarCobroAFactura(CheckInId checkInId, ContratoServicioSpaId contratoServicioSpaId, Costo costo){
    var cobroID = new CobroId();
    appendChange(new CobroAgregadoAFactura(cobroID, checkInId,contratoServicioSpaId,costo)).apply();

  }


}