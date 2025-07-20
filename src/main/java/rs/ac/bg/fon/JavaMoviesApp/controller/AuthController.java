package rs.ac.bg.fon.JavaMoviesApp.controller;

import jakarta.validation.Valid;

import java.util.Map;

import org.hibernate.type.descriptor.jdbc.JsonAsStringJdbcType;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.JavaMoviesApp.converter.LoginKorisnikConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.RegisterKorisnikConverter;
import rs.ac.bg.fon.JavaMoviesApp.converter.SuccessLoginConverter;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.LoginKorisnikDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.RegisterKorisnikDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.SuccessLoginDto;
import rs.ac.bg.fon.JavaMoviesApp.jwt.JwtUtil;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;

/**
 *
 * @author Jovana Stakic
 */
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final RegisterKorisnikConverter registerKorisnikConverter;
    private final LoginKorisnikConverter loginKorisnikConverter;
    private final SuccessLoginConverter successLoginConverter;
    private final KorisnikService korisnikService;
    private final JwtUtil jwtUtil;

    public AuthController(RegisterKorisnikConverter registerKorisnikConverter, LoginKorisnikConverter loginKorisnikConverter,
    		KorisnikService korisnikService, JwtUtil jwtUtil, SuccessLoginConverter successLoginConverter) {
        this.registerKorisnikConverter = registerKorisnikConverter;
        this.loginKorisnikConverter = loginKorisnikConverter;
        this.korisnikService = korisnikService;
        this.jwtUtil = jwtUtil;
        this.successLoginConverter=successLoginConverter;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterKorisnikDto> register(@Valid @RequestBody RegisterKorisnikDto regosterKorisnikDto) {
        Korisnik korisnik = registerKorisnikConverter.toEntity(regosterKorisnikDto);
        korisnikService.register(korisnik);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerKorisnikConverter.toDto(korisnik));
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessLoginDto> loginUser(@Valid @RequestBody LoginKorisnikDto loginKorisnikDto) {
        Korisnik korisnik = korisnikService.login(loginKorisnikConverter.toEntity(loginKorisnikDto));
        String token = jwtUtil.generateToken(korisnik.getKorisnickoIme());
       
        SuccessLoginDto body=successLoginConverter.toDto(korisnik);
        body.setToken(token);
        return ResponseEntity.ok(body);

    }
}
