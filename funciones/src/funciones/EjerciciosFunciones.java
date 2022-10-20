package funciones;

import java.util.Scanner;

public class EjerciciosFunciones {
	
	public static void ejercicio1() {
		for(int i = 0; i <=20; i++) {
			System.out.print("*");
		} 
		System.out.println();
	}
	
	public static void ejercicio2(String cadena, int a, int b ) {
			int letras = cadena.length();
			int min, max;
			if (a<b) {
				min=a;
				max=b;
			}
			else {
				min = b;
				max = a;
			}
			if (letras >=a && letras <=b)
				System.out.println("Está en el rango");
			else
				System.out.println("No está en el rango");
						
			}
	public static void ejercicio2b(String cadena, int a, int b ) {
		
		if (cadena.length() >=a && cadena.length() <=b)
			System.out.println("Está en el rango");
		else
			System.out.println("No está en el rango");
					
		}
	
	public static void ejercicio2c(String cadena, int a, int b ) {
		
		System.out.println(cadena.length() >=a && cadena.length() <=b ? "Está en el rango" : "No está en el rango");
	}
	
	
	public static void ejercicio2cMejorado(String cadena, int a, int b ) {
		
		System.out.println(cadena.length() >=Math.min(a, b) && cadena.length() <=Math.max(a, b)? "Está en el rango" : "No está en el rango");
	}
	
	
	public static void ejercicio3(String caracter, int numero) {

		for (int fila = 0; fila < numero; fila++) {
			for (int col = 0; col < numero; col++) {
				System.out.print(caracter);
			}
			System.out.println(); // salto de línea
		}
		
	}
	
	
	

	public static void main(String[] args) {
		//ejercicio1();
		//ejercicio1();
		//ejercicio1();
		
		//Ejercicios diferentes mejorados
		//ejercicio2("Hola", 2, 4); //Está en el rango
		//ejercicio2("adiós", 2, 4); //No está en el rango
		
		//ejercicio2b("Hola", 2, 4); //Está en el rango
		//ejercicio2b("adiós", 2, 4); //No está en el rango
		
		//ejercicio2c("Hola", 2, 4); //Está en el rango
		//ejercicio2c("adiós", 2, 4); //No está en el rango
		
		//ejercicio2cMejorado("Hello",4,2);
		//ejercicio2cMejorado("Hello",4,2);
		ejercicio3("#", 5);
		
		

	}

}
