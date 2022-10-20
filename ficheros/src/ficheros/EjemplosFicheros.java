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

	//LEER FICHEROS
	public static void leer1(String directorio, String nombreFichero) throws IOException {
		//String ruta = directorio + File.separator + nombreFichero; // ruta = "c:\ficheros\eoi.txt"
		Files.readAllLines(Paths.get(directorio + File.separator + nombreFichero)).forEach(l -> System.out.println(l));
	}
	
	public static void leer2(String directorio, String nombreFichero) throws IOException {
	//Este ejemplo es el mismo que el ejemplo 1 pero paso a paso
		
	String rutaAbsoluta = directorio + File.separator + nombreFichero;// Construir la cadena
	//Transformar la cadena a ruta de ordenador con PATH
	Path rutaOrdenador = Paths.get(rutaAbsoluta);
	List<String> lineasFichero = Files.readAllLines(rutaOrdenador); //Te devuelve una lista de strings con las lineas del fichero
	lineasFichero.forEach(l->System.out.println(l));		
	}
	
	public static void escribir1 (String directorio, String nombreFichero, List<String> lineas) throws IOException {
		Files.write(Paths.get(directorio + File.separator + nombreFichero), lineas, StandardOpenOption.CREATE_NEW);
	}
	
	
	public static void main(String[] args) throws IOException {
		// leer1("/Users/camilahess/Desktop/ficheros", "eoi.txt");
		List<String> lineas = Arrays.asList("Linea  1" , "Línea 2");
		escribir1("/Users/camilahess/Desktop/ficheros", "ejemploeoi.txt",lineas);
	}

}
