package rs.ac.bg.fon.JavaMoviesApp.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.JavaMoviesApp.domain.Korisnik;
import rs.ac.bg.fon.JavaMoviesApp.dto.LoginKorisnikDto;

/**
 *
 * @author Jovana Stakic
 */
@Component
public class LoginKorisnikConverter  implements GenericConverter<LoginKorisnikDto, Korisnik> {

    @Override
    public Korisnik toEntity(LoginKorisnikDto dto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(dto.getKorisnickoIme());
        korisnik.setSifra(dto.getSifra());
        return korisnik;
    }

    @Override
    public LoginKorisnikDto toDto(Korisnik entity) {
        LoginKorisnikDto dto = new LoginKorisnikDto();
        dto.setKorisnickoIme(entity.getKorisnickoIme());
        dto.setSifra(entity.getSifra());
        return dto;
    }
}