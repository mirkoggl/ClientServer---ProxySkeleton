package Client;

import java.io.*;
import java.net.*;

public class ProxyCounter implements Counter {
	private String ind;
	private int port;
	private Socket c;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ProxyCounter(String s,int x){
		ind=s;
		port=x;
		connetti();
	}
	
	private void connetti(){
		
		try{
			
			c=new Socket(ind,port);
			in=new DataInputStream(c.getInputStream());
			out=new DataOutputStream(c.getOutputStream());
			
		}
		catch(IOException e){
			System.err.println("Connessione fallita..");
			e.printStackTrace();
		}	
	}

	public void incrementa(int x) {
		
		try {
			//connetti();
			out.writeUTF("Incrementa");
			out.writeInt(x);
			//chiudi();
			
		} catch (IOException e) {
			System.err.println("Errore Incrementa..");
			e.printStackTrace();
		}
			
		
	}

	public int stampa() {
		int x=0;
				
		try{
			//connetti();
			out.writeUTF("Leggi");
			x=in.readInt();
			//chiudi();
			
		}
		catch(IOException e){
			System.err.println("Errore Stampa..");
			e.printStackTrace();
		}
		return x;
	}
	
	public void chiudi(){
		
		try {
			out.writeUTF("Bye");
			in.close();
			out.close();
			c.close();
		}
		catch(IOException e){
			System.err.println("Errore chiusura..");
			e.printStackTrace();
		}
	}
}
