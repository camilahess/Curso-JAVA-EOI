package com.camilahess2.proyectoClases.entidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.camilahess2.proyectoClases.enumerados.NivelCatalan;

public final class CuentaSabadell extends Cuenta {
	
		private NivelCatalan nivelCatalan;

		public NivelCatalan getNivelCatalan() {
			return nivelCatalan;
		}

		public void setNivelCatalan(NivelCatalan nivelCatalan) {
			this.nivelCatalan = nivelCatalan;
		}
		
		public CuentaSabadell() {
			super();
		}

		public CuentaSabadell(String dniCif, String nombreCliente, LocalDate fechaNacimientoCliente, String codigoPais,
				int saldo) {
			super(dniCif, nombreCliente, fechaNacimientoCliente, codigoPais, saldo);
			this.nivelCatalan = NivelCatalan.Medio;
		}
		
		public CuentaSabadell(String dniCif, String nombreCliente, LocalDate fechaNacimientoCliente, String codigoPais,
				int saldo, NivelCatalan nivelCatalan) {
			super(dniCif, nombreCliente, fechaNacimientoCliente, codigoPais, saldo);
			this.nivelCatalan = nivelCatalan;
		}
		
		@Override
		public String toString() {
			return "DNI-CIF: " +getDniCif() 
			+ "\nCliente: " +getNombreCliente() 
			+ "\nFecha Nacimiento: " + getFechaNacimiento().format(FORMATO)
			+ "\nCódigo País: "+ ((getCodigoPais().equals("ES"))? "(España)" :  "(Reino Unido)")
			+"\nSaldo: " +(double)(getSaldo())+"€"
			+"\nNivel Catalán: "+nivelCatalan + "\n";
		}

		public static List<CuentaSabadell> listaSabadell(String RUTA) {
			List<CuentaSabadell> datosBanco = new ArrayList<>();
			try {
				Path path = Paths.get(RUTA, "sabadell.txt"); //transformo la ruta
				List<String> lineas = Files.readAllLines(path);
				for (String linea:lineas) {
					List<String> datosLinea = new ArrayList<>(Arrays.asList(linea.split(";")));
					datosBanco.add(new CuentaSabadell(
							datosLinea.get(0), 
							datosLinea.get(1), 
							LocalDate.parse(datosLinea.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
							datosLinea.get(3), 
							Integer.parseInt(datosLinea.get(4)))); 
				}
			} catch (IOException e) {
				System.err.println("Error leyendo el archivo ");
			}
			return datosBanco;
		}
}

