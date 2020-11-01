package classes;

/*Omer Sananes & Lilach Laniado*/
import interfaces.StringToIntTime;

public class Middle implements StringToIntTime {
	private String station;
	private String leavingTime;

	public Middle(String station, String leavingTime) {
		this.station = station;
		this.leavingTime = leavingTime;
	}

	public Middle(String str) {
		String[] midArr = str.split("-");
		String tempStation = midArr[1].replace(" leaving at", "");
		this.station = tempStation.trim();
		this.leavingTime = midArr[2].trim();
	}

	public String getStation() {
		return station;
	}

	public String getLeavingTime() {
		return leavingTime;
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
		return " middle station- " + station + " leaving at- " + leavingTime + "\n";
	}

}

