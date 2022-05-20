package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.HuespedCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.PromocionCreada;
import co.com.sofkau.generic.values.Disponibilidad;

import java.util.HashMap;

public class CheckInEventChange extends EventChange {

  public CheckInEventChange(CheckIn checkIn){
    apply((CheckInCreado event)->{
      checkIn.habitacion = event.getHabitacion();
      checkIn.fechaLlegada = event.getFechaLlegada();
      checkIn.metodoDePago = event.getMetodoDePago();
      checkIn.huespedes = new HashMap<>();
      var disponibilidad = new Disponibilidad(false);
      checkIn.habitacion.cambiarDisponibilidad(disponibilidad);
    });

    apply((HuespedCreado event)->{
      var huespedId = event.getHuespeId();
      var huesped = new Huesped(huespedId, event.getNombre(), event.getTelefono(),
        event.getDireccion(), event.getCorreo());
      checkIn.huespedes.put(huespedId, huesped);
    });

    apply((PromocionCreada event)->{
      var promocionId = event.getPromocionId();
      var promocion = new Promocion(promocionId, event.getNombre(),event.getDescuento());
      checkIn.promocion= promocion;
    });




  }


}
