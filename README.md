# MVC-Sample
Sample project for basic model view controller design implementation (without Observables)

Presidential Elections System

The Comelec needs to prepare a program that will be used for the country's elections. As the programmer, you have to create a program that utilizes the MVC design pattern. The application will promote encapsulation based on its identified data – a registered voter will encode the voter ID assigned (a combination of numbers and letters), voter’s name (last name and first name), age, chosen Presidential and Vice-Presidential candidates. The application must also be capable of counting the number of votes cast for the candidates. The program also has multiple different sessions in place for different users. An admin session is opened to edit the ballot information, such as the list of candidates for the election, and the positions available in the elections.

In the given sample, the presidential and vice-presidential candidates are:
	
	ROBREDO, Leni (President)
	DUTERTE, Sara (President)
	MORENO, Isko (Vice-President)
	GO, Bong (Vice-President)

Below is the sample program execution:

	WELCOME TO THE 2020 PRESIDENTIAL COMELEC ELECTIONS

	1 - New Session
	2 - Shut down
	
	Enter choice: 1

	Enter username: pcos-1123
	Enter password: abcd1234
	
	WELCOME TO THE 2020 PRESIDENTIAL COMELEC ELECTIONS

	1 - Vote
	2 - End Session

	Enter an option: 1

	Enter voter’s ID: 123AC3
	Enter Last Name: Nowitzki
	Enter First Name: Dirk
	Enter age: 30

	List of PRESIDENT Candidates:
	1Liberal - ROBREDO, Leni
	1HP - DUTERTE, Sara

	Enter Presidential Candidates: 1Liberal

	List of VICE PRESIDENT Candidates:
	2HP - GO, Bong
	2Liberal - MORENO, Isko

	Enter VICE PRESIDENT Candidate ID: 2HP

	Ballot Information: 
	Voter ID: 123AC3
	Voter Name: Nowitzki, Dirk
	Voter Age: 30

	PRESIDENT - ROBREDO, Leni
	VICE PRESIDENT - GO, Bong

	Thank you for voting.

Assuming that the user has made multiple votes:

	WELCOME TO THE 2020 PRESIDENTIAL COMELEC ELECTIONS

	1 - Vote
	2 - End Session

	Enter an option: 2

	Thank you for using this voting machine. Session has ended.
	WELCOME TO THE 2020 PRESIDENTIAL COMELEC ELECTIONS

	1 - New Session
	2 - Shut down

	Enter an option: 1
	
	Enter username: 09123rheikde
	Enter password: abcde1234

	WELCOME TO 2020 PRESIDENTIAL COMELEC ELECTIONS
	DEBUG MENU

	1 - Get Vote Tally
	2 - Add New Candidate
	3 - Remove Candidate
	4 - End Session

	Enter an option: 1

	PRESIDENTCandidates: 
	Robredo, Leni - 5
	Duterte, Sara - 4

	VICE PRESIDENTCandidates: 
	Go, Bong - 3
	Moreno, Isko - 6

	WELCOME TO 2020 PRESIDENTIAL COMELEC ELECTIONS
	DEBUG MENU

	1 - Get Vote Tally
	2 - Add New Candidate
	3 - Remove Candidate
	4 - End Session

	Enter an option: 4

	WELCOME TO THE 2020 PRESIDENTIAL COMELEC ELECTIONS

	1 - New Session
	2 - Shut down

	Enter an option: 2

	Thank you for using this voting machine. Machine is now shutting down.

Assume that all user inputs are valid.
