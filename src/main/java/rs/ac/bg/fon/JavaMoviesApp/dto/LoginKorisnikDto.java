
package rs.ac.bg.fon.JavaMoviesApp.dto;

/**
 *
 * @author Jovana Stakic
 */
public class LoginKorisnikDto implements ApplicationDto{
    private String korisnickoIme;
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
