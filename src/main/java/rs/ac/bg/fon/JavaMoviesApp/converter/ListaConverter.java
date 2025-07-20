package rs.ac.bg.fon.JavaMoviesApp.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;
import rs.ac.bg.fon.JavaMoviesApp.dto.CreateFilmDto;
import rs.ac.bg.fon.JavaMoviesApp.dto.ListaDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class ListaConverter implements GenericConverter<ListaDto, Lista> {

    private final GenericConverter<CreateFilmDto, Film> filmConverter;

    public ListaConverter(CreateFilmConverter filmConverter) {
        this.filmConverter = filmConverter;
    }

    @Override
    public Lista toEntity(ListaDto dto) {
        Lista lista = new Lista();
        lista.setId(dto.getId());
        lista.setNazivListe(dto.getNazivListe());
        lista.setDatumKreiranja(null);

        if (dto.getFilmovi() != null) {
            List<Film> filmovi = dto.getFilmovi().stream()
                    .map(filmConverter::toEntity)
                    .collect(Collectors.toList());
            lista.setFilmovi(filmovi);
        }

        return lista;
    }

    @Override
    public ListaDto toDto(Lista entity) {
        ListaDto dto = new ListaDto();
        dto.setId(entity.getId());
        dto.setNazivListe(entity.getNazivListe());
        dto.setDatumKreiranja(entity.getDatumKreiranja());

        if (entity.getFilmovi() != null) {
            List<CreateFilmDto> filmovi = entity.getFilmovi().stream()
                    .map(filmConverter::toDto)
                    .collect(Collectors.toList());
            dto.setFilmovi(filmovi);
        }

        return dto;
    }

}
