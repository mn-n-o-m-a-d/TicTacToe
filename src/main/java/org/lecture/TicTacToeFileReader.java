package org.lecture;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Getter
public class TicTacToeFileReader {

    private char[][] gameBoard = new char[3][3];
    private char player;

    /**
     * Reads the file, with the last information about the player and game board, if it exists
     * @param p path of the file
     * @return true if the file reading is done
     * @throws IOException when the IO failed
     */
    public boolean readFile(Path p) throws IOException {

        if (Files.exists(p)) {

            String[] allLines = Files.readAllLines(p).toArray(new String[0]);

            this.gameBoard[0][0] = allLines[0].charAt(0);
            this.gameBoard[0][1] = allLines[0].charAt(1);
            this.gameBoard[0][2] = allLines[0].charAt(2);
            this.gameBoard[1][0] = allLines[1].charAt(0);
            this.gameBoard[1][1] = allLines[1].charAt(1);
            this.gameBoard[1][2] = allLines[1].charAt(2);
            this.gameBoard[2][0] = allLines[2].charAt(0);
            this.gameBoard[2][1] = allLines[2].charAt(1);
            this.gameBoard[2][2] = allLines[2].charAt(2);

            this.player = allLines[4].charAt(0);

            return true;
        }
        return false;
    }
}
