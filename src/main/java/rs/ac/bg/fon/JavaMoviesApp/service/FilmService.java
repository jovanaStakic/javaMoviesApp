
package rs.ac.bg.fon.JavaMoviesApp.service;

import java.util.List;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;

/**
 *
 * @author Jovana Stakic
 */
public interface FilmService {
    Film addFilm(Film film);
    List<Film> getAllFilmsByKorisnik(Long korisnikId);
    List<Film> findFilmoviByCriteria(Film film);
    Film findFilmById(Long id);
}
