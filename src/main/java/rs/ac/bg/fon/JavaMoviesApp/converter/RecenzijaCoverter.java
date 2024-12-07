package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Recenzija;
import rs.ac.bg.fon.JavaMoviesApp.dto.FilmDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.RecenzijaDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class RecenzijaCoverter implements GenericConverter<RecenzijaDto, Recenzija> {

    @Override
    public Recenzija toEntity(RecenzijaDto dto) {
        Recenzija recenzija = new Recenzija();
        recenzija.setId(dto.getId());
        recenzija.setDatumKreiranja(null);
        recenzija.setOcenaFilma(dto.getOcenaFilma());
        recenzija.setUtisak(dto.getUtisak());

        if (dto.getFilmId() != null) {
            Film film = new Film();
            film.setId(dto.getFilmId().getId());
            recenzija.setFilm(film);
        }

        return recenzija;
    }

    @Override
    public RecenzijaDto toDto(Recenzija entity) {
        RecenzijaDto dto = new RecenzijaDto();
        dto.setId(entity.getId());
        dto.setDatumKreiranja(entity.getDatumKreiranja());
        dto.setOcenaFilma(entity.getOcenaFilma());
        dto.setUtisak(entity.getUtisak());


        if (entity.getFilm() != null) {
            FilmDto filmDto = new FilmDto();
            filmDto.setId(entity.getFilm().getId());
            dto.setFilmId(filmDto);
        }

        return dto;
    }
}
