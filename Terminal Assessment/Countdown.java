/*
Countdown.java
C Gunning
23 04 2020
*/

import java.lang.Math.*; //used in order to randomise the vowels and consonants
public class Countdown{

	//data members

	//input
	private int rounds;
	private String p1Answ;
	private String p2Answ;
	private int vowelsAmnt;
	private int consonantsAmnt;

	//processes
	private String randomLetters;
	private StringBuffer strBuff;
	private String[] wordBank;
	private String[] VOWELS;
	private String[] CONSONANTS;
	private String mixedVowels;
	private String mixedConsonants;

	//outputs
	private int p1Score;
	private int p2Score;
	private String winnerAnnouncement;


	//constructor
	public Countdown(){
	rounds=0;
	p1Answ="";
	p2Answ="";
	vowelsAmnt=0;
	consonantsAmnt=0;
	randomLetters="";
	strBuff=new StringBuffer();
	wordBank=new String[] {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "import", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};
	VOWELS=new String[] {"a", "e", "i", "o", "u"};
	CONSONANTS=new String [] {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
	mixedVowels="";
	mixedConsonants="";
	p1Score=0;
	p2Score=0;
	winnerAnnouncement="";

	}

	//setters (4) - Sets the variable in the App Class so the user can input either a number or string

	public void setP1Answ(String p1Answ){
		this.p1Answ=p1Answ;
	}

	public void setP2Answ(String p2Answ){
		this.p2Answ=p2Answ;
	}

	public void setVowelsAmnt(int vowelsAmnt){
		this.vowelsAmnt=vowelsAmnt;
	}

	public void setConsonantsAmnt(int consonantsAmnt){
		this.consonantsAmnt=consonantsAmnt;
	}

	//compute
	public void computeRandomLetters(){ //Calculations separated for generating random mix of letters

		for(int i=0; i<vowelsAmnt; i++){ //Loop for the amount of vowels the user wants
			mixedVowels=VOWELS[(int)(Math.random()*5)]; //randomize 5 vowels
			strBuff.append(mixedVowels); //Stores the randomized vowels into a String
			}

		for(int i=0; i<consonantsAmnt; i++){ //Loop for the amount of consonants the user wants
			mixedConsonants=CONSONANTS[(int)(Math.random()*21)]; //randomize 21 consonants
			strBuff.append(mixedConsonants); //Stores the randomized vowels into a String
			}

			randomLetters=strBuff.toString(); //String buffer changes to a new String called randomLetters, which now has the mixed vowels and consonats within it
			strBuff=new StringBuffer();

			}


	public void computeScore(){ //Calculations for counting and displaying scoring to the user, also compares word length of each players guess

		for(int i=0; i<wordBank.length; i++){
			if(p1Answ.equalsIgnoreCase(wordBank[i])){ //Verifies if the player's guess is actually present within the word bank

				if(p1Answ.length()>p2Answ.length()||p1Answ.length()==p2Answ.length()){ //Compares length of each players answer to see which is longer (or equal) in order to see who gets the point
					p1Score = p1Score + 1; //Adds to the players score
				}
			}

			if(p2Answ.equalsIgnoreCase(wordBank[i])){ //Verifies if the player's guess is actually present within the word bank

				if(p2Answ.length()>p1Answ.length()||p2Answ.length()==p1Answ.length()){ //Compares length of each players answer to see which is longer (or equal) in order to see who gets the point
					p2Score = p2Score + 1; //Adds to the players score
				}
			}
		}
	}

	public void computeWinner(){ //Calculations to display the winner announcement depending on the comparison of the scores

			if(p1Score>p2Score){
				winnerAnnouncement="Congratulations Player One, you have won!";
			}
			else if(p2Score>p1Score){
				winnerAnnouncement="Congratulations Player Two, you have won!";
			}
			else{ // If it is a draw
				winnerAnnouncement="Congratulations, both Player One and Player Two have won!";
			}
		}


	public void computeReset(){ //Calculations for reseting the scores when the game loops and restarts
			p1Score=0;
			p2Score=0;
		}


	//getters - Allows the App class the get these variables from the Insta class

		public String getRandomLetters(){
			return randomLetters;
	}

		public int getP1Score(){
			return p1Score;
	}

		public int getP2Score(){
			return p2Score;
	}

		public String getWinnerAnnouncement(){
			return winnerAnnouncement;
	}

}



