package rs.ac.bg.fon.JavaMoviesApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.LoginKorisnikConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.RegisterKorisnikConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.LoginKorisnikDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.RegisterKorisnikDto;
import rs.ac.bg.fon.JavaMoviesApp.jwt.JwtUtil;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;

/**
 *
 * @author Jovana Stakic
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final RegisterKorisnikConverter registerKorisnikConverter;
    private final LoginKorisnikConverter loginKorisnikConverter;
    private final KorisnikService korisnikService;
    private final JwtUtil jwtUtil;

    public AuthController(RegisterKorisnikConverter registerKorisnikConverter, LoginKorisnikConverter loginKorisnikConverter, KorisnikService korisnikService, JwtUtil jwtUtil) {
        this.registerKorisnikConverter = registerKorisnikConverter;
        this.loginKorisnikConverter = loginKorisnikConverter;
        this.korisnikService = korisnikService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterKorisnikDto dto) {
        System.out.println("Register route accessed");
        Korisnik korisnik = registerKorisnikConverter.toEntity(dto);
        korisnikService.register(korisnik);
        return ResponseEntity.status(HttpStatus.CREATED).body("Korisnik uspešno registrovan!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginKorisnikDto loginKorisnikDto) {
        System.out.println("Login route accessed");
        Korisnik korisnik = korisnikService.login(loginKorisnikConverter.toEntity(loginKorisnikDto));
        String token = jwtUtil.generateToken(korisnik.getKorisnickoIme());
        return ResponseEntity.ok("Bearer " + token);

    }
}
