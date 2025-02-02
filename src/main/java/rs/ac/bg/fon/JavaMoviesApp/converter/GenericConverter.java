package rs.ac.bg.fon.JavaMoviesApp.converter;

import rs.ac.bg.fon.JavaMoviesApp.domain.ApplicationEntity;
import rs.ac.bg.fon.JavaMoviesApp.dto.ApplicationDto;

/**
 *
 * @author Jovana Stakic
 * @param <D>
 * @param <E>
 */
public interface GenericConverter <D extends ApplicationDto, E extends ApplicationEntity> {

    E toEntity(D dto);

    D toDto(E entity);
}