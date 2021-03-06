package co.com.sofkau.gestionHuespedes.checkIn;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.Correo;
import co.com.sofkau.gestionHuespedes.checkIn.values.Direccion;
import co.com.sofkau.gestionHuespedes.checkIn.values.HuespedId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Telefono;

public class Huesped extends Entity<HuespedId> {
  protected Nombre nombre;
  protected Telefono telefono;
  protected Direccion direccion;
  protected Correo correo;

  public Huesped(HuespedId huespeId, Nombre nombre, Telefono telefono, Direccion direccion, Correo correo) {
    super(huespeId);
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.correo = correo;
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

  public void updateNombre(Nombre nombre) {
    this.nombre = nombre;
  }

  public void updateTelefono(Telefono telefono) {
    this.telefono = telefono;
  }

  public void updateDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public void updateCorreo(Correo correo) {
    this.correo = correo;
  }
}
