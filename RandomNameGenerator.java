package Hangman;

public class RandomNameGenerator implements NameGenerator{
	
	String word;
	String words[];
	int length;
	
	public RandomNameGenerator(String words[]) {
		this.words = words;
	};
	
	
	@Override
	public String getWord() {
		word = words[(int) (Math.random() * words.length)];
		length = word.length();
		System.out.println(word);
		return word;
	}

}
