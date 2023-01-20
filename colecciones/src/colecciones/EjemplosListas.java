package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EjemplosListas {

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
		alumnosDam.sort(Comparator.comparingInt(String::length)); // Ordena las cadenas según la cantidad de letras que
																	// tenga.
		System.out.println(alumnosDam);
		alumnosDam.sort(String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println(alumnosDam);

	}

	public static void buscarLista() {

		List<String> meses = new ArrayList<String>(Arrays.asList("Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		if (meses.contains("enero"))
			System.out.println("enero existe en la lista");
		if (meses.containsAll(new ArrayList<String>(Arrays.asList("Enero", "febrero"))))
			System.out.println("Enero y Febrero existen en la lista");

	}

	public static void reemplazarLista() {
		List<String> meses = new ArrayList<String>(Arrays.asList("Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		meses.replaceAll(e -> e + " mes"); // hace una operación a TODOS los elementos de una lista, sin ningún tipo de
											// filtro
		meses.forEach(e -> System.out.println(e));
		meses = new ArrayList<String>(Arrays.asList("Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
				"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		meses.replaceAll(cadena -> cadena.substring(0, 1).toUpperCase() + cadena.substring(1).toLowerCase()); // CAPITALIZAR
																												// UNA
																												// LISTA
																												// ENTERA
		meses.forEach(e -> System.out.println(e));
		// Filtrar elementos en la cadena
		meses.stream().filter(e -> e.equals("Julio") || e.equals("Agosto")).forEach(e -> e = "Verano"); // ESTO NO HACE
																										// LO QUE
																										// QUEREMOS
		// meses.forEach(e->System.out.println(e))

		// Buscar los elementos que queremos y cambiar el contenido de su posición
		meses.indexOf("Julio"); // 6
		meses.set(meses.indexOf("Julio"), "Verano");
		meses.set(meses.indexOf("Agosto"), "Verano");
		meses.set(11, "December");
		meses.forEach(e -> System.out.println(e));

	}

	public static void algunasOperacionesCadenas() {
		String cadena = "Hola mundo";
		System.out.println(cadena.length()); // 10
		cadena.replace("Hola", "hola"); // Esto no hace lo que yo quiero
		System.out.println(cadena); // Hola o hola? -> Hola (inmutabilidad de las cadenas)
		cadena = cadena.replace("Hola", "hola"); // Esto sí hace lo que yo quiero
		System.out.println(cadena);
		System.out.println(cadena.toUpperCase());
		System.out.println(cadena.substring(0, 1).toUpperCase()); // Esto es la primera letra en mayúscula

		cadena = cadena.substring(0, 1).toUpperCase() + cadena.substring(1).toLowerCase(); // Capitalizar una cadena
		System.out.println(cadena);

		String cadena2 = "Esta es una cadena más larga que la anterior";
		// Encontrar todas las 'a' de esta cadena
		for (int i = 0; i < cadena2.length(); i++) {
			if (cadena2.charAt(i) == 'a' || cadena2.charAt(i) == 'á') {
				System.out.println("Encontrada una 'a' en la posición: " + i);
			}
		}

	}

	// dada una cadena, pregunta al usuario la subcadena a buscar y muéstrale esa
	// subcadena hasta el final
	// luego pregunta si quiere buscar la siguiente ocurrencia y mientras diga que
	// sí, sácale el resultado.
	public static void buscarSiguiente() {
		Scanner sc = new Scanner(System.in);
		String cadena = "w Esta es una cadena más larga que la Anterior, hola adiós hola hola";
		boolean salir = false;
		int posicionEncontrada = -1;
		// Pista: contains, indexOf, lastIndexOf
		System.out.println("Introduzca la cadena a buscar: ");
		String cadenaBuscada = sc.nextLine();
		while (!salir) {
			posicionEncontrada = cadena.toLowerCase().indexOf(cadenaBuscada.toLowerCase(), posicionEncontrada + 1);
			if (posicionEncontrada != -1) { // Encuentro la cadena
				System.out.println(cadena.substring(posicionEncontrada));
				System.out.println("¿Buscar siguiente? (s/n): ");
				String respuesta = sc.nextLine();
				if (respuesta.toLowerCase().equals("n")) {
					salir = true;
				}
			} else {
				System.out.println("No se encuentran más ocurrencias de la cadena");
				salir = true;
			}
		}
	}

	private static void reemplazarCadena() {
		Scanner sc = new Scanner(System.in);
		String cadena = "w Esta es una cadena más larga que la Anterior, hola adiós hola hola";
		boolean salir = false;
		int posicionEncontrada = -1;
		// Pista: contains, indexOf, lastIndexOf
		System.out.println("Introduzca la cadena a buscar: ");
		String cadenaBuscada = sc.nextLine();
		System.out.println("Introduzca la cadena a reemplazar: ");
		String cadenaReemplazar = sc.nextLine();

		while (!salir) {
			posicionEncontrada = cadena.toLowerCase().indexOf(cadenaBuscada.toLowerCase(), posicionEncontrada + 1);
			if (posicionEncontrada != -1) { // Encuentro la cadena
				System.out.println(cadena.substring(posicionEncontrada));
				System.out.println("Reemplazar y buscar siguiente ? ( s / n ) : ");
				String respuesta = sc.nextLine();
				if (respuesta.toLowerCase().equals("n")) {
					salir = true;
				} else {
					cadena = cadena.replaceFirst(cadenaBuscada, cadenaReemplazar);
				}
			} else {
				System.out.println("No se encuentran más ocurrencias de la cadena");
				salir = true;
			}
		}
		System.out.println("La cadena queda asi: " + cadena);
	}

	public static void ejemplosCondicionalesListas() {
		// ejemplo removeIf
		List<String> meses = new ArrayList<String>(Arrays.asList("Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		// borrar los elementos de la lista que tienen más de 7 letras
		meses.removeIf(e -> e.length() > 6);
		System.out.println(meses);

		// ejemplo retainAll
		meses = new ArrayList<String>(Arrays.asList("Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
				"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		List<String> subconjunto = new ArrayList<String>(Arrays.asList("Julio", "Agosto"));
		// quedarse con todos los elementos de la lista que pertenezcan al subconjunto
		meses.retainAll(subconjunto);
	}


	public static void main(String[] args) {
		//ejercicio1();

	}
}