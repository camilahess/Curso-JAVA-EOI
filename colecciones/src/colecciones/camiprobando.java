package colecciones;


import java.util.ArrayList;
import java.util.List;

public class camiprobando {

	private static void prueba1() {
		
		// CREAR UNA LISTA
		List<String> cad = new ArrayList<String>();
	
		cad.add("Camila");
		cad.add("Thiago");
		cad.add("Jaqui");
		cad.add("Tomi");
		
		for (String nombres : cad) 
			System.out.println(nombres);

		cad.forEach(n -> System.out.println(n)); // For each n (nombre) de la lista CAD (cad.forEach) , se imprimen los n. (nombres)
	}

	private static void prueba2() {
		//BORRAR
		List<String> cad1 = new ArrayList<String>();
		cad1.add("Camila");
		cad1.add("Thiago");
		cad1.add("Jaqui");
		cad1.add("Tomi");
		
		cad1.forEach(nom -> System.out.println(nom));
		
		cad1.remove(1); // 1 es thiago, porque las listas inician siempre desde el cero.
		
		cad1.forEach(nom -> System.out.println(nom));
		
	}
	
	private static void prueba3 () { 
		//Agregar elemento en una posición en específica
		List<String> cad2 = new ArrayList<String>();
		cad2.add("Camila");
		cad2.add("Thiago");
		cad2.add("Jaqui");
		cad2.add("Tomi");
		
		cad2.forEach(name -> System.out.println(name));
		
		cad2.add(2, "Juan");
		
		cad2.forEach(name ->System.out.println(name));
		
		// tamaño de la lista
		System.out.println("El tamaño de la lista es de : " + cad2.size() + " nombres");
	}
	public static void main(String[] args) {
		prueba3();
	}

}
