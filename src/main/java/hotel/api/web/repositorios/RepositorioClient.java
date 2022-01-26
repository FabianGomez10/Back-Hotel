package hotel.api.web.repositorios;

import java.util.List;
import java.util.Optional;
import hotel.api.web.modelos.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hotel.api.web.repositorios.crud.InterfaceClient;

@Repository
public class RepositorioClient {

    @Autowired
    private InterfaceClient crud;

    public List<Client> getAll() {
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getClient(int id) {
        return crud.findById(id);
    }

    public Client save(Client categoria) {
        return crud.save(categoria);
    }

    public void delete(Client category) {
        crud.delete(category);
    }
}
