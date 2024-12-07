
package rs.ac.bg.fon.JavaMoviesApp.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Jovana Stakic
 */
public class LoginKorisnikDto implements ApplicationDto{
    @NotBlank(message = "Korisničko ime je obavezno.")
    private String korisnickoIme;

    @NotBlank(message = "Šifra je obavezna.")
    private String sifra;

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
    
}
