package rs.ac.bg.fon.JavaMoviesApp.converter;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Glumac;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Reziser;
import rs.ac.bg.fon.JavaMoviesApp.domain.Uloga;
import rs.ac.bg.fon.JavaMoviesApp.domain.UlogaId;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.dto.FilmDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.UlogaDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class FilmConverter implements GenericConverter<FilmDto, Film> {

    @Override
    public Film toEntity(FilmDto dto) {
        Film film = new Film();
        film.setId(dto.getId());
        film.setNaziv(dto.getNaziv());
        film.setDatumIzlaska(dto.getDatumIzlaska());
        film.setTrajajanjeFilma(dto.getTrajanjeFilma());
        film.setDrzavaPorekla(dto.getDrzavaPorekla());

        if (dto.getKorisnikId() != null) {
            Korisnik korisnik = new Korisnik();
            korisnik.setId(dto.getKorisnikId());
            film.setKorisnik(korisnik);
        }

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
    public FilmDto toDto(Film entity) {
        FilmDto dto = new FilmDto();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNaziv());
        dto.setDatumIzlaska(entity.getDatumIzlaska());
        dto.setTrajanjeFilma(entity.getTrajajanjeFilma());
        dto.setDrzavaPorekla(entity.getDrzavaPorekla());

        if (entity.getKorisnik() != null) {
            dto.setKorisnikId(entity.getKorisnik().getId());
        }

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
