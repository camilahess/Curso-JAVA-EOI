package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ejemplos2 {
	
	/**
	 * Función que nos lee todo el contenido de un fichero y nos imprimes sus líneas en Java8
	 * Files nos permite trabajar con el contenido de los ficheros
	 * Paths nos permite trabajar con las rutas del ordenador(ej:C/ficheros/archivos.txt)
	 * @param nombreFichero Nombre del fichero en formato texto
	 * @throws IOException
	 */
	public static void leerFicheroJava8(String nombreFichero) throws IOException {
		Files.readAllLines(Paths.get(nombreFichero)).forEach(l->System.out.println(l));
	}
	
	public static void leerFicheroJava8(Path ruta) throws IOException {
		//System.out.println(ruta.toAbsolutePath().toString()); //para comprobar qué archivo está por abrir
		Files.readAllLines(ruta).forEach(l->System.out.println(l));
	}
	
	public static List<String> devolverLineasJava8(Path ruta){
		try {
			List<String> lineas = Files.readAllLines(ruta); //almacenamos la lista de lineas
			return lineas;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
		
	}
	public static void main(String[] args)  throws IOException {
		 //leerFicheroJava8("/Users/camilahess/Desktop/ficheros/eoi.txt"); //ruta absoluta
		// leerFicheroJava8(Paths.get("datos","eoi.txt")); //Lee la ruta relativa, teniendo la carpeta datos
		 //dentro del paquete del proyecto
		//PRIMERO GUARDAMOS LOS DATOS DEVUELTOS EN UNA LISTA
		List<String> datosDevueltos = devolverLineasJava8(Paths.get("/Users/camilahess/Desktop/ficheros/eoi.txt"));
		//UTILIZAMOS LA LISTA PARA LEER O BUSCAR
		datosDevueltos.forEach(l->System.out.println(l));
		datosDevueltos.stream().filter(l->l.contains("Camila")).forEach(l->System.out.println(l));
	}

}
