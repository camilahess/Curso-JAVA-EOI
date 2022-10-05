package ejercicios;

import java.util.Scanner;

public class Ejercicios {
	
	private static void ejercicio1() {
		Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Número entero: ");                                                 
        N = sc.nextInt();
        if(N%2==0) { //Para saber si es par
           System.out.println("Par");   
        } else {
            System.out.println("Impar"); 
     }	
        sc.close();
	}
	
	private static void ejercicio2() {
		Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Número entero: ");
        N = sc.nextInt();
        if(N%10==0) { //Si el numero dividido 10 da cero, es multiplo de 10
           System.out.println("Es múltiplo de 10");   
        } else {
           System.out.println("No es múltiplo de 10");
		
	 }
        sc.close();
	}
	private static void ejercicio3() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Introduzca un carácter: ");
        char car = sc.nextLine().charAt(0);
        if (car>='A' && car <='Z') {
        	System.out.println("Es una letra mayúscula");
        } else {
        	System.out.println("No es una letra mayúscula");
        }
        
		sc.close();
	}
	private static void ejercicio4() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Introduzca una palabra : ");
		String palabra1 = sc.nextLine();
		System.out.println("Introduzca otra palabra: ");
		String palabra2 = sc.nextLine();
		if (palabra1.equals(palabra2)) {
			System.out.println("Las palabras son iguales");
		} else {
			System.out.println("Las palabras NO son iguales");
		}
		
		sc.close();
		
		}

	private static void ejercicio5() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Introduzca un número: ");
		int numero1 = sc.nextInt();
		System.out.println("Introduzca otro número: ");
		int numero2 = sc.nextInt();
		if (numero2 > 0) {
			System.out.println(numero1 + "%" + numero2 + "= " + numero1/numero2);
		} else {
			System.out.println("El divisor no puede ser cero");
		}
		sc.close();
		
		}
		
	private static void ejercicio6() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Introduzca el primer número entero");
		int num1 = sc.nextInt();
		System.out.println("Introduzca el segundo número entero");
		int num2 = sc.nextInt();
		System.out.println("Introduzca el tercer número entero");
		int num3 = sc.nextInt();
		if (num1>num2 && num1>num3) {
			System.out.println("El número mayor es: " + num1);
		} else if (num2>num1 && num2>num3) {
			System.out.println("El mayor es : " + num2);
		} else{
			System.out.println(" El mayor es : " + num3);
		}
		sc.close();
		
		}
	
	private static void ejercicio7() {
		/* 
		HECHO POR MI
		
		int h,m,s;
		Scanner sc =new Scanner(System.in);
		System.out.println("Introduzca la hora : ");
		h = sc.nextInt();
		System.out.println("Introduzca los minutos: ");
		m=sc.nextInt();
		System.out.println("Introduzca los segundos: ");
		s= sc.nextInt();
				
		if (h>0 && h<23 && m>=0 && m <60 && s>0 && s<60) {
			System.out.printf("%02d:%02d:%02d",h,m,s);
			
		}  else {
			System.out.println("La hora es incorrecta");
		}
			
		} */ 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime una hora");
		int h1 = sc.nextInt();
		System.out.println("Dime los minutos");
		int m1 = sc.nextInt();
		System.out.println("Dime los segundos");
		int s1 = sc.nextInt();
		
		if (h1<0) {
			System.out.println("Error, las horas van de 0 a 23");
		}else if(h1>23) {
			System.out.println("Error, las horas van de 0 a 23");
		}else if  (m1<0) {
			System.out.println("Error, los minutos van de 0 a 59");
		}
		else if(m1>59) {
				System.out.println("Error, los minutos van de 0 a 59");
		}else if  (s1<0) {
			System.out.println("Error, los segundos van de 0 a 59");
		}else if(s1>59) {
				System.out.println("Error, los segundos van de 0 a 59");
		}else {
			System.out.printf("%02d:%02d:%3d\n", h1, m1, s1);
		}
		sc.close();	
	}

	private static void ejercicio8() {
		/* BÁSICO :
		
		int a = 5;
		
		if (a%2==0) {
			System.out.println("Tú número es par");
		} else {
			System.out.println("Tú número es impar");
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int a = sc.nextInt();
		
		System.out.println((a%2==0) ? "Tú número es par" : " Tú número es impar");
		sc.close();
	}
	private static void ejercicio9() {
		Scanner sc = new Scanner(System.in);
		int mes;
		System.out.println("Introduzca el número de mes: ");
		mes = sc.nextInt();
		if (mes <1 || mes >12) {
			System.out.println("El mes es incorrecto");
		} else { 
			switch(mes) {
			case 1 : System.out.print("El mes de enero tiene 31 días");
			break;
			case 2 : System.out.print("El mes de febrero tiene 28 días");
			break;
			case 3 : System.out.print(" El mes de marzo tiene 31 días");
			break;
			case 4 : System.out.print(" El mes de abril tiene 30 días");
			break;
			case 5 : System.out.print(" El mes de mayo tiene 31 días");
			break;
			case 6 : System.out.print(" El mes de junio tiene 30 días");
			break;
			case 7 : System.out.print(" El mes de julio tiene 31 días");
			break;
			case 8 : System.out.print(" El mes de agosto tiene 31 días");
			break;
			case 9 : System.out.print(" El mes de septiembre tiene 30 días");
			break;
			case 10 : System.out.print(" El mes de octubre tiene 31 días");
			break;
			case 11 : System.out.print(" El mes de noviembre tiene 30 días");
			break;
			case 12 : System.out.print(" El mes de diciembre tiene 31 días");
			break;
			
			default: break;
			}
			
			
		}
		sc.close();
	}
	private static void ejercicio10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe una letra,un número o un carácter: ");
		char letra = sc.next().charAt(0);
		
		switch (letra) {
		case '.': System.out.println("Es un .");
			break;
		case ',': System.out.println("Es una ,");
			break;
		case ':': System.out.println("Son dos puntos :");
			break;
		case ';': System.out.println("Es un ; ");
			break;
		case '0': System.out.println("Es un 0");
			break;
		case '1': System.out.println("Es un 1");
			break;
		case '2': System.out.println("Es un 2");
			break;
		case '3': System.out.println("Es un 3");
			break;
		case '4': System.out.println("Es un 4");
			break;
		case '5': System.out.println("Es un 5");
			break;
		case '6': System.out.println("Es un 6");
			break;
		case '7': System.out.println("Es un 7");
			break;
		case '8': System.out.println("Es un 8");
			break;
		case '9': System.out.println("Es un 9");
			break;

		default:
			System.out.println("Es otro carácter");
			break;
		}
		sc.close();
	}
	private static void ejercicio11() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un número entero");
		int n1 = sc.nextInt();
		System.out.println("Escribe un segundo número entero");
		int n2 = sc.nextInt();
		System.out.println("Elige una de las siguientes opciones");
		System.out.println("1.Sumar");
		System.out.println("2.Restar");
		System.out.println("3.Multiplicar");
		System.out.println("4.Dividir");
		int n3 = sc.nextInt();
		double division = (double)n1/n2;
		if (n3==1) {
			System.out.println(n1 + " + "+ n2 + " = " + (n1+n2));
		}else if (n3==2) {
			System.out.println(n1 + " - "+ n2 + " = " + (n1-n2) );
		}else if (n3==3) {
			System.out.println(n1 + " x "+ n2 + " = " + (n1*n2) );
		}else if(n3==4) {
			System.out.println((n2==0)? "El divisor no puede ser 0": (n1 + " / "+ n2 ) + " = " + (division));
		}else { 
			System.out.println("Elige una de las 4 opciones");
		}
		sc.close();
	}	
	
	private static void ejercicio13() {
		/* BUCLE CON WHILE
		int i = 20;
		while(i<=20 && i > 0) { 
			System.out.print(i+", ");
			i-=1;
		} */
		
		for (int i = 20 ; i<=20 && i > 0; i-=1) { 
			System.out.print(i + ", ");
		
		}
	}
	private static void ejercicio18() {
		for ( int i = 0; i>=0 && i <=100; i+=5) {
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
	            System.out.print(i + ", ");
	        }
}
	
	
	
	
	
	public static void main(String[] args) {
		ejercicio19();

	}

}
