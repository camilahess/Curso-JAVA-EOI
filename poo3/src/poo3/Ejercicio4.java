package poo3;

public class Ejercicio4 {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Empleado fran = new Empleado("Fran",10000);  // puedo crear el empleado y luego añadirlo a la lista
		empresa.getEmpleados().add(fran);
		empresa.getEmpleados().add(new Empleado("Dani",20000));  // Creo el empleado sobre la marcha añadiéndolo a la empresa
		empresa.getEmpleados().add(new Empleado("Paco",10000));  // Creo el empleado sobre la marcha añadiéndolo a la empresa
		
		Empresa copia = new Empresa(empresa);  // Copiar una empresa a partir de otra
		copia.getEmpleados().get(0).setNombre("Francisco");  // Cambio el nombre al primer empleado
		copia.getDireccion().setNumero(10);  // Cambiar el número de la calle de la dirección de la empresa copia
		copia.getEmpleados().add(new Empleado("Nuevo",30000));  // Añado un nuevo empleado en la copia
		
		// Mostramos los valores de la empresa original y de la copia
		System.out.println("Empresa original");
		System.out.println(empresa);
		System.out.println("La empresa original tiene " + empresa.getEmpleados().size());
		System.out.println("Empresa copia");
		System.out.println(copia);
		System.out.println("La empresa copia tiene " + copia.getEmpleados().size() + " empleados");
		
	}
	
	
}