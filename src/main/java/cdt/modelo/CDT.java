//Juan David Calderon Cardenas
package cdt.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class CDT implements Serializable{

	private double inversion;
    private String tipoCDT;

    private double interes;
    private int plazo;

    private double ganancia;
    private double impuesto;
    private double gananciaNeta;
    private double valorFuturo;
	
    private ArrayList<FilaCDT> lista = new ArrayList<>();

    private static final double ANIO = 360.0;
    
    public void calcular() {

        if (tipoCDT == null || tipoCDT.equals("")) {
            tipoCDT = "Mensual";
        }

        // tasa automática
        if (inversion < 1000000) {
            interes = 8;
        } else if (inversion <= 5000000) {
            interes = 10;
        } else {
            interes = 12;
        }

        // plazo
        switch (tipoCDT) {
            case "Mensual": plazo = 30; break;
            case "Trimestral": plazo = 90; break;
            case "Semestral": plazo = 180; break;
            default: plazo = 360;
        }

        // cálculo
        ganancia = inversion * ((interes / 100.0) * (plazo / ANIO));
        impuesto = ganancia * 0.04;
        gananciaNeta = ganancia - impuesto;
        valorFuturo = inversion + gananciaNeta;

        // tabla
        lista.clear();
        agregarFila("Mensual", 30);
        agregarFila("Trimestral", 90);
        agregarFila("Semestral", 180);
        agregarFila("Anual", 360);
    }

    private void agregarFila(String tipo, int dias) {

        double g = inversion * ((interes / 100.0) * (dias / ANIO));
        double imp = g * 0.04;
        double neta = g - imp;
        double total = inversion + neta;

        lista.add(new FilaCDT(tipo, dias, interes, neta, total));
    }

    // getters y setters

    

    public ArrayList<FilaCDT> getLista() { return lista; }

	public double getInversion() {
		return inversion;
	}

	public void setInversion(double inversion) {
		this.inversion = inversion;
	}

	public String getTipoCDT() {
		return tipoCDT;
	}

	public void setTipoCDT(String tipoCDT) {
		this.tipoCDT = tipoCDT;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getGananciaNeta() {
		return gananciaNeta;
	}

	public void setGananciaNeta(double gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}

	public double getValorFuturo() {
		return valorFuturo;
	}

	public void setValorFuturo(double valorFuturo) {
		this.valorFuturo = valorFuturo;
	}

	public static double getAnio() {
		return ANIO;
	}

	public void setLista(ArrayList<FilaCDT> lista) {
		this.lista = lista;
	}
    
}
