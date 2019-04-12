//package io.careerdeer;

public class Turtle extends Reptile implements Adoptable, WaterDweller {

	public Turtle(String name) {
		super(name);
	}

	@Override
	public String homeCareDirections() {
		return "Keep them in a glass container and make sure they have food, water, and warmth";
	}

	@Override
	public boolean canLiveOutOfWater() {
		return true;
	}
	
}


