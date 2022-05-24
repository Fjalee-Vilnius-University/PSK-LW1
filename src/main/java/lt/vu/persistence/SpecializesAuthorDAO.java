//package lt.vu.persistence;
//
//import lt.vu.entities.Author;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.inject.Specializes;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Specializes
//@ApplicationScoped
//public class SpecializesAuthorDAO extends AuthorDAO{
//    private List<Author> specializedAuthors = new ArrayList<>(
//            Arrays.asList(
//                    new Author(4, "specializedAuthors dede Petras"),
//                    new Author(5, "specializedAuthors tas Marius"),
//                    new Author(6, "specializedAuthors anas Kujis")
//            )
//    );
//    public List<Author> loadAll() {
//        return specializedAuthors;
//    }
//
//}
