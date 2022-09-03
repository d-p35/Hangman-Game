package Hangman;

import java.util.List;
import java.util.Scanner;

public class Generator {
	String letter[] = new String[10];
	String username;
	int length;
	String guessname = "";
	int correct;
	String answer;
	int userguess;
	String name;
	int wrong;
	String last_letter;
	Scanner kbReader = new Scanner(System.in);
	String asterikword = "";
	int index;
	boolean already_guessed;

	public Generator() {

	}

	public void Word() {
		String names[] = { "jalpa" };
		name = names[(int) (Math.random() * names.length)];
		length = name.length();

	}

	public void Intro() {
		Scanner kbReader = new Scanner(System.in);
		System.out.print("Please enter your name. ");
		username = kbReader.next();

		System.out.println("Welcome " + username
				+ " to hangman! You're about to enter userguess game of hangman using Marvel characters.");
		System.out
				.println("In this game, you will have to guess the first name of one of the Marvel characters given.");
		System.out.println("Hint: Enter only one letter and use lowercase letter while entering guesses.");
		
		boolean b = true;
		while(b) {
		System.out.println("Would you like to proceed?");
		String answer1 = kbReader.next();
		
		if (answer1.equalsIgnoreCase("no")) {
			System.out.println("Okay, good luck!");
			b = false;
		}
		else if (answer1.equalsIgnoreCase("yes")) {
			System.out.print("Here is your word: \n");
			b = false;
		}
		
		else {
			System.out.println("Please enter a valid response");
		}
		}
	
		
			for(int i=0; i<name.length();i++) {
				asterikword = "*" + asterikword;
				System.out.print("*");
				
			}
			System.out.print("\n");


		
	}
	
	public boolean getIndex(String name, String guess, String asterikname) {
		if(!name.contains(guess))return false;
		int indexarr[] = new int[name.length()+1];
		int ind = 0;
		int in = 0;
		int i;
		for(i=0; i<indexarr.length; i++) {
			ind = name.indexOf(guess, in);
			indexarr[i] = ind;
			if (ind==-1) break;
			in += guess.length();
		}
	
		boolean b = false;
		for(i=0;indexarr[i]!=-1;i++) {
			for(int j=indexarr[i]; j<indexarr[i]+guess.length();j++) {
				if(asterikname.charAt(j)=='*') {
					b = true;
				
				}
			}
			if(b) {
				ind = indexarr[i];
				break;
			}
			
		}
			if(!b) {
				already_guessed = true;
				return false;
			}
			
			index =ind;
		
			return true;
		
		
	}
	
	public boolean containing(String name, String guess) {
		int index = name.indexOf(guess);
		if(index==-1) {
			return false;
		}
		int guessi = 0;
		for(int i=index; i<index+guess.length();i++) {
			if(!(name.charAt(i)==guess.charAt(guessi))) {
				return false;
			}
			guessi++;
		}
		
		return true;
	}
	
	public void guessing() {
		
		while (wrong < 3 && !(name.equals(asterikword))) {
			for (userguess = 0; userguess < letter.length; userguess++) {
				System.out.println("Please enter your guess.");
				String useguess;
				useguess = kbReader.next();
				already_guessed = false;
				
		
				if (containing(name, useguess)) {
					
					while(getIndex(name, useguess, asterikword)){
					
					asterikword = asterikword.substring(0, index) + useguess + asterikword.substring(index+useguess.length());
					
					/*Problem: If word is band and someone guessed "an" then if they guess "a", and event if no
													another "a" in the word, they won't be charged a wrong*/
					}
					System.out.println(asterikword);
					
					break;
				}

				else {
					System.out.println("Incorrect guess");
					wrong++;
					if (wrong == 1) {
						System.out.println("    ----");
						System.out.println("    |	|");
						System.out.println("    O	|");
						System.out.println("    	|");
						System.out.println("    	|");
						System.out.println("    	|");
						System.out.println(" ----------");
					}

					else if (wrong == 2) {
						System.out.println("    ----");
						System.out.println("    |	|");
						System.out.println("    O	|");
						System.out.println("   /|\\	|");
						System.out.println("    	|");
						System.out.println("    	|");
						System.out.println(" ----------");
					}

					break;
				}
			}
		}
		if (wrong == 3) {
			System.out.println("    ----");
			System.out.println("    |	|");
			System.out.println("    O	|");
			System.out.println("   /|\\	|");
			System.out.println("    |	|");
			System.out.println("   / \\	|");
			System.out.println(" ----------");
			System.out.println("Sorry you've run out of guesses:( Please try again.");
		} else if (correct == length) {
			System.out.println("Congratulations " + username + ", you have guessed the name of your Marvel character");
		}
	}

	public void Finish() {
		if (name == "tony") {
			System.out.println("The character you were given was Tony Stark aka 'Iron Man'");
		} else if (name == "nick") {
			System.out.println(
					"The character you were given was Nick Fury aka the Former Director and founder of S.H.E.I.L.D");
		} else if (name == "sam") {
			System.out.println("The character you were given was Sam Wilson aka 'Falcon'");
		} else if (name == "clint") {
			System.out.println("The character you were given was Clint Barton aka 'Hawkeye'");
		} else if (name == "bucky") {
			System.out.println("The character you were given was Bucky Barnes aka 'The Winter Soldier'");
		} else if (name == "wade") {
			System.out.println("The character you were given was Wade Wilson aka 'Deadpool'");
		} else if (name == "carol") {
			System.out.println("The character you were given is Carol Danvers aka 'Captain Marvel'");
		} else if (name == "loki") {
			System.out.println("The character you were given is Loki Laufeyson aka 'God of Mischief'");
		} else if (name == "bruce") {
			System.out.println("The character you were given is Bruce Banner aka 'The Hulk'");
		}
	}
}
