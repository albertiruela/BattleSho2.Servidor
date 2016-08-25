package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






import java.sql.SQLException;

import view.MainViewS;
import view.VistaUsuaris;
import view.VistaEscenaris;


public class ButtonsController implements ActionListener {

	private static MainViewS view;
	private VistaUsuaris vistaUsuaris;
	private VistaEscenaris vistaEscenaris;
	
	public ButtonsController(MainViewS view, VistaUsuaris vistaUsuaris){
		
		this.view = view;
		this.vistaUsuaris = vistaUsuaris;
		
	}
	
	
	
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
			
			VistaEscenaris vistaEscenaris = null;
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
		}
	}
	
	
	
}
