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

/*
En este ejercicio practicaremos algunas de las cosas vistas en programación funcional, por lo que todos los resultados los tenemos que obtener por esta técnica.
El programa inicialmente cargará los archivos de los diferentes bancos en la clase Cuenta vista en el ejercicio anterior. Para eso puedes coger de dicho ejercicio todas las clases que consideres oportunas. 
Posteriormente sacarás un menú al usuario con las siguientes opciones:
1. Obtener saldo cliente. Para ello pedirás un dni por pantalla y devolverás la suma de todas las cuentas (de todos los bancos) asociadas con ese dni.
2. Obtener lista morosos y no morosos. Sacaras un listado con aquellas personas cuya suma de saldos es menor que cero (previamente te habrás creado una lista con ellos) y de aquellos cuyo saldo es >= 0 (también tendrás una lista con ellos). Piensa las diferentes formas de obtener esas listas.
3. Cliente Preferido. Obtener el nombre de la persona cuyo suma de los saldos de las cuentas sea mayor.
4. Obtener Clientes por nombre. Pedirá por pantalla una cadena a buscar y devolverá un listado con los clientes cuyo nombre contiene la cadena buscada junto con su saldo total en las cuentas.
5. Clientes concretos. Pedirá por pantalla un número que indica su posición dentro de los que más ganan (es decir, podemos indicar el tercero que más gane). De él sacará toda su información. */