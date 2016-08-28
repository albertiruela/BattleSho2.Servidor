package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe encarregada d'extreure la informació del .json 
 * @author Albert
 *
 */
public class Configuracio {
	/**
	 * Atribut on guardarem el Port de la BBDD
	 */
	private String PortBD = new String(); 
	/**
	 * Atribut on guardarem la IP de la connexió
	 */
	private String IP = new String();
	/**
	 * Atribut on guardarem el Nom de la BBDD
	 */
	private String NomBD = new String();
	/**
	 * Atribut on guardem el nom de l'usuari de la connexió amb la BBDD
	 */
	private String Usuari = new String();
	/**
	 * Atribut on guardem la password de l'usuari de la connexió amb la BBDD
	 */
	private String Password = new String();
	/**
	 * Atribut on guardem el Port del Client necessari per a la connexió
	 */
	private int PortC;
	
	/**
	 * En aquesta funció llegirem el fitxer i guardarem el que llegim en els atributs creats
	 * @return boolea que indica si s'ha llegit correctament
	 */
	
	public boolean fes(){
		Gson gson = new GsonBuilder().create();
		BufferedReader BR;
		try {
		   BR = new BufferedReader(new FileReader("config.json"));
		   Configuracio aux = gson.fromJson(BR, Configuracio.class);
		   
		   this.PortBD = aux.PortBD;
		   this.IP = aux.IP;
		   this.NomBD = aux.NomBD;
		   this.Usuari = aux.Usuari;
		   this.Password = aux.Password;
		   this.PortC = aux.PortC;
		   
		  } catch (FileNotFoundException e) {
		   return false;
		  } catch (Exception e) {
		   e.printStackTrace();
		   return false;
		  }
		  return true;
	}
	/**
	 * Getter per treure el port de la BBDD
	 * @return String amb el port de la BBDD
	 */
	public String getPortBD() {
		return PortBD;
	}
	/**
	 * Getter per treure la IP de la connexió
	 * @return String amb l'IP
	 */

	public String getIP() {
		return IP;
	}
	/**
	 * Getter per treure el nom de la BBDD
	 * @return nom de la BBDD
	 */
	public String getNomBD() {
		return NomBD;
	}
	/**
	 * Getter per treure el nom de l'Usuari
	 * @return nom de l'usuari
	 */
	public String getUsuari() {
		return Usuari;
	}
	/**
	 * Getter per treure el password de l'usuari
	 * @return password de l'usuari
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * Getter 
	 * @return
	 */
	public int getPortC() {
		return PortC;
			
	}
	
	
	
}
