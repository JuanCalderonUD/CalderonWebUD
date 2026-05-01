/**
 * Juan David Calderón Cardenas
 */
package asp.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id_p;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String correo;
	
	
	public Persona() {
		super();
	}
	
	public Persona(String id_p, String nombres, String apellidos, String telefono, String correo) {
		super();
		this.id_p = id_p;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
	}


	public String getId_p() {
		return id_p;
	}

	public void setId_p(String id_p) {
		this.id_p = id_p;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, correo, id_p, nombres, telefono);
	}
	
	@Override
	public boolean equals (Object obj) {
		
		if(this == obj)
			return true;
		
		if(this == null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;

		Persona other = (Persona) obj;
		
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(correo, other.correo)
				&& Objects.equals(nombres, other.nombres)
				&& Objects.equals(telefono, other.telefono);
	}
	
}
