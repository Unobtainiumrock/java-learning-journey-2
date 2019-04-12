//package io.careerdeer;

public class Cat extends Mammal implements Adoptable {
	public Cat(String name) {
		super(name);
	}

	@Override
	public String homeCareDirections() {
		return "Feed, pet, give water, and love unconditionally";
	}
}

