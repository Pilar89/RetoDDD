package co.com.sofkau.generic;

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
}
