package model;

import java.util.HashMap;

public class BallotEntry {
	private Voter voter;
	private HashMap<Position,Candidate> candidates;
	
	public BallotEntry() { this(new Voter()); }
	public BallotEntry(Voter voter) {
		this.voter = voter;
		this.candidates = new HashMap<Position,Candidate>();
	}
	
	public Voter getVoter() { return this.voter; }
	public void setVoter(Voter voter) { this.voter = voter; }
	
	public HashMap<Position,Candidate> getCandidates() { return this.candidates; }
	public Candidate getCandidate(Position position) {
		return this.candidates.get(position);
	}

	public void voteCandidate(Position position, Candidate candidate) {
		if(this.candidates.containsKey(position)) { //if there is already a candidate in that position
			this.candidates.replace(position, candidate); // we replace the candidate with the new one
		}
		else { //insert a new candidate for that position if no candidate in that position found
			this.candidates.put(position, candidate);
		}
		
	}
}
