package model;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;





import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.ButtonsController;
import network.ConectorDB;
/**
 * Classe on farem les funcions encarregades de la logica de tractament de informació rebuda del servidor
 * @author Albert
 *
 */
public class Logica {
	

	private static ButtonsController controller;
	
	public void registerController(ButtonsController controller){
		this.controller = controller;
	}
	/**
	 * Rebem la cadena que arriba del Client i la preparem per a carregarla a la base de dates
	 * @param message
	 * @return booleà que verifica si s'ha afegit correctament
	 */
	public static boolean addUser(String message){
		String[] info = new String[2];
		boolean ok = false;
		message = message.substring(4);
		info = message.split("/");
		
		System.out.println(info[0]);
		System.out.println(info[1]);
		if(checkUserExists(info[0])){
			if(checkPassword(info[1])){
				if (ConectorDB.insertUser(info[0],info[1])){
					ok = true;
				}
			}
		}
		
		return ok;
	}
	/**
	 * Funció que valida si existeix un usuari en la base de dades
	 * @param message
	 * @return informa si el troba o no
	 */
	public static String checkUser(String message){
		String[] info = new String[3];
		
		String answer = new String();
		
		message = message.substring(4);
		info = message.split("/");
		try {	
			System.out.println("nickname:" + info[0]);
			ResultSet usuari = ConectorDB.selectUser(info[0]);

		   
			try {
				usuari.next();
				String password = usuari.getString("Password");
				System.out.println(password);
				if(password.equals(info[1])){
					answer = "OK";
					ConectorDB.updateAccessDate(info[0]);
				}else{
					answer = "KO";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return answer;
	}
	/**
	 * Comprovem si el password introduit és el que hi ha a la BBDD
	 * @param Password
	 * @return boolea si es correcte
	 */
	public static boolean checkPassword(String Password){
		boolean numeros = false;
		boolean lletres = false;
		if(Password.length()>= 6){
			if(Password.matches(".*\\d+.*")){
				numeros = true;
			}
			if(Password.matches(".*[a-zA-Z]+.*")){
				lletres = true;
			}
		}
		return numeros && lletres;
	}
	/**
	 * Mirem si l'usuari existeix a la base de dades
	 * @param nickname
	 * @return bolea informant de l'existencia de l'usuari
	 */
	public static boolean checkUserExists(String nickname){
		boolean noExisteix = true;
		ResultSet rs = ConectorDB.selectAllUsers();
		try {
			while (rs.next()) {
				String Nickname = rs.getString("Nickname");
				if (Nickname.equals(nickname)){
					noExisteix = false;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noExisteix;
	}
	public static LinkedList <Contrincant> enviaEscenaris() throws IOException{
		LinkedList<Contrincant> contrincants = new LinkedList<Contrincant>();
		
		ResultSet rs = ConectorDB.selectAllMaps();
		
		try {
			while (rs.next())
				try {
					{
						Contrincant c = null;
						String nom = rs.getString("Nom");
						Date datacreacio = rs.getDate("DataCreacio");
						Mapa mapa = fesMapa(nom);
						Contrincant cont = new Contrincant(nom,datacreacio,mapa);
						contrincants.add(cont);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return contrincants;	
	}
	
	public static Mapa fesMapa(String nom) throws IOException{
		
		String linia;
		FileReader f = new FileReader("mapes/"+nom);
		BufferedReader b = new BufferedReader(f);
		linia = b.readLine();
		int n_vaixells_petits = Integer.parseInt(linia);
		System.out.println(linia);
		linia = b.readLine();
		int n_vaixells_mitjans = Integer.parseInt(linia);
		System.out.println(linia);
		linia = b.readLine();
		int n_vaixells_grans = Integer.parseInt(linia);
		System.out.println(linia);
		
		linia = b.readLine();
		String[][] taulell = new String[linia.length()][linia.length()];
		
		int fila = 0;
		while (linia!="1" && linia !="2" && linia !="3" && linia != null) {
			String[] parts = linia.split(" ");
			//System.out.println(parts.length);
			for(int i=0; i<parts.length; ++i) taulell[fila][i] = parts[i];	
			for (int i=0; i<parts.length; ++i) System.out.println(taulell[fila][i]);
			fila++;
			linia = b.readLine();
			System.out.println(linia);
		}
		
		Mapa m = new Mapa (n_vaixells_petits,n_vaixells_mitjans, n_vaixells_grans, taulell);
		return m;
	}
}
