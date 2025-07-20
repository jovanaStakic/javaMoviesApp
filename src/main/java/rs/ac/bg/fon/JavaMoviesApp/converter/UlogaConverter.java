package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.JavaMoviesApp.domain.Uloga;
import rs.ac.bg.fon.JavaMoviesApp.dto.UlogaDto;

@Component
public class UlogaConverter implements GenericConverter<UlogaDto, Uloga>{

	@Override
	public Uloga toEntity(UlogaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UlogaDto toDto(Uloga entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
