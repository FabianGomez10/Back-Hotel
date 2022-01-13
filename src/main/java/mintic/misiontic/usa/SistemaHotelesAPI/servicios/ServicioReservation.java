package mintic.misiontic.usa.SistemaHotelesAPI.servicios;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.usa.SistemaHotelesAPI.modelos.Reservation;
import mintic.misiontic.usa.SistemaHotelesAPI.repositorios.RepositorioReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioReservation {

    @Autowired
    private RepositorioReservation metodosCrud;

    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return metodosCrud.getReservation(id);
    }

    public void save(Reservation categoria) {
        if (categoria.getIdReservation() == null) {
            metodosCrud.save(categoria);
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(categoria.getIdReservation());
            if (evt.isEmpty()) {
                metodosCrud.save(categoria);
            }
        }
    }

    public void update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> obtener = metodosCrud.getReservation(reservation.getIdReservation());
            if (!obtener.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    obtener.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    obtener.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getClient()!= null) {
                    obtener.get().setClient(reservation.getClient());
                }
                if (reservation.getRoom()!= null) {
                    obtener.get().setRoom(reservation.getRoom());
                }
                metodosCrud.save(obtener.get());
            }
        }
    }

    public boolean delete(int id) {
        Optional<Reservation> obtener = metodosCrud.getReservation(id);
        if (!obtener.isEmpty()) {
            metodosCrud.delete(obtener.get());
            return true;
        }
        return false;
    }
}
