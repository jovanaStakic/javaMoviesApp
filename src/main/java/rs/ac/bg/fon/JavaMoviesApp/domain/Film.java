
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private Date datumIzlaska;
    private int trajanjeFilma;
    private String drzavaPorekla;
    @ManyToOne
    @JoinColumn(name="korisnikID")
    private Korisnik korisnik;
    @ManyToOne
    @JoinColumn(name = "zanrID")
    private Zanr zanr;
    @ManyToOne
    @JoinColumn(name="reziserID")
    private Reziser reziser;
    @OneToMany(mappedBy = "id.film")
    private List<Uloga> uloge;
    
    public Film() {
    }

    public Film(Long id, String naziv, Date datumIzlaska, int trajajanjeFilma, String drzavaPorekla, Korisnik korisnik, Zanr zanr, Reziser reziser) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzlaska = datumIzlaska;
        this.trajanjeFilma = trajajanjeFilma;
        this.drzavaPorekla = drzavaPorekla;
        this.korisnik = korisnik;
        this.zanr = zanr;
        this.reziser = reziser;
    }

    public List<Uloga> getUloge() {
        return uloge;
    }

    public void setUloge(List<Uloga> uloge) {
        this.uloge = uloge;
    }

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

    public int getTrajajanjeFilma() {
        return trajanjeFilma;
    }

    public void setTrajajanjeFilma(int trajajanjeFilma) {
        this.trajanjeFilma = trajajanjeFilma;
    }

    public String getDrzavaPorekla() {
        return drzavaPorekla;
    }

    public void setDrzavaPorekla(String drzavaPorekla) {
        this.drzavaPorekla = drzavaPorekla;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Reziser getReziser() {
        return reziser;
    }

    public void setReziser(Reziser reziser) {
        this.reziser = reziser;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.naziv);
        hash = 31 * hash + Objects.hashCode(this.datumIzlaska);
        hash = 31 * hash + this.trajanjeFilma;
        hash = 31 * hash + Objects.hashCode(this.drzavaPorekla);
        hash = 31 * hash + Objects.hashCode(this.korisnik);
        hash = 31 * hash + Objects.hashCode(this.zanr);
        hash = 31 * hash + Objects.hashCode(this.reziser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if (this.trajanjeFilma != other.trajanjeFilma) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.drzavaPorekla, other.drzavaPorekla)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumIzlaska, other.datumIzlaska)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        if (!Objects.equals(this.zanr, other.zanr)) {
            return false;
        }
        return Objects.equals(this.reziser, other.reziser);
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", naziv=" + naziv + ", datumIzlaska=" + datumIzlaska + ", trajajanjeFilma=" + trajanjeFilma + ", drzavaPorekla=" + drzavaPorekla + ", korisnik=" + korisnik + ", zanr=" + zanr + ", reziser=" + reziser + '}';
    }
   
    
    
}
