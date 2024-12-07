package rs.ac.bg.fon.JavaMoviesApp.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;
import rs.ac.bg.fon.JavaMoviesApp.dto.ListaDto;
import rs.ac.bg.fon.JavaMoviesApp.service.FilmService;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class ListaConverter implements GenericConverter<ListaDto, Lista> {
    private final FilmService filmService;

    public ListaConverter(FilmService filmService) {
        this.filmService = filmService;
    }
    
      @Override
    public Lista toEntity(ListaDto dto) {
        Lista lista = new Lista();
        lista.setId(dto.getId());
        lista.setNazivListe(dto.getNazivListe());
        lista.setDatumKreiranja(dto.getDatumKreiranja());

        List<Film> filmovi = dto.getFilmovi().stream()
                .map(filmId -> filmService.findFilmById(filmId)).collect(Collectors.toList());
                        
        lista.setFilmovi(filmovi);

        return lista;
    }

    @Override
    public ListaDto toDto(Lista entity) {
        ListaDto listaDto = new ListaDto();
        listaDto.setId(entity.getId());
        listaDto.setNazivListe(entity.getNazivListe());
        listaDto.setDatumKreiranja(entity.getDatumKreiranja());

        List<Long> filmoviDto = entity.getFilmovi().stream()
                .map(Film::getId)
                .collect(Collectors.toList());
        listaDto.setFilmovi(filmoviDto);

        return listaDto;
    }

}
