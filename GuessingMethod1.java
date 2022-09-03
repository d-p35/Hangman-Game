package Hangman;

import java.util.Scanner;

public class GuessingMethod1 implements UserGuess{
	String word;
	int already_guessed;
	int index;
	int wrong;
	String asterikword;
	Scanner kbReader = new Scanner(System.in);
	String username;
	
	public GuessingMethod1(String word, String asterikword, String username) {
		this.word = word;
		this.asterikword = asterikword;
		this.username = username;
		
	}
	
	// Check if the entered guess is in the word
	public boolean containing(String word, String guess) {
		int index = word.indexOf(guess);
		if(index==-1) {
			return false;
		}
		int guessi = 0;
		for(int i=index; i<index+guess.length();i++) {
			if(!(word.charAt(i)==guess.charAt(guessi))) {
				return false;
			}
			guessi++;
		}
		
		return true;
	}
	
	
	public boolean getIndex(String word, String guess, String asterikname) {
		if(!word.contains(guess))return false;
		int indexarr[] = new int[word.length()+1];
		int ind = 0;
		int in = 0;
		int i;
		for(i=0; i<indexarr.length; i++) {			// get an array of all the indexes of the guess
			ind = word.indexOf(guess, in);
			indexarr[i] = ind;
			if (ind==-1) break;
			in += guess.length();
		}
		
		boolean b = false;
		for(i=0;indexarr[i]!=-1;i++) {
			for(int j=indexarr[i]; j<indexarr[i]+guess.length();j++) {
				if(asterikname.charAt(j)=='*') {
					b = true;				// is true if there is at least one letter that hasn't been guessed
					
				}
			}
			if(b) {
				ind = indexarr[i];
				break;
			}
			
		}
			if(!b) {
				return false;
			}
			
			index =ind;
		
			return true;
		
		
	}
	
	@Override
	public boolean guessingmethod() {
		
		while (wrong < 3 && !(word.equals(asterikword))) {
			for (;;) {
				System.out.println("Please enter your guess.");
				String useguess;
				useguess = kbReader.next();

				
		
				if (containing(word, useguess)) {
					already_guessed = 0;
					while(getIndex(word, useguess, asterikword)){
					already_guessed++;
					asterikword = asterikword.substring(0, index) + useguess + asterikword.substring(index+useguess.length());
					
					/*Problem: If word is band and someone guessed "an" then if they guess "a", and event if no
													another "a" in the word, they won't be charged a wrong*/
					}
					
					
					if(already_guessed==0) {
						System.out.println("No change, please enter a new guess");
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
					System.out.println(asterikword);
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
			return false;
		} 
		else{
			
			return true;
		}
	}
		
		
	}
	
	

