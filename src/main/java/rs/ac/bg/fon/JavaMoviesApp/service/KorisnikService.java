
package rs.ac.bg.fon.JavaMoviesApp.service;

import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;


/**
 *
 * @author Jovana Stakic
 */
public interface KorisnikService {
    Korisnik login(String korisnickoIme, String sifra);
    Korisnik register(Korisnik korisnik);
    
   
}
