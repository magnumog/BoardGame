package Gamelogic;

import Movements.Directions;

import Main.Main;

import Board.Board;

import java.util.List;

/**
 * Created by magnumog on 03.05.16.
 */
public class GameLogic {



    public boolean checkMove(Directions dir) {
        int xPos = getXPosition();
        int yPos = getYPosition();
        if(dir==Directions.DOWN) {
            return movePossible(Directions.DOWN,xPos,yPos);
        } else if(dir==Directions.UP) {
            return movePossible(Directions.UP,xPos,yPos);
        }else if(dir==Directions.LEFT) {
            return movePossible(Directions.LEFT,xPos,yPos);
        } else {
            return movePossible(Directions.RIGHT,xPos,yPos);
        }
    }

    private boolean movePossible(Directions down, int xPos, int yPos) {
        return true;
    }

    public int getXPosition() {
        List<String> temp = Main.board.get(Main.board.size()-1).getBoard();
        for(int i=0;i<temp.size();i++) {
            if(temp.get(i).indexOf("@")>0) {
                return temp.get(i).indexOf("@");
            }
        }
        return 0;
    }

    public int getYPosition() {
        List<String> temp = Main.board.get(Main.board.size()-1).getBoard();
        for(int i=0;i<temp.size();i++) {
            if(temp.get(i).indexOf("@")>0) {
                return i;
            }
        }
        return 0;
    }
}
