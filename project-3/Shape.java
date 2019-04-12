//package io.careerdeer;


// x is run, y is rise, z is depth.
public abstract class Shape {
	private double x = -1, y = -1, z = -1;
	private Shapes shape;
	
	public enum Shapes {
		RECTANGLE, CIRCLE, SQUARE, CYLINDER, CUBE;
	}
	
	// circle
	Shape(double x, Shapes shape) {
		this.x = x;
		this.shape = shape;
	}

	// rectangles, squares, cylinders
	Shape(double x, double y, Shapes shape) {
		this.x = x;
		this.y = y;
		this.shape = shape;
	}
	
	// Cubes
	Shape(double x, double y, double z, Shapes shape) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.shape = shape;
	}

	abstract String getDescription();
	
	abstract double calculateArea();
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public Shapes getShape() {
		return this.shape;
	}
	
	public void setShape(Shapes shape) {
		this.shape = shape;
	}
	
	@Override
	public String toString() {
		return String.format("Shape: %s\n", this.shape);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shape) {
			Shape otherShape = (Shape) obj;
			return otherShape.getX() == this.x && otherShape.getY() == this.y && otherShape.getZ() == this.z;
		}
		return false;
	}
}
//package io.careerdeer;


// x is run, y is rise, z is depth.
public abstract class Shape {
	private double x = -1, y = -1, z = -1;
	private Shapes shape;
	
//	public enum Shapes {
//		RECTANGLE, CIRCLE, SQUARE, CYLINDER, CUBE;
//	}
//	
	// circle
	Shape(double x) {
		this.x = x;
//		this.shape = shape;
	}

	// rectangles, squares, cylinders
	Shape(double x, double y) {
		this.x = x;
		this.y = y;
//		this.shape = shape;
	}
	
	// Cubes
	Shape(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
//		this.shape = shape;
	}

	abstract String getDescription();
	
	abstract double calculateArea();
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
//	public Shapes getShape() {
//		return this.shape;
//	}
	
	@Override
	public String toString() {
		if (z < 0) {
			return String.format("The rise is : %s\nThe run is: %s", this.x, this.y); 
		}	
		return String.format("The rise is : %s\nThe run is: %s\nThe depth is: %s", this.x, this.y, this.z);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shape) {
			Shape otherShape = (Shape) obj;
			return otherShape.getX() == this.x && otherShape.getY() == this.y && otherShape.getZ() == this.z;
		}
		return false;
	}
}

