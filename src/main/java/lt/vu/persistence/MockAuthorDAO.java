package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
@Alternative
public class MockAuthorDAO implements AuthorDAOInterface{

    private List<Author> mockedAuthors = new ArrayList<>(
            Arrays.asList(
                new Author(1, "dede Petras"),
                new Author(2, "tas Marius"),
                new Author(3, "anas Kujis")
            )
    );

    @Inject
    private EntityManager em;

    public List<Author> loadAll() {
        return mockedAuthors;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Author author){
        this.em.persist(author);
    }

    public Author findOne(Integer id) {
        return em.find(Author.class, id);
    }

    @Override
    public void update(Author existingPerson) {
        em.merge(existingPerson);
        em.flush();
    }
}
