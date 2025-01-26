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
    public Korisnik toEntity(RegisterKorisnikDto registerKorisnikDto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(registerKorisnikDto.getKorisnickoIme());
        korisnik.setSifra(registerKorisnikDto.getSifra());
        korisnik.setIme(registerKorisnikDto.getIme());
        korisnik.setPrezime(registerKorisnikDto.getPrezime());
        return korisnik;
    }

    @Override
    public RegisterKorisnikDto toDto(Korisnik korisnikEntity) {
        RegisterKorisnikDto registerKorisnikDto = new RegisterKorisnikDto();
        registerKorisnikDto.setKorisnickoIme(korisnikEntity.getKorisnickoIme());
        registerKorisnikDto.setSifra(korisnikEntity.getSifra());
        registerKorisnikDto.setIme(korisnikEntity.getIme());
        registerKorisnikDto.setPrezime(korisnikEntity.getPrezime());
        return registerKorisnikDto;
    }

}
