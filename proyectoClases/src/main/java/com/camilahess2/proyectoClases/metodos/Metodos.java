package com.camilahess2.proyectoClases.metodos;

import java.util.List;
import java.util.Random;

import com.camilahess2.proyectoClases.entidades.Cuenta;

public class Metodos {

	 public static Cuenta borrarCuentaAzar(List<Cuenta> todasLasCuentas) {
	        Random random = new Random();
	        int index = random.nextInt(todasLasCuentas.size());
	        Cuenta elemento = todasLasCuentas.remove(index);
	        return elemento;
	    }
	 
}

