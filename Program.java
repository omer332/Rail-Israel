package main;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Middle;
import classes.Ride;
import classes.RideMangment;

public class Program {
	public static void sortTime(ArrayList<Ride> arrRide) {
		for (int i = 0; i < arrRide.size() - 1; i++) {
			if (arrRide.get(i).getHours() > arrRide.get(i + 1).getHours())
				swap(arrRide, i, i + 1);
			if (arrRide.get(i).getHours() == arrRide.get(i + 1).getHours())
				if (arrRide.get(i).getMinutes() > arrRide.get(i + 1).getMinutes())
					swap(arrRide, i, i + 1);
		}
	}

	public static void swap(ArrayList<Ride> arrRide, int i, int j) {
		Ride temp = arrRide.get(i);
		arrRide.set(i, arrRide.get(j));
		arrRide.set(j, temp);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Ride> rideArr = new ArrayList<Ride>();
		RideMangment mangment = new RideMangment(rideArr);
		boolean ok = true;

		do {
			System.out.println("Hello and welcome to the program!");
			System.out.println("Please choose from the following:");
			System.out.println("1 - Entering ride information");
			System.out.println("2 - Summary of the rides that has been sorted by the leaving time");
			System.out.println("3 - Searching ride");
			System.out.println("9 - Exit");
			int question = scan.nextInt();
			scan.nextLine();
			switch (question) {
			case 1:
				System.out.println("Please enter origin");
				String origin = scan.nextLine();

				System.out.println("Please enter leaving time (in a format of 00:00)");
				String leavingTime = scan.nextLine();
				System.out.println("Please choose destination from the list");
				String destination = scan.nextLine();
				System.out.println("Please enter estimated arrival time (in a format of 00:00)");
				String arrivalTime = scan.nextLine();
				System.out.println("How many middle stations to add?");
				int num = scan.nextInt();
				Middle[] stationArr = new Middle[num];
				scan.nextLine();
				for (int i = 0; i < num; i++) {
					System.out.println("Please enter middle station for # " + (i + 1));
					String middle = scan.nextLine();
					System.out.println("Please enter middle station's leaving time for # " + (i + 1));
					String middleTime = scan.nextLine();
					stationArr[i] = new Middle(middle, middleTime);
				}
				Ride temp = new Ride(origin, destination, leavingTime, arrivalTime, stationArr);
				rideArr.add(temp);
				rideArr.get(0).getOrigin().replace("[", "");
				System.out.println("\n Welcome Back! \n");
				break;
			case 2:
				sortTime(rideArr);
				System.out.println(rideArr.toString());
				System.out.println("\n Welcome Back! \n");
				break;
			case 3:
				sortTime(rideArr);
				System.out.println("Please enter your origin station");
				String searchOrigin = scan.nextLine();
				System.out.println("Please enter your destination");
				String searchDestination = scan.nextLine();
				System.out.println("Please enter the hour you want to leave (01-24)");
				int searchHour = scan.nextInt();
				System.out.println("Please enter the minutes you want to leave (00-59)");
				int searchMin = scan.nextInt();
				System.out.println(mangment.match(searchOrigin, searchDestination, searchHour, searchMin));
				System.out.println("\n Welcome Back! \n");
				break;
			case 9:
				System.out
						.println("Thank your for using the program! \n This program was made by ⒸOmerSⒸ && ⒸLilachLⒸ");
				ok = false;
				break;

			}
		} while (ok == true);
		System.out.println();
		scan.close();
	}

}