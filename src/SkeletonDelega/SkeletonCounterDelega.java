package SkeletonDelega;

import Client.Counter;
import java.io.*;
import java.net.*;

public class SkeletonCounterDelega implements Counter{
	private Counter count;
	private ServerSocket server;
	private int port;
	
	public SkeletonCounterDelega (int x){
		
		port = x;
		
		try {
			
			server=new ServerSocket(port);
			
		}
		catch(IOException e){
			System.err.println("Connessione fallita!");
			e.printStackTrace();
		}
		
	}
	
	/*public void runSkeleton(){
		Socket client;
		
		try {
			
			client=server.accept();
			
		}
		catch(IOException e){
			System.err.println("Connessione fallita!");
			e.printStackTrace();
		}
		
	}*/
	
	public void incrementa(int x) {
		 count.incrementa(x);
		
	}

	
	public int stampa() {
		return count.stampa();
	}

}
