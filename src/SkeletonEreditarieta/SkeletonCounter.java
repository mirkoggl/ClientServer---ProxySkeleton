package SkeletonEreditarieta;

import java.io.IOException;
import java.net.*;

import Client.Counter;

public abstract class SkeletonCounter implements Counter{
	private ServerSocket server;
	private int port;
	
	public SkeletonCounter(int x){
		port=x;
		try{
			
			server = new ServerSocket(port);
			
		}catch(IOException e){
			e.printStackTrace();
			System.err.println("Creazione Skeleton fallita!");
		}
	}
	
	public void runSkeleton(){
		Socket client;
		
		try{
			
			while(true){
				System.out.println("Attesa connessioni..");
				client=server.accept();
				Worker w=new Worker(client,this);
				w.start();
				System.out.println("Connessione Skeleton stabilita..");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
