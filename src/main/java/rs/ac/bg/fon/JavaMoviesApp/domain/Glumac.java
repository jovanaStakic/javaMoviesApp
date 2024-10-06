
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Objects;


@Entity
public class Glumac implements ApplicationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imePrezime;
    @OneToMany(mappedBy = "id.glumac")
    private List<Uloga> uloge;
    
    public Glumac() {
    }

    public Glumac(Long id, String imePrezime) {
        this.id = id;
        this.imePrezime = imePrezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.imePrezime);
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
        final Glumac other = (Glumac) obj;
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Glumac{" + "id=" + id + ", imePrezime=" + imePrezime + '}';
    }
    
    
    
}
