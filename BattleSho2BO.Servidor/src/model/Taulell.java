package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Taulell.
 */
public class Taulell implements Serializable{
	
	private char[][] taulell;

	/** The n vaixells petits. */
	private int n_vaixells_petits;
	private Point[][] vaixells2;
	/** The n vaixells mitjans. */
	private int n_vaixells_mitjans;
	private Point[][] vaixells3;
	/** The n vaixells grans. */
	private int n_vaixells_grans;
	private Point[][] vaixells4;
	/** The dificultat. */
	private int dificultat;
	private int vTotals;
	
	
	
	

	/**
	 * Carregar taulell.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void carregar_taulell(String fitxer) throws IOException {
		String linia;
		
		FileReader f = new FileReader(fitxer);
		BufferedReader b = new BufferedReader(f);
		linia = b.readLine();
		n_vaixells_petits = Integer.parseInt(linia);
		vaixells2 = new Point[n_vaixells_petits][2];
		
		linia = b.readLine();
		n_vaixells_mitjans = Integer.parseInt(linia);
		vaixells3 = new Point[n_vaixells_mitjans][3];
		
		linia = b.readLine();
		n_vaixells_grans = Integer.parseInt(linia);
		vaixells4 = new Point[n_vaixells_grans][4];
		
		
		vTotals = n_vaixells_petits+n_vaixells_mitjans+n_vaixells_grans;
		System.out.println(vTotals);
		
		linia = b.readLine();
		taulell = new char[linia.length()][linia.length()];
		
		int fila = 0;
		while (linia!="1" && linia !="2" && linia !="3" && linia != null) {
			String[] parts = linia.split(" ");
			for(int i=0; i<parts.length; ++i){
				if(fila!=10){
					taulell[fila] = parts[i].toCharArray();
				}
			}
			fila++;
			linia = b.readLine();
			
			try{
				if(linia.equals("1") || linia.equals("2") || linia.equals("3")){
					dificultat = Integer.parseInt(linia);
				}
			}catch(NullPointerException ex){}
		}
		System.out.println(dificultat);
	}
	

	public Point[][] getVaixells2() {
		return vaixells2;
	}

	public void setVaixells2(Point[][] vaixells2) {
		this.vaixells2 = vaixells2;
	}

	public void setVaixells3(Point[][] vaixells3) {
		this.vaixells3 = vaixells3;
	}

	public void setVaixells4(Point[][] vaixells4) {
		this.vaixells4 = vaixells4;
	}

	public int getvTotals() {
		return vTotals;
	}

	public void setvTotals(int vTotals) {
		this.vTotals = vTotals;
	}

	/**
	 * Imprimir taulell.
	 */
	private void imprimir_taulell() {
		for (int i=0; i<taulell[i].length; ++i) {
			for (int j=0; j<taulell[j].length; ++j) {
				System.out.println(taulell[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	public void ompleVaixells(){
		int caselles = 0;
		boolean trobat = false;
		int v4 = n_vaixells_grans;
		int v3 = n_vaixells_mitjans;
		int v2 = n_vaixells_petits;
		int nV = v4+v3+v2;
		for(int i=0;i<taulell.length;i++){
			for(int j=0;j<taulell[i].length;j++){
				if(taulell[i][j] == 'V'){
					caselles = 1;
					for(int k=0;k<4;k++){
						switch(k){
						
						case 0:
							if(i-1>=0 && taulell[i-1][j]=='V'){
								trobat = true;
								
							}
							break;
							
						case 1:
							if(j-1>=0 && taulell[i][j-1]=='V'){
								trobat = true;
							}
							break;
						
						case 2:
							if(!trobat && nV!=0){	
								if(j+1<taulell[i].length && taulell[i][j+1]=='V'){
									caselles=2;
									if(j+2<taulell[i].length && taulell[i][j+2]=='V'){
										caselles=3;
										if(j+3<taulell[i].length && taulell[i][j+3]=='V'){
											caselles=4;
											vaixells4[v4-1][0] = new Point(i,j);
											vaixells4[v4-1][1] = new Point(i,j+1);
											vaixells4[v4-1][2] = new Point(i,j+2);
											vaixells4[v4-1][3] = new Point(i,j+3);
											v4--;
											nV--;
											
										}else{
											vaixells3[v3-1][0] = new Point(i,j);
											vaixells3[v3-1][1] = new Point(i,j+1);
											vaixells3[v3-1][2] = new Point(i,j+2);
											v3--;
											nV--;
											
										}
									}else{
										vaixells2[v2-1][0] = new Point(i,j);
										vaixells2[v2-1][1] = new Point(i,j+1);
										v2--;
										nV--;
										
									}
								}
							}
							break;
							
						case 3:
							if(!trobat && nV!=0){	
								if(i+1<taulell.length && taulell[i+1][j]=='V'){
									caselles=2;
									if(i+2<taulell.length && taulell[i+2][j]=='V'){
										caselles=3;
										if(i+3<taulell.length && taulell[i+3][j]=='V'){
											caselles=4;
											vaixells4[v4-1][0] = new Point(i,j);
											vaixells4[v4-1][1] = new Point(i+1,j);
											vaixells4[v4-1][2] = new Point(i+2,j);
											vaixells4[v4-1][3] = new Point(i+3,j);
											v4--;
											nV--;
											
										}else{
											vaixells3[v3-1][0] = new Point(i,j);
											vaixells3[v3-1][1] = new Point(i+1,j);
											vaixells3[v3-1][2] = new Point(i+2,j);
											v3--;
											nV--;
											
										}
									}else{
										vaixells2[v2-1][0] = new Point(i,j);
										vaixells2[v2-1][1] = new Point(i+1,j);
										v2--;
										nV--;
										
									}
								}
							}
							break;
						}
					}
				}
				trobat = false;
			}
		}
	}
	
	
	public Point[][] getVaixells(int i) {
		switch(i){
		case 0:
			return vaixells2;
		case 1:
			return vaixells3;
		case 2:
			return vaixells4;
		}
		return null;
	}

	public Point[][] getVaixells3() {
		return vaixells3;
	}

	public Point[][] getVaixells4() {
		return vaixells4;
	}

		
	/**
	 * Gets the files.
	 *
	 * @return the files
	 */
	public int getFiles(){
		return taulell.length;
	}
	
	/**
	 * Gets the columnes.
	 *
	 * @return the columnes
	 */
	public int getColumnes(){
		return taulell[0].length;
	}

	public char[][] getTaulell() {
		return taulell;
	}

	public void setTaulell(char[][] taulell) {
		this.taulell = taulell;
	}

	/**
	 * Gets the n vaixells petits.
	 *
	 * @return the n vaixells petits
	 */
	public int getN_vaixells_petits() {
		return n_vaixells_petits;
	}

	/**
	 * Sets the n vaixells petits.
	 *
	 * @param n_vaixells_petits the new n vaixells petits
	 */
	public void setN_vaixells_petits(int n_vaixells_petits) {
		this.n_vaixells_petits = n_vaixells_petits;
	}

	/**
	 * Gets the n vaixells mitjans.
	 *
	 * @return the n vaixells mitjans
	 */
	public int getN_vaixells_mitjans() {
		return n_vaixells_mitjans;
	}

	/**
	 * Sets the n vaixells mitjans.
	 *
	 * @param n_vaixells_mitjans the new n vaixells mitjans
	 */
	public void setN_vaixells_mitjans(int n_vaixells_mitjans) {
		this.n_vaixells_mitjans = n_vaixells_mitjans;
	}

	/**
	 * Gets the n vaixells grans.
	 *
	 * @return the n vaixells grans
	 */
	public int getN_vaixells_grans() {
		return n_vaixells_grans;
	}

	/**
	 * Sets the n vaixells grans.
	 *
	 * @param n_vaixells_grans the new n vaixells grans
	 */
	public void setN_vaixells_grans(int n_vaixells_grans) {
		this.n_vaixells_grans = n_vaixells_grans;
	}

	/**
	 * Gets the dificultat.
	 *
	 * @return the dificultat
	 */
	public int getDificultat() {
		return dificultat;
	}

	/**
	 * Sets the dificultat.
	 *
	 * @param dificultat the new dificultat
	 */
	public void setDificultat(int dificultat) {
		this.dificultat = dificultat;
	}

	/**
	 * Sets the vaixell.
	 *
	 * @param i the i
	 * @param j the j
	 */
	public void setVaixell(int i, int j){
		taulell[i][j] = 'V';
	}
	
	public void setBlanc(int i, int j){
		taulell[i][j] = '-';
	}
}
