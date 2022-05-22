package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.gestionHuespedes.checkIn.events.*;
import co.com.sofkau.generic.values.Disponibilidad;


import java.util.HashMap;

public class CheckInEventChange extends EventChange {

  public CheckInEventChange(CheckIn checkIn) {
    apply((CheckInCreado event) -> {
      checkIn.habitacion = event.getHabitacion();
      checkIn.fechaLlegada = event.getFechaLlegada();
      checkIn.metodoDePago = event.getMetodoDePago();
      checkIn.huespedes = new HashMap<>();
    });

    apply((HuespedAgregado event) -> {
      var huespedId = event.getHuespeId();
      var huesped = new Huesped(huespedId, event.getNombre(), event.getTelefono(),
        event.getDireccion(), event.getCorreo());
      checkIn.huespedes.put(huespedId, huesped);
    });

    apply((PromocionAgregada event) -> {
      var promocionId = event.getPromocionId();
      var promocion = new Promocion(promocionId, event.getNombre(), event.getDescuento());
      checkIn.promocion = promocion;
    });

    apply((NombreHuespedActualizado event) -> {
      var id = event.getHuespedId();
      var huesped = checkIn.huespedes.get(id);
      huesped.updateNombre(event.getNombre());
    });

    apply((TelefonoHuespedActualizado event) -> {
      var id = event.getHuespedId();
      var huesped = checkIn.huespedes.get(id);
      huesped.updateTelefono(event.getTelefono());
    });

    apply((DireccionHuespedActualizada event) -> {
      var id = event.getHuespedId();
      var huesped = checkIn.huespedes.get(id);
      huesped.updateDireccion(event.getDireccion());
    });

    apply((CorreoHuespedActualizado event) -> {
      var id = event.getHuespedId();
      var huesped = checkIn.huespedes.get(id);
      huesped.updateCorreo(event.getCorreo());
    });

    apply((DisponibilidadHabitacionActualizada event) -> {
      var habitacionId = event.getHabitacionHotelId();
      var disponibilidad = event.getDisponibilidad();
      checkIn.habitacion.cambiarDisponibilidad(disponibilidad);
    });

    apply((MetodoDePagoActualizado event)->{
      var metodoDePago = event.getMetodoDePago();
      checkIn.actualizarMetodoDePago(metodoDePago);
    });
  }
}
