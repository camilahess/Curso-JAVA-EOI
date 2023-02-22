package com.camilahess2.proyectoClases.entidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuentaSantander extends Cuenta {
	private static int numCuentas = 0; //contador de clase, variable única para TODAS las cuentas de Santander
	
	private boolean isResidente; //false  
	
	
	public CuentaSantander() {
		super();
		this.isResidente = false;
		numCuentas++;
	}  
	
	public CuentaSantander(String dniCif, String nombreCliente, LocalDate fechaNacimientoCliente, String codigoPais,
			int saldo) {
		super(dniCif, nombreCliente, fechaNacimientoCliente, codigoPais, saldo);
		this.isResidente = false;
		numCuentas++;
	}
	
	public CuentaSantander(String dniCif, String nombreCliente, LocalDate fechaNacimientoCliente, String codigoPais,
			int saldo, boolean residente) {
		super(dniCif, nombreCliente, fechaNacimientoCliente, codigoPais, saldo);
		this.isResidente = residente;
		numCuentas++;
	}

	public CuentaSantander(CuentaSantander c) {
		super(c);
		this.isResidente = c.isResidente;
		numCuentas++;
	}
	
	public boolean isResidente() {
		return isResidente;
	}

	public void setResidente(boolean isResidente) {
		this.isResidente = isResidente;
	}
	
	
	public static int getNumCuentas() {
		return numCuentas;
	}

	public static void setNumCuentas(int numCuentas) {
		CuentaSantander.numCuentas = Math.abs(numCuentas);
	}

	@Override
	public String toString() {
		return "DNI-CIF: " +getDniCif() 
		+ "\nCliente: " +getNombreCliente() 
		+ "\nFecha Nacimiento: " + getFechaNacimiento().format(FORMATO)
		+ "\nCódigo País: "+ getCodigoPais()
		+"\nSaldo: " +getSaldo()+"€"
		+"\n" +(isResidente?"Residente de Santander" : "No residente de Santander") + "\n";
	}
	
	public static List<CuentaSantander> listaSantander(String RUTA) {
		List<CuentaSantander> datosBanco = new ArrayList<>();
		try {
			Path path = Paths.get(RUTA, "santander.txt"); //transformo la ruta
			List<String> lineas = Files.readAllLines(path);
			for (String linea:lineas) {
				List<String> datosLinea = new ArrayList<>(Arrays.asList(linea.split(";")));
				datosBanco.add(new CuentaSantander(
						datosLinea.get(0), 
						datosLinea.get(1), 
						LocalDate.parse(datosLinea.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
						datosLinea.get(3),
						Integer.parseInt(datosLinea.get(4))));
			}
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo ");
		}
		return datosBanco;
	}
	
	

	
	
}
