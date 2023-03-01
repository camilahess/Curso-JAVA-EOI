package com.camilahess.harrypotter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.camilahess.harrypotter.entidades.CharacterHP;
import com.camilahess.harrypotter.utilidades.JsonUtils;
import com.camilahess.harrypotter.utilidades.SerializationUtils;


public class App 
{
	static List<CharacterHP> personajes = new ArrayList<CharacterHP>();
	
	public static void ejemploSerializar() {
		 //Probamos la serialización
	       if(SerializationUtils.serializarListaObjetos("personajes.txt", personajes)) {
	    	   System.out.println("La serialización fue satisfactoria");
	       }else { 
	    	   System.out.println("La serialización falló");
	       }
	       
	}
	
	public static void objetenerDatosApi() {
		//Lista de personajes almacenada en lista, que obtendremos del método devolverArrayGsonGenerico
	       personajes = JsonUtils.devolverArrayGsonGenerico("https://hp-api.onrender.com/api/characters", CharacterHP[].class);
	       personajes.stream()
	       .filter(e->e.getName().equals("Harry Potter"))
	       .forEach(e->System.out.println(e));
	       
	}
	
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
    public static void main( String[] args )
    {
    	//obtenerDatosApi();
    	//rellenarFechaNacLD();
       //ejemploSerializar();
      
    }
}
