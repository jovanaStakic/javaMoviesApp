package rs.ac.bg.fon.JavaMoviesApp.converter;

import java.util.Date;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateRecenzijaDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.FilmDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class CreateRecenzijaConverter implements GenericConverter<CreateRecenzijaDto, Recenzija> {

    @Override
    public Recenzija toEntity(CreateRecenzijaDto dto) {
        Recenzija recenzija = new Recenzija();
        recenzija.setDatumKreiranja(new Date());
        recenzija.setOcenaFilma(dto.getOcenaFilma());
        recenzija.setUtisak(dto.getUtisak());

        if (dto.getFilmId() != null) {
            Film film = new Film();
            film.setId(dto.getFilmId());
            recenzija.setFilm(film);
        }

        return recenzija;
    }

    @Override
    public CreateRecenzijaDto toDto(Recenzija entity) {
        CreateRecenzijaDto dto = new CreateRecenzijaDto();
        dto.setId(entity.getId());
        dto.setDatumKreiranja(entity.getDatumKreiranja());
        dto.setOcenaFilma(entity.getOcenaFilma());
        dto.setUtisak(entity.getUtisak());

        if (entity.getFilm() != null) {
            FilmDto filmDto = new FilmDto();
            filmDto.setId(entity.getFilm().getId()); 
            dto.setFilmId(filmDto.getId());
        }

        return dto;
    }

}
