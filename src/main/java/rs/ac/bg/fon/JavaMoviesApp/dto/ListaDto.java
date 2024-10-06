package rs.ac.bg.fon.JavaMoviesApp.dto;

import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class ListaDto implements ApplicationDto{
    private Long id;
    private String naziv;
    private String opis;
    private Long korisnikId;
    private List<FilmDto> filmovi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public List<FilmDto> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<FilmDto> filmovi) {
        this.filmovi = filmovi;
    }
    
    
    
}
