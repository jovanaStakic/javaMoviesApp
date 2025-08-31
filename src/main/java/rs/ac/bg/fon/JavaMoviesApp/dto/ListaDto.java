package rs.ac.bg.fon.JavaMoviesApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class ListaDto implements ApplicationDto {

    private Long id;

    private String nazivListe;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datumKreiranja;

    @NotEmpty(message = "Lista filmova ne sme biti prazna.")
    private List<FilmDto> filmovi;

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


    public List<FilmDto> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<FilmDto> filmovi) {
        this.filmovi = filmovi;
    }

}
