package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.MouseClickTable;
import network.ConectorDB;


/**
 * Classe que crea la vista dels usuaris amb la seva taula
 * @author Albert
 *
 */
public class VistaUsuaris extends JDialog {
	/**
	 * Crea el panell principal de la vista
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * creem la taula que mostrarem amb els usuaris
	 */
	private JTable jtTaula = new JTable(); 
	/**
	 * ResultSet on rebre els usuaris i pintar-ho
	 */
	private ResultSet rs ;
	/**
	 * Constructor de la vista i crea la taula
	 * @throws SQLException
	 */
	public VistaUsuaris() throws SQLException {
		
		setTitle("USUARIS");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		rs = ConectorDB.selectAllUsers();
		jtTaula = fesTaula(rs);
		add(jtTaula, BorderLayout.CENTER);
	}
	
	public void registerControllers(MouseClickTable mct){
		
		this.jtTaula.addMouseListener(mct);
			
	}
	/**
	 * Crea la taula dels usuaris
	 * @param rs
	 * @return la taula que pintarem
	 */
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
