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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.ListaConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;
import rs.ac.bg.fon.JavaMoviesApp.dto.ListaDto;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;
import rs.ac.bg.fon.JavaMoviesApp.service.ListaService;

/**
 *
 * @author Jovana Stakic
 */
@RestController
@RequestMapping("/api/liste")
public class ListaController {
    
    private final ListaService listaService;
    private final ListaConverter listaConverter;
    private final KorisnikService korisnikService;
    
    public ListaController(ListaService listaService, ListaConverter listaConverter, KorisnikService korisnikService) {
        this.listaService = listaService;
        this.listaConverter = listaConverter;
        this.korisnikService = korisnikService;
    }
    
    @PostMapping
    public ResponseEntity<ListaDto> createLista(@Valid @RequestBody ListaDto listaDto, @AuthenticationPrincipal String username) {
        Korisnik korisnik = (Korisnik) korisnikService.loadUserByUsername(username);
        Lista lista = listaConverter.toEntity(listaDto);
        lista.setKorisnik(korisnik);
        Lista savedLista = listaService.saveLista(lista);
        return new ResponseEntity<>(listaConverter.toDto(savedLista), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ListaDto>> getAllListe(@AuthenticationPrincipal String username) {
        Korisnik korisnik = (Korisnik) korisnikService.loadUserByUsername(username);
        List<Lista> liste = listaService.getAllListeByKorisnikId(korisnik.getId());
        List<ListaDto> listeDto = liste.stream()
                .map(listaConverter::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listeDto);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<ListaDto> updateLista(@PathVariable @Min(0) Long listaId, @RequestBody ListaDto listaDto, @AuthenticationPrincipal String username) {
        Korisnik korisnik = (Korisnik) korisnikService.loadUserByUsername(username);
        Lista lista = listaService.findListaById(listaId);
        
        if (!lista.getKorisnik().getId().equals(korisnik.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
        lista = listaConverter.toEntity(listaDto);
        Lista updatedLista = listaService.updateLista(lista);
        return ResponseEntity.ok(listaConverter.toDto(updatedLista));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLista(@PathVariable @Min(0) Long id, @AuthenticationPrincipal String username) {
        Korisnik korisnik = (Korisnik) korisnikService.loadUserByUsername(username);
        Lista lista = listaService.findListaById(id);
       
        if (!lista.getKorisnik().getId().equals(korisnik.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        listaService.deleteLista(id);
        return ResponseEntity.ok("Lista je uspešno obrisana.");
    }
    
    @GetMapping("/naziv/{naziv}")
    public ResponseEntity<List<ListaDto>> findListaByNaziv(@PathVariable String naziv, @AuthenticationPrincipal String username) {
        Korisnik korisnik = (Korisnik) korisnikService.loadUserByUsername(username);
        List<Lista> liste = listaService.findListaByNazivAndKorisnik(naziv, korisnik.getId());
        List<ListaDto> listaDtos = liste.stream().map(listaConverter::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(listaDtos);
    }
}
