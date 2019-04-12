package demo;

public class IsIsocelese {
	
	public static void main(String[] args) {
		System.out.println("\n\n******TESTING ISOCELES");
		System.out.println("Should print Not a triangle and false");
		System.out.println(isIsocelesTriangle(1, 2, 4));
		System.out.println("\nShould print Not a triangle and false");
		System.out.println(isIsocelesTriangle(4, 5, 1));
		System.out.println("\nShould print Not a triangle and false");
		System.out.println(isIsocelesTriangle(5, 5, 10));
		System.out.println("\nShould print true");
		System.out.println(isIsocelesTriangle(5, 9, 5));
		System.out.println("\nShould print Equilateral triangle and false");
		System.out.println(isIsocelesTriangle(5, 5, 5));
		System.out.println("\nShould print Scalene triangle and false");
		System.out.println(isIsocelesTriangle(3, 4, 5));
		System.out.println("\nShould print true");
		System.out.println(isIsocelesTriangle(3, 2, 3));
	}
	
	public static boolean isIsocelesTriangle(int a, int b, int c) {
		boolean isIsoceles = false;
		
		// Only evaluate the type if it is a triangle
		if (a + b > c && a + c > b && b + c > a) {
			isIsoceles = evaluateTriangleType(a,b,c);
		} else {
			System.out.println("This is not a triangle because the sum of any two sides is not greater than the third side.");
		}
		return isIsoceles;
	}
	
	// Broke this out into a helper method to enhance readability and have separation of concerns.
	public static boolean evaluateTriangleType(int a, int b, int c) {
		if (a == c && a == b && b == c) {
			System.out.println("It is an Equilateral triangle.");
			return false;
		} else if ((a == b && c != a && c !=b) || (a == c && b != c && b != a) || (b == c && a != b && a != c)) {
			System.out.println("It is an Isoceles triangle");
			return true;
		} else {
			System.out.println("It is a Scalene Triangle");
			return false;
		}
	}
}

