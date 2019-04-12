//package io.careerdeer;

public class Parakeet extends Bird implements Adoptable {

	public Parakeet(String name) {
		super(name);
	}

	@Override
	public boolean canFly() {
		return true;
	}

	@Override
	public String homeCareDirections() {
		return "Feed seeds, give water, and sing to it";
	}

}

