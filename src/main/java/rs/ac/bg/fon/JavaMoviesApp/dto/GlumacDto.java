package rs.ac.bg.fon.JavaMoviesApp.dto;


/**
 *
 * @author Jovana Stakic
 */
public class GlumacDto implements ApplicationDto{
	
    private Long id;
    private String imePrezime;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

}
