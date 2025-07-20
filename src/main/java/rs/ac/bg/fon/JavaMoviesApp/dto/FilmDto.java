package rs.ac.bg.fon.JavaMoviesApp.dto;

import java.util.Date;
import java.util.List;


public class FilmDto implements ApplicationDto{
	
	private Long id;
	private String naziv;
	private Date datumIzlaska;
	private int trajanjeFilma;
	private String drzavaPorekla;
	private ZanrDto zanr;
	private ReziserDto reziser;
	private List<UlogaDto> uloge;
	
	
	public FilmDto() {
		super();
	}

	public FilmDto(Long id, String naziv, Date datumIzlaska, int trajanjeFilma, String drzavaPorekla, ZanrDto zanr,
			ReziserDto reziser, List<UlogaDto> uloge) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumIzlaska = datumIzlaska;
		this.trajanjeFilma = trajanjeFilma;
		this.drzavaPorekla = drzavaPorekla;
		this.zanr = zanr;
		this.reziser = reziser;
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

	public ZanrDto getZanr() {
		return zanr;
	}

	public void setZanr(ZanrDto zanr) {
		this.zanr = zanr;
	}

	public ReziserDto getReziser() {
		return reziser;
	}

	public void setReziser(ReziserDto reziser) {
		this.reziser = reziser;
	}

	public List<UlogaDto> getUloge() {
		return uloge;
	}

	public void setUloge(List<UlogaDto> uloge) {
		this.uloge = uloge;
	}

	
}
