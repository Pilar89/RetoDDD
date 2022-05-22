package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;


public class FechaDeSalidaActualizada extends DomainEvent {

  private final Fecha fechaDeSalida;

  public FechaDeSalidaActualizada(Fecha fechaDeSalida){

    super("co.com.sofkau.gestionHuespedes.FechaDeSalidaActualizada");
    this.fechaDeSalida = fechaDeSalida;

  }

  public Fecha getFechaDeSalida() {
    return fechaDeSalida;
  }
}
