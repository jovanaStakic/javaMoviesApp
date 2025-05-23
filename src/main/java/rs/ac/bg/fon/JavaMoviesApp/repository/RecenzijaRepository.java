package rs.ac.bg.fon.JavaMoviesApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;

/**
 *
 * @author Jovana Stakic
 */
@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {

    List<Recenzija> findByKorisnik_Id( Long korisnikId);

    List<Recenzija> findByFilm_IdAndKorisnik_Id(Long filmId, Long korisnikId);
}
