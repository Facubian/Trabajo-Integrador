package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import objetos.Partidos;
import objetos.Pronostico;

public class Principal {

	public static void main(String[] args) {
		
		Partidos partidos = new Partidos(); //Declaro al objeto partidos
		
		System.out.println("Resultados de partidos");
		//Llamo al archivo resultados.csv y leo y cargo la info en el objeto
		try {
			File resultados = new File("src/principal/resultados.csv");
			Scanner sc = new Scanner(resultados);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				
				partidos.setEquipo1(linea.split(";")[0]);
				partidos.setPuntaje1(linea.split(";")[1]);
				partidos.setPuntaje2(linea.split(";")[2]);
				partidos.setEquipo2(linea.split(";")[3]);
				
			}
			sc.close();
			
		} catch (FileNotFoundException e) { //En caso de no encontrarse el archivo, dar aviso
			System.out.println("No se encontro el archivo"); 
			e.printStackTrace();
		}
		
		Pronostico pronostico = new Pronostico(); //Declaro al objeto pronostico
		
		System.out.println("Pronostico");
		//Llamo al archivo pronostico.csv y leo y cargo la info en el objeto
		try {
			File resultados = new File("src/principal/pronostico.csv");
			Scanner sc = new Scanner(resultados);
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				
				pronostico.setEquipo1(linea.split(";")[0]);
				pronostico.setGana1(linea.split(";")[1]);
				pronostico.setEmpata(linea.split(";")[2]);
				pronostico.setGana2(linea.split(";")[3]);
				pronostico.setEquipo2(linea.split(";")[4]);
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo");
		     e.printStackTrace();
		}
		
		//Llamo a funcion para ver los resultados de los partidos por pantalla
		mostrarResultados(partidos);
		
		System.out.println();
		
		//Llamo a funcion para ver el pronostico de los partidos por pantalla
		mostrarPronosticos(pronostico);
		
		System.out.println();
		
		//Llamo a funcion para ver la cantidad de puntos que consiguio el usuario
		System.out.println("La cantidad de puntos conseguidos es de: "+ calcularPuntos(partidos, pronostico));
		
		
	}
	
	public static void mostrarResultados(Partidos partidos) {
		for (int i=0;i<partidos.getEquipo1().size();i++) {
			System.out.println(partidos.getEquipo1().get(i)+" "+partidos.getPuntaje1().get(i)+" "+partidos.getPuntaje2().get(i)+" "+partidos.getEquipo2().get(i));
		}
	}
	
	public static void mostrarPronosticos(Pronostico pronosticos) {
		for (int i=0;i<pronosticos.getEquipo1().size();i++) {
			System.out.println(pronosticos.getEquipo1().get(i)+pronosticos.getGana1().get(i)+pronosticos.getEmpata().get(i)+pronosticos.getGana2().get(i)+pronosticos.getEquipo2().get(i));
		}
	}
	
	public static void anunciarResultado(int resultado, int ronda, Partidos part) {
		if (resultado==0) {
			System.out.println("El ganador de la ronda "+ronda+" es el equipo "+part.getEquipo1().get(ronda));
		} else if (resultado == 1) {
			System.out.println("El ganador de la ronda "+ronda+" es el equipo "+part.getEquipo2().get(ronda));
		} else {
			System.out.println("Termino en empate en la ronda " + ronda);
		}
	}
	
	public static int calcularPuntos(Partidos part, Pronostico pron) {
		int resultado = 0;
		for (int i=0;i<part.getEquipo1().size();i++) {
			int ganador = part.ganador(i);
			if (((ganador == 1) && (pron.getGana1().get(i).equals("X"))) || ((ganador == 2) && (pron.getGana2().get(i).equals("X"))) || ((ganador == 0) && (pron.getEmpata().get(i).equals("X"))))  {
				resultado++;
			} 
		}
		return resultado;
		
	}

}
