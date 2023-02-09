package poo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {

    
    private String nombre; //variables básica String y Double
    private double presuAnual;
    private Estadio estadio; //un equipo tiene un OBJETO ESTADIO , de tipo Estadio
    private List<Jugador> jugadores; //también tiene una lista de Jugadores
    
    
    public Equipo() {  // El constructor vacío que contenga objetos o listas de objetos debe asignar memoria para ellos.
        estadio = new Estadio();
        jugadores = new ArrayList<Jugador>(); // Creamos el objeto para poder meter elementos
    }


    public Equipo(String nombre, double presuAnual, Estadio estadio, List<Jugador> jugadores) {
        super();
        this.nombre = nombre;
        this.presuAnual = presuAnual;
        this.estadio = estadio;
        this.jugadores = jugadores;
    }
    
    //constructor de copia
    public Equipo(Equipo e) {
        super();
        this.nombre = e.nombre;
        this.presuAnual = e.presuAnual;
     // this.estadio = e.estadio; //esto está mal, no está creando un nuevo objeto de copia
     // this.jugadores = e.jugadores; //esto está mal, no está creando un nuevo objeto de copia
        //FORMA CORRECTA DE COPIAR UN OBJETO 
        this.estadio = new Estadio(e.estadio); // ahora ya creo un nuevo estadio a partir de otro
        
        //FORMA CORRECTA DE COPIAR UNA LISTA DE OBJETOS (copia de profundidad de una lista)
        this.jugadores = new ArrayList<Jugador>(); //primero creo la lista vacía
        //Coge el equipo de base, para cada elemento de ese equipo(j), añade ese jugador en la nueva lista
        e.getJugadores().forEach(j->this.jugadores.add(new Jugador(j)));
        
    }
    
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPresuAnual() {
        return presuAnual;
    }


    public void setPresuAnual(double presuAnual) {
        this.presuAnual = presuAnual;
    }


    public Estadio getEstadio() {
        return estadio;
    }


    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }


    public List<Jugador> getJugadores() {
        return jugadores;
    }


    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }


    @Override
    public String toString() {
        return nombre + "\n" + presuAnual + "\n" + estadio + "\nJugadores="
                + jugadores;
    }


    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipo other = (Equipo) obj;
        return Objects.equals(nombre, other.nombre);
    }
    
    
}
