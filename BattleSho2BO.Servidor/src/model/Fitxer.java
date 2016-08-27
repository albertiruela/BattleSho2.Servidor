package model;
/**
 * Classe que ens carrega un fitxer amb path i nom
 * @author Albert
 *
 */
public class Fitxer {

	
	private String Path;
	private String Nom;
	
	public Fitxer(String Path, String Nom){
		
		this.setPath(Path);
		this.setNom(Nom);
		
		
	}
	/** retorna el path del escenari*/
	public String getPath() {
		return Path;
	}
	/** fixa el path*/
	public void setPath(String path) {
		Path = path;
	}
	/** Retorna el nom*/
	public String getNom() {
		return Nom;
	}
	/** fixa el nom*/ 
	public void setNom(String nom) {
		Nom = nom;
	}
	
}
