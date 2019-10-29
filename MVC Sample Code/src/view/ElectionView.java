package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import controller.Main;
import utils.Reader;

import model.*;

public class ElectionView {
	public static void showMainMenu(BallotBox ballotBox, BootOption bootOption) throws IOException {
		switch(bootOption) {
			case VOTER_SESSION:
				showVoterSessionMenu(ballotBox);
				break;
			case DEBUG_SESSION:
				showDebugSessionMenu(ballotBox);
				break;
			case DEFAULT:
				showLoginMenu(ballotBox);
				break;
		}
		showLoginMenu(ballotBox);
	}
	
	private static void showLoginMenu(BallotBox ballotBox) throws IOException {
		Option option = Option.START;
		
		do {
			do {
				System.out.println("WELCOME TO THE " + ballotBox.getBallotInfo().getElectionYear() + " PRESIDENTIAL COMELEC ELECTIONS");
				System.out.println();
				System.out.println("1 - New Session");
				System.out.println("2 - Shut down");
				System.out.println();
				
				if(option == Option.INVALID) {
					System.out.println("Invalid input. Please enter a valid option.");
					System.out.println();
				}
				
				switch(Reader.readInt("Enter an option: ")) {
					case 1:
						System.out.println();
						option = showSessionOptions();
						/*
						 * Possible results of option in this case is:
						 * OPTION_1 = DEBUG SESSION
						 * OPTION_2 = VOTER SESSION
						 * INVALID = CREDENTIAL FAIL
						 */
						break;
					case 2:
						option = Option.TERMINATE;
						break;
					default:
						option = Option.DEFAULT;
						break;
				}
			}while(option == Option.INVALID || option == Option.DEFAULT);
			System.out.println();
			switch(option) {
				case OPTION_1:
					showDebugSessionMenu(ballotBox);
					break;
				case OPTION_2:
					showVoterSessionMenu(ballotBox);
					break;
			}
		} while(option != Option.TERMINATE); //keep the program running while the program has not yet been given a terminate order
		
		System.out.println("Thank you for using this voting machine. Machine is now shutting down.");
	}

	private static Option showSessionOptions() throws IOException {
		String username = Reader.readString("Enter username: ");
		String password = Reader.readString("Enter password: ");
		
		try {
			if(username.equals(Main.debugModeId) && password.equals(Main.debugPassword)) {
				return Option.OPTION_1; //Option 1 is debug session
			}
			if(username.equals(Main.pcosId) && password.equals(Main.pcosPassword)) {
				return Option.OPTION_2; //option 2 is voter session
			}
			else {
				System.out.println("Your voting machine credentials are invalid.");
				System.out.println();
				return Option.INVALID;
			}
		}
		catch (Exception e) {
			System.out.println("Unknown error occurred.");
			e.printStackTrace();
			return Option.INVALID;
		}
	}
	
	public static void showVoterSessionMenu(BallotBox ballotBox) throws IOException {
		Option option = Option.START;
		do {
			System.out.println("WELCOME TO THE " + ballotBox.getBallotInfo().getElectionYear() + " PRESIDENTIAL COMELEC ELECTIONS");
			System.out.println();
			System.out.println("1 - Vote");
			System.out.println("2 - End Session");
			System.out.println();
			
			if(option == Option.DEFAULT) {
				System.out.println("Invalid input. Please enter a valid option.");
				System.out.println();
			}
			
			switch(Reader.readInt("Enter an option: ")) {
				case 1:
					System.out.println();
					showVotingMenu(ballotBox.getBallotInfo().getPositions(),
							ballotBox.getBallotInfo().getCandidates(),
							ballotBox.getBallots());
					option = Option.OPTION_1;
					break;
				case 2:
					option = Option.TERMINATE;
					break;
				default:
					option = Option.DEFAULT;
					break;
			}
			System.out.println();
		} while(option != Option.TERMINATE); //keep the program running while the program has not yet been given a terminate order
		
		System.out.println("Thank you for using this voting machine. Session has ended.");
	}
	
	//TODO: Implement Observable between BallotBox and BallotInfo
	public static void showDebugSessionMenu(BallotBox ballotBox) throws IOException {
		Option option = Option.START;
		do {
			System.out.println("WELCOME TO " + ballotBox.getBallotInfo().getElectionYear() + " PRESIDENTIAL COMELEC ELECTIONS");
			System.out.println("DEBUG MENU");
			System.out.println();
			System.out.println("1 - Get Vote Tally");
			System.out.println("2 - Add New Candidate");
			System.out.println("3 - Remove Candidate");
			System.out.println("4 - End Session");
			System.out.println();
			
			if(option == Option.INVALID) {
				System.out.println("Invalid input. Please enter a valid option.");
				System.out.println();
			}
			
			switch(Reader.readInt("Enter an option: ")) {
				case 1:
					System.out.println();
					showVoteTally(ballotBox.getBallotInfo(), ballotBox.getBallots());
					option = Option.OPTION_1;
					break;
				case 2:
					//TODO: implement add of new candidates
					option = Option.OPTION_2;
					break;
				case 3:
					//TODO: implement remove of current candidates
					option = Option.OPTION_3;
					break;
				case 4:
					option = Option.TERMINATE;
					break;
				default:
					option = Option.INVALID;
					break;
			}
			System.out.println();
		} while(option != Option.TERMINATE); //keep the program running while the program has not yet been given a terminate order
		
	}
	
	private static void showVotingMenu(ArrayList<Position> positions, HashMap<String,Candidate> candidates, ArrayList<BallotEntry> ballots) throws IOException {
		Voter voter = new Voter(
				Reader.readString("Enter Voter's ID: "), //voter id
				Reader.readString("Enter Last Name: "), //last name
				Reader.readString("Enter First Name: "), //first name
				Reader.readInt("Enter Age: ") //age
				);
	
		BallotEntry ballot = new BallotEntry(voter);
		
		for(Position position : positions) { //populate ballot with votes
			Option option = Option.START;
			do {
				System.out.println();
				System.out.println("List of " + position.toString().replace('_', ' ') + " Candidates:");
				candidates.forEach((candidateId,candidate) -> {
					if(candidate.getPosition() == position) { // if candidate is not of the current position being voted for then skip
						System.out.println(candidate.getCandidateId() 
								+ " - " + candidate.getLastName().toUpperCase()
								+ ", " + candidate.getFirstName());
					}
				});
				
				System.out.println();
				
				if(option == Option.INVALID) {
					System.out.println("Invalid input. Please enter a valid Candidate ID from the list above.");
				}
				
				String candidateId = Reader.readString("Enter " + position.toString().replace('_', ' ') + " Candidate ID: ");
				if(!candidates.containsKey(candidateId)) {
					option = Option.INVALID;
				}
				else {
					ballot.voteCandidate(position, candidates.get(candidateId));
					option = Option.OK;
				}
			}while(option == Option.INVALID);
		}
		
		System.out.println();
		showBallotPrintout(ballot);
		ballots.add(ballot);
		System.out.println();
		System.out.println("Thank you for voting.");
	}
	
	private static void showBallotPrintout(BallotEntry ballot) {
		System.out.println("Ballot Information: ");
		System.out.println("Voter ID: " + ballot.getVoter().getVoterId());
		System.out.println("Voter Name: " + ballot.getVoter().getLastName()
				+ ", " + ballot.getVoter().getFirstName());
		System.out.println("Voter Age: " + ballot.getVoter().getAge());
		System.out.println();
		ballot.getCandidates().forEach((candidateId,candidate) -> {
			System.out.println(candidate.getPosition().toString().replace('_', ' ') 
					+ " - " + candidate.getLastName().toUpperCase() 
					+ ", " + candidate.getFirstName());
		});
		//TODO: Confirm vote
	}

	private static void showVoteTally(BallotInfo ballotInfo, ArrayList<BallotEntry> ballots) {
		System.out.println("Vote Tally for " + ballotInfo.getElectionYear() + " Presidential Comelec Elections:");
		System.out.println();
		for(Position position : ballotInfo.getPositions()) {
			System.out.println(position.toString().replace('_', ' ') + "Candidates: ");
			ballotInfo.getCandidates().forEach((candidateId,candidate) -> {
				if(candidate.getPosition() == position) {
					int votes = 0;
					for(BallotEntry ballot : ballots) {
						votes += (ballot.getCandidate(candidate.getPosition()).equals(candidate)) ? 1 : 0;
					}
					System.out.println(candidate.getLastName() + ", " + candidate.getFirstName() + " - " + votes);
				}
			});
			System.out.println();
		}
	}
}
