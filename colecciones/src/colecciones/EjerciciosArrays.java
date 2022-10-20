package colecciones;

import java.util.Scanner;
import java.util.Arrays;

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
		int suma = 0;
		int numeroMayor = numeros[0];
		int numeroMenor = numeros[0];
		
		System.out.println("Introduce primer número: ");
		numeros[0]= sc.nextInt();
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
		numeros[8]= sc.nextInt();
		System.out.println("Introduce decimo número: ");
		numeros[9]= sc.nextInt();
		
		/* 
		 * //Lo imprime uno debajo del otro 
		for (int i = 0; i < numeros.length; i++) {
		System.out.println(numeros[i]);
		}*/
		
		//Lo imprime uno al lado del otro entre [ ]
		System.out.println(Arrays.toString(numeros)); 
	
		//suma de los números 
		for (int i = 0; i < numeros.length; i++) {
			suma = suma + numeros[i];
		}
		System.out.println("La suma de los valores del array es: " + suma); 
		
		//Promedio de los números // media de los números 
		// El promedio es la suma dividida entre la cantidad de elementos
		float promedio = suma / numeros.length;
		System.out.printf("Suma: %d. Promedio: %.2f", suma, promedio);
		System.out.println("");
		
		
		for (int i = 0; i < numeros.length; i++){
			  if (numeros[i] > numeroMayor){
			    numeroMayor = numeros[i];
			  } if (numeros [i]< numeroMenor) {
				  numeroMenor = numeros[i];
			  }
		}
		
		System.out.println("El número mayor es: " + numeroMayor);
		System.out.println("El número menor es: " + numeroMenor);
		
		
}
		
	
	public static void ejercicio3(){
		Scanner sc = new Scanner(System.in);
		double[] numeros = new double[10];
		double suma = 0;
		double media = 0;
		System.out.println("Introduce primer número: ");
		numeros[0]= sc.nextDouble();
		System.out.println("Introduce segundo número: ");
		numeros[1] = sc.nextDouble();
		System.out.println("Introduce tercer número: ");
		numeros[2] =sc.nextDouble();
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
		numeros[8]= sc.nextDouble();
		System.out.println("Introduce decimo número: ");
		numeros[9]= sc.nextDouble();
		
		
		for (int i = 0; i < numeros.length; i++) {
			 suma = suma + numeros[i];
		}
		//Promedio de los números // media de los números 
				// El promedio es la suma dividida entre la cantidad de elementos
		double promedio = suma / numeros.length;
		System.out.printf("Suma: %.2f Promedio: %.2f", suma, promedio);
		System.out.println("");
		
		
	}

	public static void main(String[] args) {
		ejercicio3();
	}

}
