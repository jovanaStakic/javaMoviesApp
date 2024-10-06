package rs.ac.bg.fon.JavaMoviesApp.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class FilmDto implements ApplicationDto{
    private Long id;
    private String naziv;
    private Date datumIzlaska;
    private int trajanjeFilma;
    private String drzavaPorekla;
    private Long korisnikId;
    private Long zanrId;
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

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
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
