package co.com.sofkau.gestionHuespedes.checkOut;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.generic.Cobro;
import co.com.sofkau.gestionHuespedes.checkIn.events.ValorDescuentoPromocionActualizado;
import co.com.sofkau.gestionHuespedes.checkOut.events.CheckOutCreado;
import co.com.sofkau.gestionHuespedes.checkOut.events.CobroAgregadoAFactura;
import co.com.sofkau.gestionHuespedes.checkOut.events.CobrosAgregadosAFactura;
import co.com.sofkau.gestionHuespedes.checkOut.events.NombreClienteFacturaActualizado;

public class CheckOutEventChange extends EventChange {

  public CheckOutEventChange(CheckOut checkOut) {
    apply((CheckOutCreado event) -> {
      checkOut.checkInId = event.getCheckInId();
      checkOut.fechaCheckOut = event.getFechaCheckOut();
      checkOut.factura = event.getFactura();


    });

    apply((CobroAgregadoAFactura event) -> {
      var cobro = new Cobro(event.getCobroId(), event.getCheckInId(), event.getContratoServicioSpaId(), event.getCosto());
      checkOut.factura.agregarCobro(cobro);
    });

    apply((CobrosAgregadosAFactura event) -> {
      checkOut.factura.agregarCobros(event.getFactory());
    });

    apply((NombreClienteFacturaActualizado event)->{
      var nombreCliente = event.getNombre();
      checkOut.factura.updateNombre(nombreCliente);
    });


  }


}
