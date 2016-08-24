package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;









import network.ComunicacioServidor;

import view.MainViewC;
import view.VistaAccedirC;
import view.VistaNouRegistre;


public class ButtonsController implements ActionListener{
	
	private static MainViewC viewClient;
	private VistaAccedirC vistaAccedir;
	private VistaNouRegistre vistaRegistre;
	private static ComunicacioServidor comunicacioS;
	
	public ButtonsController(MainViewC viewClient, VistaAccedirC vistaAccedir, VistaNouRegistre vistaRegistre, ComunicacioServidor comunicacioS){
		
		this.viewClient = viewClient;
		this.vistaAccedir = vistaAccedir;
		this.vistaRegistre = vistaRegistre;
		this.comunicacioS = comunicacioS;
		
	}
	
	public void actionPerformed (ActionEvent e){
		
		String message = new String();
		System.out.println("actionPerformed");
		if(e.getActionCommand().equals("ACCEDIR")){
			
			vistaAccedir.setVisible(true);
		}
		
		if(e.getActionCommand().equals("REGISTRE")){
			
			vistaRegistre.setVisible(true);
				
		}
		
		if(e.getActionCommand().equals("SESSIO")){
			
			viewClient.noPotsJugar();
			viewClient.sessioTancada();
				
		}
		
		
		if(e.getActionCommand().equals("OK1")){
			
			System.out.println("BOTO OK APRETAT");
			message = "LOG:"+vistaAccedir.getNickname()+"/"+vistaAccedir.getPasword();
			//System.out.println(message);
			if(comunicacioS.sendUsuariAccedir(message)){
				viewClient.updateEstat("Has accedit correctament!");
				viewClient.potsJugar();
				viewClient.sessioActiva();
				
			}else{
				viewClient.updateEstat("No has pogut accedir");
			}
			
		}
		
		if(e.getActionCommand().equals("OK2")){
			
			System.out.println("BOTO OK2 APRETAT");
			message = "ADD:"+vistaRegistre.getNickname()+"/"+vistaRegistre.getPasword();
			System.out.println("FORMAT:" + message);
			if (comunicacioS.sendUsuariARegistrar(message)){
				viewClient.updateEstat("Has estat registrat correctament!");
				
			}else{
				viewClient.updateEstat("No has pogut ser registrat");
			}
			
		}
		
			
		
	}
	
	
}
