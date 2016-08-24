package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuracio {
	
	private String PortBD = new String(); 
	private String IP = new String();
	private String NomBD = new String();
	private String Usuari = new String();
	private String Password = new String();
	private int PortC;
	
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
	public String getPortBD() {
		return PortBD;
	}

	public String getIP() {
		return IP;
	}

	public String getNomBD() {
		return NomBD;
	}

	public String getUsuari() {
		return Usuari;
	}

	public String getPassword() {
		return Password;
	}

	public int getPortC() {
		return PortC;
			
	}
	
	
	
}
