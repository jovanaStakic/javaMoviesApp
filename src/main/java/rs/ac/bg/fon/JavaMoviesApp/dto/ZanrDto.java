
package rs.ac.bg.fon.JavaMoviesApp.dto;

/**
 *
 * @author Jovana Stakic
 */
public class ZanrDto implements ApplicationDto{
    private Long id;
    private String naziv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
