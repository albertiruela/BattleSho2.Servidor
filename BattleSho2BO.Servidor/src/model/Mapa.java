package model;

public class Mapa {
	private int nVaixellsPetits;
	private int nVaixellsMitjans;
	private int nVaixellsGrans;
	private String[][] caselles;
	
	public Mapa (int nVaixellsPetits, int nVaixellsMitjans, int nVaixellsGrans, String[][] caselles){
		this.nVaixellsPetits = nVaixellsPetits;
		this.nVaixellsGrans = nVaixellsGrans;
		this.nVaixellsMitjans = nVaixellsMitjans;
		this.caselles = caselles;
	}
	public int getnVaixellsPetits() {
		return nVaixellsPetits;
	}
	public int getnVaixellsMitjans(){
		return nVaixellsMitjans;
	}
	public int getnVaixellsGrans(){
		return nVaixellsGrans;
	}
	public String[][] getCaselles(){
		return caselles;
	}
	
}
