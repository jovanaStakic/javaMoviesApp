package rs.ac.bg.fon.JavaMoviesApp.dto;

/**
 *
 * @author Jovana Stakic
 */
public class KorisnikDto implements ApplicationDto{
    private Long id;
    private String korisnickoIme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    
}
