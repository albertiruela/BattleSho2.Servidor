package network;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorDB {
	static String userName;
	
	static String password;
	
	static String db;
	
	static int port;
	
	static String url = "jdbc:mysql://";
	
	static Connection conn = null;
	
	static Statement s;
	
	public ConectorDB(String usr, String pass, String db, int port, String ip) {
		ConectorDB.userName = usr;
		ConectorDB.password = pass;
		ConectorDB.db = db;
		ConectorDB.port = port;
		ConectorDB.url += ip;
		ConectorDB.url += ":"+port+"/";
		ConectorDB.url += db;
	}
	
	 public void connect() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");

	            conn = (Connection) DriverManager.getConnection(url, userName, password);
	            if (conn != null) {
	                System.out.println("Conexio a base de dades "+url+" ... Ok");
	            }
	        }
	        catch(SQLException ex) {
	            System.out.println("Problema al connecta-nos a la BBDD: "+url);
	            ex.printStackTrace();
	        }
	        catch(ClassNotFoundException ex) {
	            System.out.println(ex);
	        }

	    }
	 
	
	 public static boolean insertUser(String nickname, String password){

	        String query = new String("INSERT INTO usuaris (Nickname,Password,PartidesGuanyades, PartidesPerdudes) VALUES ('"+nickname+"','"+password+"', 0 , 0);");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	            System.out.println("Problema al Inserir: " + ex.getSQLState());
	            return false;
	        }
	    	return true;
	    }
	 
	 public static void deleteUser(String nickname){
	    	String query = new String("DELETE FROM usuaris WHERE Nickname='"+nickname+"'");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);
	             
	        } catch (SQLException ex) {
	            System.out.println("Problema al Eliminar : " + ex.getSQLState());
	        }
	    	
	    }
	 
	  public static ResultSet selectAllUsers(){
	    	ResultSet rs = null;
	    	String query = new String("SELECT * FROM usuaris");
	    	try {
	            s =(Statement) conn.createStatement();
	            rs = s.executeQuery (query);
	            
	        } catch (SQLException ex) {
	            System.out.println("Problema al Recuperar les dades --> " + ex.getSQLState());
	        }
			return rs;
	    }
	  
	  public static ResultSet selectUser(String Nickname){
	    	ResultSet rs = null;
	    	String query = new String("SELECT * FROM usuaris WHERE Nickname='"+Nickname+"' LIMIT 1");
	    	try {
	            s =(Statement) conn.createStatement();
	            rs = s.executeQuery (query);
	            
	        } catch (SQLException ex) {
	            System.out.println("Problema al recuperar el usuari: " + ex.getSQLState());
	        }
			return rs;
	    }
	  
	  public static void updateAccessDate(String nickname){
	    	String query = new String("UPDATE usuaris SET DataUltimAcces = NOW() WHERE nickname='"+nickname+"'");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);
	             
	        } catch (SQLException ex) {
	            System.out.println("Problema al Actualitzar Data : " + ex.getSQLState());
	        }
	    	
	    }
	  
	  public static ResultSet selectAllMaps(){
	    	ResultSet rs = null;
	    	String query = new String("SELECT * FROM escenaris");
	    	try {
	            s =(Statement) conn.createStatement();
	            rs = s.executeQuery (query);
	            
	        } catch (SQLException ex) {
	            System.out.println("Problema al Recuperar els escenaris:" + ex.getSQLState());
	        }
			return rs;
	    }
	  
	  public static void deleteMap(String nom){
	    	String query = new String("DELETE FROM escenaris WHERE Nom='"+nom+"'");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);
	             
	        } catch (SQLException ex) {
	            System.out.println("Problema al Eliminar el mapa : " + ex.getSQLState());
	        }
	    	
	    }
	  
	  public static boolean insertMap(String nom, String path){

	        String query = new String("INSERT INTO escenaris (Nom,Path) VALUES ('"+nom+"','"+path+"');");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	            System.out.println("Problema al Inserir el mapa: " + ex.getSQLState());
	            return false;
	        }
	    	return true;
	    }
	 
	 
	 public void disconnect(){
	    	try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Problema al tancar la connexio --> " + e.getSQLState());
			}
	    }
	 
	 
	
	
}
