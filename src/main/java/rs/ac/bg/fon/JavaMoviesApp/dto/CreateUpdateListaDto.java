/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nlLonbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.JavaMoviesApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author Administrator
 */
public class CreateUpdateListaDto implements ApplicationDto {

    private Long id;

    @NotBlank(message = "Naziv liste je obavezan.")
    private String nazivListe;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datumKreiranja;

    @UniqueElements(message = "Lista filmova ne sme sadržavati duplikate.")
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
