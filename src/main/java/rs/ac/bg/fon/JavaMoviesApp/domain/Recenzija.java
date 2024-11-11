
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
public class Recenzija implements ApplicationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datumKreiranja;
    private int ocenaFilma;
    private String utisak;
    @ManyToOne
    @JoinColumn(name="korisnikID", nullable = false)
    private Korisnik korisnik;
    @ManyToOne
    @JoinColumn(name="filmID", nullable = false)
    private Film film;

    public Recenzija() {
    }

    public Recenzija(Date datumKreiranja, int ocenaFilma, String utisak, Korisnik korisnik, Film film) {
        this.datumKreiranja = datumKreiranja;
        this.ocenaFilma = ocenaFilma;
        this.utisak = utisak;
        this.korisnik = korisnik;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
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

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.datumKreiranja);
        hash = 41 * hash + this.ocenaFilma;
        hash = 41 * hash + Objects.hashCode(this.utisak);
        hash = 41 * hash + Objects.hashCode(this.korisnik);
        hash = 41 * hash + Objects.hashCode(this.film);
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
        final Recenzija other = (Recenzija) obj;
        if (this.ocenaFilma != other.ocenaFilma) {
            return false;
        }
        if (!Objects.equals(this.utisak, other.utisak)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumKreiranja, other.datumKreiranja)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }

    @Override
    public String toString() {
        return "Recenzija{" + "id=" + id + ", datumKreiranja=" + datumKreiranja + ", ocenaFilma=" + ocenaFilma + ", utisak=" + utisak + ", korisnik=" + korisnik + ", film=" + film + '}';
    }

    
}
