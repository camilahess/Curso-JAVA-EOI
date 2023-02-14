package poo1;

import java.util.Objects;

public class Jugador implements IHablador { // implementa la interface

    private String nombre;
    private int edad;
    private double sueldo;

    public Jugador() {
    }

    // Filtrar en los setter y en los constructores
    public Jugador(String nombre, int edad, double sueldo) {
        super();
        this.nombre = nombre;
        this.setEdad(edad); // controlo que cuando se cree el jugador, el negativo se pasa a positivo
        this.setSueldo(sueldo); // Lo mismo, controlado por el setter sueldo
    }

    public Jugador(Jugador j) {
        super();
        this.nombre = j.nombre;
        this.setEdad(j.edad);
        this.setSueldo(j.sueldo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = Math.abs(edad);
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = Math.abs(sueldo);
    }

    @Override
    public String toString() {
        return "[nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(edad, nombre, sueldo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador other = (Jugador) obj;
        return edad == other.edad && Objects.equals(nombre, other.nombre)
                && Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
    }

    // método adicional nombre oculto

    public String nombreOculto() {
        return nombre.substring(0, 2) + "*".repeat(nombre.length() - 2);
    }

    @Override
    public void hablar() {
        System.out.println("Hola");

    }

    @Override
    public void gritar() {
        System.out.println("HOLAAAA");

    }

}
