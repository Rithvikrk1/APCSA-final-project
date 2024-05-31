/*
 *	Author:  
 *  Date: 
*/

import pkg.*;
import java.util.Scanner;
import java.util.Random;


class starter {
	public static void main(String args[]) {
		// Your code goes below here
		Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("Welcome to Classic Old Games!");
            System.out.println("Please select a game to play:");
            System.out.println("1. Tic Tac Toe");
            System.out.println("2. Connect Four");
            System.out.println("3. Hangman");
            System.out.println("4. Unscramble");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                TicTacToe ticTacToe = new TicTacToe();
                ticTacToe.playGame();
            } else if (choice == 2) {
                ConnectFour connectFour = new ConnectFour();
                connectFour.playGame();
            } else if (choice == 3) {
                Hangman hangman = new Hangman();
                hangman.playGame();
            } else if (choice == 4) {
                Unscramble unscramble = new Unscramble();
                unscramble.playGame();
            } else if (choice == 5) {
                continuePlaying = false;
            } else {
                System.out.println("Invalid choice, please select again.");
            }

            if (continuePlaying) {
                System.out.println("Do you want to continue playing? (yes/no)");
                String response = scanner.next();
                continuePlaying = response.equalsIgnoreCase("yes");
            }
        }

        System.out.println("Thank you for playing!");
	}
}
