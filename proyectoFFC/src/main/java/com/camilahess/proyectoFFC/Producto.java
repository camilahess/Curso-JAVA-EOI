package com.camilahess.proyectoFFC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Producto {

	private int edadMinima;
	private int edadMaxima;
	private int saldoMinimo;
	private int saldoMaximo;
	private String nombre;

	public Producto(int edadMinima, int edadMaxima, int saldoMinimo, int saldoMaximo, String nombre) {
		super();
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.saldoMinimo = saldoMinimo;
		this.saldoMaximo = saldoMaximo;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public int getSaldoMinimo() {
		return saldoMinimo;
	}

	public int getSaldoMaximo() {
		return saldoMaximo;
	}

	@Override
	public String toString() {
		return "Producto [edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", saldoMinimo=" + saldoMinimo
				+ ", saldoMaximo=" + saldoMaximo + ", nombre=" + nombre + "]";
	}

	public static List<Producto> leerProductos(String ruta) {
		List<Producto> productos = new ArrayList<>();
		try {
			Path path = Paths.get(ruta, "productosofertados.txt"); // transformo la ruta
			List<String> lineas = Files.readAllLines(path);
			for (String linea : lineas) {
				String[] datos = linea.split(";");
				Producto producto = new Producto(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]),
						Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4]);
				productos.add(producto);
			}
		} catch (IOException e) {
			System.out.println("Fichero de productos a ofertar no encontrado");
		}
		return productos;
	}

}