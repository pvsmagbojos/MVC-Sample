package model;

public class Candidate extends Person {
	private String candidateId;
	private Position position;
	
	public Candidate(String candidateId, String lastName, String firstName, Position position) {
		super(lastName, firstName);
		this.candidateId = candidateId;
		this.position = position;
	}
	
	public String getCandidateId() { return this.candidateId; }

	public Position getPosition() { return this.position; }
	public void setPosition(Position position) { this.position = position; }
}
