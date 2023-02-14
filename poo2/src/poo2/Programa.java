package poo2;

public class Programa {

	public static void main(String[] args) {

		Ave pajaro = new Ave(true);
		Ave gallina = new Ave("Animal desconocido", 1, true);

		//pajaro.comer();
		pajaro.ponerHuevos();
		
		Mamifero leon = new Mamifero("León", 210, true);
		Mamifero puma = new Mamifero("Puma", 210, true);
		leon.comer();
		System.out.println(leon.equals(puma)); //false
		System.out.println(pajaro.equals(gallina)); //true

	}
}
