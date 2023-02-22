package com.camilahess2.proyectoClases.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Cuenta {
	
	protected static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private String dniCif;
	private String nombreCliente;
	private LocalDate fechaNacimiento;
	private String codigoPais;
	private int saldo;
	
	
	public Cuenta() {
	
	}


	public Cuenta(String dniCif, String nombreCliente, LocalDate fechaNacimiento, String codigoPais, int saldo) {
		this.dniCif = dniCif;
		this.nombreCliente = nombreCliente;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoPais = codigoPais;
		this.saldo = saldo;
	}

	public Cuenta(Cuenta c) {
		this.dniCif = c.dniCif;
		this.nombreCliente = c.nombreCliente;
		this.fechaNacimiento = c.fechaNacimiento;
		this.codigoPais = c.codigoPais;
		this.saldo = c.saldo;
	}


	public String getDniCif() {
		return dniCif;
	}


	public void setDniCif(String dniCif) {
		this.dniCif = dniCif;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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


	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	@Override
	public String toString() {
		return "Cuenta [dniCif=" + dniCif + ", nombreCliente=" + nombreCliente + ", fechaNacimiento=" + fechaNacimiento
				+ ", codigoPais=" + codigoPais + ", saldo=" + saldo + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigoPais, dniCif, fechaNacimiento, nombreCliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(codigoPais, other.codigoPais) && Objects.equals(dniCif, other.dniCif)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombreCliente, other.nombreCliente);
	}

	
	
	
}
