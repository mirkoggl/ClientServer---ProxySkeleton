package SkeletonEreditarieta;

public class CounterImpl extends SkeletonCounter{
	private int count=0;
	
	public CounterImpl(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	
	public synchronized void incrementa(int x) {
		// TODO Auto-generated method stub
		count=count+x;
		
	}

	
	public synchronized int stampa() {
		// TODO Auto-generated method stub
		return count;
	}
	

}
