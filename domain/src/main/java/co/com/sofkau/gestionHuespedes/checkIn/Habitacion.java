package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.gestionHuespedes.checkIn.values.Categoria;
import co.com.sofkau.gestionHuespedes.checkIn.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionId;

public class Habitacion extends Entity<HabitacionId> {
  protected Categoria categoria;
  protected Disponibilidad disponibilidad;

  public Habitacion(HabitacionId entityId, Categoria categoria) {
    super(entityId);
    this.categoria = categoria;
    this.disponibilidad = new Disponibilidad(true) ;
  }

  public void cambiarDisponibilidad(Disponibilidad disponibilidad){
     this.disponibilidad = disponibilidad;
  }


}
