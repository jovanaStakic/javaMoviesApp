
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Lista {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazivListe;
    private Date datumKreiranja;
    @ManyToOne
    @JoinColumn(name="korisnikID")
    private Korisnik korisnik;
    @ManyToMany
    @JoinTable(name = "lf",
            joinColumns =@JoinColumn (name="listaID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "filmID",referencedColumnName = "id"))
    private List<Film> filmovi;

    public Lista() {
    }

    public Lista(String nazivListe, Date datumKreiranja, Korisnik korisnik, List<Film> filmovi) {
        this.nazivListe = nazivListe;
        this.datumKreiranja = datumKreiranja;
        this.korisnik = korisnik;
        this.filmovi = filmovi;
    }

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

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<Film> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<Film> filmovi) {
        this.filmovi = filmovi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nazivListe);
        hash = 79 * hash + Objects.hashCode(this.datumKreiranja);
        hash = 79 * hash + Objects.hashCode(this.korisnik);
        hash = 79 * hash + Objects.hashCode(this.filmovi);
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
        final Lista other = (Lista) obj;
        if (!Objects.equals(this.nazivListe, other.nazivListe)) {
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
        return Objects.equals(this.filmovi, other.filmovi);
    }

    @Override
    public String toString() {
        return "Lista{" + "id=" + id + ", nazivListe=" + nazivListe + ", datumKreiranja=" + datumKreiranja + ", korisnik=" + korisnik + ", filmovi=" + filmovi + '}';
    }
    
    
}
