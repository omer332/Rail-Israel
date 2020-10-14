package classes;

import java.util.ArrayList;

public class RideMangment {

	ArrayList<Ride> arrRide = new ArrayList<Ride>();

	public RideMangment(ArrayList<Ride> arrRide) {
		this.arrRide = arrRide;
	}

	public String match(String origin, String destination, int hours, int minutes) {
		String result = "";
		Ride[] rideArr = new Ride[3];

		for (int i = 0; i < arrRide.size(); i++) {
			if (arrRide.get(i).getOrigin().equals(origin) && arrRide.get(i).getDestination().equals(destination)) {
				if (arrRide.get(i).getHours() >= hours && arrRide.get(i).getMinutes() >= minutes) {
					for (int j = 0; j < rideArr.length; j++) {
						if(rideArr[j] == null) {
							rideArr[j] = arrRide.get(i);
						break;
						}
					}
				}
			}

				if (arrRide.get(i).getStationArr().length > 0) {
					for (int k = 0; k < arrRide.get(i).getStationArr().length; k++) {
						if ((arrRide.get(i).getStationArr()[k].getStation().equals(origin)
								&& arrRide.get(i).getDestination().equals(destination))
								|| (arrRide.get(i).getOrigin().equals(origin)
										&& arrRide.get(i).getStationArr()[k].getStation().equals(destination))) {
							if (arrRide.get(i).getStationArr()[k].getHours() >= hours
									&& arrRide.get(i).getStationArr()[k].getMinutes() >= minutes)
								for (int j = 0; j < rideArr.length; j++) {
									if(rideArr[j] == null) {
										rideArr[j] = arrRide.get(i);
									break;
									}
								}
						}
							if (arrRide.get(i).getStationArr()[k].getStation().equals(origin)) {
								for (int l = 0; l < arrRide.get(i).getStationArr().length; l++) {
									if (arrRide.get(i).getStationArr()[l].getStation().equals(destination))
										if (arrRide.get(i).getStationArr()[k].getHours() >= hours
										&& arrRide.get(i).getStationArr()[k].getMinutes() >= minutes)
											for (int j = 0; j < rideArr.length; j++) {
												if(rideArr[j] == null) {
													rideArr[j] = arrRide.get(i);
												break;
												}
											}
								}
							}
					}
				}
						}
				if (rideArr[0] == null)
					return "NO RIDES MATCHES";
				else {
					for (int j = 0; j < rideArr.length; j++) {
						if (rideArr[j] != null)
							result += rideArr[j].toString();
					}
				}
				return result;

			}
		}