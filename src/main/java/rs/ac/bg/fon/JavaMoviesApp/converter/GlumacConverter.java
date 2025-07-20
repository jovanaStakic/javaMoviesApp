package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;


import rs.ac.bg.fon.JavaMoviesApp.domain.Glumac;
import rs.ac.bg.fon.JavaMoviesApp.dto.GlumacDto;

@Component
public class GlumacConverter implements GenericConverter<GlumacDto, Glumac>{

	@Override
	public Glumac toEntity(GlumacDto dto) {
		throw new UnsupportedOperationException();
	}

	@Override
	public GlumacDto toDto(Glumac entity) {
		GlumacDto dto=new GlumacDto();
		dto.setId(entity.getId());
		dto.setImePrezime(entity.getImePrezime());
		return dto;
	}

}
