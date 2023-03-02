package com.camilahess.harrypotter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.camilahess.harrypotter.entidades.CharacterHP;
import com.camilahess.harrypotter.utilidades.JsonUtils;
import com.camilahess.harrypotter.utilidades.SerializationUtils;


//LECTURA DE UNA API Y CARGA EN UNA BASE DE DATOS

public class App 
{
	static List<CharacterHP> personajes = new ArrayList<CharacterHP>();
	//Conexión a la BBDD
	final static String URI = "jdbc:mysql://localhost:3306/harry_potter";
	final static String USER = "root";
	final static String PASSWORD ="";
	public static Connection con;
	
	
	public static void ejemploSerializar() {
		 //Probamos la serialización
	       if(SerializationUtils.serializarListaObjetos("personajes.txt", personajes)) {
	    	   System.out.println("La serialización fue satisfactoria");
	       }else { 
	    	   System.out.println("La serialización falló");
	       }
	       
	}
	
	public static void obtenerDatosApi() {
		//Lista de personajes almacenada en lista, que obtendremos del método devolverArrayGsonGenerico
	       personajes = JsonUtils.devolverArrayGsonGenerico("https://hp-api.onrender.com/api/characters", CharacterHP[].class);
	       personajes.stream()
	       .filter(e->e.getName().equals("Harry Potter"))
	       .forEach(e->System.out.println(e));
	       
	}
	
	//Date of birth LOCAL DATE
	public static void rellenarFechaNacLD() {
		// Rellenar el campo dateOfBirthLD
	       personajes.stream()
	       .peek(e->{
	       	if(e.getDateOfBirth()!=null) {
	       		e.setDateOfBirthLD(LocalDate.parse(e.getDateOfBirth(),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	       	}
	       })
	       .filter(e->e.getName().equals("Harry Potter"))
	       .forEach(e->System.out.println(e));
	   
	}
	
	public static void ejemploDesSerializar() {
		personajes = SerializationUtils.desSerializarListaObjetos("personajes.dat");
	}
	
	public static void mostrarPersonajes() {
		personajes.forEach(e->System.out.println(e));
	}
	
	public static void probarConexión() {
		con = null;
		try {
			con = DriverManager.getConnection(URI, USER, PASSWORD);
			System.out.println("La conexión se realizó correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la conexión");
		}
	}
	
	public static void poblarbBbdd() {
		String sql = "";
		Statement st;
		con = null;
		try {
			con = DriverManager.getConnection(URI, USER, PASSWORD);
			st = con.createStatement();
			
			for(CharacterHP personaje: personajes) {
				sql ="INSERT INTO personaje(id,name) VALUES('" +
						personaje.getId() + "','" + 
						personaje.getName() + 
					"');";
				st.executeUpdate(sql); //Por duplicidad de clave primaria no podríamos hacerlo dos veces
				
			}
		
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en la conexión");
		}
	}
	
    public static void main( String[] args )
    {
    	//PROCESO DE SERIALIZACIÓN
    	//obtenerDatosApi();
    	//rellenarFechaNacLD();
        //ejemploSerializar();
    	
    	//PROCESO DE DES-SERIALIZACIÓN
    	//ejemploDesSerializar();
    	//rellenarFechaNacLD();
    	//mostrarPersonajes();
    	
    	//PROCESO DE CARGA EN BASE DE DATOS
    	//probarConexión();
    	obtenerDatosApi();
    	rellenarFechaNacLD();
    	poblarbBbdd();
    	
    }
}
