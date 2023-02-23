package com.camilahess2.proyectoClases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.camilahess2.proyectoClases.entidades.Cuenta;
import com.camilahess2.proyectoClases.entidades.CuentaCaixa;
import com.camilahess2.proyectoClases.entidades.CuentaSabadell;
import com.camilahess2.proyectoClases.entidades.CuentaSantander;
import com.camilahess2.proyectoClases.metodos.Metodos;

public class App {
	private static final String RUTA = "ficheros/";

	public static void main(String[] args) {

		List<CuentaCaixa> cuentasCaixa = CuentaCaixa.listaCaixa(RUTA);
		List<CuentaSabadell> cuentasSabadell = CuentaSabadell.listaSabadell(RUTA);
		List<CuentaSantander> cuentasSantander = CuentaSantander.listaSantander(RUTA);

		List<Cuenta> todasLasCuentas = Metodos.unirListas(cuentasCaixa, cuentasSabadell, cuentasSantander);

		for (Cuenta cuenta : todasLasCuentas) {
			if (cuenta instanceof CuentaCaixa) {
				System.out.println("Cuenta CAIXA: " + cuenta);
			} else if (cuenta instanceof CuentaSabadell) {
				System.out.println("Cuenta SABADELL: " + cuenta);
			} else if (cuenta instanceof CuentaSantander) {
				System.out.println("Cuenta SANTANDER: " + cuenta);
			}
		}

		// Borra un elemento al azar de la lista todasLasCuentas
		Cuenta cuentaEliminada = Metodos.borrarCuentaAzar(todasLasCuentas);
		System.out.println("\nLa cuenta eliminada es:\n" + cuentaEliminada);

		// SANTANDER
		System.out.println("Números de cuentas del banco Santander: " + CuentaSantander.getNumCuentas());
		System.out.println("Suma de todos los saldos del banco Santander: "
				+ CuentaSantander.getSumaSaldos(cuentasSantander) + "€\n");
		System.out.println("Cuenta con el saldo máximo: \n" + CuentaSantander.getCuentaConSaldoMax(cuentasSantander));

	}
}

/*
 * A partir de los archivos de los ficheros dados, realiza las siguientes tareas:
 * 
 * 1. Crea una clase genérica Cuenta que no se pueda instanciar con los campos
 * comunes de todos los archivos. Crea todos los métodos básicos de dicha
 * cuenta.
 * 
 * 2. Crea tantas clases heredadas como de bancos tienes información. Llámalas
 * CuentaSantander ...
 * 
 * 3. En las Clases de bancos catalanes (caixa y sabadell) cada vez que se cree
 * una cuenta deberá introducirse el nivel de catalán que tiene el titular de la
 * cuenta admitiendo solo tres opciones (alto, medio o bajo).
 * 
 * 4. En las cuentas del banco Santander queremos saber si el titular de la
 * cuenta es residente en Santander. Además queremos un contador interno en la
 * clase que almacene el número de cuentas que se crean de ese banco.
 * 
 * 5. Las cuentas de bancos catalanes no pueden ser heredadas por ninguna otra
 * clase.
 * 
 * 6. Crea un toString diferente para cada Cuenta de banco.
 * 
 * 7. Crea un proceso que lea los ficheros y cree una lista de objetos por cada
 * uno de los tipos de cuenta.
 * 
 * 8. Une todas las listas en una sola lista.
 * 
 * 9. Recorre esa lista agrupada y antes de mostrar sus datos indica el banco al
 * que pertenece.
 * 
 * 10. Crea un método que borre al azar un elemento de esta nueva lista.
 * 
 * 11. Busca en las listas de las cuentas de los diferentes bancos para
 * descubrir cuál de sus elementos no está en la lista agrupada.
 * 
 * 12. Sobre la lista del banco Santander saca la suma total de los saldos de
 * todos los clientes, el número de Cuentas que hay y aquella Cuenta con el
 * saldo más alto.
 */