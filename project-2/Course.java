// package course_registration;

//import java.util.Arrays;

//import java.lang.reflect.Field;
//import java.util.stream.*;

// Based on how everything evolved over time, I'd just break out a lot of logic into a separate class for making a custom data structure.

// IMPORTANT NOTE: Order isn't dictated by my waitList Array. I'm leaving the Array as part of the app to meet the requirement, 
// but I handle order based on a Student having a next value which points to another Student object.

// This is what an Array of 3 students might look like. Each student S points to the next Student all the way to the end to preserve order (wait list only),
// regardless of me doing swaps on my array.

//   S
//   ^
//   |
//   S  S  null
//   ^  ^   ^
//   |  |   |
// [ S, S,  S  ]

// 1) I'm still using insertion logic to make sure that a student is always added to the end of our array.
// 2) I'm still using removal logic, so that our nulls are always right-most on the array via a swap.

// Here's a visual example for array insertion. ^ represents our insertion reference

// 1)    [null,null,null,null]
//         ^
// 2)	 [S1, null, null,null]
//             ^
// 3) 	 [S1, S2, null,null]
//				   ^             
// 	.....

// Here's a visual example for removal from array. ^ still represents our removal reference
//	1)     [S1,S2,S3,S4]
//                    ^ 		     		 

// Removing S2 by making it reference S4
//  2)     [S1,S4,S3,S4]
//                    ^
// Making S4 reference null
//  3)     [S1,S4,S3,null]
//                    ^
// Adjusting removal reference.
//  4)     [S1,S4,S3,null]
//                 ^   
// Removing S4 by making it reference S3
//  5)     [S1,S3,S3,null]
//                 ^   
// Making S3 reference null
//  6)     [S1,S3,null,null]
//                 ^   
// Adjust removal reference
//  7)     [S1,S3,null,null]
//                 

// Since people are only ever removed from the head of a list, its very simple to just save references to the beginning and end using variables
// on the Course class.

public class Course {
	private StudentList waitList, roster; // Access Student[] with getListWaitList().getList(). Still two Student[] objects housed inside StudentList
	private String instructor;
	private String name;

	public Course(String name, int waitListCap, int rosterCap) {
		this.name = name;
		this.waitList = new StudentList(waitListCap, "WAIT LIST");
		this.roster = new StudentList(rosterCap, "ROSTER");
	}

	public boolean addStudent(Student student) {

		if (!student.isTuitionPaid()) {
			return false;
		}
		
		if (this.roster.has(student) || this.waitList.has(student)) {
			return false;
		}

		if (this.roster.getSize() < this.roster.getCapacity()) {
			return this.roster.add(student);
		}

		if (this.waitList.getSize() < this.waitList.getCapacity()) {
			return this.waitList.add(student);
		}

		return false;
	}

	// This is where I'd change it to accept a student ID. Then at the very least if 
	// we aren't doing constant time lookups, we can at least
	// search for a student to drop by ID in our loop. The current setup assumes
	// that we already have a Student instance/object on hand to be
	// searched and dropped.
	
	// note: People are only dropped from roster, since dropping implies you're already on the class roster. I didn't add removal from waitList other than
	// spots opening up on the class roster.
	public boolean dropStudent(Student student) {
		if (this.roster.remove(student)) {
			if (this.waitList.getSize() > 0) {
				Student temp = this.waitList.getHead();
				this.waitList.remove(temp);
				this.roster.add(temp);				
			}
			return true;
		}
		return false;
	}

	public StudentList getWaitList() {
		return this.waitList;
	}

	public StudentList getRoster() {
		return this.roster;
	}

	public String getInstructor() {
		return this.instructor;
	}

	@Override
	public String toString() {
		String roster = toStringHelper(this.roster);
		String waitList = toStringHelper(this.waitList);

		return "Course name: " + this.name + "\nENROLLED: " + this.roster.getSize() + "\nENROLLED CAP: " + this.roster.getCapacity()
				+ "\nROSTER: \n" + roster + "\nWAITING: " + this.waitList.getSize() + "\nWAITLIST CAP: "
				+ this.waitList.getCapacity() + "\nWAIT LIST: \n" + waitList;
	}

	private String toStringHelper(StudentList students) {
		String temp = "";
		Student currentStudent;
		
		if (students.getType() == "WAIT LIST" && students.getSize() > 1) {
			currentStudent = students.getHead();
			// Wait list order matters.
			while (currentStudent != null) {
				temp += (currentStudent.toString());
				currentStudent = currentStudent.getNext();
				temp += "\n";
			}
			
		} else {
			// Roster order doesn't matter.
			for (int i = 0; i < students.getSize(); i++) {
				temp += students.getList()[i].toString();
				temp += "\n";
			}	
		}
		
		return temp;
	}
}
