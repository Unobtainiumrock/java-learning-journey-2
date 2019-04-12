// package course_registration;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

//import course_registration.Course;


// I wanted to avoid creating a student instance each time we remove a student from the roster, so
// I store all student instances that are added to a Course in a HashMap. When I want to remove a student,
// I pull them off the HashMap by ID and pass that given student into our dropStudent(Student student) method.

// In our provided CourseTester.java, we were provided all of the students we were testing
// right off the bat this is my solution to not having them all right off the bat.

// This could be avoided if the Project 2 assignment asked us for
// dropStudent(String first, String last, String id, boolean tuitionPaid) 
// 					instead of 
// dropStudent(Student student)

public class CourseDriver {
	private static Scanner input = new Scanner(System.in);
	private static Course course;
	private static Map<String,Student>  students = new HashMap<String, Student>();
	
	public static void main(String[] args) {
		int userChoice = 0;
		int[] limits;
		boolean isActive = true;
		
		// Initiate Welcome Message and experience
		userChoice = welcomeMenu(userChoice);

		switch (userChoice) {
		case 1:
			limits = gatherListLimits();
			course = new Course(gatherCourseName(),limits[0], limits[1]);
			break;
		case 2:
			isActive = false;
			break;
		default:
			isActive = false;
		}
		
		while(isActive) {
			String temp[];
			Student student;
			boolean added;
			boolean dropped;
			
			System.out.println("\n" + course + "\n");
			userChoice = promptAction();

			switch(userChoice) {
				case 1:
					temp = gatherNameAndID();
					student = new Student(temp[0], temp[1], temp[2], gatherTuitionStatus());
					added = course.addStudent(student);
					
					if (added)  {
						students.put(temp[2], student);
					}
					
					System.out.println(student + (added ? " dropped successfully" : " not dropped"));
					break;
				case 2:
					
					if (course.getRoster().getSize() == 0) {
						System.out.println("The course roster is empty! Try adding students");
						break;
					}
					
					String id = gatherId();
					student = students.get(id);
					dropped = course.dropStudent(student);
					
					if (dropped)	 {
						students.remove(id);
					}
					
					System.out.println(student + (dropped ? " dropped successfully" : " not dropped"));
					break;
				case 3:
					System.out.println(course);
					break;
				case 4: 
					isActive = false;
					break;
				default:
					isActive = false;
					break;
			}
		}
		
		System.out.println("Good bye!");
		input.close();
	}
	
	private static String[] gatherNameAndID() {
		String[] info = new String[3];
	
		info[0] = gatherFirst();
		info[1] = gatherLast();
		info[2] = gatherId();
		
		while (students.containsKey(info[2])) {
			System.out.println("That ID is taken, try a new one.");
			System.out.print("Enter the id: ");
			info[2] = validateString();
		}
				
		return info;
	}
		
	private static String gatherFirst() {
		System.out.print("Enter the first name: ");
		return validateString();
	}
	
	private static String gatherLast() {
		System.out.print("Enter the last name: ");
		return validateString();
	}
	
	private static String gatherId() {
		System.out.print("Enter the student id: ");
		return validateString();
	}
	
	private static boolean gatherTuitionStatus() {
		System.out.println("Has the student paid tuition?");
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		return validateNumber() == 1;
	}
	
	private static int promptAction() {	
		System.out.println("What action would you like to take?");
		System.out.println("[1] Add a student");
		System.out.println("[2] Drop a student");
		System.out.println("[3] Print course info");
		System.out.println("[4] Exit");
			
		return validateNumber();
	}
	
	private static String gatherCourseName() {
		System.out.println("Please provide a course name");
		return validateString();
	}
	
	private static int[] gatherListLimits() {
		int[] limits = new int[2];
		
		System.out.println("Please provide a wait list cap.");
		limits[0] = validateNumber();
		System.out.println("Please provide a roster cap.");
		limits[1] = validateNumber();
		
		return limits;
	}

	private static int welcomeMenu(int userChoice) {

		System.out.println("Welcome to the Course Registration system");
		System.out.println("Would you like to create a course?");
		System.out.println("[1] Yes");
		System.out.println("[2] No, exit program.");

		return validateNumber();

	}

	private static int validateNumber() {
		int choice = 0;

		while (choice == 0) {
			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException err) {
				err.printStackTrace();
				System.out.println("");
				System.out.println("Invalid entry. Please try again.");
			}
		}

		return choice;
	}
	
	private static String validateString() {
		String choice = "";
		
		while (choice.length() == 0) {
			try {
				choice = input.nextLine();
			} catch (InputMismatchException error) {
				error.printStackTrace();
				System.out.println("");
				System.out.println("Invalid entry. Please try again.");
			}
		}
		return choice;
	}

}
