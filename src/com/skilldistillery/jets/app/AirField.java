package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}
