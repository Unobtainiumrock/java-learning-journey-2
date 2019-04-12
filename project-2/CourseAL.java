// package course_registration;

import java.util.List;
import java.util.ArrayList;

public class CourseAL {
	private int capacity;
	private int size = 0;			
	private final String type;
	private Student head;
	private Student tail;
	private List<Student> list;

	public CourseAL(int capacity, String type) {
		this.capacity = capacity;
		this.type = type.toUpperCase();
		this.list = new ArrayList<Student>(capacity);
	}

	public CourseAL(int capacity) {
		this(capacity, "ROSTER");
	}

	public CourseAL(String type) {
		this(10, type);
	}

	public CourseAL() {
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

	public List<Student> getList() {
		return this.list;
	}

	public boolean add(Student student) {

		if (this.list.contains(student) || this.size >= this.capacity) {
			return false;
		}

		if (this.type == "WAIT LIST") {
			this.enqueue(student);
		}

		this.list.add(student);
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

		if ((!this.list.contains(student)) || this.size <= 0) {
			return false;
		}

		if (this.type == "WAIT LIST") {
			this.dequeue();
		}

		this.list.remove(student);
		
		this.size--;
		
		return true;
	}

	public void dequeue() {
		this.head = this.head.getNext();
	}

	
}
