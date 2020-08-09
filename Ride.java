package sprint1;

public class Ride {

	private String origin;
	private String destination;
	private String leavingTime;
	private String arrivalTime;
	

	public static int idGenerator = 0;
	private int rideNumber;

	public Ride(String origin, String destination, String leavingTime, String arrivalTime) {
		this.origin = origin;
		this.destination = destination;
		this.leavingTime = leavingTime;
		this.arrivalTime = arrivalTime;
		rideNumber = idGenerator++;
	
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getLeavingTime() {
		return leavingTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getrideNumber() {
		return rideNumber;
	}

	public int getHours() {
		int[] sort = new int[2];
		String[] split = getLeavingTime().split(":");
		return sort[0] = Integer.parseInt(split[0]);// Hour
	}
	
	public int getMinutes() {
		int[] sort = new int[2];
		String[] split = getLeavingTime().split(":");
		return sort[1] = Integer.parseInt(split[1]);// Minute
		
	}
	

	@Override
	public String toString() {
		return origin + "," + leavingTime + "," + destination + "," + arrivalTime;
	}



}
