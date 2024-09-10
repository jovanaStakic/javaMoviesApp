/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.JavaMoviesApp.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Stakic
 */
public class FilmDto {
    private Long id;
    private String naziv;
    private Date datumIzlaska;
    private int trajanjeFilma;
    private String drzavaPorekla;
    private Long korisnikId;
    private Long zanrId;
    private Long reziserId;
    private List<UlogaDto> uloge;
}
