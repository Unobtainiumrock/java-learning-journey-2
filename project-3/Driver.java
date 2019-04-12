//package io.careerdeer;


// I Didn't have enough time to structure anything the way I wanted. I wanted everything to be of a type "Shape" when assigning instances to variables.
public class Driver {
	public static void main(String ...args) {
		Rectangle rectangleOne = new Rectangle(4,3);
		Rectangle rectangleTwo = new Rectangle(3,4);
		
		Rectangle rectangleThree = new Rectangle(5,2);
		Rectangle rectangleFour = new Rectangle(5,2);
		
		Rectangle perfectSquare = new Rectangle(4,4);
		
		Circle circleOne = new Circle(5);
		Circle circleTwo = new Circle(5);
		
		Cube cubeOne = new Cube(5); // perfect cubes only, no cuboids.
		Cube cubeTwo = new Cube(5);
		
		Cylinder cylinderOne = new Cylinder(5,2);
		
		
		System.out.println(rectangleOne);
		System.out.println(" ");
		System.out.println(perfectSquare);
		System.out.println(" ");

		System.out.println(rectangleOne.equals(rectangleTwo));
		System.out.println(rectangleThree.equals(rectangleFour));
		System.out.println("");
		
		System.out.println(perfectSquare.equals(rectangleOne));
		System.out.println("");
		
		System.out.println(String.format("Perfect square is a: %s", perfectSquare.getDescription()));
		System.out.println("");
		
		
		System.out.println(circleOne.calculateArea());
		System.out.println(circleOne.calculatePerimeter());
		
		System.out.println(circleOne.equals(circleTwo));
		
		
		System.out.println(cubeOne.equals(cubeTwo));
		
		System.out.println(cylinderOne.calculateVolume());
		System.out.println(cylinderOne.calculateArea());
		
	}
}

