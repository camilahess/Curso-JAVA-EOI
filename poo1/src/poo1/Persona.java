package poo1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
	//1- CREAR LOS ATRIBUTOS
    //2 - Crear los constructores ( vacío, todos los parámetros )
    //2b opcional - Crear más constructores y el de copia
    //3 - Crear Getters and Setters
    //4 - Crear toString
    //5 - Crear  hashCode and Equals
    //6 opcional - Métodos adicionales
    
    
	//Atributos / propiedades de la clase 
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private LocalDate fechaNacimiento;
	
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

	//Persona es igual a otra persona solo si tienen el mismo DNI 
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(dni, other.dni);
    }
	
	
	//Nuevo método para saber si es o no mayor de edad la persona
	//Con LOCAL DATE
    public boolean esMayorEdad() {
        //Period para obtener dias, meses o años.
        Period edad = Period.between(this.fechaNacimiento, LocalDate.now()); // Esto saca un periodo de tiempo
        int anyos = Math.abs(edad.getYears()); // El math abs, da un valor absoluto en positivo siempre
        if (anyos>=18)
            return true;
        else 
            return false;
        
    }
}
