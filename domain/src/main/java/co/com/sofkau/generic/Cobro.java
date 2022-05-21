package co.com.sofkau.generic;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.generic.values.CobroId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;


//Si el cobro es el servicio spa checkInId es null
//Si el cobro es de la habitación  contratoServicioSpaI es nulo

public class Cobro extends Entity<CobroId> {

  protected CheckInId checkInId;
  protected ContratoServicioSpaId contratoServicioSpaId;
  protected Costo costo;

  public Cobro(CobroId entityId, CheckInId checkInId, ContratoServicioSpaId contratoServicioSpaId, Costo costo) {
    super(entityId);
    this.checkInId = checkInId;
    this.contratoServicioSpaId = contratoServicioSpaId;
    this.costo = costo;
  }

  public CheckInId getCheckInId() {
    return checkInId;
  }

  public ContratoServicioSpaId getContratoServicioSpaId() {
    return contratoServicioSpaId;
  }

  public Costo getCosto() {
    return costo;
  }


}
