package lt.vu.decorator;

import lt.vu.entities.Author;
import lt.vu.persistence.AuthorDAO;
import lt.vu.persistence.AuthorDAOInterface;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Decorator
public class AuthorDecorator implements AuthorDAOInterface {
    @Inject
    @Delegate
    AuthorDAOInterface authorInterface;

    @Override
    public List<Author> loadAll(){
        System.out.println("decorator: before load");
        List<Author> results = authorInterface.loadAll();
        System.out.println("decorator: after load");
        return results;
    }

    @Override
    public void setEm(EntityManager em){
        authorInterface.setEm(em);
    }

    @Override
    public void persist(Author author) {
        authorInterface.persist(author);
    }

    @Override
    public Author findOne(Integer id) {
        return authorInterface.findOne(id);
    }
}
