package poo1;

import java.time.LocalDate;

public class Persona {
	
	//Atributos / propiedades de la clase 
	String nombre;
	String apellido;
	String dni;
	String telefono;
	LocalDate fechaNacimiento;
	
	//Constructores , crear persona , constructor vacío
	public Persona() {
		
	}
	
	//Constructor con todo 
	//Source GENERATE CONSTRUCTOR USING FIELDS
	public Persona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	
	//Getters and Setters, modificar los datos de una persona ya creada. Coger info y modificar
		//SOURCE, GENERATE GETTERS AND SETTERS
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	//Imprimir una persona toString()
	//SOURCE, GENERATE toString()
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	
	
}
