package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class VistaAfegirMapa extends JDialog {
	
	String mapes = "mapes";
	JFileChooser jfcEscullMapa = new JFileChooser(mapes);
	
	public VistaAfegirMapa(){
		setTitle("Afegir Mapa");
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		add(jfcEscullMapa);
		
		
	}
	
	
}
