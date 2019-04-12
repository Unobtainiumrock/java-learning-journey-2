// package testerThing;

import java.util.Scanner;

public class PrintNumbers {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String ...args) {
		System.out.println("Does the number contain decimals?");
		System.out.println("[1] Yes.");
		System.out.println("[2] No.");
		System.out.println("[3] Quit.");
	
		Number choice = validateNumber(false);
		Number out = 0;
		
		System.out.print("Please provide a number: ");
		
		switch(choice.intValue()) {
			case 1:
				out = validateNumber(true);
				break;
			case 2:
				out = validateNumber(false);
				break;
			case 3:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Please provide 1, 2, or 3");
				main(args);
		}
		
		System.out.println(String.format("You wished to print %s%nPrint output: %s", out, out));
	}
	
	public static void readAndPrintNumber(boolean containsDecimals) {
		System.out.println("Please provide a number");
		
		validateNumber(containsDecimals);
	}

	
	private static Number validateNumber(boolean containsDecimals) {
		Number choice = 0;
		boolean valid = false;
		
		while(!valid) {
			try {
				if (containsDecimals) {
					choice = Double.parseDouble(input.nextLine());
					valid = true;
				} else if ((Integer) choice % 1 == 0) {
					choice = Integer.parseInt(input.nextLine());
					valid = true;
				} 
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("");
				System.out.println("Invalid entry. Please try again.");
			}
		}
		
		return choice;
	}
	
}
