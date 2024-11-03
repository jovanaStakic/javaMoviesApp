
package rs.ac.bg.fon.JavaMoviesApp.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;


/**
 *
 * @author Jovana Stakic
 */
public interface KorisnikService extends UserDetailsService{
    Korisnik login(Korisnik korisnik);
    Korisnik register(Korisnik korisnik);
    
   
}
