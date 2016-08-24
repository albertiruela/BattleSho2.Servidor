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



public class VistaUsuaris extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable jtTaula = new JTable(); 
	private ResultSet rs ;
	
	public VistaUsuaris() throws SQLException {
		
		setTitle("USUARIS");
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		rs = ConectorDB.selectAllUsers();
		jtTaula = fesTaula(rs);
		add(jtTaula, BorderLayout.CENTER);
	}
	
	public void registerControllers(MouseClickTable mct){
		
		this.jtTaula.addMouseListener(mct);
			
	}
	public JTable fesTaula(ResultSet rs) {
		
		 JTable jtTable = new JTable();
		 String header[] = new String[] { "Nickname", "DataRegistre", "DataAcces",
		            "PartidesGuanyades", "PartidesPerdudes"};
		 DefaultTableModel dtm = new DefaultTableModel(0, 0);
		 
		 dtm.setColumnIdentifiers(header);
		  
		 jtTable.setModel(dtm);
		
		 
		 dtm.addRow(new Object[] { "Nickname", "DataRegistre", "DataAcces",
	                "PartidesGuanyades", "PartidesPerdudes"});

		 try {
			while (rs.next()) {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			        String nickname = rs.getString("Nickname");
			        Timestamp tsRegistre = rs.getTimestamp("DataRegistre");
			        Timestamp tsUltimAcces = rs.getTimestamp("DataUltimAcces");
			        String dataRegistre = df.format(new Date(tsRegistre.getTime()));
			        String dataAcces = df.format(new Date(tsUltimAcces.getTime()));
			        int PG = rs.getInt("PartidesGuanyades");
			        int PP = rs.getInt("PartidesPerdudes");
			        
			        dtm.addRow(new Object[] { nickname, dataRegistre, dataAcces,
			                PG, PP});
			       
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 
		 return jtTable;
		
		
	}
	
	
}
