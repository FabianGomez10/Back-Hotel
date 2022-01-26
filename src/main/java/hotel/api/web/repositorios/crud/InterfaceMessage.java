package hotel.api.web.repositorios.crud;

import hotel.api.web.modelos.Message;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceMessage extends CrudRepository<Message, Integer> {

}
