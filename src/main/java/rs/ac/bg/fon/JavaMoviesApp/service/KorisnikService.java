
package rs.ac.bg.fon.JavaMoviesApp.service;

import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;


/**
 *
 * @author Jovana Stakic
 */
public interface KorisnikService{
    Korisnik login(Korisnik korisnik);
    Korisnik register(Korisnik korisnik);
    
   
}
