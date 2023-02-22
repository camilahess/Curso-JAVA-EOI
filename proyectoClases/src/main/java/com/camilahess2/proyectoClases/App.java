package com.camilahess2.proyectoClases;


import java.util.ArrayList;
import java.util.List;

import com.camilahess2.proyectoClases.entidades.Cuenta;
import com.camilahess2.proyectoClases.entidades.CuentaCaixa;
import com.camilahess2.proyectoClases.entidades.CuentaSabadell;
import com.camilahess2.proyectoClases.entidades.CuentaSantander;

public class App {
	private static final String RUTA = "ficheros/";
	
	
	public static void main(String[] args) {

		List<CuentaCaixa> cuentasCaixa = CuentaCaixa.listaCaixa(RUTA);
		List<CuentaSabadell> cuentasSabadell = CuentaSabadell.listaSabadell(RUTA);
		List<CuentaSantander> cuentasSantander = CuentaSantander.listaSantander(RUTA);
		
		
		List<Cuenta> todasLasCuentas = new ArrayList<Cuenta>();
		todasLasCuentas.addAll(cuentasCaixa);
		todasLasCuentas.addAll(cuentasSabadell);
		todasLasCuentas.addAll(cuentasSantander);
		
		for (Object cuenta : todasLasCuentas) {
		    if (cuenta instanceof CuentaCaixa) {
		        System.out.println("Cuenta CAIXA: " + cuenta);
		    } else if (cuenta instanceof CuentaSabadell) {
		        System.out.println("Cuenta SABADELL: " + cuenta);
		    } else if (cuenta instanceof CuentaSantander) {
		        System.out.println("Cuenta SANTANDER: " + cuenta);
		    }
		}
		
		System.out.println("Números de cuentas de Santander: " + CuentaSantander.getNumCuentas());
	}
}
