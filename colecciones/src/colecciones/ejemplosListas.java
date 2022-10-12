package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ejemplosListas {

	private static void ejemplo1() {
		// Crear listas
		List<String> nombres = new ArrayList<String>();
		// añadir elementos
		nombres.add("Thiago");
		nombres.add("Camila");
		nombres.add("Jaquelina");
		nombres.add("Tomas");

		// recorre una lista
		for (String nombre : nombres) // para cada nombre de la lista nombres, imprime
			System.out.println(nombre);

		// programando funcionalmente
		nombres.forEach(e -> System.out.println(e)); // para cada elemento dentro de (nombres) , se imprime el elemento
		nombres.forEach(e -> System.out.println(e + "García"));

		// eliminar elementos de una lista REMOVE
		nombres.remove(1); // borra pocisionalmente , pocisión 1 , si pusiera cero seria thiago
		nombres.forEach(e -> System.out.println(e));

		// eliminar por elemento
		nombres.remove("Thiago");
		nombres.forEach(e -> System.out.println(e));
		// añadir en una posición específica
		nombres.add(0, "Nuevo nombre");
		nombres.forEach(e -> System.out.println(e));
		// tamaño de la lista
		System.out.println("El tamaño de la lista es: " + nombres.size());
		// Conversiones entre arrays y listas
		// 1. Convertir de lista a array
		String[] nombresArray = new String[nombres.size()];
		nombres.toArray(nombresArray);
		System.out.println("Impresión de la lista");
		nombres.forEach(e -> System.out.println(e));
		System.out.println("Impresión del array");
		System.out.println(Arrays.toString(nombresArray));
		// 2. Convertir de array en lista
		String[] meses = { "Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		List<String> mesesLista = new ArrayList<String>(Arrays.asList(meses));
		mesesLista.forEach(e -> System.out.println(e));
		// Creación de una lista a partir de otra/s
		List<String> alumnosDam = new ArrayList<String>(Arrays.asList("pablo", "Ismael", "Yessica"));
		List<String> alumnosEoi = new ArrayList<String>(Arrays.asList("Alberto", "Benjamín", "Camila", "Pablo"));
		List<String> alumnosBorrar = new ArrayList<String>(Arrays.asList("Pablo", "Benjamín"));
		List<String> todosAlumnos = new ArrayList<String>(alumnosDam);
		todosAlumnos.addAll(alumnosEoi);
		System.out.println("Todos mis alumnos:");
		todosAlumnos.forEach(e -> System.out.println(e));
		todosAlumnos.removeAll(alumnosBorrar);
		System.out.println("Todos mis alumnos menos los borrados:"); 
		todosAlumnos.forEach(e -> System.out.println(e));
		// Eliminar toda la lista
		todosAlumnos.clear();
		if (todosAlumnos.isEmpty()) {
			System.out.println("La lista está vacía");
		}

		// Ordenar una lista
		alumnosDam.sort(null);
		System.out.println(alumnosDam);
		alumnosDam.sort(Collections.reverseOrder());
		System.out.println(alumnosDam);
		alumnosDam.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(alumnosDam);
		alumnosDam.sort(Comparator.comparingInt(String::length));
		System.out.println(alumnosDam);
		alumnosDam.sort(String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println(alumnosDam);

	}
	
	public static void buscarLista() {

		List<String> meses = new ArrayList<String>(Arrays.asList("Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre"));
		if(meses.contains("enero"))
			System.out.println("enero existe en la lista");
		if(meses.containsAll(new ArrayList<String>(Arrays.asList("Enero","febrero"))))
			System.out.println("Enero y Febrero existen en la lista");
		
	}

	public static void main(String[] args) {
		ejemplo1();

	}
}