package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Ejemplos2 {

	/**
	 * Función que nos lee todo el contenido de un fichero y nos imprimes sus líneas
	 * en Java8 Files nos permite trabajar con el contenido de los ficheros Paths
	 * nos permite trabajar con las rutas del ordenador(ej:C/ficheros/archivos.txt)
	 * 
	 * @param nombreFichero Nombre del fichero en formato texto
	 * @throws IOException
	 */
	public static void leerFicheroJava8(String nombreFichero) throws IOException {
		Files.readAllLines(Paths.get(nombreFichero)).forEach(l -> System.out.println(l));
	}

	public static void leerFicheroJava8(Path ruta) throws IOException {
		// System.out.println(ruta.toAbsolutePath().toString()); //para comprobar qué
		// archivo está por abrir
		Files.readAllLines(ruta).forEach(l -> System.out.println(l));
	}

	/**
	 * Método que lee un fichero y devuelve sus lineas en una lista
	 * 
	 * @param Ruta Path con la ruta del fichero
	 * @return Lista de cadenas, una por cada línea.
	 */
	public static List<String> devolverLineasJava8(Path ruta) {
		try {
			List<String> lineas = Files.readAllLines(ruta); // almacenamos la lista de lineas
			return lineas;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se puede acceder al fichero");
			return null;
		}

	}

	/**
	 * Método para crear un fichero nuevo y escribir en él (sobreescribe lo anterior
	 * si ya tenia información )
	 * 
	 * @param lineas Lista de líneas que escribiremos Devolvemos un booleano para
	 *               saber si se ha completado correctamente la acción
	 */
	public static boolean escribirLineasJava8(Path ruta, List<String> lineas) {
		try {
			Files.write(ruta, lineas);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Añadir líneas a un fichero existente
	 * 
	 * @param ruta
	 * @param lineas
	 * @return
	 */
	public static boolean agregarLineasJava8(Path ruta, List<String> lineas) {
		try {
			Files.write(ruta, lineas, StandardOpenOption.APPEND); // Append es añadir
			return true;
		} catch (IOException e) {
			return false;
		}

	}

	public static void main(String[] args) throws IOException {
		// leerFicheroJava8("/Users/camilahess/Desktop/ficheros/eoi.txt"); //ruta
		// absoluta
		// leerFicheroJava8(Paths.get("datos","eoi.txt")); //Lee la ruta relativa,
		// teniendo la carpeta datos
		// dentro del paquete del proyecto
		// PRIMERO GUARDAMOS LOS DATOS DEVUELTOS EN UNA LISTA
		// List<String> datosDevueltos =
		// devolverLineasJava8(Paths.get("/Users/camilahess/Desktop/ficheros/eoi.txt"));
		// UTILIZAMOS LA LISTA PARA LEER O BUSCAR
//		if(datosDevueltos!=null) {
//		datosDevueltos.forEach(l->System.out.println(l));
//		datosDevueltos.stream().filter(l->l.contains("Camila")).forEach(l->System.out.println(l));

		// Escribir lineas java 8
		List<String> lineas = Arrays.asList("Linea agregada", "Línea agregada2");
		List<String> lineas2 = Arrays.asList("Linea agregada 3", "Línea agregada4");
		if (escribirLineasJava8(Paths.get("/Users/camilahess/Desktop/ficheros/eoiNuevo.txt"), lineas)) {
			System.out.println("Todo ok");
		} else {
			System.out.println("Error");
		}
		if (agregarLineasJava8(Paths.get("/Users/camilahess/Desktop/ficheros/eoiNuevo.txt"), lineas2)) {
			System.out.println("Agregado correctamente");
		} else {
			System.out.println("Error al añadir");
		}
	}

}
