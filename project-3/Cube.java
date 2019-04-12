//package io.careerdeer;

public class Cube extends Shape implements ThreeDimensional {

	// Assuming perfect cube's and not cuboids.
	public Cube(double x) {
		super(x,x,x, Shapes.CUBE);
	}

	@Override
	public double calculateVolume() {
		return Math.pow(this.getX(), 3);
	}

	@Override
	double calculateArea() {
		return Math.pow(this.getX(), 2) * 6; // surface area!
	}
	
	@Override
	String getDescription() {
		return "A cube is a 3-dimensional shape that looks like you've taken a bunch of squares, laid them flat, and stacked them on top of eachother until the height of the stack is equivalent to a single side of the drawn squares.";
	}
	
	@Override
	public Shape getChild() {
		return this;
	} 
 
	@Override
	public String toString() {
		return super.toString() + String.format("Rise: %s\nRun: %s\nDepth: %s", super.getX(),super.getY(), super.getZ()) ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cube) {
			Cube otherCube = (Cube) obj;
			return otherCube.getDescription().equalsIgnoreCase(this.getDescription())
					&& otherCube.calculateArea() == this.calculateArea();
		}
		return false;
	}
}
//package io.careerdeer;

public class Cube extends Shape implements ThreeDimensional {

	// Assuming perfect cube's and not cuboids.
	public Cube(double x) {
		super(x,x,x);
	}

	@Override
	public double calculateVolume() {
		return Math.pow(this.getX(), 3);
	}

	@Override
	double calculateArea() {
		return Math.pow(this.getX(), 2) * 6; // surface area!
	}

	@Override
	String getDescription() {
		return "A cube is a 3-dimensional shape that looks like you've taken a bunch of squares, laid them flat, and stacked them on top of eachother until the height of the stack is equivalent to a single side of the drawn squares.";
	}
 
	@Override
	public String toString() {
		return "Shape: Cube\n" + String.format("Rise: %s\nRun: %s\nDepth: %s", super.getX(),super.getY(), super.getZ()) ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cube) {
			Cube otherCube = (Cube) obj;
			return otherCube.getDescription().equalsIgnoreCase(this.getDescription())
					&& otherCube.calculateArea() == this.calculateArea();
		}
		return false;
	}
}

