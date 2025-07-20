
package rs.ac.bg.fon.JavaMoviesApp.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.JavaMoviesApp.converter.CreateFilmConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.FilmConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.SearchFilmConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateFilmDto;
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
	private final CreateFilmConverter createFilmConverter;
	private final SearchFilmConverter searchFilmConverter;

	public FilmController(FilmService filmService, CreateFilmConverter createFilmConverter, FilmConverter filmConverter,
			KorisnikService korisnikService, SearchFilmConverter searchFilmConverter) {
		this.filmService = filmService;
		this.filmConverter = filmConverter;
		this.searchFilmConverter = searchFilmConverter;
		this.createFilmConverter = createFilmConverter;
	}

	@GetMapping
	public ResponseEntity<List<FilmDto>> getAllFilms(@AuthenticationPrincipal Korisnik korisnik) {
		List<FilmDto> filmovi = filmService.getAllFilmsByKorisnik(korisnik.getId()).stream().map(filmConverter::toDto)
				.toList();
		return ResponseEntity.ok(filmovi);
	}

	@PostMapping
	public ResponseEntity<CreateFilmDto> saveFilm(@Valid @RequestBody CreateFilmDto filmDto,
			@AuthenticationPrincipal Korisnik korisnik) {
		Film film = createFilmConverter.toEntity(filmDto);
		film.setKorisnik(korisnik);
		Film savedFilm = filmService.addFilm(film);
		return ResponseEntity.status(HttpStatus.CREATED).body(createFilmConverter.toDto(savedFilm));
	}

	@GetMapping("/search")
	public ResponseEntity<List<FilmDto>> findFilmsByCriteria(@RequestParam(required = false) String naziv,
			@RequestParam(required = false) Long reziserId, @RequestParam(required = false) Long zanrId,
			@AuthenticationPrincipal Korisnik korisnik) {
		SearchFilmDto searchDto = new SearchFilmDto();
		searchDto.setNaziv(naziv);
		searchDto.setReziserId(reziserId);
		searchDto.setZanrId(zanrId);
		Film kriterijum = searchFilmConverter.toEntity(searchDto);
		kriterijum.setKorisnik(korisnik);
		List<FilmDto> filmovi = filmService.findFilmoviByCriteria(kriterijum).stream()
				.map(filmConverter::toDto).collect(Collectors.toList());
		return ResponseEntity.ok(filmovi);
	}
}
