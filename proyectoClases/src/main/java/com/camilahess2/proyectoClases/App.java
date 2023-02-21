package com.camilahess2.proyectoClases;

import java.util.List;

public class App {
	private static final String RUTA = "ficheros/";
	
	public static void main(String[] args) {

		List<CuentaCaixa> cuentasCaixa = CuentaCaixa.listaCaixa(RUTA);
		System.out.println(cuentasCaixa);
	}
}
