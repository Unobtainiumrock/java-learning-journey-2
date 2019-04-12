//package io.careerdeer;

import java.lang.Math;

//(x - h)^2 + (y - k)^2 = r^2

public class Circle extends Shape implements TwoDimensional {
	public Circle(double x) {
		super(x, Shapes.CIRCLE);
	}

	// Circumference is perimeter.
	// 2PI * r
	@Override
	public double calculatePerimeter() {
		return (2 * Math.PI) * this.getX();
	}

	// Area
	// PI * radius^2
	@Override
	public double calculateArea() {
		return Math.PI * (Math.pow(this.getX(), 2));
	}

	@Override
	String getDescription() {
		return "A circle looks something like this O, but with a less pronounced ellipses";
	}

	@Override 
	public String toString() {
		return super.toString() + String.format("Radius: %s ", super.getX()) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle otherCircle = (Circle) obj;
			return super.equals(otherCircle) && this.getDescription().equalsIgnoreCase(otherCircle.getDescription());
		}
		return false;
	}

}
//package io.careerdeer;

import java.lang.Math;

// General formula
// (x - h)^2 + (y - k)^2 = r&^2

// Diameter
// 2 * radius

public class Circle extends Shape implements TwoDimensional {
	public Circle(double x) {
		super(x);
	}

	// Circumference is perimeter.
	// 2PI * r
	@Override
	public double calculatePerimeter() {
		return (2 * Math.PI) * this.getX();
	}

	// Area
	// PI * radius^2
	@Override
	public double calculateArea() {
		return Math.PI * (Math.pow(this.getX(), 2));
	}

	@Override
	String getDescription() {
		return "A circle looks something like this O, but with a less pronounced ellipses";
	}

	@Override 
	public String toString() {
		return "Shape: Circle\n" + String.format("Radius: %s ", super.getX()) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle otherCircle = (Circle) obj;
			return super.equals(otherCircle) && this.getDescription().equalsIgnoreCase(otherCircle.getDescription());
		}
		return false;
	}

}

