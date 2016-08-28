package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import controller.ButtonsController;
/**
 * Classe que gestiona la creacio de la vista principal del servidor
 * @author Albert
 *
 */
public class MainViewS extends JFrame {

	/**
	 * Panell on anira el titol principal
	 */
	private JPanel JPTitol1 = new JPanel();
	/**
	 * Panell on anire el subtitol
	 */
	private JPanel JPTitol2 = new JPanel(new FlowLayout());
	/**
	 * Panell amb GridLayout on aniran els botons tan d'usuaris com escenaris
	 */
	private JPanel JPBotons = new JPanel (new GridLayout(1,2));
	/**
	 * Boto per mostrar la taula d'usuaris
	 */
	private static JButton jbUsuaris = new JButton("VistaUsuaris");
	/**
	 * Boto per mostrar la taula d'escenaris
	 */
	private static JButton jbEscenaris = new JButton("Escenaris");
	/**
	 * Label del titol principal
	 */
	private JLabel jlBattle = new JLabel("BattleSho2");
	/**
	 * Label del subtitol
	 */
	private JLabel jlServer = new JLabel ("SERVER");
	
	
	
	/**
	 * Instancia per a crear la vista principal
	 */
	public MainViewS() {
		
		setBounds(100,100,700,400);
		setLocationRelativeTo(null);
		setTitle("BattleSho2-SERVIDOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(700,400);
		getContentPane().setBackground(Color.black);
		
		
	
		jlBattle.setFont(new java.awt.Font("Courier New", 1, 40));
		jlBattle.setForeground(Color.BLUE);
		JPTitol1.add(jlBattle);
		JPTitol1.setSize(350, 300);
		
		jlServer.setFont(new java.awt.Font("Courier New", 2, 26));
		jlServer.setForeground(Color.BLACK);
		JPTitol2.add(jlServer);
		JPTitol2.setSize(100,300);
		
		
		
		JPBotons.add(jbUsuaris);
		JPBotons.add(jbEscenaris);
		
		
		add(JPTitol1, BorderLayout.NORTH);
		add(JPTitol2, BorderLayout.CENTER);
		add(JPBotons, BorderLayout.SOUTH);
		
		
		
		
	}
	
	public void registerController(ButtonsController controller){
		
		jbUsuaris.setActionCommand("USUARIS");
		jbUsuaris.addActionListener(controller);
		
		jbEscenaris.setActionCommand("ESCENARIS");
		jbEscenaris.addActionListener(controller);
					
	}
	
	
	
}

