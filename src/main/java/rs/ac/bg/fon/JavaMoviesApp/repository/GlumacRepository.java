package rs.ac.bg.fon.JavaMoviesApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.JavaMoviesApp.domain.Glumac;

/**
 *
 * @author Jovana stakic
 */
@Repository
public interface GlumacRepository extends JpaRepository<Glumac, Long>{

}
