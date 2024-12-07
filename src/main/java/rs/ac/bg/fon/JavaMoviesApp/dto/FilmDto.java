package rs.ac.bg.fon.JavaMoviesApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class FilmDto implements ApplicationDto{
    
    private Long id;
    @NotBlank(message = "Naziv filma je obavezan.")
    @Size(max = 255, message = "Naziv filma ne sme biti duži od 255 karaktera.")
    private String naziv;
    
    @Past
    @NotNull(message = "Datum izlaska filma je obavezan.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datumIzlaska;
    
    @Positive(message = "Trajanje filma mora biti pozitivno.")
    private int trajanjeFilma;
      
    @Positive(message = "Trajanje filma mora biti pozitivno.")
    @NotBlank(message = "Država porekla je obavezna.")
    private String drzavaPorekla;

    @NotNull(message = "ID žanra je obavezan.")
    private Long zanrId;

    @NotNull(message = "ID režisera je obavezan.")
    private Long reziserId;
    private List<UlogaDto> uloge;

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

    public Date getDatumIzlaska() {
        return datumIzlaska;
    }

    public void setDatumIzlaska(Date datumIzlaska) {
        this.datumIzlaska = datumIzlaska;
    }

    public int getTrajanjeFilma() {
        return trajanjeFilma;
    }

    public void setTrajanjeFilma(int trajanjeFilma) {
        this.trajanjeFilma = trajanjeFilma;
    }

    public String getDrzavaPorekla() {
        return drzavaPorekla;
    }

    public void setDrzavaPorekla(String drzavaPorekla) {
        this.drzavaPorekla = drzavaPorekla;
    }

    public Long getZanrId() {
        return zanrId;
    }

    public void setZanrId(Long zanrId) {
        this.zanrId = zanrId;
    }

    public Long getReziserId() {
        return reziserId;
    }

    public void setReziserId(Long reziserId) {
        this.reziserId = reziserId;
    }

    public List<UlogaDto> getUloge() {
        return uloge;
    }

    public void setUloge(List<UlogaDto> uloge) {
        this.uloge = uloge;
    }
    
    
}
