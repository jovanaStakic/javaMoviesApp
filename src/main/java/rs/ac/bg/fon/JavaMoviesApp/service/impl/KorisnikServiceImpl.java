package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.exception.AuthenticationException;
import rs.ac.bg.fon.JavaMoviesApp.exception.BadRequestException;
import rs.ac.bg.fon.JavaMoviesApp.exception.InternalServerErrorException;
import rs.ac.bg.fon.JavaMoviesApp.repository.KorisnikRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Korisnik login(String korisnickoIme, String sifra) {
        Korisnik korisnik = korisnikRepository.findByKorisnickoIme(korisnickoIme).orElseThrow(() -> new AuthenticationException("Korisnik nije pronadjen!"));
        if(!passwordEncoder.matches(sifra, korisnik.getSifra()))
            throw new AuthenticationException("Pogresna lozinka!");
        return korisnik;
    }

    @Override
    @Transactional
    public Korisnik register(Korisnik korisnik) {
        if(korisnikRepository.existsByKorisnickoIme(korisnik.getKorisnickoIme())){
            throw new BadRequestException("Korisničko ime "+korisnik.getIme()+" već postoji.");
        }
        
        String encodedSifra=passwordEncoder.encode(korisnik.getSifra());
        korisnik.setSifra(encodedSifra);
        return korisnikRepository.save(korisnik);  
    }

}
