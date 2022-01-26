package hotel.api.web.repositorios.crud;

import hotel.api.web.modelos.Category;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCategory extends CrudRepository<Category, Integer> {

}
