package classes;

/*Omer Sananes & Lilach Laniado*/
import java.util.ArrayList;

public class RideManagement {

	ArrayList<Ride> arrRide = new ArrayList<Ride>();

	public RideManagement(ArrayList<Ride> arrRide) {
		this.arrRide = arrRide;
	}

	public String match(String origin, String destination, int hours, int minutes) {
		String result = "", temp = "";
		Ride[] rideArr = new Ride[3];
		origin = origin.trim();
		destination = destination.trim();
		// Matching direct lines
		for (int i = 0; i < arrRide.size(); i++) {
			arrRide.get(i).setOrigin(arrRide.get(i).getOrigin().trim());
			arrRide.get(i).setDestination(arrRide.get(i).getDestination().trim());
			if (arrRide.get(i).getOrigin().equals(origin) && arrRide.get(i).getDestination().equals(destination)) {
				if (arrRide.get(i).getHours() > hours
						|| ((arrRide.get(i).getHours() == hours) && (arrRide.get(i).getMinutes() >= minutes))) {
					for (int j = 0; j < rideArr.length; j++) {
						if (rideArr[j] == null) {
							rideArr[j] = arrRide.get(i);
							break;
						}
					}
				}
			}
			// Matching stops stations
			if (arrRide.get(i).getStationArr() != null) {
				if (arrRide.get(i).getStationArr().length > 0) {
					for (int k = 0; k < arrRide.get(i).getStationArr().length; k++) {
//						arrRide.get(i).getStationArr()[k]
//								.setStation(arrRide.get(i).getStationArr()[k].getStation().trim());
						if ((arrRide.get(i).getStationArr()[k].getStation().equals(origin)
								&& arrRide.get(i).getDestination().equals(destination))
								|| (arrRide.get(i).getOrigin().equals(origin)
										&& arrRide.get(i).getStationArr()[k].getStation().equals(destination))) {
							if ((arrRide.get(i).getStationArr()[k].getHours() > hours)
									|| ((arrRide.get(i).getStationArr()[k].getHours() == hours)
											&& (arrRide.get(i).getStationArr()[k].getMinutes() >= minutes))) {
								if (arrRide.get(i).getStationArr()[k].getMinutes() >= minutes)
									for (int j = 0; j < rideArr.length; j++) {
										if (rideArr[j] == null) {
											rideArr[j] = arrRide.get(i);
											break;
										}
									}
							}
						}
						if (arrRide.get(i).getStationArr()[k].getStation().equals(origin)) {
							for (int l = 0; l < arrRide.get(i).getStationArr().length; l++) {
								if (arrRide.get(i).getStationArr()[l].getStation().equals(destination))
									if (arrRide.get(i).getStationArr()[k].getHours() > hours) {
										for (int j = 0; j < rideArr.length; j++) {
											if (rideArr[j] == null) {
												rideArr[j] = arrRide.get(i);
												break;
											}
										}
									}
								if (arrRide.get(i).getStationArr()[k].getHours() == hours) {
									if (arrRide.get(i).getStationArr()[k].getMinutes() >= minutes)
										for (int j = 0; j < rideArr.length; j++) {
											if (rideArr[j] == null) {
												rideArr[j] = arrRide.get(i);
												break;
											}
										}
								}
							}
						}
					}
				}
			}
		}
		// results
		if (rideArr[0] == null)
			return "NO RIDES MATCHES";
		else {
			for (int j = 0; j < rideArr.length; j++) {
				if (rideArr[j] != null) {
					for (int i = 0; i < rideArr[j].getOrigin().length(); i++) {
						if (rideArr[j].getOrigin().charAt(i) == '_') {
							temp = rideArr[j].getOrigin().replace(rideArr[j].getOrigin().charAt(i), ' ');
							rideArr[j].setOrigin(temp);
						}
					}
					for (int i = 0; i < rideArr[j].getDestination().length(); i++) {
						if (rideArr[j].getDestination().charAt(i) == '_') {
							temp = rideArr[j].getDestination().replace(rideArr[j].getDestination().charAt(i), ' ');
							rideArr[j].setDestination(temp);
						}
					}
					if (rideArr[j].getStationArr() != null) {
						for (int j2 = 0; j2 < rideArr[j].getStationArr().length; j2++) {
							for (int i = 0; i < rideArr[j].getStationArr()[j2].getStation().length(); i++) {
								if (rideArr[j].getStationArr()[j2].getStation().charAt(i) == '_') {
									temp = rideArr[j].getStationArr()[j2].getStation()
											.replace(rideArr[j].getStationArr()[j2].getStation().charAt(i), ' ');
									rideArr[j].getStationArr()[j2].setStation(temp);
								}
							}
						}
					}
					result += (rideArr[j].toString() + "\r\n");
				}
			}
		}
		return result;

	}
}
