package co.com.sofkau.gestionHuespedes.checkOut;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.generic.Cobro;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
import co.com.sofkau.gestionHuespedes.checkOut.events.CobroAgregadoAFactura;

public class CheckOutEventChange extends EventChange {

  public CheckOutEventChange(CheckOut checkOut){
    apply((CheckOutCreado event)->{
      checkOut.checkInId = event.getCheckInId();
      checkOut.fechaCheckOut = event.getFechaCheckOut();
      checkOut.factura= event.getFactura();


    });

    apply((CobroAgregadoAFactura event)->{
      var cobro = new Cobro(event.getCobroId(),event.getCheckInId(),event.getContratoServicioSpaId(),event.getCosto());
      checkOut.factura.agregarCobro(cobro);
    });






  }


}