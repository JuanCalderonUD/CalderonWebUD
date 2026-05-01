//Juan David Calderon Cardenas
package asp.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import asp.modelo.Aspirante;
import asp.modelo.AspiranteDAO;
import asp.modelo.ProgAcad;
import asp.modelo.ProgAcadDAO;

import jakarta.faces.view.ViewScoped;   // ✅ CAMBIO AQUÍ
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("asp")
@ViewScoped   

public class AspiranteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Aspirante dto = new Aspirante();
    private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
    private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;
    private int codPrograma;

    public AspiranteBean() {
        ProgAcadDAO.cargaDatos();
    }

    public Aspirante getDto() {
        return dto;
    }

    public void setDto(Aspirante dto) {
        this.dto = dto;
    }

    public ArrayList<Aspirante> getListaAs() {
        return listaAs;
    }

    public void setListaAs(ArrayList<Aspirante> listaAs) {
        this.listaAs = listaAs;
    }

    public ArrayList<ProgAcad> getListaPa() {
        return listaPa;
    }

    public void setListaPa(ArrayList<ProgAcad> listaPa) {
        this.listaPa = listaPa;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    public void registrar() {

        for (Aspirante a : listaAs) {

            if (a.getId_p().equals(dto.getId_p())) {

                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "ID ya registrado"));

                return;
            }

            if (a.getTelefono().equals(dto.getTelefono())) {

                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Teléfono ya registrado"));

                return;
            }

            if (a.getCorreo().equals(dto.getCorreo())) {

                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Correo ya registrado"));

                return;
            }
        }

        Aspirante nuevo = new Aspirante();
        nuevo.setId_p(dto.getId_p());
        nuevo.setNombres(dto.getNombres());
        nuevo.setApellidos(dto.getApellidos());
        nuevo.setTelefono(dto.getTelefono());
        nuevo.setCorreo(dto.getCorreo());
        nuevo.setFecha_reg(LocalDate.now());

        nuevo.setPro_acad(listaPa.get(codPrograma));

        listaAs.add(nuevo);

        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
            "Éxito", "Aspirante registrado correctamente"));

        dto = new Aspirante();
    }
}