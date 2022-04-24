package lt.vu.entities;

import javax.persistence.*;

@Entity
public class Contacts {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String contactDescription;

    @Basic
    public String getContactDescription() {
        return contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }

    private String contactInfo;

    @Basic
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @ManyToOne(optional = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name="Author_Id")
    private Author author;
}
