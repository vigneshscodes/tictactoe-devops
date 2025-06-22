package com.vignesh.tictactoe.tictactoe_devops;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    @BeforeEach
    public void setup(){
        TicTacToeMain.board = new String[][] { {"1","2","3"}, {"4","5","6"}, {"7","8","9"} };
        TicTacToeMain.enteredNumbers = new int[9];
        TicTacToeMain.moveCount = 0;
    }
    @Test
    public void testValidNumber() {
        assertTrue(TicTacToeMain.isNumber("5"));
    }
    @Test
    public void testInvalidNumber() {
        assertFalse(TicTacToeMain.isNumber("X"));
    }
    @Test
    public void testValidIsEntered() {
        TicTacToeMain.enteredNumbers[0] = 1;
        TicTacToeMain.moveCount = 1;
        assertTrue(TicTacToeMain.isEntered(1));
    }
    @Test
    public void testInvalidIsEntered() {
        TicTacToeMain.enteredNumbers[0] = 1;
        TicTacToeMain.moveCount = 1;
        assertFalse(TicTacToeMain.isEntered(2));
    }
    @Test
    public void testWinRow() {
        TicTacToeMain.board = new String[][] { {"X", "X", "X"}, {"4","5","6"}, {"7","8","9"} };
        assertTrue(TicTacToeMain.checkWin("X"));
    }
    @Test
    public void testWinColumn() {
        TicTacToeMain.board = new String[][] { {"O", "2", "3"}, {"O","5","6"}, {"O","8","9"} };
        assertTrue(TicTacToeMain.checkWin("O"));
    }
    @Test
    public void testWinDiagonal() {
        TicTacToeMain.board = new String[][] { {"X", "2", "3"}, {"4","X","6"}, {"7","8","X"} };
        assertTrue(TicTacToeMain.checkWin("X"));
    }
    @Test
    public void testNoWin() {
        TicTacToeMain.board = new String[][] { {"X", "O", "X"}, {"O", "X", "O"}, {"O", "X", "O"} };
        assertFalse(TicTacToeMain.checkWin("X"));
    }
    @Test
    public void testXWinsFullMoves() {
        TicTacToeMain.board = new String[][] { {"1","2","3"}, {"4","5","6"}, {"7","8","9"} };
        TicTacToeMain.enteredNumbers = new int[9];
        TicTacToeMain.moveCount = 0;
        updateBoardForTest("X", 1);
        updateBoardForTest("O", 4);
        updateBoardForTest("X", 2);
        updateBoardForTest("O", 5);
        updateBoardForTest("X", 3);
        assertTrue(TicTacToeMain.checkWin("X"), "X should win with top row");
    }
    private void updateBoardForTest(String symbol, int pos) {
        TicTacToeMain.enteredNumbers[TicTacToeMain.moveCount] = pos;
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        TicTacToeMain.board[row][col] = symbol;
        TicTacToeMain.moveCount++;
    }
}
