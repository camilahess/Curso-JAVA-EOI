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
		
		//SANTANDER 
		System.out.println("Números de cuentas del banco Santander: " + CuentaSantander.getNumCuentas());
		System.out.println("Suma de todos los saldos del banco Santander: " + CuentaSantander.getSumaSaldos(cuentasSantander) + "€\n");
		System.out.println("Cuenta con el saldo máximo: \n" + CuentaSantander.getCuentaConSaldoMax(cuentasSantander));
		
		
	}
}
