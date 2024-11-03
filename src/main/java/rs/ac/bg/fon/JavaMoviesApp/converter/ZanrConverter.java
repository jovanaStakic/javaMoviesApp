package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.dto.ZanrDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class ZanrConverter implements GenericConverter<ZanrDto, Zanr> {

    @Override
    public Zanr toEntity(ZanrDto dto) {
        if (dto == null) {
            return null;
        }
        Zanr zanr = new Zanr();
        zanr.setId(dto.getId());
        zanr.setNazivZanra(dto.getNaziv());
        return zanr;
    }

    @Override
    public ZanrDto toDto(Zanr entity) {
        if (entity == null) {
            return null;
        }
        ZanrDto dto = new ZanrDto();
        dto.setId(entity.getId());
        dto.setNaziv(entity.getNazivZanra());
        return dto;
    }
}