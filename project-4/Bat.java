//package io.careerdeer;

public class Bat extends Mammal implements Winged {

	public Bat(String name) {
		super(name);
	}

	@Override
	public boolean canFly() {
		return true;
	}
}

