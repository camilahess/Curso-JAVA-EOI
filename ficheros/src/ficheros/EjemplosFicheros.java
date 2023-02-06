package ficheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class EjemplosFicheros {

	// LEER FICHEROS y controlarlos con TRY CATCH
	public static void leerFichero(String directorio, String nombreFichero) {
		// String ruta = directorio + File.separator + nombreFichero; // ruta =
		// "c:\ficheros\eoi.txt"
		// el file.separator es para reconocer la barra que separa los directorios / \
		// dependiendo el sistema operativo
		try {
			Files.readAllLines(Paths.get(directorio + File.separator + nombreFichero))
					.forEach(l -> System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ejemplo de método sobrecargado
	 * 
	 * @param directorio
	 * 
	 */
	public static void leerFichero(String ruta) {
		File fichero = new File(ruta);
		leerFichero(fichero.getParent(), fichero.getName()); // Llamamos a otro método desde este método
	}

	public static void leer2(String directorio, String nombreFichero) {
		// Este ejemplo es el mismo que el ejemplo 1 pero paso a paso

		String rutaAbsoluta = directorio + File.separator + nombreFichero;// Construir la cadena
		// Transformar la cadena a ruta de ordenador con PATH
		Path rutaOrdenador = Paths.get(rutaAbsoluta);
		try {
			List<String> lineasFichero = Files.readAllLines(rutaOrdenador); // Te devuelve una lista de strings con las
																			// lineas del fichero
			lineasFichero.forEach(l -> System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerRutaEntera(String ruta) {
		try {
			Files.readAllLines(Paths.get(ruta)).forEach(l -> System.out.println(l));
			// System.out.println("Esto lo hace si lee bien el fichero");
		} catch (IOException e) { // con el catch conseguimos que el programa no se interrumpa, y no falle
			e.printStackTrace();
		}
		// System.out.println("La función acaba correctamente, pero no he podido leer el
		// fichero");

	}

	// DEVOLVER LINEAS DE FICHERO
	public static List<String> devolverLineasFichero(String directorio, String nombreFichero) {

		try {

			return Files.readAllLines(Paths.get(directorio + File.separator + nombreFichero));

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;

	}

	// CREAR UN FICHERO DE CERO, E INCLUIR LINEAS DENTRO.
	public static void escribir1(String directorio, String nombreFichero, List<String> lineas) {
		try {
			Files.write(Paths.get(directorio + File.separator + nombreFichero), lineas, StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ejemploTry() {
		int numero1 = 10;
		int numero2 = 0;
		try {
			int division = numero1 / numero2;
		} catch (Exception e) {
			System.out.println("Error en la división"); // controlamos la división
		}
	}

	public static void ejemploTry2() {
		int numero1 = 10;
		int numero2 = 0;
		try {
			int division = numero1 / numero2;
			Files.write(Paths.get("/Users/camilahess/Desktop/ficherosx/eoi.txt"), Arrays.asList("" + division),
					StandardOpenOption.CREATE_NEW);

		} catch (ArithmeticException e) {
			e.printStackTrace(); // Esto ayuda a saber donde está el problema
			System.out.println("Error en la división"); // controlamos la división con Arithmetic Exception
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en acceso al fichero");
		}
		// ESTO: catch (Exception e) es para excepciones genéricas pero es mejor
		// especificar el tipo de excepción
	}

	public static void ejemploTry3() {
		// Controlando todo solo con el Exception e, no recomendable
		int numero1 = 10;
		int numero2 = 0;
		try {
			int division = numero1 / numero2;
			Files.write(Paths.get("/Users/camilahess/Desktop/ficherosx/eoi.txt"), Arrays.asList("" + division),
					StandardOpenOption.CREATE_NEW);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en acceso al fichero");
		}
		// ESTO: catch (Exception e) es para excepciones genéricas pero es mejor
		// especificar el tipo de excepción
	}

	public static void ejemploTryProfe() {
		int numero1 = 10;
		int numero2 = 2;
		int[] enteros = new int[2];
		enteros[0] = 10;
		enteros[1] = 15;
		String cadena = null;
		int longitudCadena = 0;
		try {
			if (cadena != null)
				longitudCadena = cadena.length();
			else
				throw new Exception("Cadena Nula");
			
			enteros[2] = longitudCadena; //La posición 2 del array no existe. ArrayIndexOutOfBounds
			int division = numero1 / numero2;
			Files.write(Paths.get("/Users/camilahess/Desktop/ficheros/eoi.txt"), Arrays.asList("" + division),
					StandardOpenOption.CREATE_NEW);

		} catch (ArithmeticException e) {
			e.printStackTrace(); // Esto ayuda a saber donde está el problema
			System.out.println("Error en la división"); // controlamos la división
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en acceso al fichero");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Otro tipo de error");
		} finally {
			// Esto se ejecuta haya acabado el try correctamente o
			// haya fallado una línea y generado una excepcion y saltado al catch
		}
		// Esto se ejecutaría siempre
		System.out.println("Hola");
	}

	public static void main(String[] args) {
		// leerFichero("/Users/camilahess/Desktop/ficheros", "eoi.txt");
		// leerFichero("/Users/camilahess/Desktop/ficheros/eoi.txt");
		//devolverLineasFichero("/Users/camilahess/Desktop/ficheros", "eoi.txt");
		//System.out.println();
		
		//Opcion 1. Devolver lineas de un fichero, buscar info
		List<String> lineas = devolverLineasFichero("/Users/camilahess/Desktop/ficheros", "eoi.txt");
		//Sin programación funciona, programacion estructurada
		for (String linea : lineas) {
			if(linea.contains("Camila"))
				System.out.println(linea);
		}
		
		//Opcion 2. Con programacion funcional
		lineas.stream()
		.filter(l->l.contains("Camila"))
		.forEach(l->System.out.println(l));
		
		//en un paso
		devolverLineasFichero("/Users/camilahess/Desktop/ficheros", "eoi.txt").stream()
		.filter(l->l.contains("Camila"))
		.forEach(l->System.out.println(l));
		

		// List<String> lineas = Arrays.asList("Linea 1" , "Línea 2"); // creamos una
		// lista para escribir en un nuevo fichero
		// escribir1("/Users/camilahess/Desktop/ficheros", "ejemploeoi.txt",lineas); //
		// creamos el fichero con el nuevo nombre del documento.txt

		// leerRutaEntera("/Users/camilahess/Desktop/ficheros/eois.txt"); --> Error
		// apropósito
		// leerRutaEntera("/Users/camilahess/Desktop/ficheros/eoi.txt"); //Lee bien el
		// fichero
		// ejemploTry3();
		//ejemploTryProfe();

	}

}
