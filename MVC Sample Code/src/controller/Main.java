package controller;

import java.io.IOException;

import model.*;
import view.ElectionView;

public class Main {
	public static final String pcosId = "pcos-1123"; //voting machine id
	public static final String pcosPassword = "abcd1234"; //voting machine password
	public static final String debugModeId = "09123rheikde"; //debug menu id
	public static final String debugPassword = "abcde1234"; //debug menu password
	
	public static void main(String[] args) throws IOException {	
		BallotInfo ballotInfo = new BallotInfo(2020);
		ballotInfo.insertNewCandidate(new Candidate("1Liberal","Robredo","Leni",Position.PRESIDENT));
		ballotInfo.insertNewCandidate(new Candidate("2Liberal","Moreno","Isko",Position.VICE_PRESIDENT));
		
		ballotInfo.insertNewCandidate(new Candidate("1HP","Duterte","Sara",Position.PRESIDENT));
		ballotInfo.insertNewCandidate(new Candidate("2HP","Go","Bong",Position.VICE_PRESIDENT));
		
		BallotBox ballots = new BallotBox(ballotInfo);
		
		try {
			if(args[0].equals(debugModeId) && args[1].equals(debugPassword)) {
				ElectionView.showMainMenu(ballots, BootOption.DEBUG_SESSION);
			}
			if(args[0].equals(pcosId) && args[1].equals(pcosPassword)) {
				ElectionView.showMainMenu(ballots,BootOption.VOTER_SESSION);
			}
			else {
				System.out.println("Your voting machine credentials are invalid.");
			}
		}
		catch (Exception e) {
			if(e instanceof ArrayIndexOutOfBoundsException) {
				ElectionView.showMainMenu(ballots, BootOption.DEFAULT);
			}
			else {
				System.out.println("Unknown error occurred.");
				e.printStackTrace();
			}
		}
	}
}
