
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void sortTime(ArrayList<Ride> arrRide) {
		for (int i = 0; i < arrRide.size()-1; i++) {
			if (arrRide.get(i).getHours()>arrRide.get(i+1).getHours()) 
				swap (arrRide, i, i+1);
			if (arrRide.get(i).getHours()==arrRide.get(i+1).getHours()) 
				if (arrRide.get(i).getMinutes()>arrRide.get(i+1).getMinutes())
					swap(arrRide, i, i+1);
		}
	}

	public static void swap (ArrayList<Ride> arrRide ,int i, int j) {
		Ride temp = arrRide.get(i);
		arrRide.set(i, arrRide.get(j));
		arrRide.set(j, temp);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Ride> rideArr = new ArrayList<Ride>();
		boolean ok = true;
		
		do {
			System.out.println("Hello and welcome to the program!");
			System.out.println("Please choose from the following:");
			System.out.println("1 - Entering ride information");
			System.out.println("2 - Summary of the rides that has been sorted by the leaving time");
			System.out.println("9 - Exit");
			int question = scan.nextInt();
			switch (question) {
			case 1:
				System.out.println("Please choose origin from the list");
				String origin = scan.nextLine();
				scan.nextLine();
				System.out.println("Please enter leaving time (in a format of 00:00)");
				String leavingTime = scan.nextLine();
				System.out.println("Please choose destination from the list");
				String destination = scan.nextLine();
				System.out.println("Please enter estimated arrival time (in a format of 00:00)");
				String arrivalTime = scan.nextLine();
				Ride temp = new Ride(origin, destination, leavingTime, arrivalTime);
				rideArr.add(temp);
				System.out.println("\n Welcome Back! \n");
				break;
			case 2:
				sortTime(rideArr);
				System.out.println(rideArr.toString());
				System.out.println("\n Welcome Back! \n");
				break;
			case 9:
				System.out.println("Thank your for using the program! /n This program was made by ⒸOmerSⒸ && ⒸLilachLⒸ");
				ok = false;
				break;

			}
		} while (ok == true);
		System.out.println();
		scan.close();
	}

}
