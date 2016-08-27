package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;




import model.Logica;

import controller.ButtonsController;

/**
 * Classe que rep les peticions del Client
 * @author Albert
 *
 */
public class ServerS extends Thread{
	
	/**
	 * Socket del servidor
	 */
	private static ServerSocket sServer;
	
	/**
	 * boolea que mantindrà el servidor sempre escoltant peticions
	 */
	private boolean escoltant;
	
	/**
	 * Socket del client
	 */
	private static Socket sClient;
	/**
	 * Input del servidor per on entra la informació del client
	 */
	private DataInputStream dataIn;
	/**
	 * Output per on sortira l'answer
	 */
	private static DataOutputStream dataOut;
	/**
	 * Controlador
	 */
	private ButtonsController controller;
	/**
	 * Creem el socket del servidor
	 * @param PortC
	 */
	public ServerS(int PortC){
		try{
			sServer = new ServerSocket(PortC);
			escoltant = false;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void registerController(ButtonsController controller){
		this.controller = controller;
	}
	/**
	 * Iniciem el servidor
	 */
	public void iniciaServidor(){
		escoltant = true;
		super.start();
		System.out.println("Obrint servidor...");
	}
	
	/**
	 * Pausem el servidor
	 */
	public void aturaServidor(){
		escoltant = false;
	}
	/**
	 * Iniciem el servidor i el deixem en espera a noves peticions, rebem la informacio i e funcio del que rebem contestem el que demanen
	 */
	public void run(){

		String message = new String();
		//LinkedList<Contrincant> = new LinkedList<Contrincant>();
		
		while(escoltant){
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
				
				/*if(message.startsWith("MAPES")){
					dataOut.writeByte(Logica.enviaEscenaris());
				}*/
				dataIn.close();
				dataOut.close();
				sClient.close();
			}catch(IOException e){
				
			}
	
		}
	}

}
