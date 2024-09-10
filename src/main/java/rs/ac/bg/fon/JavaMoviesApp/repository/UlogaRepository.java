package rs.ac.bg.fon.JavaMoviesApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.JavaMoviesApp.domain.Uloga;

/**
 *
 * @author Jovana Stakic
 */
@Repository
public interface UlogaRepository extends JpaRepository<Uloga, Long> {
    
}

