package rs.ac.bg.fon.JavaMoviesApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class ListaDto implements ApplicationDto {

    private Long id;

    @NotBlank(message = "Naziv liste je obavezan.")
    private String nazivListe;

    @NotNull(message = "Datum kreiranja liste je obavezan.")
    private Date datumKreiranja;

    @NotEmpty(message = "Lista filmova ne sme biti prazna.")
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


    public List<Long> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<Long> filmovi) {
        this.filmovi = filmovi;
    }

}
