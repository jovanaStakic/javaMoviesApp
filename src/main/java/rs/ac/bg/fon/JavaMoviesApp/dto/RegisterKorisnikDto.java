package rs.ac.bg.fon.JavaMoviesApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Jovana Stakic
 */
public class RegisterKorisnikDto implements ApplicationDto {

    @NotBlank(message = "Korisničko ime je obavezno.")
    private String korisnickoIme;

    @NotBlank(message = "Šifra je obavezna.")
    @Size(min = 6, message = "Šifra mora imati najmanje 6 karaktera.")
    private String sifra;

    @NotBlank(message = "Ime je obavezno.")
    private String ime;

    @NotBlank(message = "Prezime je obavezno.")
    private String prezime;

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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

}
