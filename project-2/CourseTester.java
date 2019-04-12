// package course_registration;


public class CourseTester {

public static void main(String[] args) {
		
		Student[] studentsInSchool = new Student[15];
		studentsInSchool[0] = new Student("Adam", "Ant", "S925", true);
		studentsInSchool[1] = new Student("Bob", "Barker", "S713", false);
		studentsInSchool[2] = new Student("Chevy", "Chase", "S512", true);
		studentsInSchool[3] = new Student("Doris", "Day", "S513", true);
		studentsInSchool[4] = new Student("Emilio", "Estevez", "S516", true);
		studentsInSchool[5] = new Student("Farrah", "Fawcet", "S956", true);
		studentsInSchool[6] = new Student("Greta", "Garbo", "S419", true);
		studentsInSchool[7] = new Student("Helen", "Hunt", "S281", true);
		studentsInSchool[8] = new Student("Jack", "Johnson", "S790", true);
		studentsInSchool[9] = new Student("Kim", "Kardashian", "S336", true);		
		studentsInSchool[10] = new Student("Martina", "McBride", "S156", true);	
		studentsInSchool[11] = new Student("Renne", "Russo", "S219", true);	
		studentsInSchool[12] = new Student("Susan", "Serandon", "S472", true);	
		studentsInSchool[13] = new Student("Vince", "Vaughn", "S892", true);	
		studentsInSchool[14] = new Student("Walt", "Whitman", "S901", true);	
		
		Course course = new Course("Media Studies", 5, 5);
		
		/* note: to test the extra credit, replace the line above with the line below.  
		 * the rest of the program should run exactly the same.
		 * 
		 * CourseAL course = new CourseAL("Media Studies", 5, 5);
		 * 
		 */
		
		System.out.println(course+"\n");

		System.out.println("*****TESTING ADDS");
		for(Student student : studentsInSchool) {
			boolean added = course.addStudent(student);
			System.out.println(student + (added ? " added successfully" : " not added"));
		}
		System.out.println("\n" + course + "\n");
		
		Student studentToAdd = studentsInSchool[2];
		boolean added = course.addStudent(studentToAdd);
		System.out.println(studentToAdd + (added ? " added successfully" : " not added"));
		System.out.println("\n" + course + "\n");	
		
		studentToAdd = studentsInSchool[7];
		added = course.addStudent(studentToAdd);
		System.out.println(studentToAdd + (added ? " added successfully" : " not added"));
		System.out.println("\n" + course + "\n");	

		
		System.out.println("*****TESTING DROPS");
		Student studentToDrop = studentsInSchool[2];
		boolean dropped = course.dropStudent(studentToDrop);
		System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
		System.out.println("\n" + course + "\n");	
		
		studentToDrop = studentsInSchool[14];
		dropped = course.dropStudent(studentToDrop);
		System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
		System.out.println("\n" + course + "\n");	
		
		studentToDrop = studentsInSchool[8];
		dropped = course.dropStudent(studentToDrop);
		System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
		System.out.println("\n" + course + "\n");	

		studentToDrop = studentsInSchool[0];
		dropped = course.dropStudent(studentToDrop);
		System.out.println(studentToDrop + (dropped ? " dropped successfully" : " not dropped"));
		System.out.println("\n" + course + "\n");					
		
	}

}
