package ejercicios;

import java.util.Scanner;

public class segundaprueba {
	
	private static void ejercicio2() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Dime un número entero: ");
	int num = sc.nextInt();
	
	if (num % 10 == 0) {
		System.out.println("Tú número es múltiplo de 10");
	} else {
		System.out.println("Tú número no es múltiplo de 10");
	}
	}
	
	private static void ejercicio3() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Escribe una letra");
	char letra = sc.nextLine().charAt(0);
	if (letra >= 'A' && letra <= 'Z') { //tiene que ir con comillas simples
		System.out.println("Es una letra mayúscula");
	} else {
		System.out.println("No es una letra mayúscula");
	}
	}
	
	private static void ejercicio4() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Escribe dos palabras: ");
	String cadena1 = sc.nextLine();
	String cadena2 = sc.nextLine();
	if (cadena1.equals(cadena2)) {
		System.out.println("Las palabras son iguales");
	} else {
		System.out.println("Las palabras son diferentes");
	}
	
	}
	
	private static void ejercicio5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa dos números");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if ( num2 != 0 ) {
			System.out.println(num1 + "/" + num2 + " = " + (num1/num2));	
		}	else {
			System.out.println("El divisor no puede ser cero");
		}			
	}
	
	

	public static void main(String[] args) {
			ejercicio5();

	}

}
