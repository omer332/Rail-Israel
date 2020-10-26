package classes;

import interfaces.StringToIntTime;

public class Ride implements StringToIntTime {

	private String origin;
	private String destination;
	private String leavingTime;
	private String arrivalTime;
	private Middle[] stationArr;

	public static int idGenerator = 0;
	private int rideNumber;

	public Ride(String origin, String destination, String leavingTime, String arrivalTime, Middle[] stationArr) {
		this.origin = origin;
		this.destination = destination;
		this.leavingTime = leavingTime;
		this.arrivalTime = arrivalTime;
		this.stationArr = stationArr;
		rideNumber = idGenerator++;
	
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
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

	public Middle[] getStationArr() {
		return stationArr;
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
	

	@Override
	public String toString() {
		String back = origin + "," + leavingTime + "," + destination + "," + arrivalTime + "\n";
		for (int i = 0; i < stationArr.length; i++) {
			if(stationArr[i] != null)
				back += " middle # " + (i+1) + stationArr[i].toString() + "\n";
		}
		return back;
	}



}