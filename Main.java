package Hangman;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		boolean playgame = true;
		while(playgame) {
		String words[] = { "hulk", "shehulk", "wolverine", "deadpool", "daredevil", "falcon", "firelord", "gamora", "hawkeye"}; //Change to list of single words, used marvel names for simplicity
		NameGenerator namegen = new RandomNameGenerator(words);
		String word = namegen.getWord();
		Introduction intro = new IntroUser();
		String username = intro.enterUsername();
		boolean userResponse = true;
		Scanner kbReader = new Scanner(System.in);
		while(userResponse) {
		System.out.println("Would you like to proceed?");
		String answer1 = kbReader.next();
		
		if (answer1.equalsIgnoreCase("no")) {
			System.out.println("Okay thank you for playing, good luck");
			userResponse = false;
			playgame = false;
		}
		else if (answer1.equalsIgnoreCase("yes")) {
			System.out.print("Here is your word: \n");
			userResponse = false;
		}
		
		else {
			System.out.println("Please enter a valid response");
		}
		}
		if(!playgame) break;
		
		String asterikword = intro.getAsterikWord(word);
		UserGuess guessing = new GuessingMethod1(word, asterikword, username);
		boolean win = guessing.guessingmethod();
		
		if(win) {
			System.out.println("Congratulations " + username + ", you have guessed the name of your Marvel character"); //if win, do this
			
		}
		else {
			System.out.println("Sorry you've run out of guesses:( Please try again."); //if lose, do this 
		}
		
		System.out.println("Your word was: " + word);
		
		boolean playagain = true;
		while(playagain) {
			System.out.println("Would you like to play again?");
			String answer2 = kbReader.next();
			
			if (answer2.equalsIgnoreCase("no")) {
				System.out.println("Okay thank you for playing, good luck");
				playgame = false;
			}
			else if (answer2.equalsIgnoreCase("yes")) {
				break;
			}
			
			else {
				System.out.println("Please enter a valid response");
			}
			
		}
		
		if(!playagain) break;
		
		}
	}
}
