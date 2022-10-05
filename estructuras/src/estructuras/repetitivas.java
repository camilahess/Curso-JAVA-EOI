package estructuras;

import java.util.Scanner;

public class repetitivas {

		public static void for1() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
			// El programa continua por aquí al acabar el bucle
		}

		public static void for2() {
			String oracion = "Hola mundo";
			for (int i = 0; i < oracion.length(); i++) {
				System.out.println(oracion.charAt(i));
			}
			// El programa continua por aquí al acabar el bucle
		}

		public static void for3() { // tabla de multiplicar
			Scanner sc = new Scanner(System.in);
			System.out.println("Escriba la tabla que desea: ");
			int tabla = sc.nextInt();
			for (int i = 1; i <= 10; i++) {
				System.out.println(tabla + " * " + i + " = " + (tabla * i));
			}
		}

		public static void for4() { // tabla de multiplicar invertida
			Scanner sc = new Scanner(System.in);
			System.out.println("Escriba la tabla que desea: ");
			int tabla = sc.nextInt();
			for (int i = 10; i > 0; i--) {
				System.out.println(tabla + " * " + i + " = " + (tabla * i));
			}
		}

		public static void for5() { // ejemplo de for complejo
			for (int i = 0, j = 10; i <= 10 && j > 5; i++, j--) { // 0+10, 1+9, 2+8...10+0
				System.out.println(i + " + " + j + " = " + (i + j));
			}
		}

		public static void infinito1() { // Probable error
			for (int i = 0; i >= 0; i++) {
				System.out.println(i);
			}
		}

		public static void offTopicEnteros() {
			// long numero = 2147483647;
			long numero = Integer.MAX_VALUE;
			System.out.println(numero);
			numero++;
			System.out.println(numero);
		}

		public static void infinito2() { // Probablemente un error
			for (int i = 0; i >= 0;) {
				System.out.println(i);
			}
		}

		public static void infinito3() { // A conciencia
			for (;;) {
				System.out.println("Hola");
			}
		}

		public static void while1() {
			Scanner sc = new Scanner(System.in);
			int total = 0;
			while (total < 100) {
				System.out.print("Escribe un número (acumulado: " + total + "): ");
				int num = sc.nextInt();
				total += num;  // total = total + num;
			}
			System.out.println("El total acumulado ha sido:" + total);
		}
		
		
		public static void whileIgualQueFor() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
			
			int numero = 0;
			while(numero < 10) {
				System.out.println(numero);
				numero++;
			}		
		}
		
		public static void whileIgualQueFor2() {
			String oracion = "Hola mundo";
			
			for (int i = 0; i < oracion.length(); i++) {
				System.out.println(oracion.charAt(i));
			}
			
			int i = 0;
			while(i < oracion.length()) {
				System.out.println(oracion.charAt(i));
				i++;
			}
		}

		public static void main(String[] args) {
			// for1();
			// for2();
			// for3();
			// for4();
			// for5();
			// infinito1();
			// offTopicEnteros();
			// infinito2();
			// infinito3();
			// while1();
			// whileIgualQueFor();
			whileIgualQueFor2();
		
	}

}
