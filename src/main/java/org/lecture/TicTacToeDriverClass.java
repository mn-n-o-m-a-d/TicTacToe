package org.lecture;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TicTacToeDriverClass {

    /**
     * This is the main driver class, it handel the class calls
     *
     * @throws IOException checks the file readers IO
     */
    public static void main(String[] args) throws IOException {

        // Make a new scanner for the user input, a new list of 2D char array for the game board, sets the path for the last game board
        Scanner scanner = new Scanner(System.in);
        List<char[][]> listGameBoards = new ArrayList<>();
        char[][] gameBoard = new char[3][3];
        Path path = Paths.get("src", "main", "resources", "lastGameBoard.txt");

        // Calls the game board, game logic, file writer and reader
        TicTacToeGameBoard ticTacToeGameBoard = new TicTacToeGameBoard(3, 3, gameBoard);
        TicTacToeGameBoard ticTacToeGameBoardNew = null;
        TicTacToeGameBoard ticTacToeGameBoardLoad = null;
        TicTacToeGameLogic ticTacToeGameLogic = new TicTacToeGameLogic('X');
        TicTacToeFileWriter ticTacToeFileWriter = new TicTacToeFileWriter();
        TicTacToeFileReader ticTacToeFileReader = new TicTacToeFileReader();

        // Helpers
        String choiceMainMenu = "";
        String choiceSubMenu = "";


        // If the file reader founds a file to read, it displays a menu with "new game board" or "load a game board"
        if (ticTacToeFileReader.readFile(path)) {
            do {
                choiceMainMenu = displayMainMenu(scanner);
            } while (!(choiceMainMenu.equals("new") || choiceMainMenu.equals("load")));
        } else choiceMainMenu = "new";

        // Switches between get a new game board and load the last game board, and puts it into the list of game boards
        switch (choiceMainMenu) {

            case "new" -> {
                // Load an empty game board
                ticTacToeGameBoardNew = new TicTacToeGameBoard(3, 3, ticTacToeGameBoard.loadEmptyBoard());
                listGameBoards.addFirst(ticTacToeGameBoardNew.getGameBoard());

                while (ticTacToeGameLogic.displayGameMenu(listGameBoards.getLast())) {
                    do {
                        choiceSubMenu = displaySubMenu(scanner, ticTacToeGameLogic.getPlayer());
                    } while (!(ticTacToeGameBoardNew.validPlayerChoice(choiceSubMenu) || choiceSubMenu.equals("quit")));

                    // This part makes the handling between the user input and the list of game boards, it checks the user input on possibility and put the player char, row and col into a game board
                    // The new game bord goes into the list of the game boards
                    if (!choiceSubMenu.equals("quit")) {
                        listGameBoards.add(ticTacToeGameBoardNew.playerMove(ticTacToeGameLogic.getPlayer(), ticTacToeGameBoardNew.validPlayerMove(choiceSubMenu)[0], ticTacToeGameBoardNew.validPlayerMove(choiceSubMenu)[1]));
                        ticTacToeFileWriter.writeFile(path, listGameBoards.getLast(), ticTacToeGameLogic.getPlayer());
                    } else break;
                }
            }

            case "load" -> {
                // Load the game board from the file reader
                ticTacToeGameBoardLoad = new TicTacToeGameBoard(3, 3, ticTacToeFileReader.getGameBoard());
                listGameBoards.addFirst(ticTacToeGameBoardLoad.getGameBoard());
                ticTacToeGameLogic.setPlayer(ticTacToeFileReader.getPlayer());

                while (ticTacToeGameLogic.displayGameMenu(listGameBoards.getLast())) {
                    do {
                        choiceSubMenu = displaySubMenu(scanner, ticTacToeGameLogic.getPlayer());
                    } while (!(ticTacToeGameBoardLoad.validPlayerChoice(choiceSubMenu) || choiceSubMenu.equals("quit")));

                    // This part makes the handling between the user input and the list of game boards, it checks the user input on possibility and put the player char, row and col into a game board
                    // The new game bord goes into the list of the game boards
                    if (!choiceSubMenu.equals("quit")) {
                        listGameBoards.add(ticTacToeGameBoardLoad.playerMove(ticTacToeGameLogic.getPlayer(), ticTacToeGameBoardLoad.validPlayerMove(choiceSubMenu)[0], ticTacToeGameBoardLoad.validPlayerMove(choiceSubMenu)[1]));
                        ticTacToeFileWriter.writeFile(path, listGameBoards.getLast(), ticTacToeGameLogic.getPlayer());
                    } else break;
                }
            }
        }
    }

    /**
     * Show a main menu for the user
     * @param scanner for the user input
     * @return user choice from scanner
     */
    private static String displayMainMenu(Scanner scanner) {

        System.out.println();
        System.out.println(">>>  Tic Tac Toe  <<<");
        System.out.println();
        System.out.println("Do you want to start a new game or load a game ?  ((new or load)):");
        System.out.println();

        return scanner.nextLine().toLowerCase();
    }

    /**
     * Show a sub menu for the user
     * @param scanner for the user input
     * @param player actual player
     * @return user choice from scanner
     */
    private static String displaySubMenu(Scanner scanner, char player) {

        System.out.printf("Player %s please make your choice (( row and col, for example: 00 )) or (( quit )): %n", player);
        System.out.println();

        return scanner.nextLine().toLowerCase();
    }
}
