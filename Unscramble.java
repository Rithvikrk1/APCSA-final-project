/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;


public class Unscramble {
	private String[] words = {"java", "hangman", "programming", "classic", "games", "computer", "algorithm", "keyboard", "internet", "software"};
    private String wordToGuess;
    private String scrambledWord;

    public Unscramble() {
        int randomIndex = (int) (Math.random() * words.length);
        wordToGuess = words[randomIndex];
        scrambledWord = scrambleWord(wordToGuess);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        System.out.println("Unscramble the word: " + scrambledWord);

        while (!gameEnded) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase(wordToGuess)) {
                System.out.println("Congratulations! You've unscrambled the word.");
                gameEnded = true;
            } else {
                System.out.println("Incorrect guess. Try again!");
            }
        }
    }

    private String scrambleWord(String word) {
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
