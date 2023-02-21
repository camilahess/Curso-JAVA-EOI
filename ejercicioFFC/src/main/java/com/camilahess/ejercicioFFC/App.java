package com.camilahess.ejercicioFFC;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

public class App {
	public static final String RUTA = "ficheros/";
	
	public static void main(String[] args) {


		List<Cliente> listaClientes = Cliente.leerClientes(RUTA);

		List<Producto> listaProductos = Producto.leerProductos(RUTA);
		
		List<Cliente> clientesEncontrados = null;
		String dniCifIngresado="";
		while (clientesEncontrados == null || dniCifIngresado.length() != 3) {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Introduzca el dni-cif del cliente: ");
		    dniCifIngresado = sc.nextLine();
		    clientesEncontrados = Metodos.buscarClientePorDniIngresado(listaClientes, dniCifIngresado);
		    if (dniCifIngresado.length() != 3 || clientesEncontrados == null ) {
		        System.out.println("DNI/CIF inválido o no encontrado. Por favor, introduce un DNI/CIF válido de 3 caracteres.");
		    }
		}
	
		String codigo = Metodos.codigoPais(clientesEncontrados.get(0));
		Metodos.mostrarMensajeBienvenida(clientesEncontrados.get(0), codigo); // recibe un Cliente
		LocalDate fecha = Metodos.buscarFechaNacimiento(clientesEncontrados, dniCifIngresado, codigo);
		int edad = Period.between(fecha, LocalDate.now()).getYears();
		System.out.println(Metodos.recomendarProducto(edad, Metodos.saldoTotal(clientesEncontrados), listaProductos, codigo));

	}
}
