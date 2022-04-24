package lt.vu.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String Name;

    @Basic(optional = false)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
