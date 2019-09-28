package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady {
	private String weapons;

	public FighterJet(String model, double speed, int range, long price, String weapons) {
		super(model, speed, range, price);
		this.weapons = weapons;
	}

	@Override
	public void fly() {
		double flyTime = getRange() / getSpeed();
		System.out.println(this.toString());
		System.out.println("Zoom Zoom mofo. I can fly for up to " + flyTime + " minutes!");
		System.out.println();
	}

	@Override
	public double getSpeedInMach() {
		double mach = this.getSpeed() / 1000;
		return mach;

	}

	public String getWeapons() {
		return weapons;
	}

	public void setWeapons(String weapons) {
		this.weapons = weapons;
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
		builder.append("Weapon loadout =");
		builder.append(weapons);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void dogFight() {
		loadAmmo();
		System.out.println("Ready for Combat!");
		System.out.println("Shooty Shooty Bang Bang!!!!");
	}

	@Override
	public void loadAmmo() {
		System.out.println("Loading fighter with " + this.getWeapons() + "...");
		System.out.println("Fighter is loaded for combat.");
	}

}
