package Gamelogic;

import Movements.Directions;

import Main.Main;

import Board.Board;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * Created by magnumog on 03.05.16.
 */
public class GameLogic implements KeyListener {



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

    private boolean movePossible(Directions dir, int xPos, int yPos) {
        List<String> board = Main.board.get(Main.board.size()-1).getBoard();
        String x = board.get(yPos);
        String y = board.get(yPos+dir.getVerticalVal());
        System.out.println(x.charAt(xPos+dir.getHorizentalVal()));
        System.out.println(y.charAt(xPos));
        if(x.charAt(xPos+dir.getHorizentalVal()))
        return false;
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
