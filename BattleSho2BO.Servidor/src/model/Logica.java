package model;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;





import javax.swing.JOptionPane;

import controller.ButtonsController;
import network.ConectorDB;

public class Logica {
	

	private static ButtonsController controller;
	
	public void registerController(ButtonsController controller){
		this.controller = controller;
	}
	
	public static boolean addUser(String message){
		String[] info = new String[2];
		boolean ok = false;
		System.out.println("Entro addUser");
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
