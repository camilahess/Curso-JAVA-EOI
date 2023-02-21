package com.camilahess2.proyectoClases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuentaSabadell extends Cuenta {
	
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
			this.nivelCatalan = NivelCatalan.Bajo;
		}
		
		public CuentaSabadell(String dniCif, String nombreCliente, LocalDate fechaNacimientoCliente, String codigoPais,
				int saldo, NivelCatalan nivelCatalan) {
			super(dniCif, nombreCliente, fechaNacimientoCliente, codigoPais, saldo);
			this.nivelCatalan = nivelCatalan;
		}
		
		public static List<CuentaSabadell> listaSabadell(String RUTA) {
			List<CuentaSabadell> datosBanco = new ArrayList<>();
			try {
				Path path = Paths.get(RUTA, "caixa.txt"); //transformo la ruta
				List<String> lineas = Files.readAllLines(path);
				for (String linea:lineas) {
					List<String> datosLinea = new ArrayList<>(Arrays.asList(linea.split(";")));
					datosBanco.add(new CuentaSabadell(
							datosLinea.get(0), // dni_cif
							datosLinea.get(1), //nombre_cliente
							LocalDate.parse(datosLinea.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")), // fechaNacimiento
							datosLinea.get(3), // codigo_pais
							Integer.parseInt(datosLinea.get(4)))); // saldo
				}
			} catch (IOException e) {
				System.err.println("Error leyendo el archivo ");
			}
			return datosBanco;
		}
}

