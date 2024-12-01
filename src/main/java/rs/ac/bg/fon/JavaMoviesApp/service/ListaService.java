package rs.ac.bg.fon.JavaMoviesApp.service;

import java.util.List;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;

/**
 *
 * @author Jovana Stakic
 */
public interface ListaService {
    Lista saveLista(Lista lista);
    List<Lista> getAllListeByKorisnikId(Long korisnikId);
    Lista updateLista(Lista lista);
    void deleteLista(Long id);
    List<Lista> findListaByNazivAndKorisnik(String naziv, Long korisnikId);
    Lista findListaById(Long id);
    
}
