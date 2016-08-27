package model;

import java.sql.Date;
import model.Mapa;

public class Contrincant {

	private String nom;
	private Date DataCreacio;
	private Mapa mapa;
	
	public Contrincant(String nom,  Date DataCreacio, Mapa mapa){
		
		this.nom = nom;
		this.DataCreacio = DataCreacio;
		this.mapa = mapa;
		
	}
	
	public String getNom(){
		return nom;
	}
	
	public Date getDataCreacio(){
		return DataCreacio;
	}
	
	public Mapa getMapa(){
		return mapa;
	}
 	
}
