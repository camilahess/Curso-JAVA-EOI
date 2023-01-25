package ejercicios;

import java.util.Scanner;

public class EjerciciosTema2 {

	private static void ejercicio1() {
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.print("Número entero: ");
		N = sc.nextInt();
		if (N % 2 == 0) { // Para saber si es par
			System.out.println("Tú número es par");
		} else {
			System.out.println("Tu número es impar");
		}
		sc.close();
	}

	private static void ejercicio2() {
		/*
		 * Programa que lea un número entero y muestre si el número es múltiplo de 10
		 * (si el resto de la división entre 10 da 0).
		 */
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.print("Número entero: ");
		N = sc.nextInt();
		if (N % 10 == 0) { // Si el numero dividido 10 da cero, es multiplo de 10
			System.out.println("Es múltiplo de 10");
		} else {
			System.out.println("No es múltiplo de 10");

		}
		sc.close();
	}

	private static void ejercicio3() {
		/*
		 * Programa que lea un carácter por teclado y compruebe si es una letra
		 * mayúscula. Una letra mayúscula es aquella que está entre la ‘A’ y la ‘Z’.
		 * Recuerda que se pueden comparar los caracteres como si fueran números.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un carácter: ");
		char car = sc.nextLine().charAt(0); // char at es para que lea el primer carácter recibido
		if (car >= 'A' && car <= 'Z') {
			System.out.println("Es una letra mayúscula");
		} else {
			System.out.println("No es una letra mayúscula");
		}

		sc.close();
	}

	private static void ejercicio4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca una palabra : ");
		String palabra1 = sc.nextLine();
		System.out.println("Introduzca otra palabra: ");
		String palabra2 = sc.nextLine();
		if (palabra1.equalsIgnoreCase(palabra2)) { // Utilizamos ignore case para quitar mayus o minus
			System.out.println("Las palabras son iguales");
		} else {
			System.out.println("Las palabras NO son iguales");
		}

		sc.close();

	}

	private static void ejercicio4b() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una palabra");
		String p1 = sc.nextLine();
		System.out.println("Ingrese otra palabra");
		String p2 = sc.nextLine();
		if (p1.equalsIgnoreCase(p2)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");
		}

		sc.close();
	}

	private static void ejercicio5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vamos a dividir dos números!");
		System.out.println("Introduzca el primer número: ");
		int numero1 = sc.nextInt();
		System.out.println("Introduzca el segundo número: ");
		int numero2 = sc.nextInt();
		if (numero2 > 0) {
			double result = (double) (numero1 / numero2);
			System.out.printf(numero1 + "/" + numero2 + "= " + result);
		} else {
			System.out.printf("El divisor no puede ser cero, intente con otro número");
		}
		sc.close();

	}

	private static void ejercicio6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el primer número entero");
		int num1 = sc.nextInt();
		System.out.println("Introduzca el segundo número entero");
		int num2 = sc.nextInt();
		System.out.println("Introduzca el tercer número entero");
		int num3 = sc.nextInt();
		if (num1 > num2 && num1 > num3) {
			System.out.println("El número mayor es: " + num1);
		} else if (num2 > num1 && num2 > num3) {
			System.out.println("El mayor es : " + num2);
		} else {
			System.out.println(" El mayor es : " + num3);
		}
		sc.close();

	}

	private static void ejercicio7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escriba la hora (HH) ");
		int horas = sc.nextInt();

		if (horas >= 00 && horas <= 23) {
			System.out.println("Escriba los minutos (MM) ");
			int minutos = sc.nextInt();
				if (minutos >= 0 && minutos <= 59) {
				System.out.println("Escriba los segundos(SS ) ");
				int segundos = sc.nextInt();
					if (segundos >= 0 && segundos <= 59) {
					System.out.println(
					"Tú hora es: " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");
				} else {
					System.out.println("La hora introducida es errónea");
				}
			} else {
				System.out.println("Los minutos introducidos no son correctos");
			}
		} else {
			System.out.println("Los segundos introducidos no son correctos");
		}
		sc.close();
	}

	private static void ejercicio8() {
		/*
		 * BÁSICO :
		 * 
		 * int a = 5;
		 * 
		 * if (a%2==0) { System.out.println("Tú número es par"); } else {
		 * System.out.println("Tú número es impar"); }
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int a = sc.nextInt();

		System.out.println((a % 2 == 0) ? "Tú número es par" : " Tú número es impar");
		sc.close();
	}

	private static void ejercicio9() {
		Scanner sc = new Scanner(System.in);
		int mes;
		System.out.println("Introduzca el número de mes: ");
		mes = sc.nextInt();
		if (mes < 1 || mes > 12) {
			System.out.println("El mes es incorrecto");
		} else {
			switch (mes) {
			case 1:
				System.out.print("El mes de enero tiene 31 días");
				break;
			case 2:
				System.out.print("El mes de febrero tiene 28 días");
				break;
			case 3:
				System.out.print(" El mes de marzo tiene 31 días");
				break;
			case 4:
				System.out.print(" El mes de abril tiene 30 días");
				break;
			case 5:
				System.out.print(" El mes de mayo tiene 31 días");
				break;
			case 6:
				System.out.print(" El mes de junio tiene 30 días");
				break;
			case 7:
				System.out.print(" El mes de julio tiene 31 días");
				break;
			case 8:
				System.out.print(" El mes de agosto tiene 31 días");
				break;
			case 9:
				System.out.print(" El mes de septiembre tiene 30 días");
				break;
			case 10:
				System.out.print(" El mes de octubre tiene 31 días");
				break;
			case 11:
				System.out.print(" El mes de noviembre tiene 30 días");
				break;
			case 12:
				System.out.print(" El mes de diciembre tiene 31 días");
				break;

			default:
				break;
			}

		}
		sc.close();
	}

	private static void ejercicio10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe una letra,un número o un carácter: ");
		char letra = sc.next().charAt(0); // CharAt(0) es para que lea el primer carácter

		switch (letra) {
		case '.':
			System.out.println("Es un .");
			break;
		case ',':
			System.out.println("Es una ,");
			break;
		case ':':
			System.out.println("Son dos puntos :");
			break;
		case ';':
			System.out.println("Es un ; ");
			break;
		case '0':
			System.out.println("Es un 0");
			break;
		case '1':
			System.out.println("Es un 1");
			break;
		case '2':
			System.out.println("Es un 2");
			break;
		case '3':
			System.out.println("Es un 3");
			break;
		case '4':
			System.out.println("Es un 4");
			break;
		case '5':
			System.out.println("Es un 5");
			break;
		case '6':
			System.out.println("Es un 6");
			break;
		case '7':
			System.out.println("Es un 7");
			break;
		case '8':
			System.out.println("Es un 8");
			break;
		case '9':
			System.out.println("Es un 9");
			break;

		default:
			System.out.println("Es otro carácter");
			break;
		}
		sc.close();
	}

	private static void ejercicio11() {
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
		while (opcion != 5) { // con el while volvemos a pedir el menu cuando la opcion es incorrecta

			System.out.println("Elige una de las siguientes opciones");
			System.out.println("1.Sumar");
			System.out.println("2.Restar");
			System.out.println("3.Multiplicar");
			System.out.println("4.Dividir");
			System.out.println("5.Salir");
			opcion = sc.nextInt();
			int n1 = -1;
			int n2 = -1;
			double division = (double) n1 / n2;

			if (opcion >= 1 && opcion <= 4) {
				System.out.println("Escribe un número entero");
				n1 = sc.nextInt();
				System.out.println("Escribe un segundo número entero");
				n2 = sc.nextInt();
			}

			switch (opcion) {
			case 1:
				System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
				break;
			case 2:
				System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
				break;
			case 3:
				System.out.println(n1 + " x " + n2 + " = " + (n1 * n2));
				break;
			case 4:
				System.out.println((n2 == 0) ? "El divisor no puede ser 0" : (n1 + " / " + n2) + " = " + (division));
				break;
			case 5:
				System.out.println("Gracias por utilizar la calculadora");
				break;
			default:
				System.out.println("Opción no válida. Vuelva a elegir opción.\n");
				break;
			}

		}
		sc.close();
	}

	private static void ejercicio12() {
		Scanner sc = new Scanner(System.in);
		double precio = 50;
		System.out.println("El precio de la entrada es: " + "€" + precio);
		System.out.println("Cuál es tu edad?: ");
		int edad = sc.nextInt();
		sc.nextLine();
		String socio = "no";
		double descuento = 0;

		if (edad < 18) {
			// hacer descuento 25%
			descuento = 0.25;
			precio = precio * (1 - descuento);
		} else if (edad >= 18 && edad <= 65) {
			System.out.print(" Es usted socio? (si/no): ");
			socio = sc.nextLine();
			if (socio.toLowerCase().equals("si")) {
				descuento = 0.40;
				precio = precio * (1 - descuento);
			}
		} else if (edad >= 65) {
			descuento = 0.75;
			precio = precio * (1 - descuento);
		}

		System.out.println("El precio de su entrada es de: " + "€" + precio);
		System.out.println("Se le ha aplicado un descuento del : " + (descuento * 100) + "%");
	}

	/**
	 * Muestra por pantalla los números de 20 al 1 usando un bucle while
	 */
	public static void ejercicio13() {
		int numero = 20;
		while (numero > 0) {
			System.out.println(numero);
			numero--; // decremento necesario para que el bucle no sea infinito.
		}
	}

	public static void ejercicio13CualquierNumero() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el número a decrementar: ");
		int numero = sc.nextInt();
		while (numero > 0) {
			System.out.println(numero);
			numero--; // decremento necesario para que el bucle no sea infinito.
		}
		sc.close();
	}


	private static void ejercicio13b() {
		/*
		 * BUCLE CON WHILE int i = 20; while(i<=20 && i > 0) { System.out.print(i+", ");
		 * i-=1; }
		 */
		for (int i = 20; i > 0; i--) {
			if (i != 1) {
				System.out.print(i + ",");
			} else {
				System.out.print(i + ".");
			}
		}
	}
	/** 
	 * . Inicializa una variable entera a 0. Después, pregunta al usuario por un número y súmaselo a la 
	 * variable inicial. Repite esto hasta que el usuario introduzca el número cero. Utiliza el bucle 
	 * do..while.
	 */
	private static void ejercicio14() {
		Scanner sc = new Scanner(System.in);
		int suma = 0;
		int num = -1;
		do {
			System.out.println("Dime un número:");
			num = sc.nextInt();
			suma += num;
			System.out.println("Resultado: " + suma);
		} while (num != 0);
		sc.close();
	}

	/**
	 * Pide al usuario un número y calcula cuantas cifras tiene dicho número. Para ello puedes dividir
	 * el número entre 10 hasta que el resultado sea cero.
	 */
	private static void ejercicio15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime un número: ");
		int num = sc.nextInt();
		int cifras = 0; // contador de cifras
		
		while (num != 0) {
			num /= 10; // achicamos el numero = num = num / 10 
			cifras++; // sube el contador
		}
		System.out.println("El número tiene " + cifras + " cifras");
		sc.close();

	}
	
	/**
	 * . Pide al usuario un número y dibuja una línea con tantos asteriscos como el número introducido.
	 */
	private static void ejercicio16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime un número entero: ");
		int num = sc.nextInt();

		for (int j = 0; j < num; j++) {
			System.out.print(" * ");
		}
		sc.close();
	}

	/**
	 * Muestra los números del 1 al 30 menos los divisibles entre 3 (resto da cero).
	 */
	private static void ejercicio17() {
		for (int i = 1; i <= 30; i++) {
			if ((i % 3) > 0)
				System.out.println(i);
		}
	}

	/**
	 * Muestra de 5 en 5, los números del 0 al 100.
	 */
	private static void ejercicio18() {
		for (int i = 0; i >= 0 && i <= 100; i+=5) {
			System.out.print(i + ", ");
		}
	}

	private static void ejercicio19() {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("Introduce un número entero: ");
		num = sc.nextInt();
		System.out.print("\nNumeros del 1 al " + num + ": ");

		for (int i = 1; i <= num; i++) {
			System.out.print((i!=num)?i+",":i+".");
		}
	}

	private static void ejercicio20() {
		Scanner sc = new Scanner(System.in);
		int suma = 0;
		int num = -1;
		while (true) {
			System.out.println("Dime un número: \n");
			num = Integer.parseInt(sc.nextLine());
			if (num == 0)
				break; // corta por encontrar el cero
			if (num < 0)
				continue; // continua con el bucle
			suma += num;
			System.out.println("Resultado: " + suma);
		}
		while (num != 0)
			;
		sc.close();
	}

	private static void ejercicio21() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un número para saber sus divisores: ");
		int numero = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= numero; i++) {
			if (numero % i == 0) {
				// imprimes la solucion
				System.out.println(i);
			}
		}
		sc.close();
	}

	private static void ejercicio22() {
		// Repite 5 veces lo que encuentra en el for anidado
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(j);
			}
		}
	}

	private static void ejercicio23() {
		for (int i = 9; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println(); // salto de linea
		}
	}

	private static void ejercicio24() {
		// cuadrado mismo alto que ancho
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un número");
		int num = Integer.parseInt(sc.nextLine());

		for (int fila = 0; fila < num; fila++) {
			for (int col = 0; col < num; col++) {
				System.out.print("*");
			}
			System.out.println(); // salto de línea
		}
		sc.close();
	}

	private static void ejercicio25() {
		// escalera de bajada
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un número");
		int num = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= num; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}
			System.out.println();
		}
	}

	private static void ejercicio26() {
		// Escalera de subida, mitad de pirámide
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un número para la altura de la figura");
		int num = sc.nextInt();

		for (int filas = 1; filas <= num; filas++) {

			for (int blancos = 1; blancos <= num - filas; blancos++) {
				System.out.print(" ");
			}
			for (int asteriscos = 1; asteriscos <= filas; asteriscos++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	private static void ejercicio27() {
		// Cuadrado vacío
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime un ancho: ");
		int ancho = sc.nextInt();

		System.out.print("Dime un alto: ");
		int alto = sc.nextInt();

		for (int fila = 1; fila <= alto; fila++) {

			for (int col = 1; col <= ancho; col++) {

				if (fila == 1 || fila == alto || col == 1 || col == ancho) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		sc.close();
	}

	private static void ejercicio28() {
		// Pirámide normal
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca número de filas");
		int numFilas = sc.nextInt();

		for (int altura = 1; altura <= numFilas; altura++) {
			// Espacios en blanco
			for (int blancos = 1; blancos <= numFilas - altura; blancos++) {
				System.out.print(" ");
			}

			// Asteriscos
			for (int asteriscos = 1; asteriscos <= (altura * 2) - 1; asteriscos++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

	private static void ejercicio29() {
		// pirámide hueca
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca número de filas");
		int num = sc.nextInt();

		for (int i = 0; i < num; ++i) {
			// Cada primer for, se hace un salto de línea.
			System.out.println();
			// Utilizamos dos for para lograr la forma.
			for (int j = 0; j < num - i - 1; ++j) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; ++j) {
				// Condición para imprimir solo los bordes.
				if ((i == 0) || (i == num - 1) || (j == 0) || (j == 2 * i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
		}
		System.out.println();
		sc.close();
	}

	private static void ejercicio30() {
		// Pirámide de asteriscos invertida
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca numero de filas: ");
		int numFilas = sc.nextInt();
		sc.close();
		System.out.println();
		for (int numBlancos = 0,
				numAsteriscos = (numFilas * 2) - 1; numAsteriscos > 0; numBlancos++, numAsteriscos -= 2) {

			// Espacios en blanco
			for (int i = 0; i < numBlancos; i++) {
				System.out.print(" ");
			}

			// Asteriscos
			for (int j = numAsteriscos; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void main(String[] args) {
		ejercicio19();

	}

}
