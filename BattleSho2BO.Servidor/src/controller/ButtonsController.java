package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






import java.sql.SQLException;

import javax.swing.JTable;

import network.ConectorDB;
import model.Fitxer;
import view.MainViewS;
import view.VistaAfegirMapa;
import view.VistaUsuaris;
import view.VistaEscenaris;

/**
 * En aquesta classe es  gestionaran els events generats pels botons de les 
 * diferents vistes del servidor, concretament en tenim 3: Usuaris que ens mostra 
 * la taula amb els usuaris enregistrats a la BBDD, Escenaris que fa el mateix pero 
 * la base de dades dels Mapes oponents i finalment AfegirMapa que es troba dins
 * dels escenaris i obre un JFileChooser per a escollir quin mapa afegim.
 * @author Albert
 *
 */
public class ButtonsController implements ActionListener {
	/**
	 * Atribut que fa referencia a la vista principal del Servidor.
	 */
	private static MainViewS view;
	/**
	 * Atribut que fa referencia a la vista amb la taula dels Usuaris.
	 */
	private VistaUsuaris vistaUsuaris;
	private VistaEscenaris vistaEscenaris;
	
	
	public ButtonsController(MainViewS view, VistaUsuaris vistaUsuaris){
		
		this.view = view;
		this.vistaUsuaris = vistaUsuaris;
		
	}
	
	/**
	 * Mètode que actua en funció dels Listeners de les vistes i actuar en conseqüència
	 */
	
	public void actionPerformed (ActionEvent e){
		
		if(e.getActionCommand().equals("USUARIS")){
			
			VistaUsuaris vistaUsuaris = null;
			try {
				vistaUsuaris = new VistaUsuaris();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			MouseClickTable mct = new MouseClickTable();
			vistaUsuaris.registerControllers(mct);
			vistaUsuaris.setVisible(true);
		}
		
		if(e.getActionCommand().equals("ESCENARIS")){
			
			vistaEscenaris = null;
			try {
				vistaEscenaris = new VistaEscenaris();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MouseClickTable mct = new MouseClickTable();
			vistaEscenaris.registerControllers(mct);
			vistaEscenaris.setVisible(true);
			vistaEscenaris.registerControllers1(this);
			
		}
		
		if(e.getActionCommand().equals("AFEGIRMAPA")){
			
			System.out.println("AFEGIRMAPA");
			VistaAfegirMapa vam = new VistaAfegirMapa();
			vam.setVisible(true);
			Fitxer Tot = VistaAfegirMapa.retornaFitxer();
			vam.setVisible(false);
			ConectorDB.insertMap(Tot.getNom(), Tot.getPath());
			if(vistaEscenaris != null){
				vistaEscenaris.setVisible(false);
			}
			
			
		}
	}
	
	
	
}
