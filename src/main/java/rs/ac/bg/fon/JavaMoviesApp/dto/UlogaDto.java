package rs.ac.bg.fon.JavaMoviesApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Jovana Stakic
 */
public class UlogaDto implements ApplicationDto {

    @NotNull(message = "ID glumca je obavezan.")
    private Long glumacId;
    @NotBlank(message = "Naziv uloge je obavezan.")
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
