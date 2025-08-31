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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.CreateUpdateListaConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.ListaConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateUpdateListaDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.ListaDto;
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
    private final CreateUpdateListaConverter createUpdateListaConverter;
    
    public ListaController(ListaService listaService, ListaConverter listaConverter, CreateUpdateListaConverter createUpdateListaConverter) {
        this.listaService = listaService;
        this.listaConverter = listaConverter;
        this.createUpdateListaConverter=createUpdateListaConverter;
    }
    
    @PostMapping
    public ResponseEntity<CreateUpdateListaDto> createLista(@Valid @RequestBody CreateUpdateListaDto listaDto, @AuthenticationPrincipal Korisnik korisnik) {
        Lista lista = createUpdateListaConverter.toEntity(listaDto);
        lista.setKorisnik(korisnik);
        Lista savedLista = listaService.saveLista(lista);
        return new ResponseEntity<>(createUpdateListaConverter.toDto(savedLista), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ListaDto>> getAllListe(@AuthenticationPrincipal Korisnik korisnik) {
        List<Lista> liste = listaService.getAllListeByKorisnikId(korisnik.getId());
        List<ListaDto> listeDto = liste.stream().map(listaConverter::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(listeDto);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<CreateUpdateListaDto> updateLista(@PathVariable @Min(0) Long id,@Valid @RequestBody CreateUpdateListaDto listaDto,@AuthenticationPrincipal Korisnik korisnik) {
        Lista lista = listaService.findListaById(id);
        
        if (!lista.getKorisnik().getId().equals(korisnik.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
        listaDto.setId(id);
        lista = createUpdateListaConverter.toEntity(listaDto);
        lista.setKorisnik(korisnik);
        Lista updatedLista = listaService.updateLista(lista);
        return ResponseEntity.ok(createUpdateListaConverter.toDto(updatedLista));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLista(@PathVariable @Min(0) Long id, @AuthenticationPrincipal Korisnik korisnik) {
        Lista lista = listaService.findListaById(id);
       
        if (!lista.getKorisnik().getId().equals(korisnik.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        listaService.deleteLista(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<ListaDto>> findListaByNaziv(@RequestParam(required = true) String naziv, @AuthenticationPrincipal Korisnik korisnik) {
        List<Lista> liste = listaService.findListaByNazivAndKorisnik(naziv, korisnik.getId());
        List<ListaDto> listaDtos = liste.stream().map(listaConverter::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(listaDtos);
    }
}
