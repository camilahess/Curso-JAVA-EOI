package com.camilahess.ejercicioFFC;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		// Definir la ruta donde se encuentran los archivos txt con la información de
		// los clientes
		final String ruta = "ficheros/";

		// Leer la información de los clientes de los archivos txt y la almacena en una
		// lista de objetos Cliente
		List<Cliente> listaClientes = Cliente.leerClientes(ruta);

		// Leo la info de los productos a ofrecer
		List<Producto> listaProductos = Producto.leerProductos(ruta);

		// MENÚ PARA PEDIR EL NÚMERO DNI
		Scanner scanner = new Scanner(System.in);
		String dniCifIngresado;
		do {
			System.out.println("Introduzca el dni-cif del cliente: ");
			dniCifIngresado = scanner.nextLine();
			if (dniCifIngresado.length() != 3) {
				System.out.println("DNI/CIF inválido. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
			}
		} while (dniCifIngresado.length() != 3);
		
	
		List<Cliente> cuentasMismoDni = Metodos.buscarClientePorDniIngresado(listaClientes, dniCifIngresado);
		final String codigo = Metodos.codigoPais(cuentasMismoDni.get(0));
		System.out.println(codigo);
		Metodos.mostrarMensajeBienvenida(cuentasMismoDni.get(0), codigo); // recibe un Cliente
		LocalDate fecha = Metodos.buscarFechaNacimiento(cuentasMismoDni, dniCifIngresado, codigo);
		int edad = Period.between(fecha, LocalDate.now()).getYears();
		System.out.println(Metodos.recomendarProducto(edad, Metodos.saldoTotal(cuentasMismoDni), listaProductos, codigo));

	}
}
