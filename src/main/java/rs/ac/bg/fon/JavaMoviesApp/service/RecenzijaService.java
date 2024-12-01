package rs.ac.bg.fon.JavaMoviesApp.service;

import java.util.List;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;

/**
 *
 * @author Jovana Stakic
 */
public interface RecenzijaService {

    Recenzija saveRecenzija(Recenzija recenzija);

    List<Recenzija> getAllRecenzijeByKorisnik(Long korisnikId);

    List<Recenzija> findRecenzije(Recenzija recenzija);

    void deleteRecenzija(Long id);

    Recenzija findRecenizjaById(Long id);
}
