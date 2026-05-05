//Juan David Calderon Cardenas
package cdt.modelo;

import java.io.Serializable;

public class FilaCDT implements Serializable{
    private String tipo;
    private int dias;
    private double tasa;
    private double gananciaNeta;
    private double valorFinal;

    public FilaCDT() {
    	
    }

    public FilaCDT(String tipo, int dias, double tasa, double gananciaNeta, double valorFinal) {
        this.tipo = tipo;
        this.dias = dias;
        this.tasa = tasa;
        this.gananciaNeta = gananciaNeta;
        this.valorFinal = valorFinal;
    }

	public String getTipo() {
		return tipo;
	}

	public int getDias() {
		return dias;
	}

	public double getTasa() {
		return tasa;
	}

	public double getGananciaNeta() {
		return gananciaNeta;
	}

	public double getValorFinal() {
		return valorFinal;
	}


}
