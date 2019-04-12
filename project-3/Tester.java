//package io.careerdeer;

import java.util.*;

public class Tester {

	public static void main(String[] args) {

			Rectangle rectangle1 = new Rectangle(3,4);
			Rectangle rectangle2 = new Rectangle(4,3);
			Rectangle rectangle3 = new Rectangle(5,6);
			Rectangle square1 = new Rectangle(2,2); // I combined square and rectangle class, I thought it was a trick question.
			Rectangle square2 = new Rectangle(4,4); // I combined square and rectangle class, I thought it was a trick question.
			Rectangle square3 = new Rectangle(4,4); // I combined square and rectangle class, I thought it was a trick question.s
			Circle circle1 = new Circle(3);
			Circle circle2 = new Circle(5);
			Cylinder cylinder1 = new Cylinder(3, 5);
			Cylinder cylinder2 = new Cylinder(4, 6);
			Cylinder cylinder3 = new Cylinder(6, 4);
			Cube cube1 = new Cube(2);
			Cube cube2 = new Cube(3);
			
			List<Shape> shapeList = new ArrayList<>();
			shapeList.add(rectangle1);
			shapeList.add(rectangle2);
			shapeList.add(rectangle3);
			shapeList.add(square1);
			shapeList.add(square2);
			shapeList.add(square3);
			shapeList.add(circle1);
			shapeList.add(circle2);
			shapeList.add(cylinder1);
			shapeList.add(cylinder2);
			shapeList.add(cylinder3);
			shapeList.add(cube1);
			shapeList.add(cube2);

			System.out.println("*****PRINTING OUT THE TEXT REPRESENTATION, DESCRIPTION, AREA, AND PERIMETER/VOLUME OF EACH SHAPE");
			for(Shape shape : shapeList) {
				System.out.println(shape);
				System.out.println(shape.getDescription());
				System.out.println("\tArea: " + shape.calculateArea());
				
				// CODE MISSING: PRINT THE PERIMETER OF TWO-DIMENSIONAL SHAPES	
				if (TwoDimensional.class.isInstance(shape)) {
					System.out.println("\tPerimeter: " + ((TwoDimensional) shape).calculatePerimeter());
				} else {
					System.out.println("\tVolume: " + ((ThreeDimensional) shape).calculateVolume());
				}
				
			}


			System.out.println("\n*****PRINTING ALL EQUAL, NON-ALIAS SHAPES");
			for(Shape firstShape : shapeList) {
				for(Shape secondShape : shapeList) {
					System.out.println(firstShape);
					System.out.println(secondShape);
					System.out.println(firstShape.equals(secondShape));
					System.out.println("=========");
				}
			}
			
			// BONUS! I MADE THIS WORK FOR CUBE/SQUARES and for CYLINDER/CIRCLES!!!!
			System.out.println("\n*****PRINTING ALL CUBE/SQUARE OR CYLINDER/CIRCLE COMBINATIONS WHERE THE SQUARE IS A SIDE FOR THE CUBE or SIDE TO A CYLINDER");
			for(Shape firstShape : shapeList) {
				for(Shape secondShape : shapeList) {
					if (TwoDimensional.class.isInstance(firstShape) && ThreeDimensional.class.isInstance(secondShape)) {
						if (((ThreeDimensional) secondShape).isTopOrBottom((TwoDimensional) firstShape) ) {
							System.out.println(String.format("%s is a top, bottom, or side of %s", firstShape, secondShape));
						}
					}
					
					if (TwoDimensional.class.isInstance(secondShape) && ThreeDimensional.class.isInstance(firstShape)) {
						if (((ThreeDimensional) firstShape).isTopOrBottom((TwoDimensional) secondShape)) {
							System.out.println(String.format("%s is a top, bottom, or side of %s", secondShape, firstShape));
						}
					}
				}
			}

			System.out.println("\n*****PRINTING ALL COMBINATIONS OF TWO-DIMENSIONAL SHAPES THAT CAN FIT INSIDE ANOTHER");
			for(Shape firstShape : shapeList) {
				for(Shape secondShape : shapeList) {
					// EXTRA CREDIT: TEST THE canFitInside METHOD FOR PAIRS OF TWO DIMENSIONAL SHAPES. PRINT ANY SHAPES THAT NEST.
					if (TwoDimensional.class.isInstance(firstShape ) && TwoDimensional.class.isInstance(secondShape)) {				
						if (((TwoDimensional) firstShape).perimeterCanFitInside((TwoDimensional) secondShape)) {
							System.out.println(String.format("%s can fit inside %s", firstShape, secondShape));
						} 
					}
				}
			}
		}
}
//package io.careerdeer;
import java.util.*;

public class Tester {

	

	public static void main(String[] args) {

			Rectangle rectangle1 = new Rectangle(3,4);
			Rectangle rectangle2 = new Rectangle(4,3);
			Rectangle rectangle3 = new Rectangle(5,6);
			Rectangle square1 = new Rectangle(2,2); // I combined square and rectangle class, I thought it was a trick question.
			Rectangle square2 = new Rectangle(4,4); // I combined square and rectangle class, I thought it was a trick question.
			Rectangle square3 = new Rectangle(4,4); // I combined square and rectangle class, I thought it was a trick question.s
			Circle circle1 = new Circle(3);
			Circle circle2 = new Circle(5);
			Cylinder cylinder1 = new Cylinder(3, 5);
			Cylinder cylinder2 = new Cylinder(4, 6);
			Cylinder cylinder3 = new Cylinder(6, 4);
			Cube cube1 = new Cube(2);
			Cube cube2 = new Cube(3);
			
			List<Shape> shapeList = new ArrayList<>();
			shapeList.add(rectangle1);
			shapeList.add(rectangle2);
			shapeList.add(rectangle3);
			shapeList.add(square1);
			shapeList.add(square2);
			shapeList.add(square3);
			shapeList.add(circle1);
			shapeList.add(circle2);
			shapeList.add(cylinder1);
			shapeList.add(cylinder2);
			shapeList.add(cylinder3);
			shapeList.add(cube1);
			shapeList.add(cube2);

			System.out.println("*****PRINTING OUT THE TEXT REPRESENTATION, DESCRIPTION, AREA, AND PERIMETER/VOLUME OF EACH SHAPE");
			for(Shape shape : shapeList) {
				System.out.println(shape);
				System.out.println(shape.getDescription());
				System.out.println("\tArea: " + shape.calculateArea());
				
				// CODE MISSING: PRINT THE PERIMETER OF TWO-DIMENSIONAL SHAPES
		
				// CODE MISSING: PRINT THE VOLUME OF THREE-DIMENSIONAL SHAPES
			
				System.out.println("");
			}


			System.out.println("\n*****PRINTING ALL EQUAL, NON-ALIAS SHAPES");
			for(Shape firstShape : shapeList) {
				for(Shape secondShape : shapeList) {
					// CODE MISSING: TEST IF THE TWO SHAPES ARE EQUAL (BUT NOT ALIASES!) PRINT THE SHAPES
					// Not sure what you mean by aliases. =(
				}
			}

			System.out.println("\n*****PRINTING ALL CUBE/SQUARE COMBINATIONS WHERE THE SQUARE IS A SIDE FOR THE CUBE");
			for(Shape firstShape : shapeList) {
				for(Shape secondShape : shapeList) {
					// CODE MISSING: TEST THE isTopOrBottom METHOD FOR SQUARE/CUBE COMBINATIONS. PRINT ANY MATCHES FOUND.
					// 
				}
			}

			System.out.println("\n*****PRINTING ALL COMBINATIONS OF TWO-DIMENSIONAL SHAPES THAT CAN FIT INSIDE ANOTHER");
			for(Shape firstShape : shapeList) {
				for(Shape secondShape : shapeList) {
					// EXTRA CREDIT: TEST THE canFitInside METHOD FOR PAIRS OF TWO DIMENSIONAL SHAPES. PRINT ANY SHAPES THAT NEST.
				}
			}
				
		}

}

