package poo2;

import java.util.Random;

public class Ave extends Animal implements IAnidar {

	private boolean puedeVolar;

	public Ave(boolean puedeVolar) {
		super();
		this.puedeVolar = puedeVolar;
	}

	public Ave(String nombre, double peso, boolean puedeVolar) {
		// super(); si pongo el super vacío estoy llamando al constructor del padre
		// vacío
		super(nombre, peso); // Aquí llamo al constructor con parámetros de Animal
		this.puedeVolar = puedeVolar;
	}

	public boolean getPuedeVolar() {
		return puedeVolar;
	}

	// puedo acceder a métodos como getPeso desde la clase que heredamos "Animal"
	public void ponerHuevos() {
		int numHuevos = new Random().nextInt(6) + 1;
		System.out.printf("He puesto %d huevos\n", numHuevos);
		// System.out.printf("He puesto %d huevos y peso %.2f kilos\n", numHuevos,
		// getPeso());

	}

	@Override
	public void comer() {
		// Definimos que un ave aumenta su peso un 5% siempre al comer
		setPeso(getPeso() * 1.05);
		System.out.printf("Pio pio. He comido y ahora peso %.2f kilos\n", getPeso());
	}

	@Override
	public String toString() {
		return "Esto es un ave";
	}

	@Override
	public int pollitos(String nombre) {
		if (nombre.equals("Animal desconocido")) {
			return 2;
		} else if (nombre.equals("Gallina")) {
			return 3;
		} else {
			return 4;
		}
	}

}
