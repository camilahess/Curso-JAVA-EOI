package poo2;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {

		Ave pajaro = new Ave(true);
		Ave gallina = new Ave("Animal desconocido", 1, true);

		// pajaro.comer();
		pajaro.ponerHuevos();

		Mamifero leon = new Mamifero("León", 210, true);
		Mamifero puma = new Mamifero("Puma", 210, true);
		leon.comer();
		System.out.println(leon.equals(puma)); // false
		System.out.println(pajaro.equals(gallina)); // true

		// POLIMORFISMO
		// Lista de elementos del padre , pero utilizará el toString de cada objeto
		List<Animal> animales = new ArrayList<Animal>();
		animales.add(gallina);
		animales.add(pajaro);
		animales.add(leon);
		animales.add(puma);
		animales.forEach(e -> System.out.println(e.toString()));

		System.out.println("Ejemplo instanceof:");
		for (Animal animal : animales) {
			// La siguiente línea fallaría en los animales que no fuesen Ave. Debe ponerse
			// dentro de un if con el instanceof
			// System.out.println("El número de pollitos es: " +
			// ((Ave)animal).pollitos(animal.getNombre()));
			if (animal instanceof Ave) {
				System.out.println("El número de pollitos es: " + ((Ave) animal).pollitos(animal.getNombre()));
			}
		}
	}
}
