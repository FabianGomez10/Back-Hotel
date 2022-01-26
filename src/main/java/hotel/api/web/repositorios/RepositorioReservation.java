package hotel.api.web.repositorios;

import java.util.List;
import java.util.Optional;
import hotel.api.web.modelos.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hotel.api.web.repositorios.crud.InterfaceReservation;

@Repository
public class RepositorioReservation {

    @Autowired
    private InterfaceReservation crud;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud.findById(id);
    }

    public Reservation save(Reservation categoria) {
        return crud.save(categoria);
    }

    public void delete(Reservation message) {
        crud.delete(message);
    }
}
