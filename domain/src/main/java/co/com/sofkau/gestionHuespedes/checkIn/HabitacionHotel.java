package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.gestionHuespedes.checkIn.values.Categoria;
import co.com.sofkau.generic.values.Disponibilidad;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;

public class HabitacionHotel extends Entity<HabitacionHotelId> {
  protected Categoria categoria;
  protected Disponibilidad disponibilidad;

  public HabitacionHotel(HabitacionHotelId entityId, Categoria categoria) {
    super(entityId);
    this.categoria = categoria;
    this.disponibilidad = new Disponibilidad(true) ;
  }

  public void cambiarDisponibilidad(Disponibilidad disponibilidad){
     this.disponibilidad = disponibilidad;
  }


}
