package funciones;

import java.util.Scanner;

public class EjemplosFunciones {
	
	public static void buscarSiguiente(String cadena) {
		Scanner sc = new Scanner(System.in);
		String cadena="w Esta es una cadena más larga que la Anterior, hola adiós hola hola";
		boolean salir = false;
		int posicionEncontrada = -1;
		// Pista: contains, indexOf, lastIndexOf
		System.out.println("Introduzca la cadena a buscar: ");
		String cadenaBuscada = sc.nextLine();
		while(!salir) {
			posicionEncontrada = cadena.toLowerCase().indexOf(cadenaBuscada.toLowerCase(), posicionEncontrada+1);
			if(posicionEncontrada!=-1) {  // Encuentro la cadena
				System.out.println(cadena.substring(posicionEncontrada));
				System.out.println("¿Buscar siguiente? (s/n): ");
				String respuesta = sc.nextLine();
				if(respuesta.toLowerCase().equals("n")) {
					salir = true;
				}
			} else {
				System.out.println("No se encuentran más ocurrencias de la cadena");
				salir = true;
			}			
		}		
	}
	
	public static void funcion1 () {
		System.out.println("hola mundo");
	}
	
	public static void funcion2 () {
		System.out.println("adios mundo");
	}

	
	
	public static void main(String[] args) {
		funcion1 ();
		funcion2();

	}

}
