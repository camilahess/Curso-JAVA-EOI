package com.camilahess.ejercicioFFC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {

	private String dniCif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String codigoPais;
	private int saldo;

	public Cliente(String dniCif, String nombre, String fechaNacimiento, String codigoPais, int saldo) {
		super();
		this.dniCif = dniCif;
		this.nombre = nombre;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.codigoPais = codigoPais;
		this.saldo = saldo;
	}

	public String getDniCif() {
		return dniCif;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public int getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Cliente [dniCif=" + dniCif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", codigoPais=" + codigoPais + ", saldo=" + saldo + "]";
	}
	
	// Leo los archivos txt y guardo en una lista los datos
	public static List<Cliente> leerClientes(String ruta) {
		List<Cliente> clientes = new ArrayList<>();
		List<String> nombresArchivos = Arrays.asList("caixa.txt", "santander.txt", "sabadell.txt");
		for (String nombreArchivo : nombresArchivos) {
			try {
				Path path = Paths.get(ruta, nombreArchivo); //transformo la ruta
				List<String> lineas = Files.readAllLines(path);
				for (String linea : lineas) {
					String[] datos = linea.split(";");
					Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
					clientes.add(cliente);
				}
			} catch (IOException e) {
				System.out.println("Error leyendo ficheros de bancos");
			}
		}
		return clientes;
	}

}

