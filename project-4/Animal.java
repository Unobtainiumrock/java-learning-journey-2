//package io.careerdeer;

public abstract class Animal {
	private String name;
	private boolean bloodedType;
	
	public Animal(String name) {
		this(name, false);
	}
	
	// For mammals only. This isn't ideal, but I need a quick solution of working code. Will fix later.
	public Animal(String name, boolean bloodedType) {
		this.name = name;
		this.bloodedType = bloodedType;
	}
		
	public final boolean isWarmBlooded() {
		return this.bloodedType;
	};

	public final String getName() {
		return this.name;
	};

	// QUESTION: Can you show me a way in code how to do this better, or give me a
	// link to a resource for making this less "hacky"?
	private String recursiveToStringHelper(Class<?> instance, String classInfo) {
		// Look two ahead since we want to omit "Animal" based on the examples logged in
		// the provided file.
		if (instance.getSuperclass().getSuperclass().getSimpleName().equals("Object")) {
			return classInfo;
		}
		return recursiveToStringHelper(instance.getSuperclass(), instance.getSuperclass().getSimpleName() + " " + classInfo + " ");
	}

	// Let me know if this is bad. This saves me from having to override and do
	// case-by-case changes on each child's toString.
	// I'm testing this new idea out.. I know that I could just inherit from the
	// parent and return the child portion concatenated onto the end
	// for each layer down in the inheritance tree. Instead I will recursively
	// traverse the tree. I couldn't do an iterative approach, because
	// I couldn't figure out what type a current "Node" needs to be so I can do a
	// typical while loop tree traversal.
	@Override
	public final String toString() {
		String classInfo = this.recursiveToStringHelper(this.getClass(), this.getClass().getSimpleName());
		return String.format("Animal name: %s %s Blooded %s", this.name, (this.isWarmBlooded() ? "Warm" : "Cold "), classInfo);
	}

	// Two animals shouldn't be equivalent if they have the same name and
	// warm-blooded status, since we can have two mammals of different species.
	// "Mr Snuggles" the Bat is not the same as "Mr Snuggles" the Cat.
	// QUESTION: Can you show me a way in code how to do this better, or give me a
	// link to a resource for making this less "hacky"?
	@Override
	public final boolean equals(Object obj) {
		// Didn't bother overriding children's equals. Feels too boilerplate and I just want to get this out of the way. I was considering coming up with a version of what I'm
		// doing with the toString method for future experimentation. I was going to do..
		
		// Recursively compare both objects and all properties only if their direct parents are the same and their current properties are the same 
		if (obj instanceof Animal) {
			Animal otherAnimal = (Animal) obj;
			return otherAnimal.getName().equalsIgnoreCase(this.getName()) && otherAnimal.isWarmBlooded() == this.isWarmBlooded();
		}
		return false;
	}
}

