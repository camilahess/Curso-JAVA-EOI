package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ejercicios {
	
	
	public static void ejercicio7_5(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero"); ///Users/camilahess/Desktop/ficheros/eoi.txt
		String nombreFichero = sc.nextLine();
		List<String> lineas = Ejemplos2.devolverLineasJava8(Paths.get(nombreFichero));
		if(lineas!=null) {
			lineas.forEach(e->System.out.println(e));
			
//			int elementosLista = lineas.size();
//			Random random = new Random();
//			int azar = random.nextInt(elementosLista);
			int azar = new Random().nextInt(lineas.size());//Esto es lo mismo que las tres líneas de arriba
			String palabra = lineas.get(azar);
			
			System.out.println("Adivina la palabra: ");
		        for (int i = 0; i < 3; i++) {
		            System.out.print("Intento " + (i + 1) + ": ");
		            String adivinar = sc.nextLine();
		            if (adivinar.equalsIgnoreCase(palabra)) {
		                System.out.println("¡Has ganado!");
		                return;
		            } else {
		                System.out.println("Incorrecto");
		            }
		        }

		        System.out.println("Has perdido. La palabra era " + lineas.get(azar));
		    }
		}

	/**
	 * Crea un programa que vaya leyendo lo que el usuario escribe en consola y lo escriba en un
	 * fichero (línea a línea). Terminará cuando el usuario escriba la palabra ‘FIN’.
	 * @param nombreFichero
	 */
	public static void ejercicio2(String nombreFichero) {
		Scanner sc = new Scanner(System.in);
		String linea;
		try {
			Files.writeString(Paths.get(nombreFichero), "");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		do {
			System.out.println("Introduzca la línea que quiere insertar en el fichero (FIN para finalizar): ");
			linea = sc.nextLine();
			if(!linea.equalsIgnoreCase("fin")) {
				try {
					Files.writeString(
							Paths.get(nombreFichero), 
							linea+"\n",
							StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		}while(!linea.equalsIgnoreCase("fin"));
		sc.close();
	}
	public static void main(String[] args) {
		//ejercicio7_5(); 
		ejercicio2("/Users/camilahess/Desktop/ficheros/ejercicio2.txt");
	}
}
