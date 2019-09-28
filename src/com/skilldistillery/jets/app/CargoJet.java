package com.skilldistillery.jets.app;

public class CargoJet extends Jet implements CargoCarrier {

	private double carryingCap;
	
	public CargoJet(String model, double speed, int range, long price, double carringCap) {
		super(model, speed, range, price);
		this.carryingCap = carringCap;
	}
	@Override
	public void fly() {
		double flyTime = this.getRange() / this.getSpeed();
		System.out.println(this.toString());
		System.out.println("Zoom Zoom. I can fly for up to " + flyTime + " minutes.");
		System.out.println();
	}

	@Override
	public double getSpeedInMach() {
		double mach = this.getSpeed() / 1000;
		return mach;
	}
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
		builder.append("Carrying Capacity =");
		builder.append(carryingCap);
		builder.append("]");
		return builder.toString();
	}
	public double getCarryingCap() {
		return carryingCap;
	}
	public void setCarryingCap(double carryingCap) {
		this.carryingCap = carryingCap;
	}
	@Override
	public void loadCargo() {
		System.out.println("Loading " + this.getCarryingCap() + " lbs of Cargo on plane: " + this.getModel());
	}
	

}
