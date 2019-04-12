//package io.careerdeer;

// All squares are rectangles, but not all rectangles are squares. Decided to combine the two classes due to this.
public class Rectangle extends Shape implements TwoDimensional {

	Rectangle(double x, double y) {
		super(x, y, null);
		super.setShape(x == y ? Shapes.SQUARE : Shapes.RECTANGLE);
	}

	@Override
	public double calculatePerimeter() {
		return (2 * this.getX()) + (2 * this.getY());
	}

	@Override
	double calculateArea() {
		return this.getX() * this.getY();
	}

	@Override
	// Since description is determined by the shape type, I compare shape types in the equals method, since I'd prefer to compare via
	// enums instead of comparing Strings returned from two invoked methods.
	String getDescription() {
		String message = "";
		switch (super.getShape()) {
		case SQUARE:
			message = "A quadrilateral with four equal sides and four equal angles";
			break;
		case RECTANGLE:
			message = "A quadrilateral with four right angles.";
			break;
		default:
			message = "A quadrilateral with four right angles";

		}
		return message;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Rise: %s\nRun: %s", super.getX(), super.getY());
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Rectangle) {
			Rectangle otherRectangle= (Rectangle) obj;
			
			// Nothing much useful to inherit from the parent class' equals. If this trend continues for other shapes,
			// I'll just remove equals from the abstract Shape class, since they aren't utilizing any of the super's equals().
			// The enums comparisons below imply they have the same description because of how I set up descriptions being returned.
			switch(otherRectangle.getShape()) {
				case RECTANGLE:
					result = (otherRectangle.getX() == super.getY() && otherRectangle.getY() == super.getX()) ||
					(otherRectangle.getX() == super.getX() && otherRectangle.getY() == super.getY()) && super.getShape() == Shapes.RECTANGLE; 
					break;
				case SQUARE:
					result = super.equals(otherRectangle) && super.getShape() == Shapes.SQUARE;
					break;
				default:
					result = false;
					break;
			} 
		}
		return result;
	}
}
//package io.careerdeer;

// All squares are rectangles, but not all rectangles are squares. Decided to combine the two classes due to this.
public class Rectangle extends Shape implements TwoDimensional {
	private Shapes actualShape;

	private enum Shapes {
		RECTANGLE, SQUARE;
	}

	Rectangle(double x, double y) {
		super(x, y);
		this.actualShape = x == y ? Shapes.SQUARE : Shapes.RECTANGLE;
	}

	@Override
	public double calculatePerimeter() {
		return (2 * this.getX()) + (2 * this.getY());
	}

	@Override
	double calculateArea() {
		return this.getX() * this.getY();
	}

	public Shapes getActualShape() {
		return this.actualShape;
	}

	@Override
	// Since description is determined by the shape type, I compare shape types in the equals method, since I'd prefer to compare via
	// enums instead of comparing Strings returned from two invoked methods.
	String getDescription() {
		String message = "";
		switch (this.actualShape) {
		case SQUARE:
			message = "A quadrilateral with four equal sides and four equal angles";
			break;
		case RECTANGLE:
			message = "A quadrilateral with four right angles.";
			break;
		default:
			message = "A quadrilateral with four right angles";

		}
		return message;
	}

	@Override
	public String toString() {
		return String.format("Shape: %s\n", this.actualShape) + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Rectangle) {
			Rectangle otherRectangle= (Rectangle) obj;
			
			// Nothing much useful to inherit from the parent class' equals. If this trend continues for other shapes,
			// I'll just remove equals from the abstract Shape class, since they aren't utilizing any of the super's equals().
			// The enums comparisons below imply they have the same description because of how I set up descriptions being returned.
			switch(otherRectangle.getActualShape()) {
				case RECTANGLE:
					result = (otherRectangle.getX() == super.getY() && otherRectangle.getY() == super.getX()) ||
					(otherRectangle.getX() == super.getX() && otherRectangle.getY() == super.getY()) && this.actualShape == Shapes.RECTANGLE; 
					break;
				case SQUARE:
					result = super.equals(otherRectangle) && this.actualShape == Shapes.SQUARE;
					break;
			} 
		}
		return result;
	}
}

