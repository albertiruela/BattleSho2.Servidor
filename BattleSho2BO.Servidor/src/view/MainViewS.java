package view;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;

import controller.ButtonsController;

public class MainViewS extends JFrame {

	
	private JPanel JPTitol1 = new JPanel();
	private JPanel JPTitol2 = new JPanel(new FlowLayout());
	private JPanel JPBotons = new JPanel (new GridLayout(1,2));
	
	private static JButton jbUsuaris = new JButton("VistaUsuaris");
	private static JButton jbEscenaris = new JButton("Escenaris");
	
	
	private JLabel jlBattle = new JLabel("BattleSho2");
	private JLabel jlServer = new JLabel ("SERVER");
	
	
	
	
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
		
		
		
		//jbEscenaris.addActionListener(controller);
			
	}
	
	
	
}

