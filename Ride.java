
public class Ride {
	public enum station {
		Hashlom("Tel Aviv-Hashalom"), HaAgana("Tel Aviv-HaHagana"), KfarSaba("Kfar Saba");

		private String stationName;

		private station(String station) {
			this.stationName = station;
		}

		@Override
		public String toString() {
			return stationName;
		}
	}

	private station origin;
	private station destination;
	private String leavingTime;
	private String arrivalTime;
	private int[] sort = new int[2];
	
	public static int idGenerator = 0;
	private int rideNumber;

	public Ride(station origin, station destination, String leavingTime, String arrivalTime) {
		this.origin = origin;
		this.destination = destination;
		this.leavingTime = leavingTime;
		this.arrivalTime = arrivalTime;
		rideNumber = idGenerator++;
		setSort(leavingTime);
	}

	public station getOrigin() {
		return origin;
	}

	public station getDestination() {
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
	
	private int getSortHour() {
		return sort[0];
	}
	private int getSortMin() {
		return sort[1];
	}

	private void setSort(String leavingTime) {
		String[] split = leavingTime.split(":");
		sort[0] = Integer.parseInt(split[0]);
		sort[1] = Integer.parseInt(split[1]);
	}

	public int compareToHours(Ride one, Ride two) {
		return two.getSortHour()- one.getSortHour();
	}
	public int compareToMin(Ride one, Ride two) {
		return two.getSortMin()- one.getSortMin();
	}
	@Override
	public String toString() {
		return origin.toString() + "," + leavingTime + "," + destination.toString() + "," + arrivalTime;
	}

}
