package hotel.api.web.repositorios;

import java.util.List;
import java.util.Optional;
import hotel.api.web.modelos.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hotel.api.web.repositorios.crud.InterfaceCategory;

@Repository
public class RepositorioCategory {

    @Autowired
    private InterfaceCategory crud;

    public List<Category> getAll() {
        return (List<Category>) crud.findAll();
    }

    public Optional<Category> getCategoria(int id) {
        return crud.findById(id);
    }

    public Category save(Category categoria) {
        return crud.save(categoria);
    }

    public void delete(Category category) {
        crud.delete(category);
    }
}
