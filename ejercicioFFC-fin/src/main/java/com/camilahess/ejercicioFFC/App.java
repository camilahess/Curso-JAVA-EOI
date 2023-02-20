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

//		// MENÚ PARA PEDIR EL NÚMERO DNI
//		Scanner sc = new Scanner(System.in);
//		String dniCifIngresado;
//		do {
//			System.out.println("Introduzca el dni-cif del cliente: ");
//			dniCifIngresado = sc.nextLine();
//			if (dniCifIngresado.length() != 3) {
//				System.out.println("DNI/CIF inválido. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
//			}
//		} while (dniCifIngresado.length() != 3);
//		sc.close();
		
		List<Cliente> clientesEncontrados = null;
		String dniCifIngresado="";
		while (clientesEncontrados == null) {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Introduzca el dni-cif del cliente: ");
		    dniCifIngresado = sc.nextLine();
		    clientesEncontrados = Metodos.buscarClientePorDniIngresado(listaClientes, dniCifIngresado);
		    if (dniCifIngresado.length() != 3 || clientesEncontrados == null ) {
		        System.out.println("DNI/CIF inválido o no encontrado. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
		    }
		}
	
		List<Cliente> cuentasMismoDni = Metodos.buscarClientePorDniIngresado(listaClientes, dniCifIngresado);
		String codigo = Metodos.codigoPais(cuentasMismoDni.get(0));
		Metodos.mostrarMensajeBienvenida(cuentasMismoDni.get(0), codigo); // recibe un Cliente
		LocalDate fecha = Metodos.buscarFechaNacimiento(cuentasMismoDni, dniCifIngresado, codigo);
		int edad = Period.between(fecha, LocalDate.now()).getYears();
		System.out.println(Metodos.recomendarProducto(edad, Metodos.saldoTotal(cuentasMismoDni), listaProductos, codigo));

	}
}
