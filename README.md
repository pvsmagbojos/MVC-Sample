# MVC-Sample
Sample project for basic model view controller design implementation (without Observables)

Presidential Elections System
The COMELEC needs to prepare a program that will be used for the country's elections. As the programmer, you have to create a program that utilizes the MVC design pattern. The application will promote encapsulation based on its identified data – a registered voter will encode the voter ID assigned (a combination of numbers and letters), voter’s name (last name and first name), age, chosen Presidential and Vice-Presidential candidates. The application must also be capable of counting the number of votes cast for the candidates. The program also has multiple different sessions in place for different users. An admin account is created to edit the ballot information, such as the list of candidates for the election, and the positions available in the elections.

In the given sample, the presidential and vice-presidential candidates are:
● ROBREDO, Leni (President)
● DUTERTE, Sara (President)
● MORENO, Isko (Vice-President)
● GO, Bong (Vice-President)

Below is the sample program execution:

WELCOME TO 2022 PRESIDENTIAL COMELEC ELECTIONS
1 – Press 1 to VOTE
2 – Count the votes
3 – Program Termination
Enter choice: 1

Enter voter’s ID: 123AC3
Enter Last Name: Nowitzki
Enter First Name: Dirk
Enter age: 30

List of President Candidates:
ROBREDO, Leni (President)
DUTERTE, Sara (President)

Enter Presidential Candidates: Robredo

List of Vice President Candidates:
● MORENO, Isko (Vice-President)
● GO, Bong (Vice-President)

Enter Vice-Presidential Candidate: Moreno

Thank you for voting.

//ASSUME THAT THE USER HAS MADE MULTIPLE VOTES

WELCOME TO 2022 PRESIDENTIAL COMELEC ELECTIONS
1 – Press 1 to VOTE
2 – Count the votes
3 – Program Termination
Enter choice: 2

Presidential Candidate Winner: Robredo (3)
Vice-President Winner: Moreno (3)
Presidential Candidate Loser: Duterte (2)
Vice-President Loser: Go (2)

WELCOME TO 2022 PRESIDENTIAL COMELEC ELECTIONS
1 – Press 1 to VOTE
2 – Count the votes
3 – Program Termination
Enter choice: 3

Program exited. Thank you for using the application

//Assume all inputs ARE VALID. You have to declare and design your own user-defined function, as well as the implementation of the admin session.
