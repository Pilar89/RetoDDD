package co.com.sofkau.gestionHuespedes.checkIn.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.Correo;
import co.com.sofkau.gestionHuespedes.checkIn.values.Direccion;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Telefono;

public class HuespedAgregado extends DomainEvent {
  private final HuespedId huespeId;
  private final Nombre nombre;
  private final Telefono telefono;
  private final Direccion direccion;
  private final Correo correo;

  public HuespedAgregado(HuespedId huespeId, Nombre nombre, Telefono telefono,
                         Direccion direccion, Correo corre){
    super("co.com.sofkau.gestionHuespede.HuespedAgregado");
    this.huespeId = huespeId;
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.correo = corre;

  }

  public HuespedId getHuespeId() {
    return huespeId;
  }

  public Nombre getNombre() {
    return nombre;
  }

  public Telefono getTelefono() {
    return telefono;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public Correo getCorreo() {
    return correo;
  }
}
