package com.camilahess.ejercicioProgramacionFuncional.metodos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.camilahess.ejercicioProgramacionFuncional.entidades.Cuenta;

public class Metodos {


	
	// Leo los archivos txt y guardo en una lista los datos
	public static List<Cuenta> leerClientes(String ruta, List<String> nombresArchivos) {
		List<Cuenta> clientes = new ArrayList<>();
		for (String nombreArchivo : nombresArchivos) {
			try {
				Path path = Paths.get(ruta, nombreArchivo); // transformo la ruta
				List<String> lineas = Files.readAllLines(path);
				for (String linea : lineas) {
					List<String> datosLinea = new ArrayList<>(Arrays.asList(linea.split(";")));
					clientes.add(new Cuenta(datosLinea.get(0), datosLinea.get(1),
							LocalDate.parse(datosLinea.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							datosLinea.get(3), Integer.parseInt(datosLinea.get(4))));
				}
			} catch (IOException e) {
				System.out.println("Error leyendo ficheros de bancos");
			}
		}
		return clientes;
	}

	public static Map<String, List<Cuenta>> obtenerCuentasPorDni(List<Cuenta> listaClientes) {
		return listaClientes.stream().collect(Collectors.groupingBy(Cuenta::getDniCif));
	}

	/**
	 * Agrupa las cuentas por el número de identificación del cliente.
	 *
	 * @param listaClientes la lista de cuentas a agrupar
	 * @return un mapa que agrupa las cuentas por el número de identificación del
	 *         cliente
	 */
	public static double obtenerSaldoTotal(Map<String, List<Cuenta>> cuentasPorDni, Scanner sc) {
		while (true) {
			System.out.println("Introduzca su dni-cif para obtener el saldo total de sus cuentas: ");
			String dniCifIngresado = sc.nextLine();
			List<Cuenta> cuentasDelCliente = cuentasPorDni.get(dniCifIngresado);
			if (dniCifIngresado.length() != 3 || cuentasDelCliente == null) {
				System.out.println(
						"DNI/CIF inválido o no encontrado. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
			} else {
				double saldoTotal = cuentasDelCliente.stream().mapToDouble(Cuenta::getSaldo).sum();
				return saldoTotal;

			}
		}
	}

	public static List<String> imprimirMorosos(Map<String, List<Cuenta>> cuentasPorDni) {
//	    List<String> nombresMorosos = new ArrayList<>();
//	    List<String> nombresNoMorosos = new ArrayList<>();
//
//	    for (List<Cuenta> cuentasConMismoDni : cuentasPorDni.values()) {
//	        double saldoTotal = 0;
//	        for (Cuenta cuenta : cuentasConMismoDni) {
//	            saldoTotal += cuenta.getSaldo();
//	        }
//	        boolean esMoroso = saldoTotal < 0;
//	        String nombreTitular = cuentasConMismoDni.get(0).getNombreCliente();
//	        if (esMoroso) {
//	            nombresMorosos.add(nombreTitular);
//	        } else {
//	            nombresNoMorosos.add(nombreTitular);
//	        }
//	    }
//		List<String> nombresMorosos = cuentasPorDni.values().stream().flatMap(List::stream)
//				.collect(Collectors.groupingBy(Cuenta::getDniCif, Collectors.summingDouble(Cuenta::getSaldo)))
//				.entrySet().stream().filter(entry -> entry.getValue() < 0)
//				.map(entry -> cuentasPorDni.get(entry.getKey()).get(0).getNombreCliente()).collect(Collectors.toList());
//
//		List<String> nombresNoMorosos = cuentasPorDni.values().stream().flatMap(List::stream)
//				.collect(Collectors.groupingBy(Cuenta::getDniCif, Collectors.summingDouble(Cuenta::getSaldo)))
//				.entrySet().stream().filter(entry -> entry.getValue() >= 0)
//				.map(entry -> cuentasPorDni.get(entry.getKey()).get(0).getNombreCliente()).collect(Collectors.toList());
		

		Map<String, Double> saldosPorCliente = cuentasPorDni.values().stream()
		        .flatMap(List::stream)
		        .collect(Collectors.groupingBy(Cuenta::getDniCif, Collectors.summingDouble(Cuenta::getSaldo)));

		List<String> nombresMorosos = saldosPorCliente.entrySet().stream()
		        .filter(entry -> entry.getValue() < 0)
		        .map(entry -> cuentasPorDni.get(entry.getKey()).get(0).getNombreCliente())
		        .collect(Collectors.toList());

		List<String> nombresNoMorosos = saldosPorCliente.entrySet().stream()
		        .filter(entry -> entry.getValue() >= 0)
		        .map(entry -> cuentasPorDni.get(entry.getKey()).get(0).getNombreCliente())
		        .collect(Collectors.toList());
		
		
		System.out.println("Clientes morosos:");
		nombresMorosos.forEach(System.out::println);

		System.out.println("Clientes no morosos:");
		nombresNoMorosos.forEach(System.out::println);

		List<String> resultados = new ArrayList<>();
		resultados.add("Clientes morosos:");
		resultados.addAll(nombresMorosos);
		resultados.add("Clientes no morosos:");
		resultados.addAll(nombresNoMorosos);

		return resultados;
	}

	public static String clientePreferido(Map<String, List<Cuenta>> cuentasPorDni) {
		String clientePreferido = cuentasPorDni.entrySet().stream()
				.max(Comparator.comparingDouble(entry -> entry.getValue().stream().mapToDouble(Cuenta::getSaldo).sum()))
				.map(entry -> entry.getValue().get(0).getNombreCliente()).orElse("");

		return clientePreferido;
	}

	public static List<String> buscarClientesPorNombre(Map<String, List<Cuenta>> cuentasPorDni, Scanner sc) {
		List<String> resultados = new ArrayList<>();
		boolean encontrado = false;

		while (!encontrado) {
			System.out.println("Ingrese una cadena a buscar (o 'salir' para salir):");
			String cadena = sc.nextLine().toLowerCase();
			if (cadena.equals("salir")) {
				break;
			}
			for (Map.Entry<String, List<Cuenta>> entry : cuentasPorDni.entrySet()) {
				String nombreCliente = entry.getValue().get(0).getNombreCliente().toLowerCase();
				if (nombreCliente.contains(cadena)) {
					double saldoTotal = entry.getValue().stream().mapToDouble(Cuenta::getSaldo).sum();
					resultados.add(nombreCliente + " - Saldo total: $" + saldoTotal);
					encontrado = true;
				}
			}

			if (!encontrado) {
				System.out.println("No se encontraron clientes con esa cadena.");
			}
		}
		return resultados;
	}

	public static List<String> clientesPorSaldo(Map<String, List<Cuenta>> cuentasPorDni) {
		List<String> resultados = cuentasPorDni.entrySet().stream()
				.sorted(Comparator
						.comparingDouble(entry -> -entry.getValue().stream().mapToDouble(Cuenta::getSaldo).sum())) // Ordenamos
																													// de
																													// forma
																													// descendente
				.map(entry -> entry.getValue().get(0).getNombreCliente() + " - Saldo total: $"
						+ entry.getValue().stream().mapToDouble(Cuenta::getSaldo).sum()) // Obtenemos el nombre del
																							// cliente y el saldo total
																							// de todas sus cuentas
				.collect(Collectors.toList()); // Convertimos el stream a una lista

		return resultados;
	}

	public static void clientesConcretos(List<String> clientesPorSaldo, Scanner sc) {
		int posicion = 0;
		while (posicion < 1 || posicion > clientesPorSaldo.size()) {
			System.out.println("Ingrese una posición (1-" + clientesPorSaldo.size() + "):");
			try {
				posicion = Integer.parseInt(sc.nextLine());
				if (posicion < 1 || posicion > clientesPorSaldo.size()) {
					System.out.println("La posición ingresada no es válida. Intente nuevamente.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número entero. Intente nuevamente.");
			}
		}
		String clienteSeleccionado = clientesPorSaldo.get(posicion - 1);
		System.out.println("Cliente seleccionado: " + clienteSeleccionado);
	}
	
}
