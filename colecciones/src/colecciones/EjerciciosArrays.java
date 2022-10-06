package colecciones;

import java.util.Scanner;

public class EjerciciosArrays {
	
	private static void ejercicio1 () {
		Scanner sc = new Scanner(System.in);
		String [] meses =  { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		System.out.println("Introduce un número de mes: (1 al 12):  ");
		int numero = sc.nextInt();
		System.out.println(meses[numero-1]); // imprimo del array meses ( el numero - 1 ) ya que va de 0 a 11 
		sc.close();
		
	}
	
	private static void ejercicio2() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[10];
		System.out.println("Introduce primer número: ");
		int num1 = sc.nextInt();
		System.out.println("Introduce segundo número: ");
		
		
			
	}
	
	

	public static void main(String[] args) {
		ejercicio2();
	}

}
