package funciones;

import java.util.Arrays;
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
	
	//parámetros por valor y por referencia
	public static void porValor(int num) {
		num = 99;
	}
	
	public static void porReferencia(int[] numeros) {
		numeros[0] = 99;
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
		int num1= 5;
		porValor(num1);
		System.out.println(num1); // el número no cambia, sigue siendo 5
		
		int[] array = {1, 2, 3, 4};
		porReferencia(array);
		System.out.println(Arrays.toString(array)); // [99, 2, 3, 4] Aquí si cambia
		
		//si queremos cambiar el valor de una variable es mejor trabajar con arrays
		//los valores primitivos no cambian
		int[] var1ref = {num1}; // {5}
		porReferencia(var1ref); // {99}
		System.out.println(var1ref[0]); // 99
	
	}

}
