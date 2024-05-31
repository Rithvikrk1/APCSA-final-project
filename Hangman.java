/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;


public class Hangman {
	private String[] words = {"java", "hangman", "programming", "classic", "games", "computer", "algorithm", "keyboard", "internet", "software"};
    private String wordToGuess;
    private char[] guessedWord;
    private int attemptsLeft;
    private char[] incorrectGuesses;
    private String[] hangmanImages = {
        "  +---+\n" +
        "  |   |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "=========", 

        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "=========", 

        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        "  |   |\n" +
        "      |\n" +
        "      |\n" +
        "=========", 

        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|   |\n" +
        "      |\n" +
        "      |\n" +
        "=========", 

        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        "      |\n" +
        "      |\n" +
        "=========", 

        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        " /    |\n" +
        "      |\n" +
        "=========", 

        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        " / \\  |\n" +
        "      |\n" +
        "========="
    };

    public Hangman() {
        wordToGuess = words[(int)(Math.random() * words.length)];
        guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }
        attemptsLeft = 6;
        incorrectGuesses = new char[6];
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded && attemptsLeft > 0) {
            printGameState();
            System.out.println("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (isCorrectGuess(guess)) {
                updateGuessedWord(guess);
                gameEnded = isWordGuessed();
            } else {
                incorrectGuesses[6 - attemptsLeft] = guess;
                attemptsLeft--;
            }
        }

        printGameState();
        if (attemptsLeft > 0) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game over! The word was: " + wordToGuess);
            System.out.println("Hangman hanged!");
        }
    }

    private void printGameState() {
        System.out.println(hangmanImages[6 - attemptsLeft]);
        System.out.print("Word to guess: ");
        for (int i = 0; i < guessedWord.length; i++) {
            System.out.print(guessedWord[i] + " ");
        }
        System.out.println("\nIncorrect guesses: ");
        for (int i = 0; i < incorrectGuesses.length; i++) {
            if (incorrectGuesses[i] != 0) {
                System.out.print(incorrectGuesses[i] + " ");
            }
        }
        System.out.println("\nAttempts left: " + attemptsLeft);
    }

    private boolean isCorrectGuess(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                return true;
            }
        }
        return false;
    }

    private void updateGuessedWord(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    private boolean isWordGuessed() {
        for (int i = 0; i < guessedWord.length; i++) {
            if (guessedWord[i] == '-') {
                return false;
            }
        }
        return true;
    }
}
