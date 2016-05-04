package Main;

import Board.Board;
import Board.ReadBoard;
import Gamelogic.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Board> board = new ArrayList<>();

    public static void main(String[] args) {
        ReadBoard board = new ReadBoard();
        board.readBoard("Board");
        Main.board.get(0).printBoard();
        GameLogic logic = new GameLogic();
        System.out.println("A game using the console, W is used to move up, S is used to move down");
        System.out.println("A is used to move left, D is used to move left and R is used to step back");
        System.out.println("Your character is @ and your goal is o");
        while (!logic.isGameFinished()) {
            System.out.println("Make move(CAPS LETTERS): ");
            logic.readKey();
        }
    }
}
