package Server;
import SkeletonEreditarieta.*;

public class MainServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Server s=new Server(5000);
		//s.todo();
		
		CounterImpl c=new CounterImpl(5000);
		c.runSkeleton();


	}

}
