package model;

public class Voter extends Person {
	private String voterId;
	private int age;
	
	public static final String DEFAULT_VOTER_ID = "default_voter_id";
	public static final int DEFAULT_AGE = -1;
	
	public Voter() {
		this(DEFAULT_VOTER_ID, Person.DEFAULT_FIRST_NAME, Person.DEFAULT_LAST_NAME, DEFAULT_AGE);
	}
	
	public Voter(String voterId, String lastName, String firstName, int age) {
		super(lastName, firstName);
		this.voterId = voterId;
		this.age = age;
	}
	
	public String getVoterId() { return this.voterId; }

	public int getAge() { return this.age; }
	public void setAge(int age) { this.age = age; }
}
