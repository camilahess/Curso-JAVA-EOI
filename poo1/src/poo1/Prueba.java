package poo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        //utilizamos el hashcode and equals
        if(todosParametros.equals(tresParametros)) {//comprueba si son el mismo coche por el criterio del hash and equals
        System.out.println("Son el mismo coche");
        } else { 
            System.out.println("Son coches distintos");
        }
        
        //Método adicional de nuevo o viejo // ESTADO 
        System.out.println(vacio.estado());
        
        //Método de estado rodado o no // RODADO
        if(todosParametros.rodado()) {
            System.out.println("El coche está en condiciones de uso");
        } else {
            System.out.println("El coche no ha sido probado");
        }
    }
    
    public static void ejercicio1Jugador() {
        Jugador num1 = new Jugador("Pepito", 20, -2000);
        Jugador num2 = new Jugador ("Pedrito", -28, 3400);
        Jugador num3 = new Jugador ("Tomi", 26, 2500);
        Jugador num4 = new Jugador ("Thiago", 19, 3800);
        System.out.println(num1);
        System.out.println(num2);
    }
    /**
     * Crea una lista o array y añade los 2 jugadores anteriores y 2 más a la misma y pon 2 posiciones intermedias a
     * null (6 elementos en la lista → 4 jugadores y 2 null)
     * Recorre la lista y muestra los datos de los jugadores (¡Cuidado con los null! Debes comprobarlos)
     */
    public static void ejercicio2Jugador() {
        // Creo una lista vacía para almacenar los jugadores
        List<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador("Fran", 45, 50000);
        Jugador jugador2 = new Jugador("David", 20, 60000);
        jugadores.add(jugador1);  // jugador que ocupa la posición 0 de la lista
        jugadores.add(jugador2); // jugador que ocupa la posición 1 de la lista
        jugadores.add(null);     // jugador que ocupa la posición 2 de la lista
        jugadores.add(null);     // jugador que ocupa la posición 3 de la lista
        Jugador jugador4 = new Jugador("Paco", 45, 50000);
        Jugador jugador5 = new Jugador("Luis", 20, 60000);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        //System.out.println(jugadores);
        
        // Programación estructurada
        /*for(Jugador jugador : jugadores) {
            //System.out.println(jugador);
            try {
                System.out.println(jugador.getNombre());
            } catch (Exception e) {
                System.out.println("Este jugador es un nulo");
            }
        }*/
        // Programación estructurada
        /*for(Jugador jugador : jugadores) {
            //System.out.println(jugador);
            if(jugador!=null)
                System.out.println(jugador.getNombre());            
        }*/

        jugadores.stream()
            .filter(e->e!=null)  // filtro para no trabajar con los nulos
            .forEach(e->System.out.println(e.getNombre()));  // obtengo el nombre de los que quedan

        /*
        jugadores.stream()
            .forEach(e->{
                if(e!=null)
                    System.out.println(e.getNombre());
            }); */
        /*
        jugadores.stream()
            .forEach(e->System.out.print((e!=null)?e.getNombre() + "\n":""));
        */
    }
    /**
     * Genera una nueva lista que sea una copia de la anterior. Que tenga los mismos elementos que la original.
     * Accede a un jugador en esta segunda lista y modifícale el nombre. Muestra por pantalla los datos del mismo
     * jugador en la otra lista.
     * ¿Han cambiado los datos del jugador en la misma posición de la primera lista?.
     * Intenta evitar que eso ocurra generando una copia de los jugadores de la primera lista para la segunda.
     */
    public static void ejercicio3Jugador() {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador("Fran", 45, 50000);
        Jugador jugador2 = new Jugador("David", 20, 60000);
        jugadores.add(jugador1);  // jugador que ocupa la posición 0 de la lista
        jugadores.add(jugador2); // jugador que ocupa la posición 1 de la lista
        jugadores.add(null);     // jugador que ocupa la posición 2 de la lista
        jugadores.add(null);     // jugador que ocupa la posición 3 de la lista
        Jugador jugador4 = new Jugador("Paco", 45, 50000);
        Jugador jugador5 = new Jugador("Luis", 20, 60000);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        List<Jugador> jugadores2 = new ArrayList<Jugador>(); // La segunda lista inicialmente está vacía
        // Copiar una lista a partir de otra con programación estructurada
        for(Jugador jugador : jugadores) {
            if(jugador!=null)
                jugadores2.add(new Jugador(jugador));
            else
                jugadores2.add(null);
        }
        /*jugadores.stream().forEach(e->{
            if(e!=null)
                jugadores2.add(new Jugador(e));
            else
                jugadores2.add(null);
        });*/
        jugadores2.get(0).setNombre("Posición 0");
        System.out.println(jugadores);
        System.out.println(jugadores2);
    }
    
    
    public static void ejemplosJugador() {
      //Creo lista vacía de jugadores para almacenar a todos
        List<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador fran = new Jugador("Fran", 45, 50000);
        Jugador david = new Jugador("David", 20, 60000);
        Jugador barbara = new Jugador("Bárbara", 23, 70000);
        Jugador camila = new Jugador("Camila", 22, 80000);
        Jugador joseLuis = new Jugador("José Luis", 18, 60000);
        Jugador enrique = new Jugador("Enrique", 15, 50000);
        Jugador atenea = new Jugador("Atenea", 20, 40000);
        Jugador angel = new Jugador("Ángel", 22, 1000000);
        Jugador nestor = new Jugador();
        nestor.setNombre("Néstor");
        nestor.setEdad(-20);
        nestor.setSueldo(-50000);
        Jugador francisco = new Jugador(fran);
        
        //utilizo el nuevo método para ocultar nombres
        System.out.println(nestor.nombreOculto());
        
        // Meter jugadores en la lista
          Collections.addAll(jugadores, fran,david,barbara,camila,joseLuis,enrique,atenea,angel,nestor);
//        jugadores.add(fran);
//        jugadores.add(david);
//        jugadores.add(barbara);
//        jugadores.add(camila);
//        jugadores.add(joseLuis);
//        jugadores.add(enrique);
//        jugadores.add(atenea);
//        jugadores.add(angel);
//        jugadores.add(nestor);      
//        jugadores.add(francisco);
//        jugadores.add(new Jugador("Naomi",20,80000));
        
        // Imprmir todos los jugadores
        jugadores.forEach(e->System.out.println(e));
        // Filtra e imprime:
        System.out.println("Jugadores que ganan más de 60000 euros");
        jugadores.stream()
            .filter(e->e.getSueldo()>60000)
            .forEach(e->System.out.println(e));
        // Filtra e imprime:
        System.out.println("Jugadores que ganan entre 50000 y 70000 euros y su nombre tenga más de 5 letras");
        jugadores.stream()
            .filter(e->e.getSueldo()>=50000 && e.getSueldo()<= 70000)
            .filter(e->e.getNombre().length()>5)
            .forEach(e->System.out.println(e));
        // Filtra e imprime:
        System.out.println("Jugadores que tengan una 'N' en su nombre");
        jugadores.stream()
            .filter(e->e.getNombre().toLowerCase().contains("n"))
            .forEach(e->System.out.println(e));
           
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
    
	public static void ejemplosEquipos () {
	    Equipo barsa = new Equipo(); // creo equipo 
	    barsa.setNombre("F.C. Barcelona");
	    barsa.setPresuAnual(40000000);
	    Estadio campNou = new Estadio(); //creo estadio 
	    campNou.setNombre("Camp Nou");
	    campNou.setCapacidad(100000);
	    barsa.setEstadio(campNou); //asigno el estadio al equipo
	    
	    //creo una lista de jugadores 
	    List<Jugador> jugadoresBarsa = new ArrayList<Jugador>(); //inicialmente vacía
	    //añado jugadores a la lista
	    jugadoresBarsa.add(new Jugador("Fran", 45, 100000));
	    jugadoresBarsa.add(new Jugador("Dani", 38, 200000));
	    jugadoresBarsa.add(new Jugador("Paco", 25, 150000));
	    jugadoresBarsa.add(new Jugador("Pedro ",30, 180000));
	    jugadoresBarsa.add(new Jugador("Juan", 33, 180000));
	    barsa.setJugadores(jugadoresBarsa); // asigno la lista de jugadores creada al equipo=barsa
	    
	    System.out.println(barsa);
	    
	    //probamos el constructor de copia
	    Equipo madrid = new Equipo(barsa);
	    madrid.setNombre("Real Madrid");
	    madrid.setPresuAnual(10000);
	    barsa.getEstadio().setNombre("Nuevo Campo");
	    madrid.getEstadio().setNombre("Santiago Bernabeu");
	    madrid.getEstadio().setCapacidad(80000);
	    
	    //Cambiar cosas de los jugadores
	    barsa.getJugadores().get(0).setNombre("Francisco");
	    madrid.getJugadores().get(1).setNombre("Ate");
	    
	    //impresión de los equipos
	    System.out.println(barsa);
	    System.out.println(madrid);
	    
	}
	
	public static void falloSiNoSeCorrige() {
        Equipo equipo = new Equipo();
        Jugador fran = new Jugador("Fran", 45, 50000);
        equipo.getJugadores().add(fran);
        equipo.getEstadio().setNombre("Mi estadio");
        System.out.println("Fin del programa");
    }
	
	   public static void ejercicio4() {
	        Equipo equipo = new Equipo();
	        equipo.setNombre("Equipo EOI");
	        equipo.addJugador(new Jugador("Fran",25,100000));  // añade jugadores a la lista
	        equipo.addJugador(new Jugador("Paco",25,100000));
	        equipo.addJugador(new Jugador("Luis",25,100000));
	        equipo.addJugador(new Jugador("Jose",25,100000));
	        //equipo.deleteJugador(0);  // borra el primer elemento
	        equipo.getJugadores().forEach(e->System.out.println(e));  // Muestra todos los jugadores de la lista
	        System.out.println("El sueldo de todos los jugadores es: " + equipo.totalSueldos());                
	    }
	    
	    /*public static void ejercicio4ampliacionConceptoNoVoid() {
	        Equipo equipo = new Equipo();
	        equipo.setNombre("Equipo EOI");
	        //equipo.setJugadores(null);
	        if(equipo.addJugador(new Jugador("Fran",25,100000)))
	            System.out.println(equipo);
	        else
	            System.out.println("No se ha podido añadir el jugador");
	    }*/
	   
    public static void main (String[] args) {
//	    sc = new Scanner (System.in);
//		//ejemploPersonas();
//	    ejemplosCoches();
//	    menu();
//	    sc.close();
	    //ejercicioJugador();
		//ejemplosJugador();
        //ejemplosEquipos();
        ejercicio4();
        
	}
}
