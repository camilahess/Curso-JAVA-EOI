package colecciones;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class EjerciciosArrays {

	private static void ejercicio1() {
		Scanner sc = new Scanner(System.in);
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		System.out.println("Introduce un número de mes: (1 al 12):  ");
		int numero = sc.nextInt();
		if (numero > 1 && numero <= 12) {
			System.out.println(meses[numero - 1]); // imprimo del array meses ( el numero - 1 ) ya que va de 0 a 11
		} else
			System.out.println("Mes no encontrado");
		sc.close();

	}

	private static void ejercicio2() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[10];
		int suma = 0;
		int numeroMayor = numeros[0];
		int numeroMenor = numeros[0];

		System.out.println("Introduce primer número: ");
		numeros[0] = sc.nextInt();
		System.out.println("Introduce segundo número: ");
		numeros[1] = sc.nextInt();
		System.out.println("Introduce tercer número: ");
		numeros[2] = sc.nextInt();
		System.out.println("Introduce cuarto número: ");
		numeros[3] = sc.nextInt();
		System.out.println("Introduce quinto número: ");
		numeros[4] = sc.nextInt();
		System.out.println("Introduce sexto número: ");
		numeros[5] = sc.nextInt();
		System.out.println("Introduce septimo número: ");
		numeros[6] = sc.nextInt();
		System.out.println("Introduce octavo número: ");
		numeros[7] = sc.nextInt();
		System.out.println("Introduce noveno número: ");
		numeros[8] = sc.nextInt();
		System.out.println("Introduce decimo número: ");
		numeros[9] = sc.nextInt();

		/*
		 * //Lo imprime uno debajo del otro for (int i = 0; i < numeros.length; i++) {
		 * System.out.println(numeros[i]); }
		 */

		// Lo imprime uno al lado del otro entre [ ]
		System.out.println(Arrays.toString(numeros));

		// suma de los números
		for (int i = 0; i < numeros.length; i++) {
			suma = suma + numeros[i];
		}
		System.out.println("La suma de los valores del array es: " + suma);

		// Promedio de los números // media de los números
		// El promedio es la suma dividida entre la cantidad de elementos
		float promedio = suma / numeros.length;
		System.out.printf("Suma: %d. Promedio: %.2f", suma, promedio);
		System.out.println("");

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > numeroMayor) {
				numeroMayor = numeros[i];
			}
			if (numeros[i] < numeroMenor) {
				numeroMenor = numeros[i];
			}
		}

		System.out.println("El número mayor es: " + numeroMayor);
		System.out.println("El número menor es: " + numeroMenor);

		sc.close();
	}

	public static void ejercicio3() {
		Scanner sc = new Scanner(System.in);
		double[] numeros = new double[10];
		double suma = 0;
		double media = 0;
		System.out.println("Introduce primer número: ");
		numeros[0] = sc.nextDouble();
		System.out.println("Introduce segundo número: ");
		numeros[1] = sc.nextDouble();
		System.out.println("Introduce tercer número: ");
		numeros[2] = sc.nextDouble();
		System.out.println("Introduce cuarto número: ");
		numeros[3] = sc.nextDouble();
		System.out.println("Introduce quinto número: ");
		numeros[4] = sc.nextDouble();
		System.out.println("Introduce sexto número: ");
		numeros[5] = sc.nextDouble();
		System.out.println("Introduce septimo número: ");
		numeros[6] = sc.nextDouble();
		System.out.println("Introduce octavo número: ");
		numeros[7] = sc.nextDouble();
		System.out.println("Introduce noveno número: ");
		numeros[8] = sc.nextDouble();
		System.out.println("Introduce decimo número: ");
		numeros[9] = sc.nextDouble();

		for (int i = 0; i < numeros.length; i++) {
			suma = suma + numeros[i];
		}
		// Promedio de los números // media de los números
		// El promedio es la suma dividida entre la cantidad de elementos
		double promedio = suma / numeros.length;
		System.out.printf("Suma: %.2f Promedio: %.2f", suma, promedio);
		System.out.println("");

		sc.close();
	}

	/*
	 * 4. Crea un programa que almacene en una tabla el número de días que tiene
	 * cada mes (de un año no bisiesto), pida al usuario que te indique un mes (ej.
	 * 2 para febrero) y un día (ej. el día 15). Muéstrale qué número de día es
	 * dentro del año (por ejemplo, el 15 de febrero sería el día número 46, y el 31
	 * de diciembre sería el día 365).
	 */
	public static void ejercicio4() {
		// Los meses son las posiciones pero del 0 al 11
		int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int total = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime un mes del año: ");
		int mes = sc.nextInt();
		System.out.print("Dime el dia del año: ");
		int dia = sc.nextInt();

		for (int i = 0; i < mes - 1; i++) {
			total += dias[i]; // total = total + dias[i];
		}
		total += dia;

		System.out.println("El número de días dentro del año de la fecha indicada es " + total);
	}

	/*
	 * 5. Crea 2 arrays, uno para almacenar notas de alumnos y otro para almacenar
	 * sus nombres. A continuación pregunta al usuario cuántos alumnos hay en total.
	 * En función del número de alumnos pide sus nombres y sus notas y guárdalos en
	 * los respectivos arrays. Recorre ambos arrays mostrando el nombre de cada
	 * alumno y su nota.
	 */
	public static void ejercicio5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuántos alumnos hay en total? ");
		int alumnos = sc.nextInt();

		String[] nombres = new String[alumnos];
		double[] notas = new double[alumnos];

		for (int i = 0; i < alumnos; i++) {
			System.out.println("Dime el nombre del alumno " + (i + 1) + " :");
			nombres[i] = sc.next();

			System.out.println("Dime su nota: ");
			notas[i] = sc.nextDouble();
		}
		System.out.printf("%12s%5s\n", "NOMBRE", "NOTA");
		for (int i = 0; i < alumnos; i++) {
			System.out.printf("%12s%6.2f\n", nombres[i], notas[i]);
		}
		sc.close();
	}

	/*
	 * 6. Crea un array de números enteros con 10 posiciones. Pregunta al usuario
	 * por un número y guarda en el array la tabla de multiplicar de dicho número. A
	 * continuación, recorre el array y muestra lo que tienes almacenado.
	 */
	public static void ejercicio6() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[10];
		System.out.println("Dime un número de la tabla de multiplicar: ");
		int tabla = sc.nextInt();

		for (int i = 1; i <= numeros.length; i++) {
			System.out.println(tabla + " x " + i + " = " + (tabla * i));
		}
	}

	/*
	 * 7. Crea un programa con 2 arrays que almacenen 10 números cada uno (pon los
	 * valores que quieras). Suma las posiciones de ambos arrays (usa un bucle) en
	 * un tercer array, y al final muestra los resultados:
	 */
	public static void ejercicio7() {
		int[] array1 = { 7, 12, 3, 8, 3, 9, 5, 11, 20, 9 };
		int[] array2 = { 8, 5, 3, 12, 25, 1, 6, 13, 7, 4 };
		int[] array3 = new int[array1.length];

		for (int i = 0; i < array2.length; i++) {
			array3[i] = array1[i] + array2[i];
		}
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array3[i] + " , ");
		}
	}

	/*
	 * 8. Crea un array de cadenas con 10 posiciones. Pide al usuario que introduzca
	 * 10 nombres. Por cada nombre introducido, debes comprobar que no existe ya en
	 * el array. Si existe, no lo guardes y vuelve a pedirle otro nombre.
	 */
	public static void ejercicio8() {
		Scanner sc = new Scanner(System.in);
		String[] nombres = new String[10];
		String nombre;
		boolean repetido;

		// Primero pregunto el nombre y lo guardo
		for (int i = 0; i < nombres.length; i++) {
			do {
				System.out.print("Introduce un nombre " + (i + 1) + ": ");
				nombre = sc.next();
				repetido = false;
				for (int j = 0; j < i && repetido == false; j++) {
					if (nombres[j].equals(nombre)) {
						repetido = true;
						System.out.println("Nombre repetido !");
						i--;
					}
				}
			} while (repetido == true);
			nombres[i] = nombre;
		}

	}

	/*9. Pide al usuario que escriba un nombre y guárdalo. A continuación, muestra las vocales
	que contiene ese nombre (debes recorrer la cadena y comparar sus caracteres).*/
	public static void ejercicio9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime un nombre ");
		String nombre = sc.nextLine().toLowerCase();
		
		char c;
		for (int i = 0; i < nombre.length(); i++) {
			c = nombre.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
			          c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú') {
			        System.out.print(c + " ");
			      }
			}
		}
	
	//Mismo ejercicio con expresión regular
	public static void ejercicio9Pattern() {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Escribe un nombre: ");
	    String nombre = sc.nextLine();
	    sc.close();
	    
	    Pattern pattern = Pattern.compile("[aeiouáéíóú]", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(nombre);
	    
	    System.out.print("Vocales en el nombre: ");
	    while (matcher.find()) {
	      System.out.print(matcher.group() + " ");
	    }
	  }
	

	/*
	 * 13. Crea un array bidimensional de cadenas. En este array almacenaremos
	 * productos con sus respectivos datos. La primera dimensión hará referencia a
	 * la posición de cada producto. Y para cada producto (segunda dimensión),
	 * almacenaremos lo siguiente (son cadenas todo): Nombre, precio y cantidad (3
	 * campos).
	 */
	public static void ejercicio13() {
		// 3 productos con 3 datos
		String[][] productos = { { "Silla", "45.50", "2" }, // primera fila, 3 columnas
				{ "Mesa", "58,68", "1" }, // segunda fila, 3 columnas
				{ "Armarios", "40", "3" }, // tercera fila, 3 columnas
		};

		System.out.printf("%-14s%10s%8s%12s\n", "NOMBRE", "PRECIO", "CANT", "TOTAL");
		System.out.println(String.valueOf('-').repeat(44));
		
		for (int i = 0; i < productos.length; i++) {
			double precio = Double.parseDouble(productos[i][1].replace(',', '.')); // porque j no varía en cuanto a posición
			int cantidad = Integer.parseInt(productos[i][2]);
			double total = precio * cantidad;
			System.out.printf("%-14s%9.2f€%8d%11.2f€\n", productos[i][0], precio, cantidad, total); // productos = solo
																									// la primera
																									// posición de
																									// arriba/abajo
		}
	}

	public static void main(String[] args) {
		//ejercicio9Pattern();
		ejercicio13();

	}

}
