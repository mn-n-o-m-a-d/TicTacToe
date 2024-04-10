package org.lecture;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicTacToeGameLogic {

    private char player;

    public TicTacToeGameLogic(char player) {
        this.player = player;
    }

    /**
     * Shows the menu with the actual game board and the player request
     * @param gameBoard needs the actual game board to show it in the console
     * @return true if the sequenz is still running, it turns to false if the game board is full or a player wins
     */
    public boolean displayGameMenu(char[][] gameBoard) {
        boolean running = true;
        boolean gameBoardIsFull = false;
        nextPlayer();
        char playerWhoWon = '#';

        System.out.println();
        System.out.println(">>>  Tic Tac Toe  <<<");
        System.out.println();
        System.out.printf("     0   1   2%n");
        System.out.printf("0    %c   %c   %c%n", gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
        System.out.printf("1    %c   %c   %c%n", gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
        System.out.printf("2    %c   %c   %c%n", gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);
        System.out.println();

        playerWhoWon = checkWinner(gameBoard);

        gameBoardIsFull = TicTacToeGameBoard.checkBoardIsFull(gameBoard);

        switch (playerWhoWon) {
            case 'X' -> {
                System.out.println("Player X is the Winner!");
                running = false;
            }
            case 'O' -> {
                System.out.println("Player O is the Winner!");
                running = false;
            }
        }

        if (gameBoardIsFull) {
            System.out.println("Game Over - Game board is full...");
            running = false;
        }

        return running;
    }

    /**
     * toggles between the players
     */
    private void nextPlayer() {
        switch (player) {
            case 'X' -> player = 'O';
            case 'O' -> player = 'X';
        }
    }

    /**
     * Check the winner with different option, each option stands for a char chain
     * @param gameBoard with the information about the actual game board
     * @return char with the player who wins
     */
    private char checkWinner(char[][] gameBoard) {

        char playerWhoWon = '#';

        String[] option = new String[8];

        option[0] = String.format("%c%c%c", gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
        option[1] = String.format("%c%c%c", gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
        option[2] = String.format("%c%c%c", gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);
        option[3] = String.format("%c%c%c", gameBoard[0][0], gameBoard[1][0], gameBoard[2][0]);
        option[4] = String.format("%c%c%c", gameBoard[0][1], gameBoard[1][1], gameBoard[2][1]);
        option[5] = String.format("%c%c%c", gameBoard[0][2], gameBoard[1][2], gameBoard[2][2]);
        option[6] = String.format("%c%c%c", gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]);
        option[7] = String.format("%c%c%c", gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]);

        for (String s : option) {
            switch (s) {
                case "XXX" -> playerWhoWon = 'X';
                case "OOO" -> playerWhoWon = 'O';
            }
        }

        return playerWhoWon;
    }
}
