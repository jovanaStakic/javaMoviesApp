package rs.ac.bg.fon.JavaMoviesApp.dto;

/**
 *
 * @author Jovana Stakic
 */
public class UlogaDto implements ApplicationDto{
    private Long glumacId;   
    private String nazivUloge; 

    public Long getGlumacId() {
        return glumacId;
    }

    public void setGlumacId(Long glumacId) {
        this.glumacId = glumacId;
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }
    
    
}
