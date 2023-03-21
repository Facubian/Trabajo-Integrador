package objetos;

import java.util.ArrayList;

public class Partidos {
	private ArrayList<String> equipo1 = new ArrayList<String>();
	private ArrayList<String> equipo2 = new ArrayList<String>();
	private ArrayList<String> puntaje1 = new ArrayList<String>();
	private ArrayList<String> puntaje2 = new ArrayList<String>();
		

	public ArrayList<String> getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1.add(equipo1);
	}

	public ArrayList<String> getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2.add(equipo2);
	}

	public ArrayList<String> getPuntaje1() {
		return puntaje1;
	}

	public void setPuntaje1(String puntaje1) {
		this.puntaje1.add(puntaje1);
	}

	public ArrayList<String> getPuntaje2() {
		return puntaje2;
	}

	public void setPuntaje2(String puntaje2) {
		this.puntaje2.add(puntaje2);
	}
	
	public int ganador(Integer ronda) {
		int puntos1 = Integer.parseInt(this.getPuntaje1().get(ronda));
		int puntos2 = Integer.parseInt(this.getPuntaje2().get(ronda)); 
		
		if (puntos1>puntos2) {
			return 1;
			
		} else if (puntos1<puntos2) {
			return 2;
			
		} else {
			return 0;
		}
	}
	
}
