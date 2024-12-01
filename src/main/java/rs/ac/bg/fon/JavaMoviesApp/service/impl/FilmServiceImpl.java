package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.exception.ResourceNotFoundException;
import rs.ac.bg.fon.JavaMoviesApp.repository.FilmRepository;
import rs.ac.bg.fon.JavaMoviesApp.repository.UlogaRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.FilmService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class FilmServiceImpl implements FilmService{
      private final FilmRepository filmRepository;
      private final UlogaRepository ulogaRepository;

    public FilmServiceImpl(FilmRepository filmRepository, UlogaRepository ulogaRepository) {
        this.filmRepository = filmRepository;
        this.ulogaRepository=ulogaRepository;
    }

    @Transactional
    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> findFilmoviByCriteria(Film film) {
         if (film.getNaziv() != null) {
            return filmRepository.findByNazivAndKorisnik_Id(film.getNaziv(),film.getKorisnik().getId());
        } else if (film.getReziser() != null && film.getReziser().getId() != null) {
            return filmRepository.findByReziser_IdAndKorisnik_Id(film.getReziser().getId(),film.getKorisnik().getId());
        } else if (film.getZanr() != null && film.getZanr().getId() != null) {
            return filmRepository.findByZanr_IdAndKorisnik_Id(film.getZanr().getId(),film.getKorisnik().getId());
        }
        return List.of();
    }

    @Override
    public List<Film> getAllFilmsByKorisnik(Long korisnikId) {
        return filmRepository.findByKorisnik_Id(korisnikId);    }

    @Override
    public Film findFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Ne postoji film koji ima id: "+id));
    }

}
