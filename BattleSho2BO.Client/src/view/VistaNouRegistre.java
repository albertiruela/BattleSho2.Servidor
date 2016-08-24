package view;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;

import controller.ButtonsController;

public class VistaNouRegistre extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JPanel jpAccedir = new JPanel (new GridLayout(3,2));
	
	private JLabel jlNickname = new JLabel("    NICKNAME");
	private JLabel jlPassword = new JLabel("    PASSWORD");
	private JLabel jlRes = new JLabel (" ");
	
	private JTextField jtfNickname = new JTextField();
	private JPasswordField jpfPassword = new JPasswordField();
	
	
	private JButton jbOK = new JButton("OK");

		
	
	public VistaNouRegistre(){
		
		setTitle("REGISTRE");
		setBounds(675, 250, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		
		jpAccedir.add(jlNickname);
		jpAccedir.add(jtfNickname);
		jpAccedir.add(jlPassword);
		jpAccedir.add(jpfPassword);
		jpAccedir.add(jlRes);
		jpAccedir.add(jbOK);
		
		add(jpAccedir, BorderLayout.CENTER);
				
			
		}
	
	public void registerControllers(ButtonsController controller){
		
		jbOK.setActionCommand("OK2");
		jbOK.addActionListener(controller);
			
	}
	
	public String getNickname(){
		return jtfNickname.getText();
	}
	
	public String getPasword(){
		return jpfPassword.getText();
	}
	
	


}
