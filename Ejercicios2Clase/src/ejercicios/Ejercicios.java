package ejercicios;

import java.util.Scanner;

public class Ejercicios {
	
	private static void ejercicio1() {
		Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Número entero: ");                                                 
        N = sc.nextInt();
        if(N%2==0) { //Para saber si es par
           System.out.println("Par");   
        } else {
            System.out.println("Impar"); 
     }	
        sc.close();
	}
	
	private static void ejercicio2() {
		Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Número entero: ");
        N = sc.nextInt();
        if(N%10==0) { //Si el numero dividido 10 da cero, es multiplo de 10
           System.out.println("Es múltiplo de 10");   
        } else {
           System.out.println("No es múltiplo de 10");
		
	 }
        sc.close();
	}
	private static void ejercicio3() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Introduzca un carácter: ");
        char car = sc.nextLine().charAt(0);
        if (car>='A' && car <='Z') {
        	System.out.println("Es una letra mayúscula");
        } else {
        	System.out.println("No es una letra mayúscula");
        }
        
		sc.close();
	}
	private static void ejercicio4() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Introduzca una palabra : ");
		String palabra1 = sc.nextLine();
		System.out.println("Introduzca otra palabra: ");
		String palabra2 = sc.nextLine();
		if (palabra1.equals(palabra2)) {
			System.out.println("Las palabras son iguales");
		} else {
			System.out.println("Las palabras NO son iguales");
		}
		
		sc.close();
		
		}

	private static void ejercicio5() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		int numero1 = sc.nextInt();
		System.out.println("Introduzca otro número: ");
		int numero2 = sc.nextInt();
		if (numero2 > 0) {
			System.out.println(numero1 + "%" + numero2 + "= " + numero1/numero2);
		} else {
			System.out.println("El divisor no puede ser cero");
		}
		sc.close();
		
		}
		
	private static void ejercicio6() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Introduzca el primer número entero");
		int num1 = sc.nextInt();
		System.out.println("Introduzca el segundo número entero");
		int num2 = sc.nextInt();
		System.out.println("Introduzca el tercer número entero");
		int num3 = sc.nextInt();
		if (num1>num2 && num1>num3) {
			System.out.println("El número mayor es: " + num1);
		} else if (num2>num1 && num2>num3) {
			System.out.println("El mayor es : " + num2);
		} else{
			System.out.println(" El mayor es : " + num3);
		}
		sc.close();
		
		}
	
	private static void ejercicio7() {
		
	}
	
	
	public static void main(String[] args) {
		ejercicio6();

	}

}
