
package rs.ac.bg.fon.JavaMoviesApp.dto;

import java.util.Date;

/**
 *
 * @author Jovana Stakic
 */
public class RecenzijaDto {
    private Long id;
    private int ocenaFilma;
    private String utisak;
    private Date datumKreiranja;
    private FilmDto film;
    private Long korisnikId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(int ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    public String getUtisak() {
        return utisak;
    }

    public void setUtisak(String utisak) {
        this.utisak = utisak;
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

    public FilmDto getFilmId() {
        return film;
    }

    public void setFilmId(FilmDto film) {
        this.film = film;
    }

 
}
