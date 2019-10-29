package model;

import java.util.ArrayList;

public class BallotBox {
	private BallotInfo ballotInfo;
	private ArrayList<BallotEntry> ballots;
	//TODO add precinct field
	
	public BallotBox() { this(new BallotInfo()); }
	
	public BallotBox(BallotInfo ballotInfo) {
		this.ballotInfo = ballotInfo;
		this.ballots = new ArrayList<BallotEntry>();
	}
	
	public BallotInfo getBallotInfo() { return ballotInfo; }
	public void setBallotInfo(BallotInfo ballotInfo) { this.ballotInfo = ballotInfo; }
	
	public ArrayList<BallotEntry> getBallots() { return this.ballots; }
	public void insertBallot(BallotEntry ballot) { this.ballots.add(ballot); }
}
