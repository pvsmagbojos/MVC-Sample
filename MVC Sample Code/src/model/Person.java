package model;

public class Person {
	private String lastName;
	private String firstName;
	
	public static final String DEFAULT_FIRST_NAME = "Last Name";
	public static final String DEFAULT_LAST_NAME = "First Name";
	
	protected Person() {
		this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
	}

	protected Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public String getLastName() { return this.lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getFirstName() { return this.firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
}
