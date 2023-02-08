package poo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prueba {
//Este lleva el main, las demás clases que llevan objetos NO TIENEN EL MAIN
    
    static Scanner sc; // El scanner declarado arriba para usar en todo el programa
    
    //Lista de coches vacía
    static List<Coche> coches = new ArrayList<Coche>(); // La lista se declara arriba para usar en todo el programa
    
    public static void ejemploPersonas() {
        
    Persona vacia = new Persona (); // Llama al constructor vacío, sin parámetros
        
        //public Persona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento) 
        Persona camila = new Persona("Camila", "Hess", "Y7764530C", "652221747", LocalDate.parse("1993-05-18"));
        Persona thiago = new Persona("Thiago", "Baruffaldi", "Y7764547Y", "652221748", LocalDate.of(2010,10,25));
        
        System.out.println(camila); //Llama al método toString definido en persona.java
        
        //Darle información a persona vacia con SET 
        vacia.setNombre("Carolina");
        vacia.setApellido("Unrein");
        
        //System.out.println(vacia);
        System.out.println("Nombre de vacia: " + vacia.getNombre()); //get obtiene valores de los campos
        System.out.println("Apellido de vacia: " + vacia.getApellido());
        
        //Método adicional para saber si una persona es mayor o menor 
        
        if (thiago.esMayorEdad())
            System.out.println("Thiago es mayor de edad");
        else 
            System.out.println("Thiago no es mayor de edad"); 
        
    }
	
    
    public static void ejemplosCoches() {
        //Crear coches
        Coche vacio = new Coche(); //Crea un coche vacío 
        vacio.setMarca("Seat"); // solo podemos acceder por encapsulamiento
        vacio.setModelo("Panda");
        vacio.setAnyo(2019);
        System.out.println(vacio);
        
        Coche todosParametros = new Coche("000AAA", "Panda", "Seat", 1990, 80000); //Coche con todos los parámetros
        Coche tresParametros = new Coche("111BBB", "Z3", "BMW"); //Crear coche con algunos parámetros
        Coche copia = new Coche(todosParametros); //Esto usa el constructor de copia, con un coche ya creado
        
        
        System.out.println(todosParametros.getMatricula()); //Uso el get para ver que matricula tiene
        todosParametros.setMatricula("1234ABC"); //Con el set cambiamos datos, le cambiamos la matricula a ese coche
        System.out.println(todosParametros.getMatricula()); //Ahora la matricula del mismo coche, ya ha cambiado
        
        tresParametros.setMatricula("1235BBBBBBBB"); //Nuestro método creado en el setter corta el string
        System.out.println(tresParametros.getMatricula());
        todosParametros.setKms(-40000);
        System.out.println(todosParametros.getKms()); //pasa los kms a positivo 
        
        System.out.println(todosParametros); //Llamamos al toString completo
        
        //Si la matricula es la misma, será el mismo coche
        
        if(todosParametros.equals(tresParametros)) {//comprueba si son el mismo coche por el criterio del hash and equals
        System.out.println("Son el mismo coche");
        } else { 
            System.out.println("Son coches distintos");
        }
        
        //Método adicional de nuevo o viejo // ESTADO 
        System.out.println(vacio.estado());
        
        //Método de estado rodado o no // RODADO
        if(vacio.rodado()) {
            System.out.println("El coche está en condiciones de uso");
        } else {
            System.out.println("El coche no ha sido probado");
        }
    }
    
    
    
    public static void darAlta() {
        //Cogemos los datos, creamos un coche, y ese coche lo agregamos a la lista
        System.out.println("Introduzca la matricula: ");
        String matricula = sc.nextLine();
        System.out.println("Introduzca el modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Introduzca la marca: ");
        String marca = sc.nextLine();
        System.out.println("Introduzca el año: ");
        int anyo = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca los kms: ");
        int kms = Integer.parseInt(sc.nextLine());
        Coche alta = new Coche (matricula, modelo, marca, anyo, kms);
        coches.add(alta);
        
                
        
        
    }
    
    public static void darBaja () {
        //borrar el primer coche que encuentre con esa matricula
        System.out.println("Introduzca la matricula a eliminar: ");
        String matriculaBuscar = sc.nextLine();

        //primera forma, recorro la lista y si coincide con la matricula, elimino el elemento
        //Borra el coche , completo, que coincide con la matricula
       
        
        for (Coche c: coches) { // para cada c de la lista de coches
            if(c.getMatricula().equals(matriculaBuscar)) {
                coches.remove(c);
                break;
                
            }
        }
    }
    
    
    
    public static void menu () {
        int opcion;
        do {
        System.out.println("Menú: Introduzca opción ");
        System.out.println("1. Dar de alta un coche");
        System.out.println("2. Dar de baja un coche");
        System.out.println("3. Modificar un coche");
        System.out.println("4. Número de coches rodados en la empresa");
        System.out.println("5. Mostrar coches de la empresa");
        System.out.println("0. Salir");
        
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
        case 1: 
            darAlta();
            break;
                
        case 2: 
            darBaja();
            break;
                
        case 3:
            
            break;
        case 4:
           System.out.println(coches.stream().filter(c->c.rodado() == true).count());
            break;
        case 5:
            coches.forEach(e->System.out.println(e)); //Mostrar coches de la lista
            break;
        case 0:
            break;
            
        default:
            break;
        }
      }  while (opcion!=0); // el cero me hace salir
        System.out.println("Gracias por confiar en nosotros");
        
    }
    
	public static void main (String[] args) {
//	    sc = new Scanner (System.in);
//		//ejemploPersonas();
	    ejemplosCoches();
//	    menu();
//	    sc.close();
//		
	}
}
