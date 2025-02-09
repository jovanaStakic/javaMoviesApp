package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.exception.ResourceNotFoundException;
import rs.ac.bg.fon.JavaMoviesApp.repository.FilmRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.FilmService;
import rs.ac.bg.fon.JavaMoviesApp.specification.FilmSpecification;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Transactional
    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> findFilmoviByCriteria(Film kriterijum) {
        return filmRepository.findAll(new FilmSpecification(kriterijum));
    }

    @Override
    public List<Film> getAllFilmsByKorisnik(Long korisnikId) {
        return filmRepository.findByKorisnik_Id(korisnikId);
    }

    @Override
    public Film findFilmById(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            return optionalFilm.get();
        } else {
            throw new ResourceNotFoundException("Ne postoji film koji ima id: " + id);
        }
    }

}
