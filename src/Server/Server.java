package Server;
import java.net.*;
import java.io.*;

public class Server {
	ServerSocket server;
	private int count =0;
	private int port;
	
	
	public Server(int x){
		port=x;
	}
	
	public void todo(){
		Socket client;
		String command;
		DataInputStream in;
		DataOutputStream out;
		
		System.out.println("Apro connessione sul port "+port);
		
		try{
			server= new ServerSocket(port);
			System.out.println("In attesa su port "+port);
			
			while(true){
				client=server.accept();
				System.out.println("Connessione stabilita..");
				
				in=new DataInputStream(client.getInputStream());
				out=new DataOutputStream(client.getOutputStream());
				
				do{
					System.out.println("Server in attesa di comandi..");
					command= in.readUTF();
					System.out.println("Comando: "+command);
					
					if(command.compareTo("Incrementa")==0){
						count=count+in.readInt();
					}
					else if(command.compareTo("Leggi")==0){
						out.writeInt(count);
					}
					else if(command.compareTo("Bye")==0){
						System.out.println("Ciao!");
					}
					else
						System.out.println("Comando sconosciuto!");
					
				}while(command.compareTo("Bye")!=0);		
				System.out.println("Chiusura Server.."); 
			}
			
			//in.close();
			//out.close();
			//server.close();
			
		}
		catch (IOException e){
			System.err.println("Creazione Connessione Server fallita..");
			e.printStackTrace();
		}
	}
	

}
