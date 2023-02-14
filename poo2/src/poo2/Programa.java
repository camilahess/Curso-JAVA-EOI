package poo2;

public class Programa {

	public static void main(String[] args) {
		
		Ave pajaro = new Ave(true);
		Ave gallina = new Ave("Gallina", 3, false);
		
		pajaro.comer();
		pajaro.ponerHuevos();
		
	}
}
