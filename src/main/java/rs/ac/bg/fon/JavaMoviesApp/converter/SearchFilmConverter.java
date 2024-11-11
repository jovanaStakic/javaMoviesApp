
package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Reziser;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.dto.SearchFilmDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class SearchFilmConverter implements GenericConverter<SearchFilmDto, Film>{

    @Override
    public Film toEntity(SearchFilmDto searchDto) {
        Film film = new Film();
        
        film.setNaziv(searchDto.getNaziv());
        
        if (searchDto.getReziserId() != null) {
            Reziser reziser = new Reziser();
            reziser.setId(searchDto.getReziserId());
            film.setReziser(reziser);
        }

        if (searchDto.getZanrId() != null) {
            Zanr zanr = new Zanr();
            zanr.setId(searchDto.getZanrId());
            film.setZanr(zanr);
        }

        return film;
    }

    @Override
    public SearchFilmDto toDto(Film entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
