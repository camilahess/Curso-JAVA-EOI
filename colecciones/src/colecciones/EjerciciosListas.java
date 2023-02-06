package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EjerciciosListas {

	private static void ejercicio1() {
		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40));
		System.out.println(numeros);
		// numeros.forEach(n -> System.out.println(n));
		numeros.add(50);
		numeros.add(60);
		System.out.println(numeros);
		// numeros.forEach(n -> System.out.println(n));
		// numeros.remove(1); // elimina la posición 1, en este caso el 20
		// numeros.removeIf(n ->n==20); // este borra todos los 20 que encuentre
		numeros.remove(numeros.indexOf(20)); // borra el primero que encuentra
		System.out.println(numeros);
		numeros.add(1, 25);
		numeros.add(2, 26);
		System.out.println(numeros);
		numeros.sort(Collections.reverseOrder());
		System.out.println(numeros);

	}

	public static void main(String[] args) {
		ejercicio1();

	}

}
