package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;
import rs.ac.bg.fon.JavaMoviesApp.exception.BadRequestException;
import rs.ac.bg.fon.JavaMoviesApp.exception.ResourceNotFoundException;
import rs.ac.bg.fon.JavaMoviesApp.repository.ListaRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.ListaService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class ListaServiceImpl implements ListaService {

    private final ListaRepository listaRepository;

    public ListaServiceImpl(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    @Override
    @Transactional
    public Lista saveLista(Lista lista) {
        boolean sviFilmoviPripadaju = lista.getFilmovi().stream()
                .allMatch(film -> film.getKorisnik().getId().equals(lista.getKorisnik().getId()));

        if (!sviFilmoviPripadaju) {
            throw new BadRequestException("Filmovi sa ovim id-jevima ne postoje.");
        }
        return listaRepository.save(lista);
    }

    @Override
    public List<Lista> getAllListeByKorisnikId(Long korisnikId) {
        return listaRepository.findByKorisnik_Id(korisnikId);
    }

    @Override
    @Transactional
    public Lista updateLista(Lista lista) {
        if (!listaRepository.existsById(lista.getId())) {
            throw new ResourceNotFoundException("Lista nije pronađena.");
        }
        return listaRepository.save(lista);
    }

    @Override
    @Transactional
    public void deleteLista(Long id) {
        if (!listaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lista nije pronađena.");
        }
        listaRepository.deleteById(id);
    }

    @Override
    public List<Lista> findListaByNazivAndKorisnik(String naziv, Long korisnikId) {
        return listaRepository.findByNazivListeContainingIgnoreCaseAndKorisnikId(naziv, korisnikId);
    }

    @Override
    public Lista findListaById(Long id) {
        Optional<Lista> optionalLista = listaRepository.findById(id);

        if (optionalLista.isPresent()) {
            return optionalLista.get();
        } else {
            throw new ResourceNotFoundException("Nije pronađena lista sa id: " + id);
        }
    }
}
