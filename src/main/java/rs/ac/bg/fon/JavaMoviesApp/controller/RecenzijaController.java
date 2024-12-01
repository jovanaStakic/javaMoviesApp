package rs.ac.bg.fon.JavaMoviesApp.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import rs.ac.bg.fon.JavaMoviesApp.converter.RecenzijaCoverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.dto.FilmDto;
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
    
    public RecenzijaController(RecenzijaService recenzijaService, RecenzijaCoverter recenzijaConverter, KorisnikService korisnikService) {
        this.recenzijaService = recenzijaService;
        this.recenzijaConverter = recenzijaConverter;
        this.korisnikService=korisnikService;
    }

   @GetMapping
    public ResponseEntity<List<RecenzijaDto>> getAllRecenzije(@AuthenticationPrincipal String username) {
         Korisnik korisnik=(Korisnik) korisnikService.loadUserByUsername(username);
          List<RecenzijaDto> recenzije = recenzijaService.getAllRecenzijeByKorisnik(korisnik.getId()).stream()
              .map(recenzijaConverter::toDto)
              .collect(Collectors.toList());
    
        return ResponseEntity.ok(recenzije);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecenzijaDto>> findRecenzije(@RequestBody RecenzijaDto recenzijaDto,@AuthenticationPrincipal String username) {
         Korisnik korisnik=(Korisnik) korisnikService.loadUserByUsername(username);
        recenzijaDto.setKorisnikId(korisnik.getId());
        Recenzija recenzija = recenzijaConverter.toEntity(recenzijaDto);
        List<RecenzijaDto> recenzije = recenzijaService.findRecenzije(recenzija).stream()
                .map(recenzijaConverter::toDto).toList();
        return ResponseEntity.ok(recenzije);
    }

    @PostMapping
    public ResponseEntity<RecenzijaDto> createRecenzija(@RequestBody RecenzijaDto recenzijaDto,@AuthenticationPrincipal String username) {
        Korisnik korisnik=(Korisnik) korisnikService.loadUserByUsername(username);
        recenzijaDto.setKorisnikId(korisnik.getId());
        Recenzija recenzija = recenzijaConverter.toEntity(recenzijaDto);
        Recenzija savedRecenzija = recenzijaService.saveRecenzija(recenzija);
        return ResponseEntity.status(HttpStatus.CREATED).body(recenzijaConverter.toDto(savedRecenzija));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecenzija(@PathVariable Long id,@AuthenticationPrincipal String username) {
         Korisnik korisnik=(Korisnik) korisnikService.loadUserByUsername(username);
         Recenzija recenzija=recenzijaService.findRecenizjaById(id);
         if(recenzija.getKorisnik().getId().equals(korisnik.getId())){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
         }
        recenzijaService.deleteRecenzija(id);
        return ResponseEntity.ok("Recenzija je uspešno obrisana.");
    }
}
