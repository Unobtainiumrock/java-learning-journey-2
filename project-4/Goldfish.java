//package io.careerdeer;

public class Goldfish extends Fish implements Adoptable {
	public Goldfish(String name) {
		super(name);
	}

	@Override
	public boolean canLiveOutOfWater() {
		return false;
	}

	@Override
	public String homeCareDirections() {
		return "Feed it, clean its tank";
	}
}

