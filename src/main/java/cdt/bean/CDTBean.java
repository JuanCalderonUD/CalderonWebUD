//Juan David Calderon Cardenas
package cdt.bean;

import java.io.Serializable;
import cdt.modelo.CDT;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("cdt")
@ViewScoped
public class CDTBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private CDT dto = new CDT();

    public CDT getDto() { return dto; }
    public void setDto(CDT dto) { this.dto = dto; }

    public void calcular() {
        dto.calcular();
    }
}
