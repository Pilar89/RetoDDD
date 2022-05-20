package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.Huesped;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.gestionHuespedes.checkIn.Habitacion;
import co.com.sofkau.gestionHuespedes.checkIn.Promocion;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;

import java.util.Map;

public class CrearCheckIn extends Command {

  private final CheckInId checkInId;
  private final Habitacion habitacion;
  private final Fecha fechaLlegada;
  private final Fecha fechaSalida;
  private final MetodoDePago metodoDePago;

  public CrearCheckIn(CheckInId checkInId, Habitacion habitacion, Fecha fechaLlegada, Fecha fechaSalida, MetodoDePago metodoDePago) {
    this.checkInId = checkInId;
    this.habitacion = habitacion;
    this.fechaLlegada = fechaLlegada;
    this.fechaSalida = fechaSalida;
    this.metodoDePago = metodoDePago;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public Habitacion getHabitacion() {
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
