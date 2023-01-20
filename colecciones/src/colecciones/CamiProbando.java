package colecciones;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CamiProbando {

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
	
	private static void prueba4 () {
		//Crear una lista a partir de otra //SUMAR LISTAS
		List<String> cad3 = new ArrayList<String>();
		cad3.add("Camila");
		cad3.add("Thiago");
		cad3.add("Jaqui");
		cad3.add("Tomi");
		
		List<String> cad4 = new ArrayList<String>(Arrays.asList("Juan", "Monica", "Eldo")); //Otra forma de ya poner los nombres en la lista 
		List<String> todaLaFamilia = new ArrayList<String>(cad3);
		todaLaFamilia.addAll(cad4);
		System.out.println("Familia completa, cad 3 + cad4:  ");
		todaLaFamilia.forEach(persona -> System.out.println(persona));
	}
	
	private static void prueba5 () {
		//Lista de numeros
		List<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(18);
		num.add(25);
		num.add(29);
		
		System.out.println(num); // asi se imprime como array, o colección. Entre [ ]
		
		//para recorrer la lista
		
		num.forEach(n -> System.out.println(n));
		
		num.remove(0);
		
		num.forEach(n -> System.out.println(n)); // borramos la posición 0 = numero 1
		
		
	}
	private static void buscar () {
		List<Integer> num = new ArrayList<Integer>();
		num.add(652221747);
		num.add(637771839);
		num.add(384899292);
		num.add(653994412);
		
		if(num.contains(652221747))
			System.out.println("Número de teléfono encontrado");
		
	}
	
	private static void prueba6 () {
		//ORDENAR
		
		List<String> ordenar = new ArrayList<String> (Arrays.asList("Pedro", "Pablo", "Agustin", "Tomas", "Thiago", "Federico", "Airton"));
		ordenar.sort(null);
		ordenar.forEach(name -> System.out.println(name + "\n"));
		
		//ordenar por cantidad de letras 
		ordenar.sort(Comparator.comparingInt(String::length)); // se pone en vez de NULL, el orden que queremos. Comparando
		ordenar.forEach(name -> System.out.println(name));
	}
	
	public static void main(String[] args) {
		prueba6();
	}

}
