package com.camilahess.ejercicioFFC;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		// Definir la ruta donde se encuentran los archivos txt con la información de
		// los clientes
		final String ruta = "ficheros/";
		
		
		// Pedir por consola el dni-cif del cliente
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el dni-cif del cliente: ");
		String dniCif = scanner.nextLine();

		// Leer la información de los clientes de los archivos txt y la almacena en una
		// lista de objetos Cliente
		List<Cliente> clientes = leerClientes(ruta);

		// Buscar en la lista de clientes el cliente con el dni-cif introducido por el
		// usuario
		Cliente cliente = clientes.stream().filter(c -> c.getDniCif().equals(dniCif)).findFirst().orElse(null);

		// Mostrar el mensaje de bienvenida utilizando la función creada
		mostrarMensajeBienvenida(cliente);
	}

	// Función para mostrar el mensaje de bienvenida
	private static void mostrarMensajeBienvenida(Cliente cliente) {
		String mensajeBienvenida = "";
		if (cliente == null) {
			mensajeBienvenida = "Lo siento, no se ha encontrado un cliente con ese dni-cif.";
		} else {
			
			if (cliente.getCodigoPais().equals("ES")) {
				//mensajeBienvenida = "¡Bienvenid@ " + cliente.getNombre() + "!, hoy es " + fechaActual + " a las " + horaActual + ".";
				System.out.println("Bienvenid@ "+ cliente.getNombre() + "!\n" + getFormatoFecha(cliente.getCodigoPais()));
				
			} else {
				//mensajeBienvenida = "Welcome " + cliente.getNombre() + "! Today is " + fechaActual + " at " + horaActual + ".";
				System.out.println("Welcome "+ cliente.getNombre() + "!\n" + getFormatoFecha(cliente.getCodigoPais()));
			}
		}
		System.out.println(mensajeBienvenida);
	}

	
	
	// Función que devuelve el patrón de formato de fecha adecuado según el código de país del cliente
	private static String getFormatoFecha(String codigoPais) {
	    if (codigoPais.equals("ES")) {
	    	return LocalDateTime.now().format(DateTimeFormatter.ofPattern("'Hoy es' eeee dd 'de' MMMM 'de' yyyy\n'Hora: 'HH:mm:ss"));
	    } else {
	        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("'Date: 'eeee',' MMMM dd',' yyyy\n'Time: 'HH:mm:ss", Locale.UK));
	    }
	}
	

	//Leo los archivos txt y guardo en una lista los datos
	private static List<Cliente> leerClientes(String ruta) {
		List<Cliente> clientes = new ArrayList<>();
		List<String> nombresArchivos = Arrays.asList("caixa.txt", "santander.txt", "sabadell.txt");
		for (String nombreArchivo : nombresArchivos) {
			try {
				Path path = Paths.get(ruta, nombreArchivo);
				List<String> lineas = Files.readAllLines(path);
				for (String linea : lineas) {
					String[] datos = linea.split(";");
					Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]));
					clientes.add(cliente);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return clientes;
	}

}
