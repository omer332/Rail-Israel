package classes;

/*Omer Sananes & Lilach Laniado*/
import interfaces.StringToIntTime;

public class Ride implements StringToIntTime {

	private String origin;
	private String destination;
	private String leavingTime;
	private String arrivalTime;
	private Middle[] stationArr;

	// Contractor for stop stations
	public Ride(String origin, String destination, String leavingTime, String arrivalTime, Middle[] stationArr) {
		this.origin = origin;
		this.destination = destination;
		this.leavingTime = leavingTime;
		this.arrivalTime = arrivalTime;
		this.stationArr = stationArr;
	}
	// Contractor for direct trains

	public Ride(String origin, String destination, String leavingTime, String arrivalTime) {
		this.origin = origin;
		this.destination = destination;
		this.leavingTime = leavingTime;
		this.arrivalTime = arrivalTime;
	}

	// Contractor for match
	public Ride(String str) {
		String rideStr[] = str.split(",");
		this.origin = rideStr[0];
		this.leavingTime = rideStr[1];
		this.destination = rideStr[2];
		this.arrivalTime = rideStr[3];
	}

	public void addMiddleToAnExistedRide(Ride rd) {

	}

	// getters
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

	public Middle[] getStationArr() {
		return stationArr;
	}

	// setters
	public void setStationArr(Middle[] stationArr) {
		this.stationArr = stationArr;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getHours() {
		int[] sort = new int[2];
		String[] split = leavingTime.split(":");
		return sort[0] = Integer.parseInt(split[0]);// Hour
	}

	public int getMinutes() {
		int[] sort = new int[2];
		String[] split = leavingTime.split(":");
		return sort[1] = Integer.parseInt(split[1]);// Minute

	}

	// toString
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(origin + "," + leavingTime + "," + destination + "," + arrivalTime);
		sb.append(System.lineSeparator());
		if (stationArr != null) {
			for (int i = 0; i < stationArr.length; i++) {
				if (stationArr[i] != null)
					sb.append("middle # " + (i + 1) + stationArr[i].toString());
			}
		} else
			sb.append("Direct Train\n");
		return sb.toString();
	}

}
