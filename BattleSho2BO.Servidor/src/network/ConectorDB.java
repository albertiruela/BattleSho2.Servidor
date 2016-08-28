package network;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Classe des d'on connectem el Servidor i la BBDD i en realitzem les modificacions 
 * @author Albert
 *
 */
public class ConectorDB {
	/**
	 * usuari amb el que accedim a MYSQL
	 */
	static String userName;
	/**
	 * password amb el que accedim a MYSQL
	 */
	static String password;
	/**
	 * nom de la BBDD
	 */
	static String db;
	/**
	 * Port que utilitzem per a la connexió
	 */
	static int port;
	/**
	 * URL de vinculació amb MYSQL
	 */
	static String url = "jdbc:mysql://";
	/**
	 * variable referent a la connexió
	 */
	static Connection conn = null;
	/**
	 * comanda
	 */
	static Statement s;
	
	private static String usuariActual;
	
	public ConectorDB(String usr, String pass, String db, int port, String ip) {
		ConectorDB.userName = usr;
		ConectorDB.password = pass;
		ConectorDB.db = db;
		ConectorDB.port = port;
		ConectorDB.url += ip;
		ConectorDB.url += ":"+port+"/";
		ConectorDB.url += db;
	}
	/**
	 * Realitzem la connexió
	 */
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
	 /**
	  * Insertem el usuari 
	  * @param nickname
	  * @param password
	  * @return boolea que informa si s'ha dut a terme
	  */
	
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
	 
	 /**
	  * Busca l'usuari a la BBDD a través del nickname i l'elimina
	  * @param nickname
	  */
	 public static void deleteUser(String nickname){
	    	String query = new String("DELETE FROM usuaris WHERE Nickname='"+nickname+"'");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);
	             
	        } catch (SQLException ex) {
	            System.out.println("Problema al Eliminar : " + ex.getSQLState());
	        }
	    	
	    }
	 /**
	  * Extreu tots els usuaris de la taula
	  * @return un ResultSet amb els usuaris
	  */
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
	  /**
	   * Extreiem un sol usuari de la base de dades
	   * @param Nickname
	   * @return ResultSet amb un usuari
	   */
	  public static ResultSet selectUser(String Nickname){
	    	ResultSet rs = null;
	    	String query = new String("SELECT * FROM usuaris WHERE Nickname='"+Nickname+"' LIMIT 1");
	    	try {
	            s =(Statement) conn.createStatement();
	            rs = s.executeQuery (query);
	            
	        } catch (SQLException ex) {
	            System.out.println("Problema al recuperar el usuari: " + ex.getSQLState());
	        }
	    	usuariActual = Nickname;
			return rs;
	    }
	  /**
	   * Registra la data del darrer accés de l'usuari a la plataforma
	   * @param nickname
	   */
	  public static void updateAccessDate(String nickname){
	    	String query = new String("UPDATE usuaris SET DataUltimAcces = NOW() WHERE nickname='"+nickname+"'");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);
	             
	        } catch (SQLException ex) {
	            System.out.println("Problema al Actualitzar Data : " + ex.getSQLState());
	        }
	    	
	    }
	  /**
	   * Retorna tots els Mapes que trobem a la taula de escenaris
	   * @return ResultSet amb tots els mapes
	   */
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
	  /**
	   * Eliminem un mapa de la taula escenaris a través de passar el nom
	   * @param nom
	   */
	  public static void deleteMap(String nom){
	    	String query = new String("DELETE FROM escenaris WHERE Nom='"+nom+"'");
	    	try {
	            s =(Statement) conn.createStatement();
	            s.executeUpdate(query);
	             
	        } catch (SQLException ex) {
	            System.out.println("Problema al Eliminar el mapa : " + ex.getSQLState());
	        }
	    	
	    }
	  /**
	   * Inserim un mapa a la taula escenaris
	   * @param nom
	   * @param path
	   * @return boolea conforme si s'ha fet correctament
	   */
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
	 
	 /**
	  * Desconnectem la base de dades del Servidor
	  */
	 public void disconnect(){
	    	try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Problema al tancar la connexio --> " + e.getSQLState());
			}
	    }
	 
	public static void insertPartidaGuanyada(){
		int partides = 0;
		ResultSet user = selectUser(usuariActual);
		try {
			while(user.next()){
				partides = (int) user.getObject("PartidesGuanyades")+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = new String("UPDATE usuaris SET PartidesGuanyades='"+partides+"' WHERE Nickname='"+usuariActual+"'");
		System.out.println(partides);
		System.out.println(usuariActual);
		try {
			System.out.println("JA");
			s =(Statement) conn.createStatement();
			s.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
	}
	
	public static void insertPartidaPerduda(){
		int partides = 0;
		System.out.println(usuariActual);
		ResultSet user = selectUser(usuariActual);
		System.out.println("usuari trobat");
		try {
			while(user.next()){
				partides = (int) user.getObject("PartidesPerdudes")+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(partides);
		String query = new String("UPDATE usuaris SET PartidesPerdudes='"+partides+"' WHERE Nickname='"+usuariActual+"'");
	
		try {
			s =(Statement) conn.createStatement();
			s.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
