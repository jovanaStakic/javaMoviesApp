package rs.ac.bg.fon.JavaMoviesApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author Jovana Stakic
 */
public class RecenzijaDto implements ApplicationDto {

    private Long id;
    private int ocenaFilma;
    private String utisak;
    private Date datumKreiranja;
    private CreateFilmDto film;

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

    public CreateFilmDto getFilm() {
        return film;
    }

    public void setFilm(CreateFilmDto film) {
        this.film = film;
    }

}
