package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.gestionHuespedes.checkIn.HabitacionHotel;


public class CheckInCreado extends DomainEvent {

  private final HabitacionHotel habitacion;
  private final Fecha fechaLlegada;
  private final Fecha fechaSalida;
  private final MetodoDePago metodoDePago;

  public CheckInCreado( HabitacionHotel habitacion,
                 Fecha fechaLlegada, Fecha fechaSalida,
                 MetodoDePago metodoDePago){
    super("co.com.sofkau.gestionHuespedes.CheckOutCreado");
    this.habitacion = habitacion;
    this.fechaLlegada = fechaLlegada;
    this.fechaSalida = fechaSalida;
    this.metodoDePago = metodoDePago;

  }

  public HabitacionHotel getHabitacion() {
    return habitacion;
  }

  public Fecha getFechaLlegada() {
    return fechaLlegada;
  }

  public Fecha getFechaSalida() {
    return fechaSalida;
  }

  public MetodoDePago getMetodoDePago() {
    return metodoDePago;
  }
}