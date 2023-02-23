package com.camilahess2.proyectoClases.metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.camilahess2.proyectoClases.entidades.Cuenta;
import com.camilahess2.proyectoClases.entidades.CuentaCaixa;
import com.camilahess2.proyectoClases.entidades.CuentaSabadell;
import com.camilahess2.proyectoClases.entidades.CuentaSantander;

public class Metodos {

	public static List<Cuenta> unirListas(List<CuentaCaixa> cuentasCaixa, List<CuentaSabadell> cuentasSabadell, List<CuentaSantander> cuentasSantander ) {
		List<Cuenta> todasLasCuentas = new ArrayList<Cuenta>();
		todasLasCuentas.addAll(cuentasCaixa);
		todasLasCuentas.addAll(cuentasSabadell);
		todasLasCuentas.addAll(cuentasSantander);
		return todasLasCuentas;
	}
	 public static Cuenta borrarCuentaAzar(List<Cuenta> todasLasCuentas) {
	        Random random = new Random();
	        int index = random.nextInt(todasLasCuentas.size());
	        Cuenta elemento = todasLasCuentas.remove(index);
	        return elemento;
	    }
	 
}

