
public class BarrierThread extends Thread {
	
	
	private int barrierId;
	private int openingTime;
	private int closingTime;
	private volatile boolean running;
	int carsPassed = 0;
	
	public BarrierThread(int barrierId, int openingTime, int closingTime ) {
		
		this.barrierId = barrierId;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.running = true;
		 
	}
	
	public void run() {
		
	
		
		while( running) {
			
		            if (carsPassed >= 10) {
		                running = false;
		                break;
		            }
			
			
			System.out.println("Barrier" +barrierId+ ": Start openning");
			
			 try {
	                Thread.sleep(openingTime * 1000); // Convert seconds to milliseconds
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			 
  System.out.println("Barrier " + barrierId + ": End Opening");
			 
  System.out.println("Barrier " + barrierId + ": Start Closing");
	            try {
	                Thread.sleep(closingTime * 1000); // Convert seconds to milliseconds
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	           System.out.println("Barrier " + barrierId + ": End Closing");
			 
			 
			 carsPassed++;
			 
		}
	}
	
	public void cancel() {
		running = false;
	}
	

}
