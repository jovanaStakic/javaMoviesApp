package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.SuccessLoginDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.RegisterKorisnikDto;

@Component
public class SuccessLoginConverter implements GenericConverter<SuccessLoginDto, Korisnik>{

	@Override
	public Korisnik toEntity(SuccessLoginDto dto) {
		throw new UnsupportedOperationException();	
		}

	@Override
	public SuccessLoginDto toDto(Korisnik entity) {
		SuccessLoginDto dto=new SuccessLoginDto();
		dto.setIme(entity.getIme());
		dto.setPrezime(entity.getPrezime());
		dto.setKorisnickoIme(entity.getKorisnickoIme());
		return dto;
	}

}
