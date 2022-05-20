package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.MetodoDePago;
import co.com.sofkau.gestionHuespedes.checkIn.HabitacionHotel;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;

public class CrearCheckIn extends Command {

  private final CheckInId checkInId;
  private final HabitacionHotel habitacion;
  private final Fecha fechaLlegada;
  private final Fecha fechaSalida;
  private final MetodoDePago metodoDePago;

  public CrearCheckIn(CheckInId checkInId, HabitacionHotel habitacion, Fecha fechaLlegada, Fecha fechaSalida, MetodoDePago metodoDePago) {
    this.checkInId = checkInId;
    this.habitacion = habitacion;
    this.fechaLlegada = fechaLlegada;
    this.fechaSalida = fechaSalida;
    this.metodoDePago = metodoDePago;
  }

  public CheckInId getCheckInId() {
    return checkInId;
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
