package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;




import model.Logica;

import controller.ButtonsController;


public class ServerS extends Thread{
	
	private boolean isOn;
	
	private static ServerSocket sServer;
	
	private static Socket sClient;
	
	private DataInputStream dataIn;
	
	private static DataOutputStream dataOut;
	
	private ButtonsController controller;
	
	public ServerS(int portClient){
		try{
			sServer = new ServerSocket(5200);
			isOn = false;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void registerController(ButtonsController controller){
		this.controller = controller;
	}
	
	public void iniciaServidor(){
		isOn = true;
		super.start();
		System.out.println("Obrint servidor...");
	}
	
	
	public void aturaServidor(){
		isOn = false;
	}
	
	public void run(){

		String message = new String();
		
		while(isOn){
			try{
				
				sClient = sServer.accept();
				System.out.println("Arribo aqui");
				dataIn = new DataInputStream(sClient.getInputStream());
				dataOut = new DataOutputStream(sClient.getOutputStream());
				
				message = dataIn.readUTF();
				
				System.out.println(message);
				
				if (message.startsWith("ADD")){
						
					if(Logica.addUser(message)){
						dataOut.writeUTF("OK");
					}else{
						dataOut.writeUTF("KO");
					}		
				}
				
				if (message.startsWith("LOG")){
					dataOut.writeUTF(Logica.checkUser(message));
				}
				
	
				dataIn.close();
				dataOut.close();
				sClient.close();
			}catch(IOException e){
				
			}
	
		}
	}

}
