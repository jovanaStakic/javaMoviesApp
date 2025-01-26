package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.exception.AuthenticationException;
import rs.ac.bg.fon.JavaMoviesApp.exception.BadRequestException;
import rs.ac.bg.fon.JavaMoviesApp.repository.KorisnikRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.KorisnikService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class KorisnikServiceImpl implements KorisnikService,UserDetailsService {

    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Korisnik login(Korisnik korisnik) {
        Korisnik existingKorisnik = korisnikRepository.findByKorisnickoIme(korisnik.getKorisnickoIme()).orElseThrow(() -> new AuthenticationException("Korisnik nije pronadjen!"));
        if(!passwordEncoder.matches(korisnik.getSifra(),existingKorisnik.getSifra()))
            throw new AuthenticationException("Pogresna lozinka!");
        return korisnik;
    }

    @Override
    @Transactional
    public Korisnik register(Korisnik korisnik) {
        if(korisnikRepository.existsByKorisnickoIme(korisnik.getKorisnickoIme())){
            throw new BadRequestException("Korisničko ime "+korisnik.getKorisnickoIme()+" već postoji.");
        }
        
        String encodedSifra=passwordEncoder.encode(korisnik.getSifra());
        korisnik.setSifra(encodedSifra);
        return korisnikRepository.save(korisnik);  
    }

   @Override
    public UserDetails loadUserByUsername(String korisnickoIme) throws UsernameNotFoundException {
        return korisnikRepository.findByKorisnickoIme(korisnickoIme)
                .orElseThrow(() -> new UsernameNotFoundException("Korisnik nije pronađen sa korisničkim imenom: " + korisnickoIme));
    }

}
