package com.camilahess.programacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import com.camilahess.programacionFuncional.entidades.Usuario;

public class App {
	static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static void poblar() { // tearUp
		usuarios.clear();
		usuarios.add(new Usuario(1, "Fran", 30000));
		usuarios.add(new Usuario(2, "Ángel", 20000));
		usuarios.add(new Usuario(3, "Miguel Ángel", 40000));
		usuarios.add(new Usuario(4, "David", 30000));
		usuarios.add(new Usuario(5, "Enrique", 50000));
		usuarios.add(new Usuario(6, "Naomi", -30000));
		usuarios.add(new Usuario(1, "Fran", 30000));
		usuarios.add(new Usuario(7, "Francisco", 100000));
	}

	public static void descargar() { // tearDown
		usuarios.clear();
	}

	/**
	 * Recorrer los elementos de una lista
	 */
	public static void forEach() {
		// Final

		// if de toda la vida
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(i + ". " + usuarios.get(i).toString());
		}

		// bucle for-each
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}

		// Programación funcional
		usuarios.forEach(e -> System.out.println(e));

		usuarios.forEach(System.out::println);

		usuarios.stream().forEach(e -> System.out.println(e));

	}

	/**
	 * permite filtrar los elementos de una lista
	 */
	public static void filter() {
		// No final
		usuarios.stream().filter(e -> e.getSueldo() > 30000).forEach(e -> System.out.println(e));

		usuarios.stream().filter(e -> e.getSueldo() > 30000 && e.getSueldo() < 50000)
				.forEach(e -> System.out.println(e));

		usuarios.stream().filter(e -> e.getSueldo() > 30000).filter(e -> e.getSueldo() < 50000)
				.forEach(e -> System.out.println(e));

		// Creación de una sublista
		List<Usuario> ricos = usuarios.stream().filter(e -> e.getSueldo() >= 50000).collect(Collectors.toList()); // crea
																													// la
																													// sublista
		System.out.println("Los ricos son:");
		ricos.forEach(e -> System.out.println(e));

	}

	/**
	 * A partir de un lista nos quedamos con parte de los objetos
	 */
	public static void map() {
		// No final

		// Crea una lista con los nombres de los usuarios
		List<String> nombres = usuarios.stream().map(e -> e.getNombre()) // se queda solo con los nombres
				.collect(Collectors.toList());
		nombres.forEach(e -> System.out.println(e));

		// Imprimir los id's de aquellos usuarios que ganen más de 40000
		usuarios.stream().filter(e -> e.getSueldo() > 40000).mapToInt(e -> e.getId()) // me quedo con los id's
				.filter(e -> e < 6) // aquí recorremos id's no usuarios
				.forEach(e -> System.out.println(e));

		// Crea una lista de los nombres DISTINTOS
		Set<String> nombresDistintos = usuarios.stream().map(e -> e.getNombre()) // se queda solo con los nombres
				.collect(Collectors.toSet());
		System.out.println("Nombres distintos");
		nombresDistintos.forEach(e -> System.out.println(e));

	}

	/**
	 * Creación de listas de elementos NO-DUPLICADOS
	 */
	public static void toSet() {
		// Final
		Set<Usuario> usuariosDistintos = usuarios.stream().collect(Collectors.toSet());
		usuariosDistintos.forEach(e -> System.out.println(e));
	}

	/**
	 * Sum suma todos los valores, average saca la media
	 */
	public static void sumAvg() {
		// Finales

		// suma de todos los sueldos
		double sumaSueldos = usuarios.stream().mapToDouble(e -> e.getSueldo()) // me quedo solo con los sueldos
				.sum();
		System.out.println("La suma de todos los sueldos es: " + sumaSueldos);

		// media de los sueldos

		// Los Optional son datos que pueden contener valor o no.

		OptionalDouble mediaOpcional = usuarios.stream().mapToDouble(e -> e.getSueldo()).average();

		System.out.println("La media es: " + mediaOpcional.getAsDouble());

		descargar();
		OptionalDouble mediaOpcional2 = usuarios.stream().mapToDouble(e -> e.getSueldo()).average();
		if (mediaOpcional2.isPresent())
			System.out.println("La media es: " + mediaOpcional2.getAsDouble());
		else
			System.out.println("La lista está vacía y por lo tanto no hay media");

		poblar();
		double mediaSegura = usuarios.stream().mapToDouble(e -> e.getSueldo()).average().orElse(0); // da valor por
																									// defecto en caso
																									// de estar la lista
																									// vacía
		System.out.println("La media segura es: " + mediaSegura);
	}

	/**
	 * Busca dentro de la lista
	 */
	public static void find() {
		// Final

		// Quédate con el primer usuario que gane más de 45000 de sueldo

		// Con Optional
		Optional<Usuario> usuario = usuarios.stream().filter(e -> e.getSueldo() > 450000).findFirst();
		if (usuario.isPresent())
			System.out.println("El primer usuario que gana más de 45000 es: " + usuario.get().getNombre());
		else
			System.out.println("Nadie gana esa cantidad");

		// Sin optional
		Usuario usuario2 = usuarios.stream().filter(e -> e.getSueldo() > 450000).findFirst().orElse(null);
		if (usuario2 != null)
			System.out.println(usuario2.getNombre());

		Usuario usuario3 = usuarios.stream().filter(e -> e.getSueldo() > 45000).findFirst()
				.orElse(new Usuario(1, "Sin datos", 0));
		System.out.println(usuario3.getNombre());

		// findAny -> te devuelve alguno, no sabemos cual
		Usuario usuario4 = usuarios.stream().filter(e -> e.getSueldo() > 45000).findAny()
				.orElse(new Usuario(1, "Sin datos", 0));
		System.out.println(usuario4.getNombre());

	}

	/**
	 * A partir de una lista de listas las juntas y las concatena en una única lista
	 * Baja una dimension
	 */
	public static void flatMap() {
		// no final
		List<String> clase1 = new ArrayList<String>(Arrays.asList("Fran", "Dani"));
		List<String> clase2 = new ArrayList<String>(Arrays.asList("Paco", "Pepe", "Luis"));
		List<String> clase3 = new ArrayList<String>(Arrays.asList("Paco2", "Pepe3", "Luis4"));
		List<List<String>> todasClases = new ArrayList<List<String>>(Arrays.asList(clase1, clase2, clase3));

		List<String> todosAlumnos = todasClases.stream().flatMap(e -> e.stream()) // te permite unir todas las sublistas
																					// en una única lista
				.collect(Collectors.toList());
		todosAlumnos.forEach(e -> System.out.println(e));
	}

	/**
	 * Lo mismo que el forEach pero no final
	 */
	public static void peek() {
		// No final

		// Aumenta todos los sueldos 1000 euros e imprime de nuevo los usuarios
		usuarios.stream().peek(e -> e.setSueldo(e.getSueldo() + 1000)).forEach(e -> System.out.println(e));
	}

	/**
	 * Parte la lista original en 2 sublistas. Una que cumple la condición y otra
	 * que no.
	 */
	public static void partitioningBy() {
		Map<Boolean, List<Usuario>> sublistas = usuarios.stream()
				.collect(Collectors.partitioningBy(e -> e.getSueldo() > 35000));

		// la sublista de los que ganan más de 35000
		System.out.println("Ganan más de 35000:");
		sublistas.get(true).forEach(e -> System.out.println(e));

		// la sublista de los que ganan menos de 35000
		System.out.println("Ganan menos de 35000:");
		sublistas.get(false).forEach(e -> System.out.println(e));
	}

	/**
	 * Agrupar por la condición que le digamos. Tendremos tantas listas como
	 * posibilidades haya
	 */
	public static void groupingBy() {
		Map<Character, List<Usuario>> agenda = usuarios.stream()
				.collect(Collectors.groupingBy(e -> e.getNombre().charAt(0)));

		if (agenda.containsKey('F')) {
			agenda.get('F').forEach(e -> System.out.println(e));
		}

		// recorrer todas las sublistas de cada una de las letras
		for (int i = (int) 'A'; i <= (int) 'Z'; i++) { // recorrer las letras del abecedario
			if (agenda.containsKey((char) i)) { // solo para las listas que existan
				System.out.println("Lista de la " + (char) i);
				agenda.get((char) i).forEach(e -> System.out.println(e));
			}
		}
	}

	public static void groupingByCadenas(String cadena) {
		Map<String, List<Usuario>> agenda = usuarios.stream()
				.collect(Collectors.groupingBy(e -> e.getNombre().substring(0, cadena.length())));

		if (agenda.containsKey(cadena)) {
			agenda.get(cadena).forEach(e -> System.out.println(e));
		}

	}

	public static void main(String[] args) {
		poblar(); // dar datos iniciales
		// forEach();
		// filter();
		// map();
		// toSet();
		// sumAvg();
		// find();
		// flatMap();
		// peek();
		// partitioningBy();
		groupingBy();
	}
}