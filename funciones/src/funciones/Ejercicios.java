package funciones;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicios {

	public static void ejercicio1() {
		for (int i = 0; i <= 20; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	// public static void ejercicio1Mejorado(int numero, String cadena) {
	// for(int = 0; i < numero; i++) {
	// System.out.print(cadena);
	// }
	// }

	public static void ejercicio2(String cadena, int a, int b) {
		int letras = cadena.length(); // longitud de la cadena ejemplo hola es 4
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		if (letras >= a && letras <= b)
			System.out.println("Está en el rango");
		else
			System.out.println("No está en el rango");

	}

	public static void ejercicio2b(String cadena, int a, int b) {
		// ESTO ES MÁS FÁCIL DE ENTENDER pero no considera si es es mayor que b que
		// sucedería.
		if (cadena.length() >= a && cadena.length() <= b)
			System.out.println("Está en el rango");
		else
			System.out.println("No está en el rango");

	}

	public static void ejercicio2c(String cadena, int a, int b) {

		System.out.println(cadena.length() >= a && cadena.length() <= b ? "Está en el rango" : "No está en el rango");
	}

	public static void ejercicio2cMejorado(String cadena, int a, int b) {
		// ESTE EJEMPLO CONSIDERA TODO, si a es mayor o menor, da igual
		System.out.println(cadena.length() >= Math.min(a, b) && cadena.length() <= Math.max(a, b) ? "Está en el rango"
				: "No está en el rango");
	}

	public static void ejercicio3(char caracter, int numero) {
		// cuadrado relleno
		for (int fila = 0; fila < numero; fila++) {
			for (int col = 0; col < numero; col++) {
				System.out.print(caracter);
			}
			System.out.println(); // salto de línea
		}

	}

	public static void ejercicio3b(char caracter, int numero) {
		// CUADRADO HUECO
		// Fila de arriba
		for (int i = 0; i < numero; i++) {
			System.out.print(caracter);
		}
		System.out.println(); // salto de línea

		// Filas de la mitad
		for (int i = 0; i < numero; i++) {
			System.out.print(caracter); // Imprimo el primer carácter
			for (int j = 0; j < numero - 2; j++) {
				System.out.print(" "); // Imprimo el medio vacío
			}
			System.out.print(caracter); // Lado derecho del cuadrado
			System.out.println();

		}
		// Fila de abajo
		for (int i = 0; i < numero; i++) {
			System.out.print(caracter);
		}
	}

	public static void ejercicio3c(char caracter, int numero) {
		for (int i = 0; i < numero; i++)
			System.out.println((i == 0 || i == numero - 1) ? ("" + caracter).repeat(numero)
					: caracter + " ".repeat(numero - 2) + caracter);
	}

	public static void ejercicio4(String nombre, String... cadenas) {
		System.out.print(nombre + ": ");

		if (cadenas.length == 0)
			System.out.println("No hay trabajos realizados");
		else {
			for (int i = 0; i < cadenas.length; i++) {
				if (i < cadenas.length - 1) {
					System.out.print(cadenas[i] + ", ");
				} else {
					System.out.print(cadenas[i] + ".");
				}
			}
		}
	}

	public static boolean ejercicio5(int numero) {
		// El 0, 1 y 4 no son primos
		if (numero == 0 || numero == 1 || numero == 4) {
			return false;
		}
		for (int x = 2; x < numero / 2; x++) {
			// Si es divisible por cualquiera de estos números, no
			// es primo
			if (numero % x == 0)
				return false;
		}
		// Si no se pudo dividir por ninguno de los de arriba, sí es primo
		return true;
	}

	public static double ejercicio6(double[] array) {
		double suma = 0.0;
		for (int i = 0; i < array.length; i++) {
			suma = suma + array[i];
			// o suma += array[i];
		}
		return suma / array.length;
	}

	public static double ejercicio6b(double...numeros) {
		double resultado=0;
		for(double numero:numeros) {
			resultado +=numero;
		}
		return resultado/numeros.length;
	}
	
	public static double ejercicio6Average(double[] numeros) {
		return Arrays.stream(numeros).average().getAsDouble();
	}
	
	public static String devolverAzar(String [] palabras) {
		
		int aleatoria = new Random().nextInt(palabras.length);
		return palabras[aleatoria];
		// return palabras[new Random().nextInt(palabras.length)]; lo mismo
	}
	
	public static void mostrarElementos(String[] cadenas) {
		for (String cadena:cadenas) {
			System.out.print(cadena+"-");
		}
		//Arrays.stream(cadenas).forEach(e->System.out.println(e)); //funcional
	}
	public static void ejercicio7() {
		Scanner sc = new Scanner(System.in);
		String[] palabras = {"casa", "gato", "mano", "cara", "silla"};
		System.out.println("Tienes que adivinar una de estas palabras: " + Arrays.asList(palabras)); 
		//mostrarElementos(palabras);
		String palabraAdivinar = devolverAzar(palabras);
		
		boolean adivinada = false;
		int intentos = 0;
		final int MAXIMO_INTENTOS=3;
		
		while(!adivinada && intentos < MAXIMO_INTENTOS) {
			System.out.print("Adivina la palabra (intento " + (intentos + 1) + "): ");
			String palabra = sc.nextLine();
			if(palabra.equals(palabraAdivinar)) {
				adivinada = true;
			}
			intentos++;
		}
		
		System.out.println((adivinada?"Enhorabuena, has acertado!":("La palabra correcta era " + palabraAdivinar)));
	}

	public static int ejercicio8Funcional(int...numeros) {
		return Arrays.stream(numeros).max().orElse(0);
	}
	
	public static int ejercicio8b(int...numeros) {
		int maximo = Integer.MIN_VALUE; // la inicialización siempre será el máximo, para no poner cero y que tome numeros negativos
		if (numeros.length==0) {
			return 0 ;
		}
		for(int numero:numeros) {
			if(numero>maximo) {
				maximo=numero;
			}
		}
		return maximo;
		
	}
	
	public static int ejercicio9(String cadena, String subCadena) {
		int contador = 0;
	    int indice = 0;
	    while ((indice = cadena.indexOf(subCadena, indice)) != -1) {
	        // Se encontró una coincidencia, se aumenta el contador
	        contador++;
	        // Se mueve el índice para buscar la siguiente coincidencia
	        indice += subCadena.length();
	    }
	    return contador;
	}
	
	public static int ejercicio9Pattern(String cadena, String subcadena) {
		//el patrón hace match con la cadena? : 
		Pattern p = Pattern.compile(subcadena);
	    Matcher m = p.matcher(cadena);
	    int contador = 0;
	    while (m.find()) { //mientras haya matches y se encuentre, se aumenta el contador
	        contador++;
	    }
	    return contador;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ejercicio1();
		// ejercicio1();
		// ejercicio1();
		// ejercicio1Mejorado

		// Ejercicios diferentes mejorados
		// ejercicio2("Hola", 2, 4); //Está en el rango
		// ejercicio2("adiós", 2, 4); //No está en el rango

		// ejercicio2b("Hola", 2, 4); //Está en el rango
		// ejercicio2b("adiós", 2, 4); //No está en el rango

		// ejercicio2c("Hola", 2, 4); //Está en el rango
		// ejercicio2c("adiós", 2, 4); //No está en el rango

		// ejercicio2cMejorado("Hello",4,2);
		// ejercicio2cMejorado("Hello",4,2);
		// ejercicio3('#', 5);
		// ejercicio3b ('*', 7);
		// ejercicio4("Thiago","Back-Office","Programador","Agricultor");
		// ejercicio3c('*', 8);

		// System.out.println("Tu número es un número primo? : " + ejercicio5(1));
		// System.out.println("Tu número es un número primo? : " + ejercicio5(10));
		// System.out.println("Tu número es un número primo? : " + ejercicio5(2));
		// System.out.println("Tu número es un número primo? : " + ejercicio5(5));
		// System.out.println("Tu número es un número primo? : " + ejercicio5(7));

//		 double[] array = {4,7,8,9};
//		 System.out.println("La media de tu array es: " + ejercicio6(array));
//		 System.out.println("La media es: " + ejercicio6b(20,10,5,3,7));
//		 System.out.println(ejercicio6Average(array));
//		 

		// String [] array = {"Camila", "Tomas", "Thiago", "Jaqui"};
//		//ejercicio8 estructurado
//		int maximo = ejercicio8b(2,10,25,100,1000);
//		System.out.println(maximo);
//		//ejercicio8 funcional
//		System.out.println(ejercicio8Funcional(2,40,50,1000,2000));
		
		//ejercicio7();
		String cadena = "cocinando cococos con chococolate";
		String busca = "coco";
		int apariciones = ejercicio9Pattern(cadena,busca);
		System.out.println(apariciones == 0 ? "La cadena no se encuentra" : "La cadena aparece "+ apariciones + " veces");

	}

}
