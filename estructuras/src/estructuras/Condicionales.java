package estructuras;

import java.util.Scanner;

public class Condicionales {
	//Declaro la CONSTANTE con final para el iva que siempre es lo mismo
	// y lo puedo utilizar en cualquier método
	
	public static final double IVA = 0.21; 
	
	public static void ejemploUsandoIva() {
		//uso la constante IVA ya declarada fuera de este método.
		Scanner sc = new Scanner(System.in);
		double precio = 50;
		System.out.println("El precio con IVA es: " +( precio + (precio * IVA)));
	}
	public static void ejemplosIf() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.nextLine();
		if (nombre.equals("")) {
			System.out.println("¡El nombre no puede estar vacío!");
		}
		System.out.println("Hola " + nombre);

		sc.close(); // siempre cerrar scanner por errores
	}

	private static void ejemploIfElse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.nextLine();
		if (nombre.equals("")) {
			System.out.println("¡El nombre no puede estar vacío!");
		} else {
			System.out.println("Hola " + nombre);
		}

		sc.close();
	}
	
	private static void ejemplosIfElseIf() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.nextLine();
		if (nombre.equals("")) {
			System.out.println("¡El nombre no puede estar vacío!");
		} else if (nombre.length()==1) {
			System.out.println("No es un nombre muy corto?");
		} else {
			System.out.println("Hola " + nombre);
		}
		// Fuera del if-else if-else
		System.out.println("Esto se imprime siempre");
		sc.close();
		
	}

	public static void ejemplosIfElseIf1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.nextLine();
		if (nombre.equals("")) {
			System.out.println("¡El nombre no puede estar vacío!");
		} else if (nombre.length() == 1) {
			System.out.println("No es un nombre muy corto?");
		} else if (nombre.length() == 2) {
			System.out.println("Me sigue pareciendo un nombre corto");
		} else {
			System.out.println("Hola " + nombre);
		}
		// Fuera del if-else if-else
		System.out.println("Esto se imprime siempre");
		sc.close();
	}

	public static void ejemplosIfElseIf2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.nextLine();
		if (nombre.equals("")) {
			System.out.println("¡El nombre no puede estar vacío!");
		} else if (nombre.length() == 1) {
			System.out.println("No es un nombre muy corto?");
		} else if (nombre.length() == 2) {
			System.out.println("Me sigue pareciendo un nombre corto");
		}
		// Fuera del if-else if-else
		System.out.println("Hola " + nombre); // Siempre se haría esta línea
		sc.close();
	}

	public static void ternario1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.nextLine();
		
		//variable = (condición) ? valor si verdadero : valor si falso;
		System.out.println(nombre.equals("") ? "¡El nombre no puede estar vacío!" : "Hola " + nombre);

		int numero = 5;
		System.out.println((numero % 2 == 0) ? "El número es par" : "El número es impar");

		/*
		 * System.out.println(nombre.equals("")?"¡El nombre no puede estar vacío!"
		 * :(nombre.length()==1)?"No es un nombre muy corto?"
		 * :(nombre.length()==2)?"Me sigue pareciendo un nombre corto" :"Hola " +
		 * nombre);
		 */

		// Fuera del if-else
		System.out.println("Esto se imprime siempre");
		sc.close();
	}

	public static void ternario2() {
		int edad1 = 4;
		int edad2 = 7;
		int diferencia = (edad1 > edad2) ? edad1 - edad2 : edad2 - edad1;
		if (edad1 > edad2) {
			diferencia = edad1 - edad2;
		} else {
			diferencia = edad2 - edad1;
		}
		System.out.println(diferencia); // 3
	}
	
	public static void ejemploTernarias() {
		int edad = 40;
		System.out.println("Mi edad es 40");
		/*if(edad>=18)
			System.out.println("Eres mayor de edad");
		else
			System.out.println("Eres menor de edad");*/
		
		System.out.println((edad>=18) ? "Eres mayor de edad" : "Eres menor de edad");
		
		/*int descuento;
		if(edad>=18) {
			descuento=5;
		} else {
			descuento=20;
		}*/
		
		int descuento = (edad>=18) ? 5:20;
		System.out.println("Tú descuento es de: " + descuento + "€");
		
		
		/*int descuento3;
		if(edad<18) {
			descuento3 =1;
		} else if(edad>=18 && edad<=65) {
			descuento4=2;
		} else {
			descuento5=3;
		}*/
		
		//Si es menor de 18, opcion 1, sino, si esta entre 18 y 65, opcion 2, sino , 3. 
		//los dos puntos : son los else 
		int descuento3 = edad < 18 ? 1 : (edad>=18 && edad<=65)? 2 : 3;
		
		System.out.println("El descuento es de: " + descuento3 + "€");
		
		int euros = 1;
		if(euros>1) {
			System.out.println("Cuesta " + euros + " euros");
		} else {
			System.out.println("Cuesta " + euros + " euro");
		}
		
		System.out.println("Cuesta " + euros + " euro" + (euros != 1 ? "s":""));
		System.out.println("Cuesta " + euros + (euros!= 1 ? "euros" : " euro" ));
				
	}

	public static void switch1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el prefijo de tu país: ");
		int prefijo = sc.nextInt();
		switch (prefijo) {
		case 34:
			System.out.println("Tu país es España");
			break;
		case 49:
			System.out.println("Tu país es Alemania");
			break;
		case 54 :
			System.out.println("Tu país es Argentina");
		default:
			System.out.println("No sé cual es tu país...");
			break;
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		ejemploUsandoIva();

	}

}
