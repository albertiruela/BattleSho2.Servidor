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



public class VistaEscenaris extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel jpAfegir = new JPanel(new GridLayout(1,2));
	
	private JTable jtTaula = new JTable(); 
	private ResultSet rs ;
	
	private JButton jbAfegir0 = new JButton (""); 
	private JButton jbAfegir1 = new JButton ("Afegir Mapa"); 
	
	
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