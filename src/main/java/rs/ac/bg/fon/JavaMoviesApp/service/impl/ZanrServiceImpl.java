
package rs.ac.bg.fon.JavaMoviesApp.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.JavaMoviesApp.domain.Zanr;
import rs.ac.bg.fon.JavaMoviesApp.repository.ZanrRepository;
import rs.ac.bg.fon.JavaMoviesApp.service.ZanrService;

/**
 *
 * @author Jovana Stakic
 */
@Service
public class ZanrServiceImpl implements ZanrService{
       private final ZanrRepository zanrRepository;

    
    public ZanrServiceImpl(ZanrRepository zanrRepository) {
        this.zanrRepository = zanrRepository;
    }

    @Override
    public List<Zanr> getAllZanrovi() {
        return zanrRepository.findAll();
    }
}
