package model;

import java.sql.SQLException;

import javax.swing.SwingUtilities;



//import network.ConectorDB;
//import network.ServerS;
import view.MainViewS;
import view.VistaUsuaris;
import controller.ButtonsController;
import network.ConectorDB;
import network.ServerS;
import model.Configuracio;

public class MainServidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					//BotoClick bc = new BotoClick(vistaUsuaris);
					
					vistaServidor.registerController(controller);
					server.iniciaServidor();
					vistaServidor.setVisible(true);
					
					
					/*Time time = new Time();
					Logics logics = new Logics(time);
					
					ButtonsController controller = new ButtonsController(VistaPrincipal,server,logics);
					
					
					server.registerController(controller);
					time.registerController(controller);
					logics.registerController(controller);
					server.startServer();
					serverView.setVisible(true);*/
					
					
				}
			}
		});
	}

}