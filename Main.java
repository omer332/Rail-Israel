import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Ride> rideArr= new ArrayList<Ride>();
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
		System.out.println("Please choose origin from the list (press the number) :");
		System.out.println("1 - Tel Aviv-Hashalom");
		System.out.println("2 - Tel Aviv-HaHagana");
		System.out.println("3 - Kfar Saba");
		Ride.station origin = Ride.station.values()[scan.nextInt()];
		System.out.println("Please enter leaving time (in a format of 00:00)");
		String leavingTime = scan.nextLine();
		System.out.println("Please choose destination from the list (press the number) :");
		System.out.println("1 - Tel Aviv-Hashalom");
		System.out.println("2 - Tel Aviv-HaHagana");
		System.out.println("3 - Kfar Saba");
		Ride.station destination = Ride.station.values()[scan.nextInt()];
		System.out.println("Please enter estimated arrival time (in a format of 00:00)");
		String arrivalTime = scan.nextLine();
		Ride temp = new Ride(origin, destination, leavingTime, arrivalTime);
		rideArr.add(temp);
		System.out.println("/n Welcome Back! /n");
	case 2:
		
	case 9:
		System.out.println("Thank your for using the program! /n This program was made by ⒸOmerSⒸ");
ok = false;
break;
	
	}
}while(ok == true);
System.out.println();
	scan.close();}

}
