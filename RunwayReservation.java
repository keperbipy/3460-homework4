import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.
		BST T = new BST();
		
		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.
		
		
		for (i = 0; i < n; i++) {

			if (reqs[i].getCommand().equals("r")) {
	
				T.findPreSuc(T.root, reqs[i].getTime());
				
				if (T.root == null) {
					T.insert(reqs[i].getTime(), i);
				}
				
				 else if (((T.pred.getTime() == -1 || reqs[i].getTime() - k >=  T.pred.getTime()) && T.root != null) &&
					       ((T.succ.getTime() == -1 || reqs[i].getTime() + k <=  T.succ.getTime()) && T.root != null))
				{
					T.insert(reqs[i].getTime(), i);
				}
				
			}
			
			
			else if (reqs[i].getCommand().equals("t")) {

				curtime = reqs[i].getTime() + curtime;
				System.out.println("Current time = " + curtime + " units");
				
				while (T.min(T.root).getTime() < curtime) { 
					System.out.println(reqs[T.min(T.root).getReq_index()].getAirline().toString());
					T.delete(T.min(T.root).getTime());
			
				}
			}
			
			
			T.pred = new Node(-1, -1);
			T.succ = new Node(-1, -1);
		}
		
		
		curtime = T.max(T.root).getTime();
		System.out.println("Current time = " + curtime + " units");
		T.print(T.root, reqs);
		
	}
	
	
	

}
	
	
	

