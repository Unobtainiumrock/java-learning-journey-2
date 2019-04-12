//package testerThing;

import java.util.Scanner;

public class PasswordChecker {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String ...args) {
		String password;
		
		System.out.println("Please provide a password to be validated. Needs 8 characters and one uppercase letter");
				
		try {
			password = validatePassword(input.nextLine());
			System.out.println(String.format("The password %s is valid. Thank you", password));
		} catch(CustomException e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println(e.getError());
			main(args);
		} finally {
			input.close();
		}
		
	}
	
	
	public static String validatePassword(String password) throws CustomException {
		
		if (password.length() < 8 ) {
			throw new CustomException(String.format("Invalid password: Needs to be 8 characters long, provided only %s characters", password.length()));
		}
	
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				break;
			}
			
			if (i == password.length()) {
				throw new CustomException("Invalid password: Needs to contain at least one uppercase letter");
			}
			
		}
		
		return password;
	}
}
