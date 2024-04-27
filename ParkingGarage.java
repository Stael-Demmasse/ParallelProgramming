import java.util.Scanner;

public class ParkingGarage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enteer de number of barriers: ");
		
		int numBarriers = sc.nextInt();
		
		 BarrierThread[] barrierThreads = new BarrierThread[numBarriers];
		 
		 for (int i = 0; i < numBarriers; i++) {
	            System.out.print("Enter the opening time for Barrier " + (i + 1) + ": ");
	            int openingTime = sc.nextInt();

	            System.out.print("Enter the closing time for Barrier " + (i + 1) + ": ");
	            int closingTime = sc.nextInt();

	            barrierThreads[i] = new BarrierThread(i + 1, openingTime, closingTime);
	            barrierThreads[i].start();
	        }

	        sc.nextLine(); // Consume the newline character

	        System.out.println("Press any key to stop the program.");
	        sc.nextLine();

	        for (BarrierThread barrierThread : barrierThreads) {
	            barrierThread.cancel();
	        }
	        
	        sc.close();

	}

}
