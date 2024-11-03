package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.RegisterKorisnikDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class RegisterKorisnikConverter implements GenericConverter<RegisterKorisnikDto, Korisnik> {

    @Override
    public Korisnik toEntity(RegisterKorisnikDto dto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(dto.getKorisnickoIme());
        korisnik.setSifra(dto.getSifra());
        korisnik.setIme(dto.getIme());
        korisnik.setPrezime(dto.getPrezime());
        return korisnik;
    }

    @Override
    public RegisterKorisnikDto toDto(Korisnik entity) {
        RegisterKorisnikDto dto = new RegisterKorisnikDto();
        dto.setKorisnickoIme(entity.getKorisnickoIme());
        dto.setSifra(entity.getSifra());
        dto.setIme(entity.getIme());
        dto.setPrezime(entity.getPrezime());
        return dto;
    }

}
