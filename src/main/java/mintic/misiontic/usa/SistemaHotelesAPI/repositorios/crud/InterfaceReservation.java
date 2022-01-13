package mintic.misiontic.usa.SistemaHotelesAPI.repositorios.crud;

import mintic.misiontic.usa.SistemaHotelesAPI.modelos.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceReservation extends CrudRepository<Reservation, Integer> {

}
