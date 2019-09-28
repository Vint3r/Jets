package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApplication {
	private AirField af = new AirField();
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();

		ja.launch();
		ja.menuSystem();

		ja.input.close();
	}

	public void launch() {
		FileReader fr = null;
		BufferedReader br = null;
		long price = 0l;
		Integer range = 0, numOfPass = 0, carryingCap = 0;
		String model = "", type = "", weapons = "";
		double speed = 0.0;
		try {
			fr = new FileReader("JetFile.txt");
			br = new BufferedReader(fr);
			String lineOfText = br.readLine();
			while (lineOfText != null) {
				String[] parts = new String[5];
				parts = lineOfText.split(", ");
				type = parts[0];
				if (type.contentEquals("f")) {
					model = parts[1];
					speed = Double.parseDouble(parts[2]);
					range = Integer.parseInt(parts[3]);
					price = Long.parseLong(parts[4]);
					weapons = parts[5];
					Jet jet = new FighterJet(model, speed, range, price, weapons);
					af.addJet(jet);
				} else if (type.contentEquals("c")) {
					model = parts[1];
					speed = Double.parseDouble(parts[2]);
					range = Integer.parseInt(parts[3]);
					price = Long.parseLong(parts[4]);
					carryingCap = Integer.parseInt(parts[5]);
					Jet jet = new CargoJet(model, speed, range, price, carryingCap);
					af.addJet(jet);
				} else if (type.contentEquals("p")) {
					model = parts[1];
					speed = Double.parseDouble(parts[2]);
					range = Integer.parseInt(parts[3]);
					price = Long.parseLong(parts[4]);
					numOfPass = Integer.parseInt(parts[5]);
					Jet jet = new BasicJet(model, speed, range, price, numOfPass);
					af.addJet(jet);
				}
				lineOfText = br.readLine();
			}
			br.close();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void menuSystem() {
		boolean userIn = true;
		while (userIn) {
			System.out.println("+----------------------------------------------------------------+");
			System.out.println("|****************************************************************|");
			System.out.println("|****************Welcome to the Jets Application!****************|");
			System.out.println("|****************Please select an option below...****************|");
			System.out.println("|****************************************************************|");
			System.out.println("|================================================================|");
			System.out.println("|1.)****************List every plane in the fleet.***************|");
			System.out.println("|2.)***********Fly all jets currently in the air field.**********|");
			System.out.println("|3.)*************View the fastest jet in the fleet.**************|");
			System.out.println("|4.)************View the jet with the longest range.*************|");
			System.out.println("|5.)************Load all the cargo jets in the field.************|");
			System.out.println("|6.)*************Load all passengers onto the planes.************|");
			System.out.println("|7.)******************Oh no! Enemies incoming!!******************|");
			System.out.println("|8.)********************Add a jet to the fleet.******************|");
			System.out.println("|9.)****************Remove a jet from the fleet.*****************|");
			System.out.println("|10.)***************************Quit.****************************|");
			System.out.println("+----------------------------------------------------------------+");

			String choice = input.nextLine();

			switch (choice.toLowerCase()) {
			case "1":
			case "one":
			case "list":
				af.getJetInfo();
				break;
			case "2":
			case "two":
			case "fly":
				af.flyJets();
				break;
			case "3":
			case "three":
			case "fastest":
				af.getFastest();
				break;
			case "4":
			case "four":
			case "range":
				af.getLongestRange();
				break;
			case "5":
			case "five":
			case "load":
				af.loadAllCargo();
				break;
			case "6":
			case "six":
			case "load passengers":
				af.loadPassengers();
				break;
			case "7":
			case "seven":
			case "oh no":
				af.dogFight();
				break;
			case "8":
			case "eight":
			case "add":
				af.addJetMenu(input);
				break;
			case "9":
			case "nine":
			case "remove":
				af.removeUserJet(input);
				break;
			case "10":
			case "ten":
			case "quit":
			case "end":
				System.out.println("Thank you for using the Jets Application!! Have a good day!!");
				userIn = false;
				break;
			default:
				System.err.println("That is not a valid input.");
				break;
			}
		}
	}
	
	public void addJet() {
		
	}
}
