package poo2;

public class Mamifero extends Animal {

	private boolean carnivoro;

	//usa el constructor de su padre, Animal. 
	public Mamifero(String nombre, double peso, boolean carnivoro) {
		super(nombre, peso);
		this.carnivoro = carnivoro;
	}

	@Override
	public void comer() {
		super.comer(); //llamo al comer de Animal 
		System.out.println("He comido: " + (carnivoro ? "carne" : "hierba"));
	}
}
