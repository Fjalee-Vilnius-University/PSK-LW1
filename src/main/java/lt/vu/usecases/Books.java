//package lt.vu.usecases;
//
//import lombok.Getter;
//import lombok.Setter;
//import lt.vu.entities.Author;
//import lt.vu.entities.Book;
//import lt.vu.persistence.AuthorDAO;
//import lt.vu.persistence.BooksDAO;
//
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Model;
//import javax.inject.Inject;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Model
//public class Books {
//
//    @Inject
//    private BooksDAO booksDAO;
//
//    @Getter @Setter
//    private Book bookToCreate = new Book();
//
//    @Getter
//    private List<Book> allBooks;
//
//    @PostConstruct
//    public void init(){
//        loadAllBooks();
//    }
//
//    @Transactional
//    public void createBook(){
//        this.booksDAO.persist(bookToCreate);
//    }
//
//    private void loadAllBooks(){
//        this.allBooks = booksDAO.loadAll();
//    }
//}
