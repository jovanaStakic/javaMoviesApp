package rs.ac.bg.fon.JavaMoviesApp.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.RecenzijaCoverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.dto.RecenzijaDto;
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

    public RecenzijaController(RecenzijaService recenzijaService, RecenzijaCoverter recenzijaConverter) {
        this.recenzijaService = recenzijaService;
        this.recenzijaConverter = recenzijaConverter;
    }

   @GetMapping
    public ResponseEntity<List<RecenzijaDto>> getAllRecenzije() {
        List<RecenzijaDto> recenzije = recenzijaService.getAllRecenzije().stream()
                .map(recenzijaConverter::toDto).toList();
        return ResponseEntity.ok(recenzije);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecenzijaDto>> findRecenzije(@RequestParam Long filmId, @RequestParam Long korisnikId) {
        Recenzija kriterijum = new Recenzija();
        kriterijum.setFilm(new Film());
        kriterijum.getFilm().setId(filmId);
        kriterijum.setKorisnik(new Korisnik());
        kriterijum.getKorisnik().setId(korisnikId);

        List<RecenzijaDto> recenzije = recenzijaService.findRecenzije(kriterijum).stream()
                .map(recenzijaConverter::toDto).toList();
        return ResponseEntity.ok(recenzije);
    }

    @PostMapping
    public ResponseEntity<RecenzijaDto> createRecenzija(@RequestBody RecenzijaDto recenzijaDto) {
        Recenzija recenzija = recenzijaConverter.toEntity(recenzijaDto);
        Recenzija savedRecenzija = recenzijaService.saveRecenzija(recenzija);
        return ResponseEntity.status(HttpStatus.CREATED).body(recenzijaConverter.toDto(savedRecenzija));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecenzija(@PathVariable Long id) {
        recenzijaService.deleteRecenzija(id);
        return ResponseEntity.ok("Recenzija je uspešno obrisana.");
    }
}
