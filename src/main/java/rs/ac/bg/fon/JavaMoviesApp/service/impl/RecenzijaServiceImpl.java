package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.exception.ResourceNotFoundException;
import rs.ac.bg.fon.JavaMoviesApp.repository.RecenzijaRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.RecenzijaService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class RecenzijaServiceImpl implements RecenzijaService{
    private final RecenzijaRepository recenzijaRepository;

    public RecenzijaServiceImpl(RecenzijaRepository recenzijaRepository) {
        this.recenzijaRepository = recenzijaRepository;
    }

    @Override
    public List<Recenzija> getAllRecenzije() {
        return recenzijaRepository.findAll();
    }

    @Override
    @Transactional
    public Recenzija saveRecenzija(Recenzija recenzija) {
        return recenzijaRepository.save(recenzija);
    }

    @Override
    public List<Recenzija> findRecenzije(Recenzija recenzija) {
        return recenzijaRepository.findByFilm_IdAndKorisnik_Id(recenzija.getFilm().getId(), recenzija.getKorisnik().getId());
    }

    @Override
    @Transactional
    public void deleteRecenzija(Long id) {
        if (!recenzijaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found.");
        }
        recenzijaRepository.deleteById(id);
    }
}
