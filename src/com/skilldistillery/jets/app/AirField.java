package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> hangers = new ArrayList<>();

	public AirField() {

	}

	public void addJet(Jet jet) {
		hangers.add(jet);
	}

	public void removeJet(Jet jet) {
		if (hangers.contains(jet)) {
			hangers.remove(jet);
		}
	}

	public int totalPlanes() {
		return hangers.size();
	}

	public void flyJets() {
		for (int i = 0; i < hangers.size(); i++) {
			hangers.get(i).fly();
		}
	}

	public void getJetInfo() {
		for (Jet jet : hangers) {
			System.out.println(jet.toString());
		}
	}

	public void getFastest() {
		Jet fastest = hangers.get(0);
		for (Jet jet : hangers) {
			if (jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println(fastest.toString());
	}

	public void getLongestRange() {
		Jet longest = hangers.get(0);
		for (Jet jet : hangers) {
			if (jet.getRange() > longest.getRange()) {
				longest = jet;
			}
		}
		System.out.println(longest.toString());
	}

	public void loadAllCargo() {
		for (Jet jet : hangers) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			}
		}
	}

	public void dogFight() {
		for (Jet jet : hangers) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).dogFight();
			}
		}
	}

	public void addJetMenu(Scanner input) {
		boolean userChoice = true;

		while (userChoice) {
			System.out.println();
			System.out.println("+------------------------------------------+");
			System.out.println("|**What type of jet do you wish to enter?**|");
			System.out.println("|1.)***************Cargo jet***************|");
			System.out.println("|2.)**************Fighter jet**************|");
			System.out.println("|3.)*************Passenger jet*************|");
			System.out.println("+------------------------------------------+");
			String userIn = input.nextLine();

			switch (userIn.toLowerCase()) {
			case "1":
			case "one":
			case "cargo jet":
			case "cargo":
				addCargoJet(input);
				break;
			case "2":
			case "two":
			case "fighter":
			case "fighter jet":
				addFighterJet(input);
				break;
			case "3":
			case "three":
			case "passenger":
			case "passenger jet":
				addPassJet(input);
				break;
			case "4":
			case "four":
			case "return":
				System.out.println("Returning to main menu...");
				userChoice = false;
				break;
			default:
				System.out.println("That is not a valid input, please try again");
				break;
			}
		}
	}

	public void addCargoJet(Scanner input) {
		String model = "";
		double speed = 0.0;
		int range = 0, carryingCap = 0;
		long price = 0l;
		boolean userStay = false;

		System.out.println("Please enter a model for the jet you wish to add.");
		model = input.nextLine();
		do {
			System.out.println("Please enter a speed for the jet you wish to add.");
			try {
				speed = input.nextDouble();
				input.nextLine();
				userStay = false;
			} catch (Exception e) {
				System.err.println("That is a invalid option for input Speed, please only type numbers");
				userStay = true;
			}
		} while (userStay);

		do {
			System.out.println("Please enter a range for the jet you wish to add.");
			try {
				range = input.nextInt();
				input.nextLine();
				userStay = false;
			} catch (Exception e) {
				System.err.println("That is a invalid option for input Range, please only type numbers");
				userStay = true;
			}
		} while (userStay);
		
		do {
			System.out.println("Please enter a price for the jet you wish to add.");
			try {
				price = input.nextInt();
				input.nextLine();
				userStay = false;
			} catch (Exception e) {
				System.err.println("That is a invalid option for input price, please only type numbers");
				userStay = true;
			}
		} while (userStay);
		
		do {
			System.out.println("Please enter a Cargo capacity for the jet you wish to add.");
			try {
				carryingCap = input.nextInt();
				input.nextLine();
				userStay = false;
			} catch (Exception e) {
				System.err.println("That is a invalid option for input Cargo capacity, please only type numbers");
				userStay = true;
			}
		} while (userStay);

		Jet jet = new CargoJet(model, speed, carryingCap, price, carryingCap);
		addJet(jet);
	}
}