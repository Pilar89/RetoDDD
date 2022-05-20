package co.com.sofkau.gestionHuespedes.checkOut.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.CobroId;
import co.com.sofkau.generic.values.Costo;
import co.com.sofkau.gestionHuespedes.checkIn.values.CheckInId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;

public class CobroAgregadoAFactura extends DomainEvent {

  private final CobroId cobroId;
  private final CheckInId checkInId;
  private final ContratoServicioSpaId contratoServicioSpaId;
  private final Costo costo;

  public CobroAgregadoAFactura(CobroId cobroId, CheckInId checkInId,
                               ContratoServicioSpaId contratoServicioSpaId,
                               Costo costo){
    super("co.com.sofkau.gestionHuespedes.CobroAgregadoAFactura");
    this.cobroId = cobroId;
    this.checkInId = checkInId;
    this.contratoServicioSpaId = contratoServicioSpaId;
    this.costo = costo;
  }

  public CobroId getCobroId() {
    return cobroId;
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
