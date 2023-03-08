package com.camilahess.harrypotter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
	    String sql = "INSERT INTO personaje(id, name, species, gender, house, dateOfBirth, yearOfBirth, wizard, ancestry, eyeColour, hairColour, patronus, hogwartsStudent, hogwartsStaff, actor, alive, image) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection con = DriverManager.getConnection(URI, USER, PASSWORD);
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        for (CharacterHP personaje : personajes) {
	            ps.setString(1, personaje.getId());
	            ps.setString(2, personaje.getName());
	            ps.setString(3, personaje.getSpecies());
	            ps.setString(4, personaje.getGender());
	            ps.setString(5, personaje.getHouse());
	            ps.setObject(6, personaje.getDateOfBirthLD());
	            ps.setInt(7, personaje.getYearOfBirth() != null ? personaje.getYearOfBirth() : 0);
	            ps.setBoolean(8, personaje.getWizard());
	            ps.setString(9, personaje.getAncestry());
	            ps.setString(10, personaje.getEyeColour());
	            ps.setString(11, personaje.getHairColour());
	            ps.setString(12, personaje.getPatronus());
	            ps.setBoolean(13, personaje.getHogwartsStudent());
	            ps.setBoolean(14, personaje.getHogwartsStaff());
	            ps.setString(15, personaje.getActor());
	            ps.setBoolean(16, personaje.getAlive());
	            ps.setString(17, personaje.getImage()); 
	            ps.executeUpdate();
	        }

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
