package rs.ac.bg.fon.JavaMoviesApp.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateFilmDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.RecenzijaDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.UlogaDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class RecenzijaCoverter implements GenericConverter<RecenzijaDto, Recenzija> {
	private final GenericConverter<CreateFilmDto, Film> filmConverter;

	public RecenzijaCoverter(CreateFilmConverter filmConverter) {
		this.filmConverter = filmConverter;
	}

	@Override
	public Recenzija toEntity(RecenzijaDto dto) {
		Recenzija recenzija = new Recenzija();
		recenzija.setId(dto.getId());
		recenzija.setDatumKreiranja(dto.getDatumKreiranja());
		recenzija.setOcenaFilma(dto.getOcenaFilma());
		recenzija.setUtisak(dto.getUtisak());

		recenzija.setFilm(filmConverter.toEntity(dto.getFilm()));
			

		return recenzija;
	}

	@Override
	public RecenzijaDto toDto(Recenzija entity) {
		RecenzijaDto dto = new RecenzijaDto();
		dto.setId(entity.getId());
		dto.setDatumKreiranja(entity.getDatumKreiranja());
		dto.setOcenaFilma(entity.getOcenaFilma());
		dto.setUtisak(entity.getUtisak());

		dto.setFilm(filmConverter.toDto(entity.getFilm()));

		return dto;
	}
}
