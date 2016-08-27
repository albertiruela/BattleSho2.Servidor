package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.SwingUtilities;




import view.MainViewS;
import view.VistaUsuaris;
import controller.ButtonsController;
import network.ConectorDB;
import network.ServerS;
import model.Configuracio;

/**
 * Main des d'on executem per ordre les vistes, la connexió amb la BBDD, iniciem el servidor i registrem els controladors 
 * @author Albert
 *
 */
public class MainServidor {
	/**
	 * Funcio principal del main
	 * @param args
	 */
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				Configuracio conf = new Configuracio();
				
				if(conf.fes()){
					ConectorDB conn = new ConectorDB(conf.getUsuari(), conf.getPassword(), conf.getNomBD(), Integer.parseInt(conf.getPortBD()), conf.getIP());
					conn.connect();
					
					MainViewS vistaServidor = new MainViewS();
					VistaUsuaris vistaUsuaris = null;
					try {
						vistaUsuaris = new VistaUsuaris();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ServerS server = new ServerS(conf.getPortC());
					ButtonsController controller = new ButtonsController(vistaServidor,vistaUsuaris);
					
					
					vistaServidor.registerController(controller);
					server.iniciaServidor();
					vistaServidor.setVisible(true);
					
					
					
						
					
				}
			}
		});
	}

}
