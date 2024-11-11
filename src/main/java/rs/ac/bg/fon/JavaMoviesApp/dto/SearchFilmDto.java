
package rs.ac.bg.fon.JavaMoviesApp.dto;

/**
 *
 * @author Jovana Stakic
 */
public class SearchFilmDto implements ApplicationDto{
    private String naziv;
    private Long reziserId;
    private Long zanrId;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getReziserId() {
        return reziserId;
    }

    public void setReziserId(Long reziserId) {
        this.reziserId = reziserId;
    }

    public Long getZanrId() {
        return zanrId;
    }

    public void setZanrId(Long zanrId) {
        this.zanrId = zanrId;
    }
 
    
}
