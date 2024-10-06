/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reziser implements ApplicationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String imePrezime;
    private Date datumRodjenja;
    private String drzavaPorekla;

    public Reziser() {
    }

    public Reziser(String imePrezime, Date datumRodjenja, String drzavaPorekla) {
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.drzavaPorekla = drzavaPorekla;
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

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getDrzavaPorekla() {
        return drzavaPorekla;
    }

    public void setDrzavaPorekla(String drzavaPorekla) {
        this.drzavaPorekla = drzavaPorekla;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.imePrezime);
        hash = 31 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 31 * hash + Objects.hashCode(this.drzavaPorekla);
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
        final Reziser other = (Reziser) obj;
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.drzavaPorekla, other.drzavaPorekla)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }

    @Override
    public String toString() {
        return "Reziser{" + "id=" + id + ", imePrezime=" + imePrezime + ", datumRodjenja=" + datumRodjenja + ", drzavaPorekla=" + drzavaPorekla + '}';
    }
    
    
    
    
}
