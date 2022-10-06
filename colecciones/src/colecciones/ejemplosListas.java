package colecciones;

import java.util.ArrayList;
import java.util.List;

public class ejemplosListas {

	private static void ejemplo1() {
		
	List<String> nombres = new ArrayList<String> ();
	//añadir elementos
	nombres.add("Thiago");
	nombres.add("Camila");
	nombres.add("Jaquelina");
	nombres.add("Tomas");
	
	//recorre una lista
	for (String nombre : nombres) // para cada nombre de la lista nombres, imprime
		System.out.println(nombre);
	
	// programado funcionalmente
		nombres.forEach(e->System.out.println(e)); //para cada elemento dentro de (nombres) , se imprime el elemento
		nombres.forEach(e->System.out.println(e + "García"));
		
	// eliminar elementos de una lista REMOVE 
		nombres.remove(1); // borra pocisionalmente , pocisión 1 , si pusiera cero deria thiago
		nombres.forEach(e->System.out.println(e));
		
	//eliminar por elemento
		nombres.remove("Thiago");
		nombres.forEach(e->System.out.println(e));
	//añadir en una posición específica
		nombres.add(0, "Nuevo nombre");
		nombres.forEach(e->System.out.println(e));
		
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
	ejemplo1();
				

	}
	}