//package io.careerdeer;

public class Otter extends Mammal implements WaterDweller {

	public Otter(String name) {
		super(name);
	}

	@Override
	public boolean canLiveOutOfWater() {
		return true;
	}

}

