package hotel.api.web.servicios;

import java.util.List;
import java.util.Optional;
import hotel.api.web.modelos.Message;
import hotel.api.web.repositorios.RepositorioMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMessage {

    @Autowired
    private RepositorioMessage metodosCrud;

    public List<Message> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return metodosCrud.getMessage(id);
    }

    public void save(Message message) {
        if (message.getIdMessage() == null) {
            metodosCrud.save(message);
        } else {
            Optional<Message> evt = metodosCrud.getMessage(message.getIdMessage());
            if (evt.isEmpty()) {
                metodosCrud.save(message);
            }
        }
    }

    public void update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> catcher = metodosCrud.getMessage(message.getIdMessage());
            if (!catcher.isEmpty()) {
                if (message.getIdMessage() != null) {
                    catcher.get().setIdMessage(message.getIdMessage());
                }
                if (message.getMessageText() != null) {
                    catcher.get().setMessageText(message.getMessageText());
                }
                if (message.getClient()!= null) {
                    catcher.get().setClient(message.getClient());
                }
                if (message.getRoom()!= null) {
                    catcher.get().setRoom(message.getRoom());
                }
                metodosCrud.save(catcher.get());
            }
        }
    }

    public boolean delete(int id) {
        Optional<Message> catcher = metodosCrud.getMessage(id);
        if (!catcher.isEmpty()) {
            metodosCrud.delete(catcher.get());
            return true;
        }
        return false;
    }
}
