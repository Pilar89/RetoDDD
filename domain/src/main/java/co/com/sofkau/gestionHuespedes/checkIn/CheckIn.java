package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.Huesped;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.events.CheckInCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.HuespedCreado;
import co.com.sofkau.gestionHuespedes.checkIn.events.PromocionCreada;
import co.com.sofkau.gestionHuespedes.checkIn.values.*;

import java.util.List;
import java.util.Map;

public class CheckIn extends AggregateEvent<CheckInId> {

  protected Habitacion habitacion;
  protected Map<HuespedId, Huesped> huespedes;
  protected Fecha fechaLlegada;
  protected Fecha fechaSalida;
  protected MetodoDePago metodoDePago;
  protected Promocion promocion;

  public CheckIn(CheckInId checkInId, Habitacion habitacion,
                 Fecha  fechaLlegada, Fecha fechaSalida,
                 MetodoDePago metodoDePago) {
    super(checkInId);
    appendChange(new CheckInCreado(habitacion,fechaLlegada,fechaSalida,metodoDePago))
      .apply();
    subscribe(new CheckInEventChange(this) );
  }

  private CheckIn(CheckInId checkInId){
    super(checkInId);
    subscribe(new CheckInEventChange(this));
  }

  public static CheckIn from(CheckInId checkInId, List<DomainEvent>events){
    var checkIn = new CheckIn(checkInId);
    events.forEach(checkIn :: applyEvent);
    return checkIn;
  }

  public void agregarHuesped(Nombre nombre, Telefono telefono,
                             Direccion direccion, Correo correo){

    var huespedId = new HuespedId();
    appendChange(new HuespedCreado(huespedId, nombre,telefono,direccion,correo)).apply();
  }

  public void agregarPromocion(Nombre nombre, Descuento descuento){
    var promocionId = new PromocionId();
    appendChange(new PromocionCreada(promocionId,nombre,descuento)).apply();

  }







}
