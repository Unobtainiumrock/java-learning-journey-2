//package io.careerdeer;

public class Cylinder extends Shape implements ThreeDimensional {
	//PI is x, height is y
	public Cylinder(double x, double y) {
		super(x,y, Shapes.CYLINDER);
	}

	@Override
	// PI * R^2h
	public double calculateVolume() {
		return Math.PI * Math.pow(super.getX(), 2) * super.getY();
	}
	
	@Override
	// 2PI * rh + 2PI * r^2
	double calculateArea() {
		return ( (2 * Math.PI) * (super.getX() * super.getY()) ) + ((2 * Math.PI) * Math.pow(super.getX(),2 )); // surface area!
	}
	
	// Just compare each radius, since PI * radius^2 = area of a circle. 
	public boolean isTopOrBottom(Circle circle) {
		return circle.getX() == super.getX();
	}
	
	@Override
	public Shape getChild() {
		return this;
	}

	@Override
	String getDescription() {
		return "A cylinder is like a bunch of circles laid flat and stacked on top of eachother n times, where n = the height of the cylinder.";
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Radius %s: \nHeight: %s", super.getX(), super.getY()); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cylinder) {
			Cylinder otherCylinder = (Cylinder) obj;
			return otherCylinder.calculateArea() == this.calculateArea() && this.getDescription().equalsIgnoreCase(otherCylinder.getDescription());
		}
		return false;
	}

}
//package io.careerdeer;

public class Cylinder extends Shape implements ThreeDimensional {
	//PI is x, height is y
	public Cylinder(double x, double y) {
		super(x,y);
	}

	@Override
	// PI * R^2h
	public double calculateVolume() {
		return Math.PI * Math.pow(super.getX(), 2) * super.getY();
	}
	
	@Override
	// 2PI * rh + 2PI * r^2
	double calculateArea() {
		return ( (2 * Math.PI) * (super.getX() * super.getY()) ) + ((2 * Math.PI) * Math.pow(super.getX(),2 )); // surface area!
	}

	@Override
	String getDescription() {
		return "A cylinder is like a bunch of circles laid flat and stacked on top of eachother n times, where n = the height of the cylinder.";
	}
	
	@Override
	public String toString() {
		return "Shape: Cylinder\n" + String.format("Radius %s: \nHeight: %s", super.getX(), super.getY()); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cylinder) {
			Cylinder otherCylinder = (Cylinder) obj;
			return otherCylinder.calculateArea() == this.calculateArea() && this.getDescription().equalsIgnoreCase(otherCylinder.getDescription());
		}
		return false;
	}

}

