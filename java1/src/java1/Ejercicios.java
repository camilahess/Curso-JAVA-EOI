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
	private static void ejemplosComparaciones() {
		Scanner sc = new Scanner(System.in);
		int a = 1;
		int b = 2;
		double c = 1.3;
		String cad1 = "hola";  // Java es case-sensitive (distingue mayúsculas y minúsculas)
		String cad2 = "Hola";
		String login = "111X";
		String password = "Fran1234";
		System.out.println(a==c);  //????
		//System.out.println(a==b);
		//System.out.println(cad1==cad2);  // No debemos comparar las cadenas con ==
		//System.out.println(cad1.equals(cad2)); // Forma correcta de comparar cadenas
		//System.out.println(cad1.equals(cad2)); // Forma correcta de comparar cadenas
		System.out.println("Introduzca su login: ");
		String loginUsuario = sc.nextLine();
		//System.out.println(login.toLowerCase().equals(loginUsuario.toLowerCase())); // 1ª alternativa
		//System.out.println(login.equalsIgnoreCase(loginUsuario)); // 2ª alternativa
		System.out.println("Introduzca su password: ");
		String passwordUsuario = sc.nextLine();
		/*System.out.println(password.equals(passwordUsuario));
		String datosUsuario = loginUsuario + " " + passwordUsuario;  // Concatenar cadenas
		String datosUsuario2 = loginUsuario.concat(passwordUsuario); // Concatenar cadenas
		System.out.println(datosUsuario);
		System.out.println(datosUsuario2); */
		System.out.println(login.equalsIgnoreCase(loginUsuario) && password.equals(passwordUsuario)); 
		
	}
	private static void ejemplosFormateos() {
		String nombre1 = "Paco";
		String nombre2 = "Anastasia";
		double salario1 = 2300.24;
		double salario2 = 24439.6;
		//primer intento
		System.out.println(" NOMBRE SALARIO");
		System.out.println("---------------------------");
		System.out.println(" " + nombre1 + " " + salario1);
		System.out.println(" " + nombre2 + " " + salario2);	
		
		//segundo intento imprimiendo bonito
		System.out.printf("%12s%14s\n", "NOMBRE", "SALARIO");
		System.out.println("---------------------------");
		System.out.printf("%12s%14f€\n", nombre1, salario1);
		System.out.printf("%12s%14f€\n", nombre2, salario2); 
		
		//tercer intento - alineación a la izquierda con el signo - adelante
		System.out.printf("%-12s%-14s\n", "NOMBRE", "SALARIO");
		System.out.println("---------------------------");
		System.out.printf("%-12s%-14f€\n", nombre1, salario1);
		System.out.printf("%-12s%-14f€\n", nombre2, salario2);
		
		//cuarto intento, dejar mejor los decimales con un . punto 
		System.out.printf("%12s%14s\n", "NOMBRE", "SALARIO");
		System.out.println("---------------------------");
		System.out.printf("%12s%14.2f€\n", nombre1, salario1);
		System.out.printf("%12s%14.2f€\n", nombre2, salario2);
		
		//FECHAS 
		int dia = 4;
		int mes = 6;
		int anyo = 2013;
		System.out.printf("Fecha: %02d/%02d/%04d\n", dia, mes, anyo);
		
		
		
	}
	private static void ejercicio1() { 
		
		int num1 = 36;
		int num2 = 27;
		
		System.out.println("Tu resultado es: " + (num1+num2));
	}
	private static void ejercicio2() {

		int n1 = 15;
		int n2 = 4;
	
		
    System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
	System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
	System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
	System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
	System.out.println(n1 + " % " + n2 + " = " + (n1 % n2));
    
	}
	private static void ejercicio3() {
		Scanner sc = new Scanner(System.in);
		int n1 = 4, n2 = 4; //comparaciones lógicas true false
		String cad1 = "Hola";
		String cad2 = "Hola";
		String login = "111X";
		String password = "holaquetal";
		
		System.out.println(n1 + " es menor que " + n2 + ": " + (n1 < n2));
		System.out.println(n1 + " es igual que " + n2 + ": " + (n1 == n2));
		System.out.println(n1 + " es mayor o igual que " + n2 + ": " + (n1 >= n2));
		System.out.println(cad1.equals(cad2)); //las cadenas se comparan con equals, no ==
		System.out.println("Introduzca su login");
		String loginUsuario = sc.nextLine();
		System.out.println(login.equals(loginUsuario));
		System.out.println(login.equalsIgnoreCase(loginUsuario)); // Ignoramos mayúsculas y minúsculas
		// 
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
	
    private static void ejercicio8() {}
    
     public static void main(String[] args) {
    	 
    	ejemplosFormateos(); 
     
      
	}

}
