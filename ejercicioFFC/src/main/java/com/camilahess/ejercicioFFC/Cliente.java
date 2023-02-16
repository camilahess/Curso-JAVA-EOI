package com.camilahess.ejercicioFFC;

import java.time.LocalDate;

public class Cliente {

	private String dniCif;
    private String nombre;
    private String fechaNacimiento;
    private String codigoPais;
    private double saldo;
    
    
	public Cliente(String dniCif, String nombre, String fechaNacimiento, String codigoPais, double saldo) {
		super();
		this.dniCif = dniCif;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoPais = codigoPais;
		this.saldo = saldo;
	}


	public String getDniCif() {
		return dniCif;
	}



	public String getNombre() {
		return nombre;
	}



	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getCodigoPais() {
		return codigoPais;
	}


	public double getSaldo() {
		return saldo;
	}



	@Override
	public String toString() {
		return "Cliente [dniCif=" + dniCif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", codigoPais=" + codigoPais + ", saldo=" + saldo + "]";
	}
    
	
    
    
}
