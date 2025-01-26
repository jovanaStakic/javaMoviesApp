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
    public Korisnik toEntity(LoginKorisnikDto loginKorisnikDto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(loginKorisnikDto.getKorisnickoIme());
        korisnik.setSifra(loginKorisnikDto.getSifra());
        return korisnik;
    }

    @Override
    public LoginKorisnikDto toDto(Korisnik korisnikEntity) {
        LoginKorisnikDto loginKorisnikDto = new LoginKorisnikDto();
        loginKorisnikDto.setKorisnickoIme(korisnikEntity.getKorisnickoIme());
        loginKorisnikDto.setSifra(korisnikEntity.getSifra());
        return loginKorisnikDto;
    }
}