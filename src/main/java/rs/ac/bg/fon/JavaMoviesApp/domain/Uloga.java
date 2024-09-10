/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.JavaMoviesApp.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;



@Entity
public class Uloga {
    @EmbeddedId
    private UlogaId id;
   
  

    public Uloga() {
    }

    public UlogaId getId() {
        return id;
    }

    public void setId(UlogaId id) {
        this.id = id;
    }

   

    
    
}
