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
public class CreateRecenzijaDto implements ApplicationDto {

    private Long id;
    @Min(value = 1, message = "Ocena filma mora biti najmanje 1.")
    @Max(value = 10, message = "Ocena filma ne sme biti veća od 10.")
    private int ocenaFilma;

    @NotBlank(message = "Utisak je obavezan.")
    private String utisak;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datumKreiranja;

    @NotNull(message = "Film ID je obavezan.")
    private Long filmId;

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

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
}
