//Juan David Calderon Cardenas
package asp.modelo;

import java.util.ArrayList;

public class AspiranteDAO {

	public static ArrayList<Aspirante> lista_A = new ArrayList<Aspirante>();
	
	public static void agregar(Aspirante a) {
	    lista_A.add(a);
	}

	public static ArrayList<Aspirante> listar() {
	    return lista_A;
	}
	
}
