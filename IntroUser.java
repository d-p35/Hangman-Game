package Hangman;

import java.util.Scanner;

public class IntroUser implements Introduction{
	
	String username;
	String asterikword = "";
	
	public IntroUser() {
		
	}

	@Override
	public String enterUsername() {
		Scanner kbReader = new Scanner(System.in);
		System.out.println("Please enter your name. ");
		username = kbReader.next();
		displayWelcomeMessage();
		return username;
		
	}

	
	private void displayWelcomeMessage() {
		System.out.println("Welcome " + username
				+ " to hangman! You're about to enter userguess game of hangman using Marvel characters.");
		System.out.println("In this game, you will have to guess the first name of one of the Marvel characters given.");
		System.out.println("Hint: use lowercase letter while entering guesses.");
		
	}

	@Override
	public String getAsterikWord(String name) {
		for(int i=0; i<name.length();i++) {
			if(name.charAt(i)== ' ') {
				System.out.print(" ");
				asterikword = " " + asterikword;
				continue;
			}
			System.out.print("*");
			asterikword = "*" + asterikword;
		}
		System.out.print("\n");
		
		return asterikword;
		
	}

}
