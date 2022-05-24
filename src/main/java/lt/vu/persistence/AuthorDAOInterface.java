package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.persistence.EntityManager;
import java.util.List;

public interface AuthorDAOInterface {
    List<Author> loadAll();

    void setEm(EntityManager em);
    void persist(Author author);
    Author findOne(Integer id);
}
