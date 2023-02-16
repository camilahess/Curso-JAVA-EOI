package com.camilahess.ejercicioFFC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Producto {
	private String nombre;
	private int edadMinima;
	private int edadMaxima;
	private double saldoMinimo;
	private double saldoMaximo;

	public Producto(String nombre, int edadMinima, int edadMaxima, double saldoMinimo, double saldoMaximo) {
		super();
		this.nombre = nombre;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.saldoMinimo = saldoMinimo;
		this.saldoMaximo = saldoMaximo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public double getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public double getSaldoMaximo() {
		return saldoMaximo;
	}

	public void setSaldoMaximo(double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}


}