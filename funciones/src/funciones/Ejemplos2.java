package funciones;

import java.util.Random;

public class Ejemplos2 {

	
	public static void imprimirMenu(String...opciones) {
		//número indeterminado de cadenas
		// array de Strings, se deben de recorrer
		int num = 1;
		for (String opcion:opciones) {
			System.out.println(num++ +"."+opcion);
		}
		System.out.println("0.Salir");
		
	}
	
	public static void sumar(int num1, int num2) {
		System.out.println(num1+num2);
	}
	
	//SOBRECARGA DE MÉTODOS 
	public static void imprimirSuma(int num1, int num2) {
		System.out.println(num1+num2);
	}
	public static void imprimirSuma(int num) {
		System.out.println(num+10);
	}
	public static void imprimirSuma(double num1, double num2) {
		System.out.println(num1+num2);
	}
	public static void imprimirSuma(float num1, float num2) {
		System.out.println(num1+num2);
	}
	public static void imprimirSuma(String num1, String num2) {
		System.out.println(Integer.parseInt(num1)+Integer.parseInt(num2));
	}
	
	public static String adivinar(String[] palabras) {
		int aleatoria = new Random().nextInt(palabras.length);
		return palabras[aleatoria];
	}
	
	public static void main(String[] args) {
//		String cadena2 = "Hola que tal";
//		imprimirCadena(cadena2);
//		imprimirCadena("Holissss");
//		//imprimirMenu("Guardar", "Descargar","Copiar");
//		//sumar(2,5);
//		imprimirSuma(2.5,2.8); //utiliza la funcion de imprimirsuma con double
//		imprimirSuma(2,8); //utiliza la misma función con int, etc.
//		imprimirSuma("10","20");
		
		
	}

}
