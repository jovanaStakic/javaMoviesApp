
package rs.ac.bg.fon.JavaMoviesApp.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.FilmConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.SearchFilmConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.FilmDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.SearchFilmDto;
import rs.ac.bg.fon.JavaMoviesApp.service.FilmService;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;

/**
 *
 * @author Jovana Stakic
 */
@RestController
@RequestMapping("/api/filmovi")
public class FilmController {

    private final FilmService filmService;
    private final FilmConverter filmConverter;
    private final KorisnikService korisnikService;
    private final SearchFilmConverter searchFilmConverter;
    
    public FilmController(FilmService filmService, FilmConverter filmConverter,KorisnikService korisnikService,SearchFilmConverter searchFilmConverter) {
        this.filmService = filmService;
        this.filmConverter = filmConverter;
        this.korisnikService=korisnikService;
        this.searchFilmConverter=searchFilmConverter;
    }

    @GetMapping
    public ResponseEntity<List<FilmDto>> getAllFilms(@AuthenticationPrincipal String username) {
        Korisnik korisnik=(Korisnik) korisnikService.loadUserByUsername(username);
       List<FilmDto> filmovi = filmService.getAllFilmsByKorisnik(korisnik.getId()).stream()
              .map(filmConverter::toDto)
              .collect(Collectors.toList());
        return ResponseEntity.ok(filmovi);
    }
    
    @PostMapping
    public ResponseEntity<FilmDto> saveFilm(@RequestBody FilmDto filmDto){
        Film film=filmConverter.toEntity(filmDto);
        Film savedFilm=filmService.addFilm(film);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmConverter.toDto(savedFilm));
    }
    
   @PostMapping("/search")
   public ResponseEntity<List<FilmDto>> findFilmsByCriteria(
            @RequestBody SearchFilmDto searchDto,
            @AuthenticationPrincipal String username) {

        Korisnik korisnik = (Korisnik) korisnikService.loadUserByUsername(username);
        
        Film kriterijum = searchFilmConverter.toEntity(searchDto);
        kriterijum.setKorisnik(korisnik);

        List<FilmDto> filmovi = filmService.findFilmoviByCriteria(kriterijum).stream()
                .map(filmConverter::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filmovi);
    }
}