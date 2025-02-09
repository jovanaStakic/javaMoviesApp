
package rs.ac.bg.fon.JavaMoviesApp.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.GenericConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.ZanrConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.dto.ZanrDto;
import rs.ac.bg.fon.JavaMoviesApp.service.ZanrService;

/**
 *
 * @author Jovana Stakic
 */ 
@RestController
@RequestMapping("/api")
public class ZanrController {

    private final ZanrService zanrService;
    private final GenericConverter<ZanrDto, Zanr> zanrConverter = new ZanrConverter();

    public ZanrController(ZanrService zanrService) {
        this.zanrService = zanrService;
    }
    
    @GetMapping("/zanrovi")
    public ResponseEntity<List<ZanrDto>> getAllZanrovi() {
        return ResponseEntity.ok(zanrService.getAllZanrovi().stream().map(zanrConverter::toDto).collect(Collectors.toList()));
    }
}
