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
		sc.close(); // siempre cerrar scanner por errores
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
		sc.close(); // siempre cerrar scanner por errores
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
		N -=3;
		System.out.println("El valor decrementado en 3 es: " + N);
		N = N*2;
		System.out.println("El valor duplicado por 2 es: " + N);
		sc.close();
	}
	private static void ejercicio6() {
		//crear variables auxliares con int auxA= A para mantener las originales
		int A = 1;
		int B = 2;
		int C = 3;
		int D = 4;
		final int auxA = A;
		final int auxB = B;
		final int auxC = C;
		final int auxD = D;
		System.out.print("Valores iniciales: A = " + A);
		System.out.print(" B = " + B);
		System.out.print(" C = " + C);
		System.out.println(" D = " + D);
		B=auxC; // B = 3
		C=auxA; // C = 1
		A=auxD; // A = 4
		D=auxB; // D = 2
		System.out.println("B toma el valor de C -> B = " + B);
		System.out.println("C toma el valor de A -> C = " + C);
		System.out.println("A toma el valor de D -> A = " + A);
		System.out.println("D toma el valor de B -> D = " + D);
		
	}
	private static void ejercicio7() {
    	//Todas las letras tienen un numero asociado, unicode o ascii
		char c1 = 'b', c2 = 'k';
		System.out.println("'" + c1 + "' tiene la posicion " + (int)c1);
		System.out.println("'" + c2 + "' tiene la posicion " + (int)c2);
		System.out.println("Diferencia entre '" + c1 + "' y '" + c2 + "': " + (c2 - c1));
	
	
}
	
    private static void ejercicio8() {
    int a = 5; int b; int c;
    b = ++a; // imprime 6
    c = a++; // imprime 6 y luego incrementa 1 
    b = b*5; // 6x5 = 30
    a = a*2; // 7x2 = 14 
    
    System.out.println("A=" + a + "\n" + "B= "+ b + "\n" + "C=" + c);
   
    		
    }
    
    private static void ejercicio9() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduzca su nombre: ");
    	String nombre = sc.nextLine();
    	System.out.println("Tu nombre es: " + nombre);
    	sc.close();
    	
    }
    
    private static void ejercicio10 () {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduzca un número entero: ");
    	int numero = sc.nextInt();
    	System.out.println("El doble de su número es: " + (numero*2));
    	System.out.println("El triple de su número es: " + (numero*3));
    	sc.close();
    }
    
    private static void ejercicio11() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduzca cuantos grados hace en su zona:" );
    	int grados = sc.nextInt();
    	grados = 32 + (9* grados / 5); 
    	System.out.println( "Sus grados en Fahrenheit son = " + grados); 
    	sc.close();
    	
    }
    
    private static void ejercicio12() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduzca un número de tres cifras: ");
    	int numero = sc.nextInt();
    	  System.out.println("Primera cifra  "+ (numero/100));
    	  System.out.println("Segunda cifra  "+ (numero/10%10));
    	  System.out.println("Tercera cifra  "+( numero%10));
    	  sc.close();
    		
    }
    
    private static void ejercicio13() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduce tu fecha de nacimiento: (dia, mes, año)");
    	int dia = sc.nextInt();
    	int mes = sc.nextInt();
    	int anio = sc.nextInt ();
    	
    	int suma = dia+mes+anio;
    	int num1 = suma %10;
    	int num2 = (suma /10) %10;
    	int num3= (suma/100) %10;
    	int num4= suma/1000;
    	int numSuerte= num1 + num2+ num3+ num4;
    	System.out.println("Tú número de la suerte es: " + numSuerte);
    	sc.close();
    	
    }
    
    private static void ejercicio14 () {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduzca su edad: ");
    	int edad = sc.nextInt();
    	System.out.println("Dentro de 15 años usted tendrá: " + (edad+15) + " años");
    	sc.close();
    	
    }
    
    private static void ejercicio15 ( ) {
    	Scanner sc = new Scanner(System.in);
    	Scanner sc1 = new Scanner(System.in);
    	Scanner sc2 = new Scanner(System.in);
    	
    	
    	System.out.println("Producto 1: ");
    	String producto1 = sc.nextLine();
    	System.out.println("Precio: ");
    	String precio1 = sc.nextLine();
    	
    	
    	System.out.println("Producto 2 : ");
    	String producto2 = sc1.nextLine();
    	System.out.println("Precio: ");
    	String precio2 = sc1.nextLine();
    	
    	
    	System.out.println("Producto 3: ");
    	String producto3 = sc2.nextLine();
    	System.out.println("Precio: ");
    	String precio3 = sc2.nextLine();
    	
    	System.out.printf("%-15s%12s%12s\n", "Producto", "Precio", " CON IVA");
    	System.out.printf("%-15s%12.2s€%12.2f\n", producto1, precio1, (Double.parseDouble(precio1)* 1.21));
    	System.out.printf("%-15s%12.2s€%12.2f\n", producto2, precio2, (Double.parseDouble(precio2)* 1.21));
    	
    	
    	
    	
    	/* public static void exercise15() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Producto uno: ");
		String produc1 = reader.readLine();
		System.out.print("Precio: ");
		double precio1 =Double.parseDouble(reader.readLine());
		
		System.out.print("Producto dos: ");
		String produc2 =  reader.readLine();
		System.out.print("Precio: ");
		double precio2 = Double.parseDouble(reader.readLine());
		
		System.out.print("Producto tres: ");
		String produc3 =  reader.readLine();
		System.out.print("Precio: ");
		double precio3 = Double.parseDouble(reader.readLine());
		
		System.out.printf("%-15s%-12s%12s\n", "NOMBRE", "PRECIO", "CON IVA");
		System.out.printf("%-15s%11.2f€%11.2f€\n", produc1, precio1, ((precio1*0.21)+precio1));
		System.out.printf("%-15s%11.2f€%11.2f€\n", produc2,  precio2, ((precio2*0.21)+precio2));
		System.out.printf("%-15s%11.2f€%11.2f€\n", produc3,  precio3, ((precio3*0.21)+precio3));
    	*/
    	
    }
    
    private static void ejercicio20() {
    	
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Introduce 3 dígitos: ");
    		double num1 = sc.nextDouble();
    		double num2 = sc.nextDouble();
    		double num3 = sc.nextDouble();
    		System.out.println("Has escrito: "+num1+" + "+num2+" + "+num3+" = "+(num1+num2+num3));
    }
    
    private static void ejercicio21() {
    	System.out.println("Introduce tu nombre: ");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.next();
		System.out.println("Dime tu edad: ");
		int edad = sc.nextInt();
		System.out.println("Estos son tus datos\n\tNombre: "+nombre+"\n\tEdad: "+edad); //\t tabula
    }
     public static void main(String[] args) {
    	 
    	ejercicio15(); 
     
      
	}

}
