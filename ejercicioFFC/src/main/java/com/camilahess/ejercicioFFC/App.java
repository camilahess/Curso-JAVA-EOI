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

		// Definir la ruta donde se encuentran los archivos txt con la información de los clientes
		final String ruta = "ficheros/";

		// Leer la información de los clientes de los archivos txt y la almacena en una lista de objetos Cliente
		List<Cliente> listaClientes = Cliente.leerClientes(ruta);

		
		//MENÚ PARA PEDIR EL NÚMERO DNI
		List<Cliente> clientesConMismoDniCif;
		Scanner scanner = new Scanner(System.in);
		String dniCifIngresado;
		do {
		    System.out.println("Introduzca el dni-cif del cliente: ");
		    dniCifIngresado = scanner.nextLine();
		    if (dniCifIngresado.length() != 3) {
		        System.out.println("DNI/CIF inválido. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
		    }
		} while (dniCifIngresado.length() != 3);

		// Buscar en la lista de clientes el cliente con el dni-cif introducido por el usuario

		String dniCliente = dniCifIngresado; //copio para poder utilizarlo en la función lambda
		clientesConMismoDniCif = listaClientes.stream()
				.filter(c -> c.getDniCif()
				.equals(dniCliente))
				.collect(Collectors.toList());
		
		mostrarMensajeBienvenida(clientesConMismoDniCif.get(0)); //recibe un Cliente
		buscarFechaNacimiento(clientesConMismoDniCif, dniCliente);
		

	}

	private static void buscarFechaNacimiento(List<Cliente> clientesConMismoDniCif, String dniCliente) {
//		List<LocalDate> fechasNacimiento = clientesConMismoDniCif.stream()
//				.map(Cliente::getFechaNacimiento) // esto es lo mismo que c->c.getFechaNacimiento()
//				.distinct()
//				.collect(Collectors.toList());
//
//		if (fechasNacimiento.size() == 1) {
//			System.out.println("Fecha de nacimiento: " + fechasNacimiento.get(0));
//		} else {
//			System.out.println(
//					"Tienes " + fechasNacimiento.size() + " fechas de nacimiento diferentes, elige la correcta:");
//			for (int i = 0; i < fechasNacimiento.size(); i++) {
//				System.out.println((i + 1) + ") " + fechasNacimiento.get(i));
//			}
//			Scanner scanner = new Scanner(System.in);
//			System.out.println((fechasNacimiento.size() == 2) ? "(1 o 2): " : "(1, 2 o 3): ");
//			int opcion = scanner.nextInt();
//			System.out.println("La fecha de nacimiento seleccionada es: " + fechasNacimiento.get(opcion - 1));
//		}
//	}

		    List<LocalDate> fechasNacimiento = clientesConMismoDniCif.stream()
		            .map(Cliente::getFechaNacimiento)
		            .distinct()
		            .collect(Collectors.toList());

		    String mensaje1 = "";
		    String mensaje2 = "";
		    if (clientesConMismoDniCif.stream().anyMatch(c -> c.getCodigoPais().equals("ES"))) {
		        mensaje1 = "Fecha de nacimiento: ";
		        mensaje2 = "Tienes " + fechasNacimiento.size() + " fechas de nacimiento diferentes, elige la correcta:";
		    } else {
		        mensaje1 = "Date of birth: ";
		        mensaje2 = "You have " + fechasNacimiento.size() + " different dates of birth, choose the correct one:";
		    }

		    if (fechasNacimiento.size() == 1) {
		        System.out.println(mensaje1 + fechasNacimiento.get(0));
		    } else {
		        System.out.println(mensaje2);
		        for (int i = 0; i < fechasNacimiento.size(); i++) {
		            System.out.println((i + 1) + ") " + fechasNacimiento.get(i));
		        }
		        Scanner scanner = new Scanner(System.in);
		        System.out.println((fechasNacimiento.size() == 2) ? "(1 or 2): " : "(1, 2 or 3): ");
		        int opcion = scanner.nextInt();
		        System.out.println(mensaje1 + fechasNacimiento.get(opcion - 1));
		    }
		}





	// Función para mostrar el mensaje de bienvenida
	private static void mostrarMensajeBienvenida(Cliente cliente) {

		if (cliente.getCodigoPais().equals("ES")) {
			System.out.println("Bienvenid@ " + cliente.getNombre() + "!\n" + getFormatoFecha(cliente.getCodigoPais()));

		} else {
			System.out.println("Welcome " + cliente.getNombre() + "!\n" + getFormatoFecha(cliente.getCodigoPais()));
		}
	}


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
