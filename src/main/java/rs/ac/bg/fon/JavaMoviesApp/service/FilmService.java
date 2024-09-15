
package rs.ac.bg.fon.JavaMoviesApp.service;

import java.util.List;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;

/**
 *
 * @author Jovana Stakic
 */
public interface FilmService {
 
    Film addFilm(Film film);
    
    List<Film> getAllFilms();
    
    List<Film> findFilmsByCriteria(Film film);
}
