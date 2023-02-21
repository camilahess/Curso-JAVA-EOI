package com.camilahess2.proyectoClases;


import java.util.List;

public class App {
	private static final String RUTA = "ficheros/";
	
	
	public static void main(String[] args) {

		List<CuentaCaixa> cuentasCaixa = CuentaCaixa.listaCaixa(RUTA);
		System.out.println("Cuentas CAIXA: \n" + cuentasCaixa + "\n");
		List<CuentaSabadell> cuentasSabadell = CuentaSabadell.listaSabadell(RUTA);
		System.out.println("Cuentas SABADELL: \n" + cuentasSabadell + "\n");
		List<CuentaSantander> cuentasSantander = CuentaSantander.listaSantander(RUTA);
		System.out.println("Cuentas SANTANDER: \n" + cuentasSantander + "\n");
		
	}
}
