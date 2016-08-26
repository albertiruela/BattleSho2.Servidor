package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;



import java.nio.file.Path;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import model.Fitxer;

public class VistaAfegirMapa extends JDialog {
	
	static String mapes = "mapes";
	static JFileChooser jfcEscullMapa = new JFileChooser(mapes);
	
	public VistaAfegirMapa(){
		setTitle("Afegir Mapa");
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		
		add(jfcEscullMapa);
		
		
	      
	    
	 
		
	}
	
	public static Fitxer  retornaFitxer(){
		int returnVal = 0 ;
		
		 int status = jfcEscullMapa.showOpenDialog(null);
		 System.out.println(status);
		 if(returnVal == JFileChooser.APPROVE_OPTION && status == 0) {
		 
		       
		       return new Fitxer(jfcEscullMapa.getSelectedFile().getPath(), jfcEscullMapa.getSelectedFile().getName());
		  }
		 	
		return null;
	}
	

	
}
