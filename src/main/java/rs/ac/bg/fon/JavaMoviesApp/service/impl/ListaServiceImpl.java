package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.JavaMoviesApp.domain.Lista;
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
        return listaRepository.findByNazivListeAndKorisnik_Id(naziv, korisnikId);
    }

    @Override
    public Lista findListaById(Long id) {
        return listaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Nije pronadjena lista sa id: "+id));
    }
}
