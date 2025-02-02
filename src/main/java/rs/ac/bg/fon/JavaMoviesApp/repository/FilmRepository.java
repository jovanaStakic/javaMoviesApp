package rs.ac.bg.fon.JavaMoviesApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;

/**
 *
 * @author Jovana Stakic
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long>,JpaSpecificationExecutor<Film>{
     
    List<Film> findByNazivAndKorisnik_Id(String naziv, Long korisnikId);

    List<Film> findByReziser_IdAndKorisnik_Id(Long reziserId, Long korisnikId);

    List<Film> findByZanr_IdAndKorisnik_Id(Long zanrId, Long korisnikId);
    
    List<Film> findByKorisnik_Id(Long korisnikId);
}
