package hotel.api.web.repositorios.crud;

import hotel.api.web.modelos.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceReservation extends CrudRepository<Reservation, Integer> {

}
