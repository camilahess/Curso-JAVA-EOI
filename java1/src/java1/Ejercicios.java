package java1;


import java.util.Scanner;

public class Ejercicios {
	
	private  static void iniciacion () { //Para hacer métodos y separar la info

		
		int numero1 = 15 , num2 = 4 ;// Las variables del mismo tipo las podemos agrupar en una única declaración. 
		    String cadena = "hola"; 
		    String cadena2 = "que tal";
		    String name = "Camila";
		    String apellido = "Hess";
		    int precio = 100;
		    final double IVA = 0.21; //Al ser constante deberíamos escribir la variable en MAYUS
		  
	      System.out.println("La división da: " + numero1 / num2); //No hace falta crear la variable RESULTADO.
	      System.out.println("La suma da: " + (numero1 + num2)); //Para que no se concatene debemos poner el resultado entre parentesis. 
	      System.out.println(cadena+num2);
	      System.out.println("Nombre completo: " + ( name + " " + apellido ));
	      System.out.println("Precio: " + precio + "\nIVA: " + (precio * IVA) + "\nTOTAL: " + (precio + (precio*IVA))) ;
	      
	      numero1 += 3; //Cambiamos el valor de una variable numero = numero + 3 ; 
	      System.out.println(numero1);
	      double division = numero1 / 4.0; //18 / 4 = 4.5 (( PONEMOS DOUBLE PARA DECIRLE QUE IMPRIMA UN NUMERO DECIMAL 
	      System.out.println(division);
	      
	      int dos = 2 ;
	      int tres = 3;
	      double resultado1 = (double) tres / dos; 
	      System.out.println(resultado1);
	      
	   
		}
	private static void ejemplosConversiones() {
	      Scanner scan = new Scanner (System.in); // utilidad para leer por pantalla
	   	  int prefijo = 34;
	      int telefono = 923423243;
	      System.out.println(prefijo + telefono); // 923423277 (suma)
	      //CONVERSIONES
	      System.out.println(String.valueOf(prefijo) + telefono); //34923423243(concatena)
	      System.out.println("" + prefijo + telefono); //concatena porque le metes un string vacío por ende todo pasa a ser string
	      
	      System.out.println("Introduzca el valor 1: ");
	      String valor1 = scan.nextLine();
	      System.out.println("El numero que usted introdujo sumando 5 da: " + (valor1 + 5)); // se concatena y no suma
	      System.out.println("El numero que usted introdujo sumando 5 da: " + (Integer.parseInt(valor1) + 5));
	      System.out.println("El numero que usted introdujo sumando 5 da: " + (Integer.valueOf(valor1) + 5));
	      
	      scan.close(); //para que libere memoria y cierre el scan
}

	private static void ejercicio1() { 
		
		int num1 = 36;
		int num2 = 27;
		
		System.out.println("Tu resultado es: " + (num1+num2));
	}
	private static void ejercicio2() {

		int numero1 = 15;
		int numero2 = 4;
	
		
    System.out.println("15+4= " + (numero1+numero2));
    System.out.println("15-4= " + (numero1-numero2) );
    System.out.println("15/4= " + (numero1/numero2) );
    System.out.println("15*4= " + (numero1*numero2) );
    
	}
	private static void ejercicio3() {
		
		
	}
	private static void ejercicio4() {

		
		double num1 = 2.5;
		double num2 = 3.5;
		double num3 = 1.0;
		double num4 = 1.5;
		
		/*System.out.print(num1);
		System.out.print(num2);
		System.out.print(num3);
		System.out.println(num4);// println para que haga el salto de linea*/
		
		System.out.println(""+num1+num2+num3+num4); //Esto es lo mismo que lo de arriba pero mas simple
		System.out.println(((num1+num2)*num3)/num4);
		
	}
	private static void ejercicio5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		int N = sc.nextInt();
		System.out.println("El valor de inicial de N es: " + N);
		N += 77;  // 78
		System.out.println("El valor incrementado en 77 es: " + N);
		
		sc.close();
	}
	private static void ejercicio6() {}
	private static void ejercicio7() {
    	
		char c1 = 'b', c2 = 'k';
		System.out.println("'" + c1 + "' tiene la posici�n " + (int)c1);
		System.out.println("'" + c2 + "' tiene la posici�n " + (int)c2);
		System.out.println("Diferencia entre '" + c1 + "' y '" + c2 + "': " + (c2 - c1));
	
	
}
	
    
    
     public static void main(String[] args) {
    	 
    	ejercicio7(); 
     
      
	}

}
