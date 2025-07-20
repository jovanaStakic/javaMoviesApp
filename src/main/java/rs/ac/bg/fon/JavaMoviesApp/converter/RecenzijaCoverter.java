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
  
    @Override
    public Recenzija toEntity(RecenzijaDto dto) {
        Recenzija recenzija = new Recenzija();
        recenzija.setId(dto.getId());
        recenzija.setDatumKreiranja(dto.getDatumKreiranja());
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
            CreateFilmDto filmDto = new CreateFilmDto();
            filmDto.setId(entity.getFilm().getId());
            filmDto.setNaziv(entity.getFilm().getNaziv());
            filmDto.setDrzavaPorekla(entity.getFilm().getDrzavaPorekla());
            filmDto.setDatumIzlaska(entity.getFilm().getDatumIzlaska());
            filmDto.setTrajanjeFilma(entity.getFilm().getTrajajanjeFilma());
            filmDto.setZanrId(entity.getFilm().getZanr().getId());
            filmDto.setReziserId(entity.getFilm().getReziser().getId());
           if (entity.getFilm().getUloge() != null) {
               List<UlogaDto> ulogeDto = entity.getFilm().getUloge().stream()
                    .map(uloga -> {
                        UlogaDto ulogaDto = new UlogaDto();
                        ulogaDto.setGlumacId(uloga.getId().getGlumac().getId()); 
                        ulogaDto.setNazivUloge(uloga.getId().getNazivUloge());
                        return ulogaDto;
                    })
                    .collect(Collectors.toList());
            filmDto.setUloge(ulogeDto);
        }

            dto.setFilmId(filmDto);
        }

        return dto;
    }
}
