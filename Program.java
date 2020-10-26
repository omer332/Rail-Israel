package main;
/*Omer Sananes & Lilach Laniado*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

	private static Middle[] resizeArray(Middle[] oldArray, int newSize) {
		Middle[] bigger = new Middle[newSize];
		bigger = Arrays.copyOf(oldArray, newSize);
		return bigger;
	}

	private static ArrayList<Ride> rideArr = new ArrayList<Ride>();
	public final static String F_NAME = "RideResult.txt";

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
			System.out.println("4 - Save all rides to a file");
			System.out.println("5 - Load rides from an existed file");
			System.out.println("9 - Exit");
			int question = scan.nextInt();
			scan.nextLine();
			switch (question) {
			case 1:
				System.out.println("Please enter origin");
				String origin = scan.nextLine();
				System.out.println("Please enter leaving time (in a format of 00:00)");
				String leavingTime = scan.nextLine();
				System.out.println("Please choose destination");
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
					System.out.println(
							"Please enter middle station's leaving time for # " + (i + 1) + "(in a format of 00:00)");
					String middleTime = scan.nextLine();
					stationArr[i] = new Middle(middle, middleTime);
				}
				Ride temp = new Ride(origin, destination, leavingTime, arrivalTime, stationArr);
				rideArr.add(temp);
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
				}
				try {
					PrintWriter pw = new PrintWriter(F_NAME);
					for (int i = 0; i < rideArr.size(); i++)
						pw.print(rideArr.get(i).toString());
					System.out.println("The file writing is completed");
					pw.close();
				} catch (IOException e) {
					System.out.println("ERROR");
					e.printStackTrace();
				}
				System.out.println("\n Welcome Back! \n");
				break;
			case 5:
				try {
					FileReader fr = new FileReader(F_NAME);
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
						if (s1.contains(" middle # ")) {
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
							rideArr.add(rd);
							s1 = br.readLine();
						}
					}
					System.out.println("reading file completed.");
					br.close();
					fr.close();
					System.out.println("\n Welcome Back! \n");
					break;
				} catch (IOException e) {
					System.out.println("ERROR");
					e.printStackTrace();
				}
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

	public void getDataFromWeb(String[] args) {
		if (args.length > 0) {
			File f = new File(F_NAME);
			if (f.exists()) {
				try {
					FileReader fr = new FileReader(F_NAME);
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
							rideArr.add(rd);
							s1 = br.readLine();
						}
					}
					System.out.println("reading file completed.");
					br.close();
					fr.close();
					RideMangment mangment = new RideMangment(rideArr);
					if (args[0].equals("html")) {
						System.out.println("<br>");
						System.out.println("Rides that fits are:" + "<br>");
					} else
						System.out.println("Rides that fits are: ");
					String back = mangment.match(args[1], args[2], Integer.parseInt(args[3]),
							Integer.parseInt(args[4]));
					System.out.println(back);
				} catch (IOException e) {
					System.out.println("ERROR");
					e.printStackTrace();
				}
			}
		}
	}
}
