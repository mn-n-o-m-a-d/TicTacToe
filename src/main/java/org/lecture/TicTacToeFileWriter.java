package org.lecture;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TicTacToeFileWriter {

    /**
     * writes the file, with the information of the actual player and game board
     * @param p path of the file
     * @param gameBoard actual game board to write
     * @param player char from the actual player
     * @return true if the file reading is done
     */
    public boolean writeFile(Path p, char[][] gameBoard, char player) {

        try (BufferedWriter bw = Files.newBufferedWriter(p)) {

            var toWrite = String.format("%c%c%c%n", gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
            toWrite += String.format("%c%c%c%n", gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
            toWrite += String.format("%c%c%c%n", gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);
            toWrite += String.format("%n");
            toWrite += String.format("%c", player);

            bw.write(toWrite);

            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
