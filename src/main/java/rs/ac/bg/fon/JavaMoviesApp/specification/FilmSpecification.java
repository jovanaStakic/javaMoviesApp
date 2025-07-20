package rs.ac.bg.fon.JavaMoviesApp.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import rs.ac.bg.fon.JavaMoviesApp.domain.Film;

/**
 *
 * @author Jovana Stakic
 */
public class FilmSpecification implements Specification<Film> {

	private static final long serialVersionUID = 1L;
	private final Film kriterijum;

    public FilmSpecification(Film kriterijum) {
        this.kriterijum = kriterijum;
    }

    @Override
    public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new LinkedList<>();

        if (kriterijum.getNaziv() != null && !kriterijum.getNaziv().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("naziv")), "%" + kriterijum.getNaziv().toLowerCase() + "%"));
        }

        if (kriterijum.getReziser() != null) {
            predicates.add(criteriaBuilder.equal(root.get("reziser").get("id"), kriterijum.getReziser().getId()));
        }

        if (kriterijum.getZanr() != null) {
            predicates.add(criteriaBuilder.equal(root.get("zanr").get("id"), kriterijum.getZanr().getId()));
        }

        if (kriterijum.getKorisnik() != null) {
            predicates.add(criteriaBuilder.equal(root.get("korisnik").get("id"), kriterijum.getKorisnik().getId()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

    }
}
