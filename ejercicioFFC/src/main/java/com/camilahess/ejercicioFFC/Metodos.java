package com.camilahess.ejercicioFFC;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Metodos {

	/**
	 * Busca las cuentas de los clientes que tengan el mismo DNI-CIF
	 * 
	 * @param listaClientes   Recibe la lista de clientes de los 3 bancos
	 * @param dniCifIngresado Recibe el DNI-CIF que se ha ingresado por consola
	 * @return Devuelve la lista de cuentas del mismo cliente
	 */
	public static List<Cliente> buscarClientePorDniIngresado(List<Cliente> listaClientes, String dniCifIngresado) {
	    List<Cliente> clientesEncontrados = listaClientes.stream().filter(c -> c.getDniCif().equals(dniCifIngresado)).collect(Collectors.toList());
	    return clientesEncontrados.isEmpty() ? null : clientesEncontrados;
	}


	public static String codigoPais(Cliente cliente) {
		return cliente.getCodigoPais();
	}
	/**
	 * Función para mostrar el mensaje de bienvenida del cliente que ha ingresado,
	 * según su código de país
	 * 
	 * @param Recibe la cuenta del cliente ingresado
	 */
	public static void mostrarMensajeBienvenida(Cliente cliente, String codigo) {
		if (codigo.equalsIgnoreCase("ES")) {
			System.out.println("Bienvenid@ " + cliente.getNombre() + "!\n" + getFormatoFecha(codigo));
		} else {
			System.out.println("Welcome " + cliente.getNombre() + "!\n" + getFormatoFecha(codigo));
		}
	}

	/**
	 * Función que devuelve el patrón de formato de fecha adecuado según el código
	 * // de país del cliente
	 * 
	 * @param codigoPais del cliente ingresado
	 * @return Devuelve el formato de fecha correcto para cada país
	 */
	public static String getFormatoFecha(String codigo) {
		if (codigo.equalsIgnoreCase("ES")) {
			return LocalDateTime.now()
					.format(DateTimeFormatter.ofPattern("'Hoy es' eeee dd 'de' MMMM 'de' yyyy\n'Hora: 'HH:mm:ss"));
		} else {
			return LocalDateTime.now().format(
					DateTimeFormatter.ofPattern("'Date: 'eeee',' MMMM dd',' yyyy\n'Time: 'HH:mm:ss", Locale.UK));
		}
	}

	/**
	 * Función para buscar la fecha de nacimiento del cliente, si tiene fechas de
	 * nacimiento diferentes en sus cuentas, le damos a elegir para seleccionar la
	 * correcta.
	 * 
	 * @param Recibe la lista de cuentas del cliente
	 * @param Recibe el DNI-CIF del cliente
	 * @return Devuelve su fecha de nacimiento correcta
	 */
	public static LocalDate buscarFechaNacimiento(List<Cliente> cuentasMismoDni, String dniCliente, String codigo) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		List<LocalDate> fechasNacimiento = cuentasMismoDni.stream()
				.map(Cliente::getFechaNacimiento).distinct()
				.collect(Collectors.toList());

		String mensaje1 = "";
		String mensaje2 = "";
		if (codigo.equalsIgnoreCase("ES")){
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
			Scanner sc = new Scanner(System.in);
			System.out.println((fechasNacimiento.size() == 2) ? "(1 or 2): " : "(1, 2 or 3): ");
			int opcion = sc.nextInt();
			System.out.println(mensaje1 + fechasNacimiento.get(opcion - 1).format(formato));
			return fechasNacimiento.get(opcion - 1);
		}
		
	}

	/**
	 * Función que busca el producto adecuado a recomendar al cliente, según su edad
	 * y el saldo total de sus cuentas
	 * 
	 * @param Recibe la edad del cliente
	 * @param Recibe el saldo total de sus cuentas
	 * @param Recibe la lista de productos a ofrecer
	 * @return Devuelve un String con el producto adecuado en caso de haber uno,
	 *         sino, otro String avisando que no hay productos adecuados para ese
	 *         cliente (en inglés o español según su código de país)
	 */
	public static String recomendarProducto(int edad, int saldoTotal, List<Producto> listaProductos, String codigo) {
		List<Producto> productosElegibles = listaProductos.stream()
				.filter(producto -> edad >= producto.getEdadMinima() && edad <= producto.getEdadMaxima()
						&& saldoTotal >= producto.getSaldoMinimo() && saldoTotal <= producto.getSaldoMaximo())
				.sorted((p1, p2) -> p2.getSaldoMinimo() - p1.getSaldoMinimo()).collect(Collectors.toList());
		if (!productosElegibles.isEmpty()) {
			return ((codigo.equalsIgnoreCase("ES"))?"Producto recomendado: " + productosElegibles.get(0).getNombre() : "Recommended product: " + productosElegibles.get(0).getNombre());
		}
		return (codigo.equalsIgnoreCase("ES"))?"No se ha encontrado un producto adecuado para el cliente":"No suitable product found for the customer";
	}

	public static int saldoTotal(List<Cliente> cuentasMismoDni) {
		return cuentasMismoDni.stream().mapToInt(Cliente::getSaldo).sum();
	}

}
