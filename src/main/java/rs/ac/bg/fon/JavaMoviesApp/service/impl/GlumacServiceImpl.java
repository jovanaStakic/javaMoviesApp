package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.JavaMoviesApp.domain.Glumac;
import rs.ac.bg.fon.JavaMoviesApp.repository.GlumacRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.GlumacService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class GlumacServiceImpl implements GlumacService{
       private final GlumacRepository glumacRepository;

    public GlumacServiceImpl(GlumacRepository glumacRepository) {
        this.glumacRepository = glumacRepository;
    }

    @Override
    public List<Glumac> loadAllActors() {
        return glumacRepository.findAll();
    }
}
