package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.events.*;
import co.com.sofkau.gestionHuespedes.checkIn.values.*;

import java.util.List;
import java.util.Map;

public class CheckIn extends AggregateEvent<CheckInId> {

  protected HabitacionHotel habitacion;
  protected Map<HuespedId, Huesped> huespedes;
  protected Fecha fechaLlegada;
  protected Fecha fechaSalida;
  protected MetodoDePago metodoDePago;
  protected Promocion promocion;

  public CheckIn(CheckInId checkInId, HabitacionHotel habitacion,
                 Fecha fechaLlegada, Fecha fechaSalida,
                 MetodoDePago metodoDePago) {
    super(checkInId);
    appendChange(new CheckInCreado(checkInId, habitacion, fechaLlegada, fechaSalida, metodoDePago))
      .apply();
    subscribe(new CheckInEventChange(this));
  }

  private CheckIn(CheckInId checkInId) {
    super(checkInId);
    subscribe(new CheckInEventChange(this));
  }

  public static CheckIn from(CheckInId checkInId, List<DomainEvent> events) {
    var checkIn = new CheckIn(checkInId);
    events.forEach(checkIn::applyEvent);
    return checkIn;
  }

  public void agregarHuesped(Nombre nombre, Telefono telefono,
                             Direccion direccion, Correo correo) {

    var huespedId = new HuespedId();
    appendChange(new HuespedAgregado(entityId, huespedId, nombre, telefono, direccion, correo)).apply();
  }

  public void agregarPromocion(Nombre nombre, Descuento descuento) {
    var promocionId = new PromocionId();
    appendChange(new PromocionAgregada(promocionId, nombre, descuento)).apply();

  }

  public void actualizarHuespedNombre(HuespedId huespedId, Nombre nombre) {
    appendChange(new NombreHuespedActualizado(huespedId, nombre)).apply();
  }

  public void actualizarHuespedTelefono(HuespedId huespedId, Telefono telefono) {
    appendChange(new TelefonoHuespedActualizado(huespedId, telefono)).apply();
  }

  public void actualizarHuespedDireccion(HuespedId huespedId, Direccion direccion) {
    appendChange(new DireccionHuespedActualizada(huespedId, direccion)).apply();
  }

  public void actualizarHuespedCorreo(HuespedId huespedId, Correo correo) {
    appendChange(new CorreoHuespedActualizado(huespedId, correo)).apply();
  }

  public void actualizarDisponibilidadHabitacion(HabitacionHotelId habitacionId, Disponibilidad disponibilidad) {
    appendChange(new DisponibilidadHabitacionActualizada(habitacionId, disponibilidad)).apply();
  }

  public void actualizarDisponibilidadHabitacion(Disponibilidad disponibilidad) {
    this.actualizarDisponibilidadHabitacion(this.habitacion.identity(), disponibilidad);
  }

  public void actualizarMetodoDePago(MetodoDePago metodoDePago){
    appendChange(new MetodoDePagoActualizado(metodoDePago)
      );

  }

  public void actualizarFechaDeSalida(Fecha fechaSalida){
    appendChange(new FechaDeSalidaActualizada(fechaSalida));
  }



}
