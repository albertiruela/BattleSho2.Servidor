package model;


import javax.swing.SwingUtilities;




import controller.ButtonsController;
import network.ComunicacioServidor;




import view.MainViewC;
import view.VistaAccedirC;
import view.VistaNouRegistre;


public class MainClient {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				Configuracio config = new Configuracio();
				
				if (config.fes()){
					
					MainViewC clientView = new MainViewC();
					VistaAccedirC vistaAccedir = new VistaAccedirC();
					VistaNouRegistre vistaRegistre = new VistaNouRegistre();
					
					ComunicacioServidor cServidor = new ComunicacioServidor (config.getIp(), config.getPortServer());
					
					ButtonsController controller = new ButtonsController(clientView,vistaAccedir,vistaRegistre,cServidor);
					
					
					
					clientView.registerController(controller);
					vistaAccedir.registerControllers(controller);
					vistaRegistre.registerControllers(controller);
					
					
					vistaAccedir.setVisible(false);
					vistaRegistre.setVisible(false);
					clientView.setVisible(true);
					
				}
			}
		});
	}
}
