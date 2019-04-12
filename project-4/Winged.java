//package io.careerdeer;

public interface Winged {
	 // Avoiding the mistake of referencing "this" and doing weird tricks on interfaces. The Trade-off being that I have to duplicate code with
	 // multiple overrides. I know you mentioned an alternative before, I'd prefer to see a concrete example in code if I am missing your point.
	boolean canFly();
}

