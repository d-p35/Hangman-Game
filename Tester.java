package Hangman;

import java.util.*;
import java.io.*;

public class Tester {
	public static void main(String args[]) {

		Generator b = new Generator();
		b.Word();
		b.Intro();
		b.guessing();
		b.Finish();
	}
}
