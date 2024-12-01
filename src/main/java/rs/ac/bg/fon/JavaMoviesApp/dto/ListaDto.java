package rs.ac.bg.fon.JavaMoviesApp.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class ListaDto implements ApplicationDto{
    private Long id;
    private String nazivListe;
    private Date datumKreiranja;
    private Long korisnikId;
    private List<Long> filmovi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivListe() {
        return nazivListe;
    }

    public void setNazivListe(String nazivListe) {
        this.nazivListe = nazivListe;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public List<Long> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<Long> filmovi) {
        this.filmovi = filmovi;
    }
    
    
    
}
