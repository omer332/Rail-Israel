package main;

/*Omer Sananes & Lilach Laniado*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Middle;
import classes.Ride;
import classes.RideManagement;

public class Program {

	// sort by leaving time
	public static void sortTime(ArrayList<Ride> arrRide) {
		for (int i = 0; i < arrRide.size() - 1; i++) {
			if (arrRide.get(i).getHours() > arrRide.get(i + 1).getHours())
				swap(arrRide, i, i + 1);
			if (arrRide.get(i).getHours() == arrRide.get(i + 1).getHours())
				if (arrRide.get(i).getMinutes() > arrRide.get(i + 1).getMinutes())
					swap(arrRide, i, i + 1);
		}
	}

	// swap for sorting
	public static void swap(ArrayList<Ride> arrRide, int i, int j) {
		Ride temp = arrRide.get(i);
		arrRide.set(i, arrRide.get(j));
		arrRide.set(j, temp);
	}

	// resizing array for reading.
	private static Middle[] resizeArray(Middle[] oldArray, int newSize) {
		Middle[] bigger = new Middle[newSize];
		bigger = Arrays.copyOf(oldArray, newSize);
		return bigger;
	}

	// Static variables
	public static ArrayList<Ride> rideArrfree = new ArrayList<Ride>();
	public final static String F_NAME = "RideResult.txt";

	// reading file
	public static ArrayList<Ride> ReadingFromFile(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			Ride rd = null;
			int size = 1;
			Middle[] midArr = new Middle[size];
			String s1 = br.readLine();
			while (s1 != null) {
				if (s1.equals("") || s1.equals("Direct Train")) {
					s1 = br.readLine();
					continue;
				}
				if (s1.contains("middle # ")) {
					Middle md = new Middle(s1);
					midArr = resizeArray(midArr, size++);
					for (int i = 0; i < midArr.length; i++) {
						if (midArr[i] == null)
							midArr[i] = md;
					}
					rd.setStationArr(midArr);
					s1 = br.readLine();
					continue;
				} else {
					size = 1;
					midArr = new Middle[size];
					rd = new Ride(s1);
					rideArrfree.add(rd);
					s1 = br.readLine();
				}
			}
			// System.out.println("reading file completed.");//TESTING
			br.close();
			fr.close();
			return rideArrfree;
		} catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		return rideArrfree;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Ride> rideArr = new ArrayList<Ride>();
		RideManagement management;
		boolean ok = true;
		System.out.println("Hello and welcome to the program!");
		// menu
		do {
			System.out.println("Please choose from the following:");
			System.out.println("1 - Entering ride information");
			System.out.println("2 - Summary of the rides that has been sorted by the leaving time");
			System.out.println("3 - Searching ride");
			System.out.println("4 - Save all rides to a file");
			System.out.println("5 - Load rides from an existed file");
			System.out.println("9 - Exit");
			int question = scan.nextInt();
			scan.nextLine();
			switch (question) {
			// Entering Rides by worker
			case 1:
				try {
					System.out.println("Please enter origin station");
					String origin = scan.nextLine();
					origin = origin.trim();
					for (int i = 0; i < origin.length(); i++) {
						if (origin.charAt(i) == ' ')
							origin = origin.replace(origin.charAt(i), '_');
					}
					System.out.println("Please enter leaving time (in a format of 00:00)");
					String leavingTime = scan.nextLine();
					if (!leavingTime.matches("\\d{2}:\\d{2}"))
						throw new InputMismatchException();
					System.out.println("Please choose destination station");
					String destination = scan.nextLine();
					destination = destination.trim();
					for (int i = 0; i < destination.length(); i++) {
						if (destination.charAt(i) == ' ')
							destination = destination.replace(destination.charAt(i), '_');
					}
					System.out.println("Please enter arrival time (in a format of 00:00)");
					String arrivalTime = scan.nextLine();
					if (!arrivalTime.matches("\\d{2}:\\d{2}"))
						throw new InputMismatchException();
					System.out.println("How many middle stations to add?");
					int numOfMiddleStation = scan.nextInt();
					Middle[] stationArr = new Middle[numOfMiddleStation];
					scan.nextLine();
					for (int i = 0; i < numOfMiddleStation; i++) {
						System.out.println("Please enter middle station for # " + (i + 1));
						String middleStation = scan.nextLine();
						middleStation = middleStation.trim();
						for (int i1 = 0; i1 < middleStation.length(); i1++) {
							if (middleStation.charAt(i1) == ' ')
								middleStation = middleStation.replace(middleStation.charAt(i1), '_');
						}
						System.out.println("Please enter middle station's leaving time for # " + (i + 1)
								+ "(in a format of 00:00)");
						String middleTime = scan.nextLine();
						if (!middleTime.matches("\\d{2}:\\d{2}"))
							throw new InputMismatchException();
						stationArr[i] = new Middle(middleStation, middleTime);
					}
					Ride temp = new Ride(origin, destination, leavingTime, arrivalTime, stationArr);
					rideArr.add(temp);
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				} catch (InputMismatchException e) {
					System.out.println("You put numbers or letters where you were not supposed to .. try again!");
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				}
				// sorting rides by leaving time
			case 2:
				sortTime(rideArr);
				System.out.println(rideArr.toString());
				// back to menu
				System.out.println("\n Welcome Back! \n");
				break;
			// Searching a ride by request
			case 3:
				try {
					sortTime(rideArr);
					System.out.println("Please enter your origin station");
					String searchOrigin = scan.nextLine();
					searchOrigin = searchOrigin.trim();
					for (int i = 0; i < searchOrigin.length(); i++) {
						if (searchOrigin.charAt(i) == ' ')
							searchOrigin = searchOrigin.replace(searchOrigin.charAt(i), '_');
					}
					System.out.println("Please enter your destination");
					String searchDestination = scan.nextLine();
					searchDestination = searchDestination.trim();
					for (int i = 0; i < searchDestination.length(); i++) {
						if (searchDestination.charAt(i) == ' ')
							searchDestination = searchDestination.replace(searchDestination.charAt(i), '_');
					}
					System.out.println("Please enter the hour you want to leave (01-24)");
					int searchHour = scan.nextInt();
					System.out.println("Please enter the minutes you want to leave (00-59)");
					int searchMin = scan.nextInt();
					management = new RideManagement(rideArr);
					System.out.println(management.match(searchOrigin, searchDestination, searchHour, searchMin));
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				} catch (InputMismatchException e) {
					System.out.println("You put numbers or letters where you were not supposed to .. try again!");
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				}
				// Writing entered data to a file.
			case 4:
				try {
					File file = new File(F_NAME);
					if (file.createNewFile())
						System.out.println("File created: " + file.getName());
					else
						System.out.println("File already exists.");
				} catch (IOException e) {
					System.out.println("ERROR");
					e.printStackTrace();
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				}
				try {
					PrintWriter pw = new PrintWriter(F_NAME);
					for (int i = 0; i < rideArr.size(); i++)
						pw.print(rideArr.get(i).toString());
					System.out.println("File write has been completed");
					pw.close();
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				} catch (IOException e) {
					System.out.println("ERROR");
					e.printStackTrace();
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				}
				// Reading from a file.
			case 5:
				try {
					File f = new File(F_NAME);
					if (f.exists()) {
						rideArr = ReadingFromFile(F_NAME);
						// back to menu
						System.out.println("\n Welcome Back! \n");
						break;
					} else
						throw new FileNotFoundException();
				} catch (FileNotFoundException e) {
					System.out.println("File is not exist. Try Again!");
					e.printStackTrace();
					// back to menu
					System.out.println("\n Welcome Back! \n");
					break;
				}
				// exit
			case 9:
				System.out.println("Thank your for using the program! \n This program was made by OmerS && LilachL");
				ok = false;
				break;
			}
		} while (ok == true);
		System.out.println();
		scan.close();
	}

	// Data collected to web connection.
	public void getDataFromWeb(String[] args) {
		if (args.length > 0) {// data exist?
			try {
				File f = new File(F_NAME);
				if (f.exists())
					rideArrfree = ReadingFromFile(F_NAME);
				else
					throw new FileNotFoundException();
				RideManagement mangment = new RideManagement(rideArrfree);
				// for web
				if (args[0].equals("html")) {
					System.out.println("<br>");
					System.out.println("Rides that fits are:" + "<br>");
					// for regular print
				} else
					System.out.println("Rides that fits are: ");
				String back = mangment.match(args[1], args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]));
				System.out.println(back + "/n");
			} catch (FileNotFoundException e) {
				System.out.println("File is not exist. Try Again!");
				e.printStackTrace();
			}
		}
	}
}
