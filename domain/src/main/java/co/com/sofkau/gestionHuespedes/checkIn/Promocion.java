package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.Correo;
import co.com.sofkau.gestionHuespedes.checkIn.values.Descuento;
import co.com.sofkau.gestionHuespedes.checkIn.values.PromocionId;


public class Promocion extends Entity<PromocionId> {

  protected Nombre nombre;
  protected Descuento descuento;

  public Promocion(PromocionId entityId, Nombre nombre, Descuento descuento) {
    super(entityId);
    this.nombre = nombre;
    this.descuento = descuento;
  }

  public  void updateDescuento(Descuento descuento){
    this.descuento = descuento;

  }
}
