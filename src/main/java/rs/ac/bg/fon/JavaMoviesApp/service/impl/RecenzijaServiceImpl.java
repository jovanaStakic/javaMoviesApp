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
    public List<Recenzija> getAllRecenzijeByKorisnik(Long korinsikId) {
        return recenzijaRepository.findByKorisnik_Id( korinsikId);
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

    @Override
    public Recenzija findRecenizjaById(Long id) {
        return recenzijaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Recenzija sa id-jem: "+id+" nije pronadjena"));
    }

}
