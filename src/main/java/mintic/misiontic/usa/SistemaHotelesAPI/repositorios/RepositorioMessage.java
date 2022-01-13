package mintic.misiontic.usa.SistemaHotelesAPI.repositorios;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.usa.SistemaHotelesAPI.modelos.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mintic.misiontic.usa.SistemaHotelesAPI.repositorios.crud.InterfaceMessage;

@Repository
public class RepositorioMessage {

    @Autowired
    private InterfaceMessage crud;

    public List<Message> getAll() {
        return (List<Message>) crud.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return crud.findById(id);
    }

    public Message save(Message message) {
        return crud.save(message);
    }

    public void delete(Message message) {
        crud.delete(message);
    }
}
