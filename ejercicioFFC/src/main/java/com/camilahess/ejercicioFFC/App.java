package com.camilahess.ejercicioFFC;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
		
		//Leo la info de los productos a ofrecer
		List<Producto> listaProductos = Producto.leerProductos(ruta);
		
		//MENÚ PARA PEDIR EL NÚMERO DNI
		Scanner scanner = new Scanner(System.in);
		String dniCifIngresado;
		do {
		    System.out.println("Introduzca el dni-cif del cliente: ");
		    dniCifIngresado = scanner.nextLine();
		    if (dniCifIngresado.length() != 3) {
		        System.out.println("DNI/CIF inválido. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
		    }
		} while (dniCifIngresado.length() != 3);

		
		List<Cliente> cuentasMismoDni = buscarClientePorDniIngresado(listaClientes,dniCifIngresado);
		mostrarMensajeBienvenida(cuentasMismoDni.get(0)); //recibe un Cliente
		LocalDate fecha = buscarFechaNacimiento(cuentasMismoDni, dniCifIngresado);
		int edad = Period.between(fecha, LocalDate.now()).getYears();
		System.out.println(saldoTotal(cuentasMismoDni));
		System.out.println(recomendarProducto(edad, saldoTotal(cuentasMismoDni), listaProductos));
	
	}

	private static List<Cliente> buscarClientePorDniIngresado(List<Cliente> listaClientes, String dniCifIngresado) {
		List<Cliente> clientesConMismoDniCif;
//		String dniCliente = dniCifIngresado; //copio para poder utilizarlo en la función lambda
		clientesConMismoDniCif = listaClientes.stream()
				.filter(c -> c.getDniCif().equals(dniCifIngresado))
				.collect(Collectors.toList());
		return clientesConMismoDniCif;
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

	private static LocalDate buscarFechaNacimiento(List<Cliente> cuentasMismoDni, String dniCliente) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    List<LocalDate> fechasNacimiento = cuentasMismoDni.stream()
	            .map(Cliente::getFechaNacimiento) // esto es lo mismo que c->c.getFechaNacimiento()
	            .distinct()
	            .collect(Collectors.toList());

	    String mensaje1 = "";
	    String mensaje2 = "";
	    if (cuentasMismoDni.stream().anyMatch(c -> c.getCodigoPais().equals("ES"))) {
	        mensaje1 = "Fecha de nacimiento: ";
	        mensaje2 = "Tienes " + fechasNacimiento.size() + " fechas de nacimiento diferentes, elige la correcta:";
	    } else {
	        mensaje1 = "Date of birth: ";
	        mensaje2 = "You have " + fechasNacimiento.size() + " different dates of birth, choose the correct one:";
	    }

	    if (fechasNacimiento.size() == 1) {
	        System.out.println(mensaje1 + fechasNacimiento.get(0).format(formato));
	        return fechasNacimiento.get(0);
	    } else {
	        System.out.println(mensaje2);
	        for (int i = 0; i < fechasNacimiento.size(); i++) {
	            System.out.println((i + 1) + ") " + fechasNacimiento.get(i).format(formato));
	        }
	        Scanner scanner = new Scanner(System.in);
	        System.out.println((fechasNacimiento.size() == 2) ? "(1 or 2): " : "(1, 2 or 3): ");
	        int opcion = scanner.nextInt();
	        System.out.println(mensaje1 + fechasNacimiento.get(opcion - 1).format(formato));
	        return fechasNacimiento.get(opcion - 1);
	    }
	}

	
	private static String recomendarProducto(int edad, int saldoTotal, List<Producto> listaProductos) {
	    List<Producto> productosElegibles = listaProductos.stream()
	            .filter(producto -> edad >= producto.getEdadMinima() && edad <= producto.getEdadMaxima() &&
	                saldoTotal >= producto.getSaldoMinimo() && saldoTotal <= producto.getSaldoMaximo())
	            .sorted((p1, p2) -> p2.getSaldoMinimo() - p1.getSaldoMinimo())
	            .collect(Collectors.toList());
	        if (!productosElegibles.isEmpty()) {
	            return productosElegibles.get(0).getNombre();
	        }
	        return "No se ha encontrado un producto adecuado para el cliente";
	    }
		
	
	private static int saldoTotal(List<Cliente> cuentasMismoDni) {
		int saldoTotal = cuentasMismoDni.stream()
				.mapToInt(Cliente::getSaldo).sum();
		return saldoTotal;
	}
	


}
