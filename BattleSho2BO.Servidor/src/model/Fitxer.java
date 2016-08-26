package model;

public class Fitxer {

	
	private String Path;
	private String Nom;
	
	public Fitxer(String Path, String Nom){
		
		this.setPath(Path);
		this.setNom(Nom);
		
		
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
	
}
