
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Korisnik implements UserDetails,ApplicationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String korisnickoIme;
    private String sifra;
    private String ime;
    private String prezime;

    public Korisnik() {
    }

    
    public Korisnik(String korisnickoIme, String sifra, String ime, String prezime) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 67 * hash + Objects.hashCode(this.sifra);
        hash = 67 * hash + Objects.hashCode(this.ime);
        hash = 67 * hash + Objects.hashCode(this.prezime);
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.sifra, other.sifra)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", korisnickoIme=" + korisnickoIme + ", sifra=" + sifra + ", ime=" + ime + ", prezime=" + prezime + '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return sifra;
    }

    @Override
    public String getUsername() {
        return this.korisnickoIme;
    }
    
    
    
}
