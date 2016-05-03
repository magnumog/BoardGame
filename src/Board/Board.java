package Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magnumog on 03.05.16.
 */
public class Board {
    List<String> board = new ArrayList<>();

    public Board(List<String> board) {
        this.board=board;
    }

    public List<String> getBoard() {
        return board;
    }

    public void printBoard() {
        for (String line: board) {
            System.out.println(line);
        }
    }
}
