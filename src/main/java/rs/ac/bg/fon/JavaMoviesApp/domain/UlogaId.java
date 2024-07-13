
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class UlogaId {
    @ManyToOne
    @JoinColumn(name = "glumacID")
    private Glumac glumac;
    @ManyToOne
    @JoinColumn(name="filmID")
    private Film film;

    public UlogaId() {
    }

    public UlogaId(Glumac glumac, Film film) {
        this.glumac = glumac;
        this.film = film;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
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
        hash = 97 * hash + Objects.hashCode(this.glumac);
        hash = 97 * hash + Objects.hashCode(this.film);
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
        final UlogaId other = (UlogaId) obj;
        if (!Objects.equals(this.glumac, other.glumac)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }
    
}
