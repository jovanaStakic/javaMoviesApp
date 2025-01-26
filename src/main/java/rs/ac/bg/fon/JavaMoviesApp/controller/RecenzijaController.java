package rs.ac.bg.fon.JavaMoviesApp.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.CreateRecenzijaConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.RecenzijaCoverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateRecenzijaDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.RecenzijaDto;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;
import rs.ac.bg.fon.JavaMoviesApp.service.RecenzijaService;

/**
 *
 * @author Jovana Stakic
 */
@RestController
@RequestMapping("/api/recenzije")
public class RecenzijaController {

    private final RecenzijaService recenzijaService;
    private final RecenzijaCoverter recenzijaConverter;
    private final KorisnikService korisnikService;
    private final CreateRecenzijaConverter createRecenzijaConverter;

    public RecenzijaController(RecenzijaService recenzijaService, RecenzijaCoverter recenzijaConverter, KorisnikService korisnikService,
            CreateRecenzijaConverter createRecenzijaConverter) {
        this.recenzijaService = recenzijaService;
        this.recenzijaConverter = recenzijaConverter;
        this.korisnikService = korisnikService;
        this.createRecenzijaConverter=createRecenzijaConverter;
    }

    @GetMapping
    public ResponseEntity<List<RecenzijaDto>> getAllRecenzije(@AuthenticationPrincipal Korisnik korisnik) {
        List<RecenzijaDto> recenzije = recenzijaService.getAllRecenzijeByKorisnik(korisnik.getId()).stream()
                .map(recenzijaConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(recenzije);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecenzijaDto>> findRecenzije(@RequestParam(required = true) @Min(0) Long filmId, @AuthenticationPrincipal Korisnik korisnik) {
        Recenzija recenzija = new Recenzija();
        recenzija.setKorisnik(korisnik);
        recenzija.setFilm(new Film());
        recenzija.getFilm().setId(filmId);
        List<RecenzijaDto> recenzije = recenzijaService.findRecenzije(recenzija).stream()
                .map(recenzijaConverter::toDto).toList();
        return ResponseEntity.ok(recenzije);
    }

    @PostMapping
    public ResponseEntity<CreateRecenzijaDto> createRecenzija(@Valid @RequestBody CreateRecenzijaDto recenzijaDto, @AuthenticationPrincipal Korisnik korisnik) {
        Recenzija recenzija = createRecenzijaConverter.toEntity(recenzijaDto);
        recenzija.setKorisnik(korisnik);
        Recenzija savedRecenzija = recenzijaService.saveRecenzija(recenzija);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRecenzijaConverter.toDto(savedRecenzija));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecenzija(@PathVariable @Min(0) Long id, @AuthenticationPrincipal Korisnik korisnik) {
        Recenzija recenzija = recenzijaService.findRecenizjaById(id);
        if (!recenzija.getKorisnik().getId().equals(korisnik.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        recenzijaService.deleteRecenzija(id);
        return ResponseEntity.ok("Recenzija je uspešno obrisana.");
    }
}
