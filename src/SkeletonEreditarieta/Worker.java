package SkeletonEreditarieta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import Client.Counter;


public class Worker extends Thread{
	private Socket client;
	private Counter count;
	
	public Worker(Socket c, Counter x){
		client=c;	
		count=x;
		System.out.println("[Worker-"+this.getName()+"] avviato..");
	}
	
	
	public void run(){
		String command;
		DataInputStream in;
		DataOutputStream out;
		
		try{
			in=new DataInputStream(client.getInputStream());
			out=new DataOutputStream(client.getOutputStream());
			do{
				System.out.println("[Worker-"+this.getName()+"] Attesa command..");
				command=in.readUTF();
				System.out.println("Comando: "+command);
				
				if(command.compareTo("Incrementa")==0){
					count.incrementa(in.readInt());
				}
				else if(command.compareTo("Leggi")==0){
					out.writeInt(count.stampa());
				}
				else if(command.compareTo("Bye")==0){
					System.out.println("[Worker-"+this.getName()+"] Ciao!");
				}
				else
					System.out.println("[Worker-"+this.getName()+"] Comando sconosciuto!");
			}while(command.compareTo("Bye")!=0);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
