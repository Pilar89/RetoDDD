package co.com.sofkau.gestionHuespedes.contratoServicioSpa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.gestionHuespedes.checkIn.Huesped;
import co.com.sofkau.gestionHuespedes.checkIn.values.HabitacionHotelId;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.events.ContratoServicioSpaCreado;
import co.com.sofkau.gestionHuespedes.contratoServicioSpa.values.ContratoServicioSpaId;

import java.util.List;

public class ContratoServicioSpa extends AggregateEvent<ContratoServicioSpaId> {

 protected ContratoServicioSpaId contratoServicioSpaId ;
 protected ServicioSpa servicioSpa;
 protected EmpleadoSpa empleadoSpa;
 protected HabitacionHotelId habitacionId;
 protected HabitacionSpa habitacionSpa;

  public ContratoServicioSpa(ContratoServicioSpaId contratoServicioSpaId,
                               ServicioSpa servicioSpa,EmpleadoSpa empleadoSpa, HabitacionHotelId habitacionId, HabitacionSpa habitacionSpa){
    super(contratoServicioSpaId);
    appendChange(new ContratoServicioSpaCreado(servicioSpa,empleadoSpa,habitacionId,habitacionSpa)).apply();
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
