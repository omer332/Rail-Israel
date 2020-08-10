
import java.util.ArrayList;

public class RideMangment {

	ArrayList<Ride> arrRide = new ArrayList<Ride>();


	public RideMangment(ArrayList<Ride> arrRide) {
		this.arrRide = arrRide;
	}

	public void sortTime() {
		for (int i = 0; i < arrRide.size()-1; i++) {
			if (arrRide.get(i).getHours()>arrRide.get(i+1).getHours()) 
				swap (arrRide.get(i), arrRide.get(i+1));
			if (arrRide.get(i).getHours()==arrRide.get(i+1).getHours()) 
				if (arrRide.get(i).getMinutes()>arrRide.get(i+1).getMinutes())
					swap(arrRide.get(i), arrRide.get(i+1));
		}
	}

	public void swap (Ride ride1, Ride ride2) {
		Ride temp = ride1;
		ride1 = ride2;
		ride2 = temp;
	}

}
