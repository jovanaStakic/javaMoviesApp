
package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.JavaMoviesApp.domain.Reziser;
import rs.ac.bg.fon.JavaMoviesApp.repository.ReziserRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.ReziserService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class ReziserServiceImpl implements ReziserService{
    private final ReziserRepository reziserRepository;

    public ReziserServiceImpl(ReziserRepository reziserRepository) {
        this.reziserRepository = reziserRepository;
    }

    @Override
    public List<Reziser> getAllReziseri() {
        return reziserRepository.findAll();
    }
}
