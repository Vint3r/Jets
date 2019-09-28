package com.skilldistillery.jets.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

		do {
			System.out.println();
			System.out.println("+------------------------------------------+");
			System.out.println("|**What type of jet do you wish to enter?**|");
			System.out.println("|1.)***************Cargo jet***************|");
			System.out.println("|2.)**************Fighter jet**************|");
			System.out.println("|3.)*************Passenger jet*************|");
			System.out.println("|4.)****************Return*****************|");
			System.out.println("+------------------------------------------+");
			String userIn = input.nextLine();

			switch (userIn.toLowerCase()) {
			case "1":
			case "one":
			case "cargo jet":
			case "cargo":
				addUserJet(input, userIn);
				input.nextLine();
				break;
			case "2":
			case "two":
			case "fighter":
			case "fighter jet":
				addUserJet(input, userIn);
				break;
			case "3":
			case "three":
			case "passenger":
			case "passenger jet":
				addUserJet(input, userIn);
				input.nextLine();
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
		} while (userChoice);
	}

	public void addUserJet(Scanner input, String userChoice) {
		String model = "";
		double speed = 0.0;
		int range = 0;
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
				price = input.nextLong();
				input.nextLine();
				userStay = false;
			} catch (Exception e) {
				System.err.println("That is a invalid option for input price, please only type numbers");
				userStay = true;
			}
		} while (userStay);
		
		switch (userChoice.toLowerCase()) {
		case "1":
		case "one":
		case "cargo":
		case "cargo jet":
			addCargoJet(model, speed, range, price, input);
			break;
		case "2":
		case "two":
		case "figher jet":
		case "fighter":
			addFighterJet(model, speed, range, price, input);
			break;
		case "3":
		case "three":
		case "passenger":
		case "passenger jet":
			addPassJet(model, speed, range, price, input);
			break;
		default:
			System.err.println("That is not a valid input please try again.");
			break;
		}
		
	}

	public void addFighterJet(String model, double speed, int range, long price, Scanner input) {
		System.out.println("What would you like for weapons on this jet? (Missiles, guns, etc.)");
		String weapons = input.nextLine();
		Jet jet = new FighterJet(model, speed, range, price, weapons);
		addJet(jet);
	}
	
	public void addCargoJet(String model, double speed, int range, long price, Scanner input) {
		System.out.println("How much would you like this jet to carry?");
		int carryingCap = input.nextInt();
		Jet jet = new CargoJet(model, speed, range, price, carryingCap);
		addJet(jet);
	}
	
	public void addPassJet(String model, double speed, int range, long price, Scanner input) {
		System.out.println("How many passengers would you like this jet to fit?");
		int numOfPass = input.nextInt();
		input.nextLine();
		Jet jet = new BasicJet(model, speed, range, price, numOfPass);
		addJet(jet);
	}
	
	public void removeUserJet(Scanner input) {
		boolean userChoice = true;
		System.out.println();
		System.out.println("Which jet would you like to remove?");
		for (int i = 0; i < hangers.size(); i++) {
			System.out.println((i + 1) + ".) " + hangers.get(i).toString());
		}
		do {
			try {
				int userIn = input.nextInt();
				input.nextLine();
				if (userIn <= hangers.size()) {
					System.out.println("Are you sure you want to delete this plane? (yes/no)");
					System.out.println(hangers.get(userIn - 1).toString());
					String userRes = input.nextLine();
					if (userRes.equalsIgnoreCase("yes")) {
						removeJet(hangers.get(userIn - 1));
						userChoice = false;
						break;
					} else {
						userChoice = false;
						break;
					}
				} else if (userIn > hangers.size()) {
					System.out.println("That is not a valid input, there are only " + hangers.size() +
							" jets in the air field, you entered " + userIn);
				}
			} catch (Exception e) {
				System.err.println("That is not a valid input, please only enter a number, not a word...");
			}
		} while(userChoice);
		
	}
	
	public void loadPassengers() {
		for (Jet jet : hangers) {
			if (jet instanceof BasicJet) {
				((BasicJet) jet).loadPass();
			}
		}
	}
	
	public void saveJets() {
		FileWriter fw = null;
		String type = "";
		try {
			File fold = new File("/Users/David/SD/Java/workspace/Jets/JetFile.txt");
			fold.delete();
			fw = new FileWriter("/Users/David/SD/Java/workspace/Jets/JetFile.txt", true);
			for (Jet jet : hangers) {
				if (jet instanceof FighterJet) {
					type = "f, ";
					type += jet.getModel()+ ", ";
					type += jet.getSpeed()+ ", ";
					type += jet.getRange()+ ", ";
					type += jet.getPrice()+ ", ";
					type += ((FighterJet) jet).getWeapons()+ "\n";
					fw.write(type);
				} else if (jet instanceof CargoJet) {
					type = "c, ";
					type += jet.getModel()+ ", ";
					type += jet.getSpeed()+ ", ";
					type += jet.getRange()+ ", ";
					type += jet.getPrice()+ ", ";
					type += ((CargoJet) jet).getCarryingCap()+ "\n";
					fw.write(type);
				} else if (jet instanceof BasicJet) {
					type = "p, ";
					type += jet.getModel()+ ", ";
					type += jet.getSpeed()+ ", ";
					type += jet.getRange()+ ", ";
					type += jet.getPrice()+ ", ";
					type += ((BasicJet) jet).getNumOfPassengers()+ "\n";
					fw.write(type);
				}
			}
			fw.close();
			
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}