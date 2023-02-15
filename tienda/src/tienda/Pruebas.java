package tienda;

import java.util.ArrayList;
import java.util.List;

public class Pruebas {

	public static void main(String[] args) {
		TiendaLicores manolo = new TiendaLicores(); //instancias, crear objeto
		manolo.bienvenida();
		
		List<Persona> personas = new ArrayList<Persona>();
		Persona camila = new Persona(763728,"Camila", 29);
		Persona thiago = new Persona(763725,"Thiago", 19);
		Persona tomas = new Persona(763729,"Tomas", 27);
		Persona jaqui = new Persona(763721,"Jaqui", 52);
		
		personas.add(jaqui);
		personas.add(tomas);
		personas.add(thiago);
		personas.add(camila);
		
		personas.forEach(e->System.out.println(e.toString()));
		
		Persona copia = new Persona(camila);
		copia.setNombre("Camille");
		
		int contador = 0;
		for (Persona persona : personas) {
			if (persona.equals(copia)) {
				System.out.println("Persona encontrada en la posición: " + contador );
				System.out.println("Persona encontrada: " + persona);
				System.out.println("Copia: " + copia);
			}
			contador ++;
		}
		
		
		//compara si hay una persona con el mismo dni
		for (Persona persona : personas) {
			if (persona.equals(copia)) {
				System.out.println("Persona encontrada en la posición: " + personas.indexOf(persona) );
				
			}
		}
		
		//programación estructurada
		for (int i=0; i<personas.size();i++) {
			if (personas.get(i).equals(copia)) {
				System.out.println("Persona encontrada en la posición: " + i);
			}
		}
		
		
	}

}
