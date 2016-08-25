package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ButtonsController;
import controller.MouseClickTable;
import network.ConectorDB;



public class VistaEscenaris extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable jtTaula = new JTable(); 
	private ResultSet rs ;
	
	public VistaEscenaris() throws SQLException {
		
		setTitle("ESCENARIS");
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		rs = ConectorDB.selectAllMaps();
		jtTaula = fesTaula(rs);
		add(jtTaula, BorderLayout.CENTER);
	}
	
	public void registerControllers(MouseClickTable mct){
		
		this.jtTaula.addMouseListener(mct);
			
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