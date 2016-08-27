package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ButtonsController;
import controller.MouseClickTable;
import network.ConectorDB;

/**
 * Classe encarregada de generar la vista amb la taula dels escenaris i dona opció a afegir-ne
 * @author Albert
 *
 */

public class VistaEscenaris extends JDialog {
	/**
	 * Panell principal del JDialog
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Panell on introduim el botó d'Accedir
	 */
	private JPanel jpAfegir = new JPanel(new GridLayout(1,2));
	/**
	 * Taula on col·locarem els escenaris classificats pel nickname
	 */
	private JTable jtTaula = new JTable(); 
	/**
	 * Rebrem els escenaris en forma ResultSet
	 */
	private ResultSet rs ;
	private JButton jbAfegir0 = new JButton (""); 
	/**
	 * Botó amb el que activarem l'opció d'afegir mapes
	 */
	private JButton jbAfegir1 = new JButton ("Afegir Mapa"); 
	
	/**
	 * Insta a la creació de la vista dels escenaris
	 * @throws SQLException
	 */
	public VistaEscenaris() throws SQLException {
		
		setTitle("ESCENARIS");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		jpAfegir.add(jbAfegir0);
		jpAfegir.add(jbAfegir1);
		
		jbAfegir0.setVisible(false);
		jbAfegir1.setVisible(true);
		
		rs = ConectorDB.selectAllMaps();
		jtTaula = fesTaula(rs);
		add(jtTaula, BorderLayout.CENTER);
		add(jpAfegir, BorderLayout.SOUTH);
	}
	
	public void registerControllers(MouseClickTable mct){	
		this.jtTaula.addMouseListener(mct);		
	}
	
	public void registerControllers1(ButtonsController bc){
		jbAfegir1.setActionCommand("AFEGIRMAPA");
		jbAfegir1.addActionListener(bc);
	}
	/**
	 * Funció que rep el ResultSet de la base de dades  i ho carrega a la taula que mostrarem
	 * @param rs
	 * @return
	 */
	public JTable fesTaula(ResultSet rs) {
		
		 JTable jtTable = new JTable();
		 String header[] = new String[] { "Nom", "Path"};
		 DefaultTableModel dtm = new DefaultTableModel(0, 0);
		 
		 dtm.setColumnIdentifiers(header);
		  
		 jtTable.setModel(dtm);
		
		 
		 dtm.addRow(new Object[] { "Nom", "Path"});

		 try {
			while (rs.next()) {
					
			        String nom = rs.getString("Nom");
			        String path = rs.getString("Path");
			        
			        dtm.addRow(new Object[] { nom, path});
			       
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return jtTable;
		
		
	}
	
	
	
}