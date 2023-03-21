package objetos;

import java.util.ArrayList;

public class Pronostico {
	private ArrayList<String> equipo1 = new ArrayList<String>();
	private ArrayList<String> equipo2 = new ArrayList<String>();
	private ArrayList<String> gana1 = new ArrayList<String>();
	private ArrayList<String> gana2 = new ArrayList<String>();
	private ArrayList<String> empata = new ArrayList<String>();
	
	
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
	public ArrayList<String> getGana1() {
		return gana1;
	}
	public void setGana1(String gana1) {
		this.gana1.add(gana1);
	}
	public ArrayList<String> getGana2() {
		return gana2;
	}
	public void setGana2(String gana2) {
		this.gana2.add(gana2);
	}
	public ArrayList<String> getEmpata() {
		return empata;
	}
	public void setEmpata(String empata) {
		this.empata.add(empata);
	}
}
