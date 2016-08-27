package model;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;





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
}
