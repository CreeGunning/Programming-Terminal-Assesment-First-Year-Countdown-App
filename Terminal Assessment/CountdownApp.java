/*
CountdownApp.java
C Gunning
23 04 2020
*/

import javax.swing.*; //used for JOptionPane
public class CountdownApp{
	public static void main(String args[]){

		//variables

		//input
		int rounds;
		String p1Answ;
		String p2Answ;
		int vowelsAmnt;
		int consonantsAmnt;

		//processes
		String randomLetters;
		StringBuffer strBuff;
		String[] wordBank;
		String[] VOWELS;
		String[] CONSONANTS;
		String mixedVowels;
		String mixedConsonants;

		//outputs
		int p1Score;
		int p2Score;
		String winnerAnnouncement;

		//variables for looping the game
		int i;
		String playGameAgain;

		//initialiser
		i=0;
		playGameAgain="";

		//object
		Countdown myCountdown=new Countdown();


	while(i<1){ //Loop so that the user has the option to play again
		rounds=Integer.parseInt(JOptionPane.showInputDialog(null, "How many rounds would you like to play?"));
		for(int k=0; k<rounds; k++){

			JOptionPane.showMessageDialog(null, "Player 1, please choose a mix of vowels and consonants first, both players may guess. Player 2, choose another mix of vowels and consonants, and again, both players may guess");
			for(int j=0; j<2; j++){ //loop for 2 times - This is so the game is fair, Player 1 chooses vowels and consonants first, both Players make a guess, then Player 2 chooses vowels and consonants, and again, both Players make a guess


				//First Compute Section
			do{
				vowelsAmnt=Integer.parseInt(JOptionPane.showInputDialog(null, "How many vowels would you like?"));
				myCountdown.setVowelsAmnt(vowelsAmnt);

				consonantsAmnt=Integer.parseInt(JOptionPane.showInputDialog(null, "How many consonants would you like?"));
				myCountdown.setConsonantsAmnt(consonantsAmnt);

				myCountdown.computeRandomLetters();
				randomLetters=myCountdown.getRandomLetters();

				if(randomLetters.length()!=9){
					JOptionPane.showMessageDialog(null, "The total amount of vowels and consonants does not add up to 9, please try again.");
				}
			}

			while(randomLetters.length()!=9);

				JOptionPane.showMessageDialog(null, "Your letters are " +randomLetters );

				p1Answ=JOptionPane.showInputDialog(null, "Player 1, please make a word from the word bank using these random letters: " +randomLetters );
				myCountdown.setP1Answ(p1Answ);

				p2Answ=JOptionPane.showInputDialog(null, "Player 2, please make a word from the word bank using these random letters: " +randomLetters );
				myCountdown.setP2Answ(p2Answ);


				//Second Compute Section
				myCountdown.computeScore();// runs calculations for counting and displaying scoring to the user
				p1Score=myCountdown.getP1Score();
				p2Score=myCountdown.getP2Score();

				JOptionPane.showMessageDialog(null, "Player 1's score is " +p1Score);
				JOptionPane.showMessageDialog(null, "Player 2's score is " +p2Score);
				}
			}

				//Third Compute Section
				myCountdown.computeWinner();// runs different outcomes for announcing the winner of the game
				winnerAnnouncement=myCountdown.getWinnerAnnouncement();
				JOptionPane.showMessageDialog(null, winnerAnnouncement);

				//Fourth Compute Section
				myCountdown.computeReset();// runs calculations to reset the scores

		playGameAgain=JOptionPane.showInputDialog (null, "Would you like to play again? Answer: Y or N");
		if(playGameAgain.equalsIgnoreCase("Y")){
			i=0;
				}
			else if(playGameAgain.equalsIgnoreCase("N")){
				i=2;
				JOptionPane.showMessageDialog (null, "Thanks for playing!");
			}
		}
	}
}






