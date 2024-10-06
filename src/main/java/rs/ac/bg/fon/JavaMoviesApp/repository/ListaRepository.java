package rs.ac.bg.fon.JavaMoviesApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;

/**
 *
 * @author Jovana Stakic
 */
@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {

    List<Lista> findByNazivListe(String nazivListe);

    List<Lista> findByKorisnik_Id(Long korisnikId);
}
