package Board;

import Main.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadBoard {

    public void readBoard(String filename) {
        List<String> temp = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();

            while (line != null) {
                temp.add(line);
                line = br.readLine();
            }
        }catch (Exception e){

        }
        Main.board.add(new Board(temp));
    }
}
