package funciones;

import java.util.Scanner;

public class EjerciciosFunciones {
	
	public static void ejercicio1() {
		for(int i = 0; i <=20; i++) {
			System.out.print("*");
		} 
		System.out.println();
	}
	
	//public static void ejercicio1Mejorado(int numero, String cadena) {
		//for(int = 0; i < numero; i++) {
		//	System.out.print(cadena);
		//}
	//}
	
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
	
	
	public static void ejercicio3(char caracter, int numero) {
		//cuadrado relleno
		for (int fila = 0; fila < numero; fila++) {
			for (int col = 0; col < numero; col++) {
				System.out.print(caracter);
			}
			System.out.println(); // salto de línea
		}
		
	}
	public static void ejercicio3b(char caracter, int numero) {
		//CUADRADO HUECO
		//Fila de arriba
		for (int i = 0; i < numero; i++) {
				System.out.print(caracter);
			}
			System.out.println(); // salto de línea
			
			//Filas de la mitad
			for (int i = 0; i < numero; i++) {
				System.out.print(caracter); //Imprimo el primer carácter
				for(int j=0; j <numero - 2; j++) {
					System.out.print(" "); //Imprimo el medio vacío
				}
				System.out.print(caracter); //Lado derecho del cuadrado
				System.out.println();
			
			}
			//Fila de abajo
				for (int i = 0; i < numero; i++) {
					System.out.print(caracter);
		}
	}
	
	public static void ejercicio3c(char caracter, int numero) {
		for(int i=0; i<numero;i++) 
			System.out.println((i==0 || i==numero-1)?
					("" + caracter).repeat(numero):
					caracter + " ".repeat(numero-2) + caracter);	
	}
		
	
	
	public static void ejercicio4 (String nombre, String ...cadenas) {
		System.out.print(nombre + ": ");
		
		if(cadenas.length==0) 
			System.out.println("No hay trabajos realizados");
		else {
			for (int i = 0; i < cadenas.length; i++) {
				if (i < cadenas.length-1) {
					System.out.print(cadenas[i] + ", ");
				} else {
					System.out.print(cadenas[i] + ".");
				}
		}
	}
	}
	
	

	public static void main(String[] args) {
		//ejercicio1();
		//ejercicio1();
		//ejercicio1();
		//ejercicio1Mejorado
		
		//Ejercicios diferentes mejorados
		//ejercicio2("Hola", 2, 4); //Está en el rango
		//ejercicio2("adiós", 2, 4); //No está en el rango
		
		//ejercicio2b("Hola", 2, 4); //Está en el rango
		//ejercicio2b("adiós", 2, 4); //No está en el rango
		
		//ejercicio2c("Hola", 2, 4); //Está en el rango
		//ejercicio2c("adiós", 2, 4); //No está en el rango
		
		//ejercicio2cMejorado("Hello",4,2);
		//ejercicio2cMejorado("Hello",4,2);
		//ejercicio3('#', 5);
		//ejercicio3b ('*', 7);
		ejercicio4("Thiago","Back-Office","Programador","Agricultor");
		//ejercicio3c('*', 8);
		
		
		

	}

}
