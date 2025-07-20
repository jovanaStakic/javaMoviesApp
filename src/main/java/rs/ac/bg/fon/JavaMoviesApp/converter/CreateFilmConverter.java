package rs.ac.bg.fon.JavaMoviesApp.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Glumac;
import rs.ac.bg.fon.JavaMoviesApp.domain.Reziser;
import rs.ac.bg.fon.JavaMoviesApp.domain.Uloga;
import rs.ac.bg.fon.JavaMoviesApp.domain.UlogaId;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateFilmDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.UlogaDto;

@Component
public class CreateFilmConverter implements GenericConverter<CreateFilmDto, Film>{

    @Override
    public Film toEntity(CreateFilmDto dto) {
        Film film = new Film();
        film.setId(dto.getId());
        film.setNaziv(dto.getNaziv());
        film.setDatumIzlaska(dto.getDatumIzlaska());
        film.setTrajajanjeFilma(dto.getTrajanjeFilma());
        film.setDrzavaPorekla(dto.getDrzavaPorekla());

        if (dto.getZanrId() != null) {
            Zanr zanr = new Zanr();
            zanr.setId(dto.getZanrId());
            film.setZanr(zanr);
        }

        if (dto.getReziserId() != null) {
            Reziser reziser = new Reziser();
            reziser.setId(dto.getReziserId());
            film.setReziser(reziser);
        }

        if (dto.getUloge() != null) {
            film.setUloge(dto.getUloge().stream()
                    .map(ulogaDto -> {
                        Uloga uloga = new Uloga();
                        UlogaId ulogaId = new UlogaId();
                        ulogaId.setNazivUloge(ulogaDto.getNazivUloge());
                        ulogaId.setFilm(film);
                        
                        if (ulogaDto.getGlumacId() != null) {
                            ulogaId.setGlumac(new Glumac());
                            ulogaId.getGlumac().setId(ulogaDto.getGlumacId());
                        }

                        uloga.setId(ulogaId);
                        return uloga;
                    }).collect(Collectors.toList()));
        }

        return film;
    }

    @Override
    public CreateFilmDto toDto(Film entity) {
        CreateFilmDto dto = new CreateFilmDto();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setDatumIzlaska(entity.getDatumIzlaska());
        dto.setTrajanjeFilma(entity.getTrajajanjeFilma());
        dto.setDrzavaPorekla(entity.getDrzavaPorekla());


        if (entity.getZanr() != null) {
            dto.setZanrId(entity.getZanr().getId());
        }

        if (entity.getReziser() != null) {
            dto.setReziserId(entity.getReziser().getId());
        }

        if (entity.getUloge() != null) {
            dto.setUloge(entity.getUloge().stream()
                    .map(uloga -> {
                        UlogaDto ulogaDto = new UlogaDto();
                        ulogaDto.setNazivUloge(uloga.getId().getNazivUloge());

                        if (uloga.getId().getGlumac() != null) {
                            ulogaDto.setGlumacId(uloga.getId().getGlumac().getId());
                        }

                        return ulogaDto;
                    }).collect(Collectors.toList()));
        }

        return dto;
    }
}
