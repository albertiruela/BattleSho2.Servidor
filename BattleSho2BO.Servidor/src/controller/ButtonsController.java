package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;

import java.sql.ResultSet;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import network.ConectorDB;
import view.MainViewS;
import view.VistaUsuaris;


public class ButtonsController implements ActionListener {

	private static MainViewS view;
	private VistaUsuaris vistaUsuaris;
	
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
			
		
	}
	
	
	
}
