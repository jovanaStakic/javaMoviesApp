package rs.ac.bg.fon.JavaMoviesApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;

/**
 *
 * @author Jovana Stakic
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
    List<Film> findByNaziv(String naziv);
    List<Film> findByReziser_ImePrezime(String imePrezime);
    List<Film> findByZanr_NazivZanra(String nazivZanra);
}
