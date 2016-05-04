package Gamelogic;

import Movements.Directions;

import Main.Main;

import Board.Board;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by magnumog on 03.05.16.
 */
public class GameLogic implements KeyListener {

    public boolean isGameFinished() {
        List<String> board = Main.board.get(Main.board.size()-1).getBoard();
        for (int i=0;i<board.size();i++) {
            if(board.get(i).contains("o")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMove(Directions dir) {
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
        char moveX = x.charAt(xPos+dir.getHorizentalVal());
        char moveY = y.charAt(xPos);
        if(moveX!='#' && moveY!='#') {
            return true;
        }
        return false;
    }

    private int getXPosition() {
        List<String> temp = Main.board.get(Main.board.size()-1).getBoard();
        for(int i=0;i<temp.size();i++) {
            if(temp.get(i).indexOf("@")>0) {
                return temp.get(i).indexOf("@");
            }
        }
        return 0;
    }

    private int getYPosition() {
        List<String> temp = Main.board.get(Main.board.size()-1).getBoard();
        for(int i=0;i<temp.size();i++) {
            if(temp.get(i).indexOf("@")>0) {
                return i;
            }
        }
        return 0;
    }

    private void makeMove(Directions dir) {
        List<String> board = new ArrayList<>(Main.board.get(Main.board.size()-1).getBoard());
        int currentXPos = getXPosition();
        int currentYPos = getYPosition();
        board.get(currentYPos);
        board.set(currentYPos,board.get(currentYPos).substring(0,currentXPos) + 'x' + board.get(currentYPos).substring(currentXPos+1));
        board.set(currentYPos+dir.getVerticalVal(),board.get(currentYPos+dir.getVerticalVal()).substring(0,currentXPos+dir.getHorizentalVal()) + '@' + board.get(currentYPos+dir.getVerticalVal()).substring(currentXPos+dir.getHorizentalVal()+1));
        Main.board.add(new Board(board));
        Main.board.get(Main.board.size()-1).printBoard();    }

    private void stepBack() {
        if(Main.board.size()>1) {
            Main.board.remove(Main.board.size() - 1);
        } else {
            System.out.println("Cannot move back any longer this is the start game");
        }
    }

    public void readKey() {
        try {
            int move = System.in.read();
            if(move==KeyEvent.VK_W) {
                if(checkMove(Directions.UP)) {
                    makeMove(Directions.UP);
                } else {
                    System.out.println("Illegal move");
                }
            } else if(move==KeyEvent.VK_S) {
                if(checkMove(Directions.DOWN)) {
                    makeMove(Directions.DOWN);
                } else {
                    System.out.println("Illegal move");
                }
            } else if(move==KeyEvent.VK_A) {
                if(checkMove(Directions.LEFT)) {
                    makeMove(Directions.LEFT);
                } else {
                    System.out.println("Illegal move");
                }
            } else if(move==KeyEvent.VK_D) {
                if (checkMove(Directions.RIGHT)) {
                    makeMove(Directions.RIGHT);
                } else {
                    System.out.println("Illegal move");
                }
            } else if(move==KeyEvent.VK_R) {
                stepBack();
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_W) {
            System.out.println("You pressed W");
        } else if(key==KeyEvent.VK_S) {
            System.out.println("You pressed S");
        } else if(key==KeyEvent.VK_A) {
            System.out.println("You pressed A");
        } else if(key==KeyEvent.VK_D) {
            System.out.println("You pressed D");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
