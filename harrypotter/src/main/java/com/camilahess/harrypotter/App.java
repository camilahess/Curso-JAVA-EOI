package com.camilahess.harrypotter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.camilahess.harrypotter.entidades.CharacterHP;
import com.camilahess.harrypotter.utilidades.JsonUtils;


public class App 
{
	static List<CharacterHP> personajes = new ArrayList<CharacterHP>();
	
    public static void main( String[] args )
    {
    	//Lista de personajes almacenada en lista, que obtendremos del método devolverArrayGsonGenerico
       personajes = JsonUtils.devolverArrayGsonGenerico("https://hp-api.onrender.com/api/characters", CharacterHP[].class);
       personajes.stream()
       .filter(e->e.getName().equals("Harry Potter"))
       .forEach(e->System.out.println(e));
       
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
}
