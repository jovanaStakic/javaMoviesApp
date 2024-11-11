
package rs.ac.bg.fon.JavaMoviesApp.service;

import java.util.List;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;

/**
 *
 * @author Jovana Stakic
 */
public interface FilmService {
 
    Film addFilm(Film film);
    
    List<Film> getAllFilmsByKorisnik(Long korisnikId);
    
    List<Film> findFilmoviByCriteria(Film film);
}
