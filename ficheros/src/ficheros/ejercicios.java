package ficheros;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ejercicios {
	
	
	public static void ejercicio7_5(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero");
		String nombreFichero = sc.nextLine();
		List<String> lineas = Ejemplos2.devolverLineasJava8(Paths.get(nombreFichero));
		if(lineas!=null) {
			lineas.forEach(e->System.out.println(e));
			
//			int elementosLista = lineas.size();
//			Random random = new Random();
//			int azar = random.nextInt(elementosLista);
			//Esto es lo mismo que las tres líneas de arriba
			int azar = new Random().nextInt(lineas.size());
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


	public static void main(String[] args) {
		ejercicio7_5(); ///Users/camilahess/Desktop/ficheros/eoi.txt
	}
}
