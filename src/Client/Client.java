package Client;

public class Client {
	private ProxyCounter count;
	private String ind;
	private int port;
	
	public Client(String s,int x){
		ind=s;
		port=x;
		count= new ProxyCounter(ind,port);
	}
	
	public void todo(){
		
				
		System.out.println("Incremento Variabile..");
		count.incrementa(40);
		System.out.println("Valore letto: "+count.stampa());
		
		System.out.println("Incremento Variabile..");
		count.incrementa(60);
		System.out.println("Valore letto: "+count.stampa());
		
		count.chiudi();
		
	}

}
