package rs.ac.bg.fon.JavaMoviesApp.service;

import java.util.List;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;

/**
 *
 * @author Jovana Stakic
 */
public interface RecenzijaService {
    List<Recenzija> loadAllReviews();

    Recenzija saveReview(Recenzija recenzija);

    List<Recenzija> findReviews(Recenzija recenzija);

    void deleteReview(Long id);
}
