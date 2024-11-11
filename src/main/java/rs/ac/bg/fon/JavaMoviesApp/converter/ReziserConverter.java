package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Reziser;
import rs.ac.bg.fon.JavaMoviesApp.dto.ReziserDto;

/**
 *
 * @author Jovana Stakić
 */
@Component
public class ReziserConverter implements GenericConverter<ReziserDto, Reziser>{

    @Override
    public Reziser toEntity(ReziserDto dto) {
        Reziser reziser=new Reziser();
        reziser.setId(dto.getId());
        reziser.setImePrezime(dto.getImePrezime());
        reziser.setDatumRodjenja(dto.getDatumRodjenja());
        reziser.setDrzavaPorekla(dto.getDrzavaPorekla());
        return reziser;
    }

    @Override
    public ReziserDto toDto(Reziser entity) {
        ReziserDto dto=new ReziserDto();
        dto.setId(entity.getId());
        dto.setImePrezime(entity.getImePrezime());
        dto.setDatumRodjenja(entity.getDatumRodjenja());
        dto.setDrzavaPorekla(entity.getDrzavaPorekla());
        return dto;
    }
    
}
