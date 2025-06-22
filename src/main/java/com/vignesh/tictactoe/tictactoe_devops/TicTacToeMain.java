package com.vignesh.tictactoe.tictactoe_devops;
import java.util.Scanner;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class TicTacToeMain{
    static final Logger logger=Logger.getLogger(TicTacToeMain.class);
    static String[][] board={{"1","2","3"},{"4","5","6"},{"7", "8", "9"}};
    static int[] enteredNumbers=new int[9];
    static int moveCount=0;

    public static void main(String[] args){
        BasicConfigurator.configure();
        Scanner in=new Scanner(System.in);
        printBoard();
        while (moveCount<9){
            String symbol=(moveCount%2==0)?"X":"O";
            logger.info("Enter "+symbol+" position:");
            String input = in.nextLine();
            if (!isNumber(input)){
                logger.info("Invalid input! Enter a number between 1 and 9.");
                continue;
            }
            int pos=Integer.parseInt(input);
            if (pos<1 || pos > 9 || isEntered(pos)){
                logger.info("Invalid or already taken position! Try again.");
                continue;
            }
            enteredNumbers[moveCount]=pos;
            int row=(pos-1)/3;
            int col=(pos-1)%3;
            board[row][col]=symbol;
            moveCount++;
            printBoard();
            if (moveCount >= 5 && checkWin(symbol)){
                logger.info("Player " + symbol + " wins!");
                break;
            }
            if (moveCount == 9) {
                logger.info("It's a draw!");
            }
        }
        in.close();
    }
    static boolean isEntered(int pos) {
        for (int i = 0; i < moveCount; i++) {
            if (enteredNumbers[i] == pos) {
                return true;
            }
        }
        return false;
    }
    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static boolean checkWin(String sym){
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(sym) && board[i][1].equals(sym) && board[i][2].equals(sym)) 
                return true;
            if (board[0][i].equals(sym) && board[1][i].equals(sym) && board[2][i].equals(sym)) 
                return true;
        }
        if (board[0][0].equals(sym) && board[1][1].equals(sym) && board[2][2].equals(sym)) 
            return true;
        if (board[0][2].equals(sym) && board[1][1].equals(sym) && board[2][0].equals(sym)) 
            return true;
        return false;
    }
    static void printBoard(){
        logger.info("\n" +
            board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
            "--+---+--\n" +
            board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
            "--+---+--\n" +
            board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n");
    }
}
