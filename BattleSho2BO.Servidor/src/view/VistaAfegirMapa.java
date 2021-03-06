package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import model.Fitxer;

/**
 * JDialog que s'encarrega de generar la vista del JChooseFile per a afegir un mapa a la BBDD
 * @author Albert
 *
 */
public class VistaAfegirMapa extends JDialog {
	
	static String mapes = "mapes";
	static JFileChooser jfcEscullMapa = new JFileChooser(mapes);
	/**
	 * constructor per a crear la finestra que dona opci� a triar el mapa
	 */
	public VistaAfegirMapa(){
		setTitle("Afegir Mapa");
		setBounds(100, 100, 1, 1);
		getContentPane().setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		
		add(jfcEscullMapa);
		
	}
	/**
	 * Extreu el nom i el path del fitxer afegit i el retorna en forma de Fitxer (Classe)
	 * @return
	 */
	public static Fitxer  retornaFitxer(){
		int returnVal = 0 ;
		
		 int status = jfcEscullMapa.showOpenDialog(null);
		 if(returnVal == JFileChooser.APPROVE_OPTION && status == 0) {
		 
		       return new Fitxer(jfcEscullMapa.getSelectedFile().getPath(), jfcEscullMapa.getSelectedFile().getName());
		  }
		 	
		return null;
	}
	

	
}
