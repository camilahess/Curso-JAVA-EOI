package com.camilahess.ejercicioProgramacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.camilahess.ejercicioProgramacionFuncional.entidades.Cuenta;
import com.camilahess.ejercicioProgramacionFuncional.metodos.Metodos;

public class App 
{
	private static final String RUTA = "ficheros/";
	private static List<String> nombresArchivos = Arrays.asList("caixa.txt", "santander.txt", "sabadell.txt");
	static List<Cuenta> listaClientes = new ArrayList<Cuenta>();
	static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args )
    {

    	//obtengo la lista de clientes y sus cuentas en todos los bancos
    	listaClientes = Metodos.leerClientes(RUTA, nombresArchivos);
    	Map<String, List<Cuenta>> cuentasPorDni = Metodos.obtenerCuentasPorDni(listaClientes);
    	//1- Obtener saldo total de todas las cuentas del cliente según su DNI
    	double saldoTotal = Metodos.obtenerSaldoTotal(cuentasPorDni, sc);
    	System.out.println("El saldo total de sus cuentas es de: " +saldoTotal + "€");
    	
    	//2.Obtener lista de morosos y no morosos de los tres bancos. 
    	
    	Metodos.imprimirMorosos(cuentasPorDni);
    	
    	//3.Obtener el nombre de la persona cuyo suma de los saldos de las cuentas sea mayor.
    	System.out.println("El cliente preferido es: " + Metodos.clientePreferido(cuentasPorDni));
    	
    	//4. Obtener clientes por nombre ( cadena a buscar ) 
    	List<String> clientesEncontrados = Metodos.buscarClientesPorNombre(cuentasPorDni, sc);
    	System.out.println(clientesEncontrados.size()==0?"Adiós": clientesEncontrados);
    

    	List<String> clientesOrdenados = Metodos.clientesPorSaldo(cuentasPorDni);
    	Metodos.clientesConcretos(clientesOrdenados, sc);
    	sc.close(); //preguntar a Fran donde cerrar el scanner
    }
}
