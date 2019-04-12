// package course_registration;

// Everything I was coding started to indicate that it needed to be factored out
// into a reusable class with all the functionalities I needed.
// Due to the logic surrounding insertion/removal, I also think it's best for the
// Course class to NOT DIRECTLY HAVE Student[] as an instance variable
// its better suited that the Course can access either StudentList instance's list of
// Student[] via the getter I've made.

public class StudentList {
	private int capacity;
	private int size = 0;
	// Tracks insertion and removal points.
	private int addIndex = 0, removeIndex = -1;
	// Used so we don't call has() and search separately, when has calls search. That'd be 2 extra calls.
	private int matchIndex; 			
	private final String type;
	private Student head;
	private Student tail;
	private Student[] list; // Assignment requirement.

	public StudentList(int capacity, String type) {
		this.capacity = capacity;
		this.type = type.toUpperCase();
		this.list = new Student[capacity];
	}

	public StudentList(int capacity) {
		this(capacity, "ROSTER");
	}

	public StudentList(String type) {
		this(10, type);
	}

	public StudentList() {
		this(10, "ROSTER");
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getSize() {
		return this.size;
	}

	public String getType() {
		return this.type;
	}

	public Student getHead() {
		return this.head;
	}

	public Student[] getList() {
		return this.list;
	}

	public boolean add(Student student) {

		if (this.has(student) || this.size >= this.capacity) {
			return false;
		}

		if (this.type == "WAIT LIST") {
			this.enqueue(student);
		}

		this.list[addIndex] = student;

		if (this.addIndex < this.capacity) {
			this.addIndex++;
			this.removeIndex++;
		}

		this.size++;

		return true;
	}

	private void enqueue(Student student) {
		if (this.head == null) {
			this.head = student;
			this.tail = student;
		} else {
			this.tail.setNext(student);
			this.tail = student;
		}
	}

	public boolean remove(Student student) {

		if ((!this.has(student)) || this.size <= 0) {
			return false;
		}

		if (this.type == "WAIT LIST") {
			this.dequeue();
		}

		// Swap logic on Array
		this.list[this.matchIndex] = this.list[this.removeIndex];
		this.list[this.removeIndex] = null;
		
		if (this.removeIndex > - 1) {
		    this.addIndex--;
		    this.removeIndex--;
		}
		
		this.size--;
		
		return true;
	}

	public void dequeue() {
		this.head = this.head.getNext();
	}

	// Super proud of this one!
	public boolean has(Student student) {
		return this.search(student) >= 0;
	}

	private int search(Student student) {
		for (int i = 0; i < this.size; i++) {

			if (this.list[i].equals(student)) {
				this.matchIndex = i;
				return i;
			}

		}
		return -1;
	}
}
