// package course_registration;

public class Student {

	private String firstName, lastName, id;
	private boolean tuitionPaid;
	private Student next = null;

	public Student(String firstName, String lastName, String id, boolean tuitionPaid) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.tuitionPaid = tuitionPaid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public boolean isTuitionPaid() {
		return tuitionPaid;
	}

	public void setTuitionPaid(boolean tuitionPaid) {
		this.tuitionPaid = tuitionPaid;
	}
	
	public void setNext(Student student) {	
		this.next = student;
	}
	
	public Student getNext() {
		if (this.next != null) {
			return this.next;
		}
		return null;
	}	


	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + id + ")";
	}
	
	
	public boolean equals(Student student) {
		return this.firstName.equalsIgnoreCase(student.firstName) && this.lastName.equalsIgnoreCase(student.lastName) && this.id.equalsIgnoreCase(student.id) && this.tuitionPaid == student.tuitionPaid;
	}

}
