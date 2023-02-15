package com.camilahess.coleccionesMaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void ejemplosListas() {
		// Lista que almacena números
		List<Integer> numeros = new ArrayList<Integer>();
		// Podemos establecer una capacidad inicial reservada
		List<Integer> numeros2 = new ArrayList<>(12);
		// Se puede crear una lista a partir de un array
		Integer[] array = { 2, 3, 5 };
		List<Integer> numeros3 = Arrays.asList(array);
		// Se puede crear una lista a partir de otra colección
		List<Integer> numeros4 = new ArrayList<Integer>(numeros2);

		Integer[][] matriz = new Integer[4][5]; // como se hacía un array de 2 dimensiones
		Integer[][][] show_red = new Integer[1024][728][128]; // array de 3 dimensiones

		// Crear listas de más de una dimensión
		List<List<Integer>> listaDeListas = new ArrayList<List<Integer>>();
		List<List<List<Integer>>> lista3Dimensiones = new ArrayList<>();

		List<String> cadenas = new ArrayList<>();
		cadenas.add("Hola");
		cadenas.add("Mundo");
		cadenas.add("Cruel");
		cadenas.add("Hola"); // Las listas SÍ permiten elementos duplicados
		cadenas.add("Otra");
		cadenas.add("Vez");
		System.out.println(cadenas.size()); // Imprime número de elementos. 6

		List<String> otra = Arrays.asList("hola", "en", "minúscula"); // Una lista de cadenas con valores iniciales
		cadenas.addAll(otra);
		System.out.println(cadenas.size()); // 9

		// cadenas.clear();
		// System.out.println(cadenas.size()); // 0
		if (cadenas.contains("hola")) {
			System.out.println("La lista contiene hola");
		}

		// recorrer una lista entera
		cadenas.forEach(e -> System.out.println(e));
		System.out.println(cadenas.indexOf("Hola")); // 0
		System.out.println(cadenas.lastIndexOf("Hola")); // 3

	}

	public static void main(String[] args) {
		ejemplosListas();
	}
}
