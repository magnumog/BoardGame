package Main;

import Board.Board;
import Board.ReadBoard;
import Gamelogic.GameLogic;
import Movements.Directions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Board> board = new ArrayList<>();

    public static void main(String[] args) {
        ReadBoard board = new ReadBoard();
        board.readBoard("Board");
        Main.board.get(0).printBoard();
        GameLogic logic = new GameLogic();
        System.out.println(logic.getXPosition());
        System.out.println(logic.getYPosition());
        logic.checkMove(Directions.LEFT);
    }
}
