package rs.ac.bg.fon.JavaMoviesApp.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.ReziserConverter;
import rs.ac.bg.fon.JavaMoviesApp.dto.ReziserDto;
import rs.ac.bg.fon.JavaMoviesApp.service.ReziserService;

/**
 *
 * @author Jovana Stakic
 */
@RestController
@RequestMapping("/api/reziseri")
public class ReziserController {
    
    private final ReziserService reziserService;
    private final ReziserConverter reziserConverter;

    public ReziserController(ReziserService reziserService,ReziserConverter reziserConverter) {
        this.reziserService = reziserService;
        this.reziserConverter=reziserConverter;
    }
    
    @GetMapping
    public ResponseEntity<List<ReziserDto>> getReziseri(){
        return ResponseEntity.ok(reziserService.getAllReziseri().stream().map(reziserConverter::toDto).toList());
    }
}
