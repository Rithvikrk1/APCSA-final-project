/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;


public class ConnectFour {
	private char[][] board;
    private char currentPlayer;

    public ConnectFour() {
        board = new char[6][7];
        currentPlayer = 'O';
        initializeBoard();
    }

    public void playGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            printBoard();
            playerMove();
            gameEnded = checkWinner();
            if (!gameEnded) {
                switchPlayer();
            }
        }
        printBoard();
        System.out.println("Game over!");
    }

    private void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (column 1-7): ");
            col = scanner.nextInt() - 1;
            if (col >= 0 && col < 7 && board[0][col] == '-') {
                for (int i = 5; i >= 0; i--) {
                    if (board[i][col] == '-') {
                        board[i][col] = currentPlayer;
                        return;
                    }
                }
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }

    private boolean checkWinner() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == currentPlayer && board[i][j+1] == currentPlayer && 
                    board[i][j+2] == currentPlayer && board[i][j+3] == currentPlayer) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == currentPlayer && board[i+1][j] == currentPlayer && 
                    board[i+2][j] == currentPlayer && board[i+3][j] == currentPlayer) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    return true;
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == currentPlayer && board[i-1][j+1] == currentPlayer && 
                    board[i-2][j+2] == currentPlayer && board[i-3][j+3] == currentPlayer) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == currentPlayer && board[i+1][j+1] == currentPlayer && 
                    board[i+2][j+2] == currentPlayer && board[i+3][j+3] == currentPlayer) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    return true;
                }
            }
        }
        boolean isFull = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                    break;
                }
            }
        }
        if (isFull) {
            System.out.println("The game is a tie!");
            return true;
        }
        return false;
    }

}
