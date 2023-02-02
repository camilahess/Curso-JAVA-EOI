package funciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjemplosFunciones {

	public static void buscarSiguiente(String cadena, String cadenaBuscada) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int posicionEncontrada = -1;
		while (!salir) {
			posicionEncontrada = cadena.toLowerCase().indexOf(cadenaBuscada.toLowerCase(), posicionEncontrada + 1);
			if (posicionEncontrada != -1) { // Encuentro la cadena
				System.out.println(cadena.substring(posicionEncontrada));
				System.out.println("¿Buscar siguiente? (s/n): ");
				String respuesta = sc.nextLine();
				if (respuesta.toLowerCase().equals("n")) {
					salir = true;
				}
			} else {
				System.out.println("No se encuentran más ocurrencias de la cadena");
				salir = true;
			}
		}
	}
	
	public static void buscarArrayInteger() {
		int [] numeros = {5,9,10,15,20};
		boolean encontrado = Arrays.stream(numeros).anyMatch(e->e==5);
		System.out.println(encontrado);
	}
	public static void reemplazar(String cadena, String cadenaBuscada, String cadenaReemplazar) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int posicionEncontrada = -1;
		while (!salir) {
			posicionEncontrada = cadena.toLowerCase().indexOf(cadenaBuscada.toLowerCase(), posicionEncontrada + 1);
			if (posicionEncontrada != -1) { // Encuentro la cadena
				System.out.println(cadena.substring(posicionEncontrada));
				System.out.println("¿Reemplazar y buscar siguiente? (s/n): ");
				String respuesta = sc.nextLine();
				if (respuesta.toLowerCase().equals("n")) {
					salir = true;
				} else {
					cadena = cadena.replaceFirst(cadenaBuscada, cadenaReemplazar);
				}
			} else {
				System.out.println("No se encuentran más ocurrencias de la cadena");
				salir = true;
			}
		}
		System.out.println("La cadena ha quedado así: " + cadena);
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return devuelve la suma de dos números, int
	 */
	public static int devuelveSuma(int num1, int num2) {
		int resultado=0;
		resultado=num1+num2;
		return resultado;
	}
	/**
	 * Función que dado un número imprime su cuadrado
	 * 
	 * @param numero Número que pasamos obtenido por pantalla
	 */
	public static void cuadrado(int numero) {
		System.out.println(numero * numero);
	}

	/**
	 * Funcion(método) para devolver el cuadrado de un numero
	 * 
	 * @param numero El numero del cual queremos obtener su cuadrado
	 * @return Devuelve el cuadrado del numero int que hemos puesto en parámetros
	 */
	public static int devolverCuadrado(int numero) {
		int cuadrado = numero * numero;
		return cuadrado;
	}

	public static boolean esPositivo(int numero) {
		/*
		 * if(numero>=0) return true; else return false;
		 */
		return numero >= 0 ? true : false; // Con ternario, condicion primero, si se cumple devuelve true, sino false
	}

	// Método que recibe un n indeterminado de cadenas y las devuelve.
	public static String concatenarCadenas(String... cadenas) { // ... numero indeterminado de cadenas que puede recibir
		String resultado = "";
		System.out.println("He recibido " + cadenas.length + " cadenas");

		for (int i = 0; i < cadenas.length; i++) { // recorremos las cadenas
			resultado = resultado + " " + cadenas[i];
		}

		return resultado;

	}
			// INT DE SALIDA ------( INT ENTRADA)
	
	//Método que cambia el valor de un numero entero.
	public static int cambiarValor(int numero) {
		numero = numero + 1;
		return numero;
	}

	// La linea del cambio de número2 se pierde al salir
	public static int cambiarValor(int numero, int numero2) {
		numero = numero + 1;
		numero2 = numero2 + 1;
		return numero;
	}

	public static void cambiarValorArray(int[] numeros) {
		numeros[0] = numeros[0] + 1;
		numeros[1] = numeros[1] + 1;
	}

	//Método para cambiar String, solo si lo volvemos a asignar en sí mismo // cad = cambiarString(cad);
	public static String cambiarString(String cadena) {
		cadena = cadena + " hola";
		return cadena;
	}

	public static double absCamila(double numero) {
		if (numero >= 0)
			return numero;
		else
			return -numero;
	}

	public static void ejemplosMath() {
		double n1 = -23.40;
		double n2 = 2.349532;
		double n3 = 2.99;
		double n4 = -2.99;

		// -3, -2, -1, 0, 1, 2, 3

		System.out.println(Math.abs(n1)); // Devuelve el valor absoluto: 23.4
		System.out.println(absCamila(n1)); // Devuelve el valor absoluto: 23.4
		System.out.println(Math.round(n2)); // 2. Redondea. A partir de .50 hacia arriba y sino hacia abajo
		System.out.println(Math.floor(n3)); // 2. Duvuelve el número por debajo del argumento
		System.out.println(Math.floor(n4)); // ??? -> -3
		System.out.println(Math.ceil(n3)); // ??? -> 3 Devuelve el siguiente número al argumento pasado(el techo)
		System.out.println(Math.ceil(n4)); // ??? -> -2
		System.out.println(Math.max(23, 43)); // 43 mayoy de los nums
		System.out.println(Math.min(4, 5)); // 4 menor de los nums
		System.out.println(Math.sqrt(25)); // 5 . raiz cuadrada
		System.out.println(Math.pow(5, 2)); // 25 . elevar al cuadrado
		System.out.println(Math.pow(5, 3)); // 125 . elevar al cuadrado
		System.out.println(Math.sin(90)); // 1. calculo del seno
		System.out.println(Math.random()); // número aleatorio entre 0.00 y 1.00
		Random r = new Random();
		int valorDado = r.nextInt(10) + 1; // Entre 0 y 10 excluido, más 1, es decir, del 1 al 10 ambos incluidos.
		System.out.println(valorDado); // Imprime entre 1 y 10
	}

	public static void ejemplosCadenas() {
		String cadena = "Hola mundo";

		System.out.println(cadena.charAt(0)); // H
		System.out.println(cadena.concat(" cruel")); // hola mundo cruel
		System.out.println(cadena); // hola mundo
		String[] nombres = { "Paco", "Pepa", "Dani" };
		System.out.println(String.join(", ", nombres)); // Paco, Pepa, Dani
		String nombresJuntos = String.join(", ", nombres);
		System.out.println(nombresJuntos); // Paco, Pepa, Dani
		String s1 = "ahora";
		String s2 = "despues";
		System.out.println(s1.compareTo(s2)); // -3
		String s = "Mi perro se llama Comeniños";
		System.out.println(s.indexOf("perro")); // 3
		System.out.println(s.indexOf("gato")); // -1
		System.out.println(s.contains("perro")); // true
		System.out.println(s.contains("gato")); // false
		//inmutabilidad de las cadenas, mutan cuando se vuelven a asignar a si mismas
		s = s.replace("perro", "koala");
		System.out.println(s); // Mi koala se llama Comeniños
		s = "Mi perro se llama Comeniños";
		// el replace es igual al replace all
		String s3 = "Mi perro perro perro perro se llama Comeniños";
		s3 = s3.replace("perro", "koala"); //imprime Mi koala koala koala koala se llama Comeniños

		System.out.println(s);
		String animal = s.substring(3, 8);
		System.out.println(animal); // perro
		
	}
	
	public static void stringSplit() {
		String s = "pato-gato-perro-koala";
		String[] animales = s.split("-");
		System.out.println("Hay " + animales.length + " animales"); // Hay 4 animales
		for (String animalString : animales) {
			System.out.println(animalString);
		}

		String tiempo = "51.50853,-0.12574,1546300800,2019-01-01 00:00:00 +0000 UTC,1546300800,2019-01-01 00:00:00 +0000 UTC,8.08,4.63,1034.848,1029.908,78.61,,2.959,292.075,,,,,,,,,";
		String[] datos = tiempo.split(",");
		System.out.println("La temperatura es: " + datos[6]); // 8.08 (obtiene la temperatura)

		String cuenta = "111;Camila;27/01/2024;ES;10000";
		String[] datos2 =cuenta.split(";");
		System.out.println(datos2[1] + " tiene " + datos2[4] + " € en la cuenta");
 	}

	public static void ejemplosFechas() {
		
		// CLASES PARA MANEJAR FECHAS 
		//LocalDate y LocalDateTime
		// Métodos para sumar días, meses, años, etc a una fecha por ejemplo 
		//También como convertir la fecha a número, o de string a fechas con .parse o DateTimeFormatter
		
		
		String fechaTexto = "01/12/2010";
		LocalDate fechaAhora = LocalDate.now();
		LocalDate fechaAyer = LocalDate.now().minusDays(1);
		System.out.println(fechaAhora);
		LocalDate fechaAhoraMas30 = fechaAhora.plusDays(30); // Suma número de días
		System.out.println(fechaAhoraMas30);
		System.out.println(fechaAhora.plusWeeks(40)); // Suma 40 semanas
		System.out.println(fechaAhora.minusMonths(2)); // Resta 2 meses
		// System.out.println(fechaTexto + 1); // No tiene sentido
		System.out.println("Hoy es el día: " + fechaAhora.getDayOfMonth());
		System.out.println("Hoy es el día año: " + fechaAhora.getDayOfYear());
		System.out.println("Hoy es el mes: " + fechaAhora.getMonthValue());
		System.out.println("Hoy es el año: " + fechaAhora.getYear());
		System.out.println("Hoy es el día de la semana: " + fechaAhora.getDayOfWeek());
		System.out.println("Hoy es antes que ayer: " + fechaAhora.isBefore(fechaAyer));
		System.out.println("Fecha como número: " + fechaAhora.toEpochDay()); // Te transforma una fecha a un número (a
																				// partir del 01/01/1970 por convención)
		System.out.println("Fecha como número: " + fechaAhora.ofEpochDay(19284)); // Te transforma un número a una fecha

		String fechaTextoLarga = "2019-01-01 00:00:00 +0000 UTC";
		LocalDate fechaTextoConvertida = LocalDate.parse(fechaTexto);
		System.out.println(fechaTextoConvertida);
		System.out.println(LocalDate.parse("2010-12-30"));
		System.out.println(LocalDate.parse("27/07/2000", DateTimeFormatter.ofPattern("d/M/yyyy")));
		System.out.println(LocalDate.parse("2000-01-30+05:00", DateTimeFormatter.ISO_DATE));
		String fechaMarcaTexto = "Wed, 19 Oct 2022 16:21:35 +0200";
		LocalDateTime fechaHoraMarca = LocalDateTime.parse(fechaMarcaTexto,DateTimeFormatter.RFC_1123_DATE_TIME);
		System.out.println("Día: " + fechaHoraMarca.getDayOfMonth() + " hora: " + fechaHoraMarca.getHour());

	}

	

	public static void main(String[] args) {
//		//Scanner sc = new Scanner(System.in);
//		/*
//		 * System.out.println("Primera búsqueda");
//		 * buscarSiguiente("Esta es la cadena en la que quiero buscar", "la");
//		 * System.out.println("Segunda búsqueda");
//		 * buscarSiguiente("Esto es otra cadena", "ot");
//		 */
//		// reemplazar("Esto es una cadena donde aparece esto y esto","esto","aquello");

		// Programa que te va imprimiendo el cuadrado de los números que mete el usuario
		// por pantalla
		/*
		 * int numero = -1; while(numero!=0) {
		 * System.out.println("Introduzca un número (0 para terminar):"); numero =
		 * Integer.parseInt(sc.nextLine());
		 * System.out.println("El cuadrado del número es: "); cuadrado(numero); }
		 * 
		 * 
		 * // Programa que pide un número por pantalla y le suma 10 a su cuadrado
		 * System.out.println("Introduzca un número:"); int numero =
		 * Integer.parseInt(sc.nextLine()); int numeroCuadrado =
		 * devolverCuadrado(numero); double numeroPow = Math.pow(numero, 2); //La
		 * función Math. pow() retorna la base elevada al exponente , es decir,
		 * baseexponente . numeroCuadrado += 10; numeroPow += 10;
		 * System.out.println(numeroCuadrado); System.out.println(numeroPow);
		 */

		// AGRUPACION DE PARÁMETROS
		/*
		 * System.out.println(concatenarCadenas("Hola"));
		 * System.out.println(concatenarCadenas("Hola", "Camila"));
		 */
		  //System.out.println(concatenarCadenas("Hola", "mundo", "cruel"));
		  /*
		 * System.out.println(concatenarCadenas("Adiós"));
		 * System.out.println(concatenarCadenas());
		 */

		/*
		 * //Cambiar valor numero int numero = 5; int cambio = cambiarValor(numero);
		 * System.out.println("Número: " + numero + " Cambio: " + cambio);
		 * 
		 * //Cambiar valor numeros en un array (varios numeros) int[] numeros = new
		 * int[2]; numeros[0] = 5; numeros[1] = 6; cambiarValorArray(numeros);
		 * System.out.println("Número 0: " + numeros[0] + " Número 1: " + numeros[1]);
		 */
		 //Cambiar String String 
		 //String cad = "Camila"; 
		 //cambiarString(cad);
		 //System.out.println(cad); 
		  /*
		 
		 * // "Fran" o "Fran hola"? -> Fran  "Solo saca FRAN porque las cadenas son inmutables"
		 * 
		 * cad = cambiarString(cad); System.out.println(cad); // "Fran" o "Fran hola"? -> Fran
		 * hola String otra = "otra"; otra.concat(" cadena"); System.out.println(otra);
		 * // "otra" o "otra cadena"? otra, no concatena otra = otra.concat(" cadena");
		 * System.out.println(otra); // "otra" o "otra cadena"? -> otra cadena
		 * 
		 * // No cambia: int, float, double, char, String (se pasan por valor, se hace
		 * una copia y se trabaja sobre la copia) // Si cambia: Arrays, Listas, Objetos
		 * (se pasan por referencia, se trabaja con el objeto original y las
		 * modificaciones le afectan)
		 * 
		 */
		//ejemplosMath();
		//ejemplosCadenas();
		//ejemplosFechas();
		//buscarArrayInteger();
		stringSplit();
	}

}
