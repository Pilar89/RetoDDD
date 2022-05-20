package co.com.sofkau.gestionHuespedes.checkIn.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.checkIn.values.Correo;
import co.com.sofkau.gestionHuespedes.checkIn.values.Direccion;
import co.com.sofkau.gestionHuespedes.checkIn.values.Telefono;

public class AgregarHuesped extends Command {

  private final CheckInId checkInId;
  private final Nombre nombre;
  private final Telefono telefono;
  private final Direccion direccion;
  private final Correo correo;

  public AgregarHuesped(CheckInId checkInId, Nombre nombre, Telefono telefono, Direccion direccion, Correo correo) {
    this.checkInId = checkInId;
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    this.correo = correo;
  }

  public CheckInId getCheckInId() {
    return checkInId;
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


