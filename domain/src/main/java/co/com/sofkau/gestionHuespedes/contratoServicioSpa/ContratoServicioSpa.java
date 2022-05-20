package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.Huesped;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.ContratoServicioSpaCreado;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;

import java.util.List;

public class ContratoServicioSpa extends AggregateEvent<ContratoServicioSpaId> {

 protected ContratoServicioSpaId contratoServicioSpaId ;
 protected ServicioSpa servicioSpa;
 protected Huesped huesped;
 protected HabitacionId habitacionId;

  public ContratoServicioSpa(ContratoServicioSpaId contratoServicioSpaId,
                               ServicioSpa servicioSpa, Huesped huesped, HabitacionId habitacionId){
    super(contratoServicioSpaId);
    appendChange(new ContratoServicioSpaCreado(servicioSpa,huesped,habitacionId)).apply();
    subscribe(new ContratoServicoSpaEventChange(this));
  }

  private  ContratoServicioSpa(ContratoServicioSpaId contratoServicioSpaId){
    super(contratoServicioSpaId);
    subscribe(new ContratoServicoSpaEventChange(this) );
  }

  public static ContratoServicioSpa from(ContratoServicioSpaId contratoServicioSpaId, List<DomainEvent>events){
    var  contratoServicioSpa = new ContratoServicioSpa(contratoServicioSpaId);
    events.forEach(contratoServicioSpa::applyEvent);
    return contratoServicioSpa;
  }


}
