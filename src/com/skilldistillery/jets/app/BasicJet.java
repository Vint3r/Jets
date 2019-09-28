package com.skilldistillery.jets.app;

public class BasicJet extends Jet implements PassengerCarrier{
	private int numOfPassengers;
	
	
	public BasicJet(String model, double speed, int range, long price, int numOfPassengers) {
		super(model, speed, range, price);
		this.numOfPassengers = numOfPassengers;
	}

	@Override
	public void fly() {
		System.out.println("Yippie flying through the air is fun!");
		this.toString();

	}

	@Override
	public double getSpeedInMach() {
		double mach = this.getSpeed() / 1000;
		return mach;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=");
		builder.append(this.getModel());
		builder.append(", speed=");
		builder.append(this.getSpeed());
		builder.append(", range=");
		builder.append(this.getRange());
		builder.append(", price=");
		builder.append(this.getPrice());
		builder.append("]");
		builder.append("BasicJet [numOfPassengers=");
		builder.append(numOfPassengers);
		builder.append("]");
		return builder.toString();
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	@Override
	public void loadPass() {
		securityCheck();
		System.out.println("Finally finished the security checks, now to hopefully board the plane...");
	}

	@Override
	public void securityCheck() {
		System.out.println("Nothing like waiting in line for 2 hours just to be groped.");
	}
	

}
