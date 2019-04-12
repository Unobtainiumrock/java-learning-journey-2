//package testerThing;

// Simply extend the Exception class. I added some basic functionality too.
public class CustomException extends Exception {
	/**
	 * What's this for? The compiler suggested I add it to remove warnings.
	 * 
	 */
	private static final long serialVersionUID = 457756819347342879L;
	
	private String error;
	
	public CustomException(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}
}
