//package lt.vu.usecases;
//
//
//import lombok.Getter;
//import lombok.Setter;
//import lt.vu.entities.Book;
//import lt.vu.entities.Player;
//import lt.vu.interceptors.LoggedInvocation;
//import lt.vu.persistence.BooksDAO;
//import lt.vu.persistence.PlayersDAO;
//
//import javax.annotation.PostConstruct;
//import javax.faces.context.FacesContext;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.persistence.OptimisticLockException;
//import javax.transaction.Transactional;
//import java.io.Serializable;
//import java.util.Map;
//
//@ViewScoped
//@Named
//@Getter @Setter
//public class UpdateBookDetails implements Serializable {
//
//    private Book book;
//
//    @Inject
//    private BooksDAO booksDAO;
//
//    @PostConstruct
//    private void init() {
//        System.out.println("UpdateBookDetails INIT CALLED");
//        Map<String, String> requestParameters =
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        Integer bookId = Integer.parseInt(requestParameters.get("bookId"));
//        this.book = booksDAO.findOne(bookId);
//    }
////
////    @Transactional
////    @LoggedInvocation
////    public String updatePlayerJerseyNumber() {
////        try{
////            playersDAO.update(this.book);
////        } catch (OptimisticLockException e) {
////            return "/playerDetails.xhtml?faces-redirect=true&playerId=" + this.player.getId() + "&error=optimistic-lock-exception";
////        }
////        return "players.xhtml?teamId=" + this.player.getTeam().getId() + "&faces-redirect=true";
////    }
//}
