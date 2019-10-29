package model;

import java.util.ArrayList;
import java.util.HashMap;

public class BallotInfo {
	private int electionYear;
	private HashMap<String,Candidate> candidates;
	private ArrayList<Position> positions;
	
	private static final int DEFAULT_ELECTION_YEAR = -1; 
	
	public BallotInfo() {
		this(DEFAULT_ELECTION_YEAR);
	}
	
	public BallotInfo(int electionYear) {
		this.electionYear = electionYear;
		this.candidates = new HashMap<String,Candidate>();
		this.positions = new ArrayList<Position>();
	}
	
	public int getElectionYear() { return this.electionYear; }
	
	public HashMap<String,Candidate> getCandidates() { return this.candidates; }
	public Candidate getCandidate(String candidateId) {
		return this.candidates.get(candidateId);
	}
	public void insertNewCandidate(Candidate candidate) {
		if(!positions.contains(candidate.getPosition())) {
			this.insertNewPosition(candidate.getPosition());
		}
		this.candidates.put(candidate.getCandidateId(), candidate);
	}

	public ArrayList<Position> getPositions() { return this.positions; }

	public void insertNewPosition(Position position) { this.positions.add(position); }
}
