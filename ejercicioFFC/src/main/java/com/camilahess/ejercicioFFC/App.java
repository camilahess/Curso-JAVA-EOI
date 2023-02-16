package com.camilahess.ejercicioFFC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		List<Cliente> clientes = Cliente.leerClientes(ruta);
		
		// Buscar en la lista de clientes el cliente con el dni-cif introducido por el
		// usuario
		Cliente cliente = clientes.stream().filter(c -> c.getDniCif().equals(dniCif)).findFirst().orElse(null);
//		List<Cliente> clientesConMismoDniCif = clientes.stream().filter(c -> c.getDniCif().equals(dniCif)).collect(Collectors.toList());
//		System.out.println(clientesConMismoDniCif);
		//Guardo en una lista los clientes con mismo DNI para comparar sus fechas de nacimiento
		

		// Mostrar el mensaje de bienvenida utilizando la función creada
		mostrarMensajeBienvenida(cliente);
		buscarFechaNacimiento(clientes, dniCif);
		
	}
	
	//Buscar fecha de nacimiento diferentes
	

//		private static void buscarFechaNacimiento(List<Cliente> clientes, String dniCif) {
//		    List<Cliente> clientesConMismoDniCif = clientes.stream()
//		        .filter(c -> c.getDniCif().equals(dniCif))
//		        .collect(Collectors.toList());

//
//		    LocalDate fecha1 = clientesConMismoDniCif.get(0).getFechaNacimiento();
//		    LocalDate fecha2 = clientesConMismoDniCif.get(1).getFechaNacimiento();
//		    LocalDate fecha3 = clientesConMismoDniCif.get(2).getFechaNacimiento();
//
//		    if (!fecha1.equals(fecha2) || !fecha1.equals(fecha3)) {
//		        System.out.println("Cuál es su fecha de nacimiento correcta? : ");
//		        System.out.println("- " + fecha1);
//		        System.out.println("- " + fecha2);
//		        System.out.println("- " + fecha3);
//		        System.out.println("Por favor, verifique y corrija los datos del cliente.");
//		    }
//		
//	}
	private static void buscarFechaNacimiento(List<Cliente> clientes, String dniCif) {
	    List<LocalDate> fechasNacimiento = clientes.stream()
	            .filter(c -> c.getDniCif().equals(dniCif))
	            .map(Cliente::getFechaNacimiento)
	            .collect(Collectors.toList());

	        List<LocalDate> fechasDistintas = fechasNacimiento.stream()
	            .distinct()
	            .collect(Collectors.toList());

	        if (fechasDistintas.size() == 1) {
	            System.out.println("Fecha de nacimiento: " + fechasDistintas.get(0));
	        } else {
	            System.out.println("Tienes " + fechasDistintas.size() + " fechas de nacimiento diferentes, elige la correcta:");
	            for (int i = 0; i < fechasDistintas.size(); i++) {
	                System.out.println((i+1) + ") " + fechasDistintas.get(i));
	            }
	            Scanner scanner = new Scanner(System.in);
	            System.out.println("(1, 2 o 3): ");
	            int opcion = scanner.nextInt();
	            System.out.println("La fecha de nacimiento seleccionada es: " + fechasDistintas.get(opcion - 1));
	        }
	    }


	// Función para mostrar el mensaje de bienvenida
	private static void mostrarMensajeBienvenida(Cliente cliente) {
//		String mensajeBienvenida = "";
//		if (cliente == null) {
//			mensajeBienvenida = "Lo siento, no se ha encontrado un cliente con ese dni-cif.";
//		} else {

			if (cliente.getCodigoPais().equals("ES")) {
				System.out.println(
						"Bienvenid@ " + cliente.getNombre() + "!\n" + getFormatoFecha(cliente.getCodigoPais()));

			} else {
				System.out.println("Welcome " + cliente.getNombre() + "!\n" + getFormatoFecha(cliente.getCodigoPais()));
			}
		}
		//System.out.println(mensajeBienvenida);
//}

	//MOSTRAR FECHA DE NACIMIENTO
	
	
	
	// Función que devuelve el patrón de formato de fecha adecuado según el código
	// de país del cliente
	private static String getFormatoFecha(String codigoPais) {
		if (codigoPais.equals("ES")) {
			return LocalDateTime.now()
					.format(DateTimeFormatter.ofPattern("'Hoy es' eeee dd 'de' MMMM 'de' yyyy\n'Hora: 'HH:mm:ss"));
		} else {
			return LocalDateTime.now().format(
					DateTimeFormatter.ofPattern("'Date: 'eeee',' MMMM dd',' yyyy\n'Time: 'HH:mm:ss", Locale.UK));
		}
	}




}
