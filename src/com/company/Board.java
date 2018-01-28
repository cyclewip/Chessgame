package com.company;

import com.company.Pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    //    boolean[][] board = new boolean[8][8];
    Unit[][] units = new Unit[8][8];

    public void populateBoard() {
        for (int i = 0; i < units.length; i++) {
            for (int y = 0; y < units.length; y++) {
                units[i][y] = null;

            }
        }
        for (int i = 1; i < 2; i++) {
            for (int y = 0; y < units.length; y++) {
                units[i][y] = new Pawn();
                units[i][y].setColor("WHITE");
                units[i][y].pos = new Pos(i, y);

            }
        }
        for (int i = 6; i < 7; i++) {
            for (int y = 0; y < units.length; y++) {
                units[i][y] = new Pawn();
                units[i][y].setColor("BLACK");
                units[i][y].pos = new Pos(i, y);
            }
        }
        units[0][1] = new Knight();
        units[0][1].setColor("WHITE");
        units[0][1].pos = new Pos(0, 1);

        units[0][6] = new Knight();
        units[0][6].setColor("WHITE");
        units[0][6].pos = new Pos(2, 5);


        units[7][1] = new Knight();
        units[7][1].setColor("BLACK");
        units[7][1].pos = new Pos(7, 1);

        units[7][6] = new Knight();
        units[7][6].setColor("BLACK");
        units[7][6].pos = new Pos(7, 6);


        units[3][1] = new Tower();
        units[3][1].setColor("WHITE");
        units[3][1].pos = new Pos(0, 0);

        units[3][0] = new Tower();
        units[3][0].setColor("WHITE");
        units[3][0].pos = new Pos(3, 0);

        units[5][5] = new Queen();
        units[5][5].setColor("WHITE");
        units[5][5].pos = new Pos(5, 5);

        int i = 0;
    }


    public void checkMovement() {
        Random r = new Random();
//        for (int i = 6; i < 7; i++) {
//            for (int y = 0; y < units.length; y++) {
//                if (units[i][y] != null) {
//                    units[i][y].move(-1, 0, units[i][y], units);
//
////                    units[i - 1][y] = units[i][y];
////                    units[i - 1][y].setPositionX(  units[i][y].getPositionX());
////                    units[i][y] = null;
//
//                }
//            }
//        }


//        String s = units[5][5].getColor();
//        availableMoves = units[5][5].availableMoves(units[5][5], units, s);      /// CHECKS A HARDCODED UNIT FOR NOW


        List<Pos> availableMoves = new ArrayList<>();
        int whichMove;
        for (int i = 0; i < units.length; i++) {
            boolean foundUnit = false;
            for (int y = 0; y < units.length; y++) {
                if (units[i][y] != null) {
                    String type = units[i][y].getType();    // GET TYPE OF UNIT
                    if (type.contains("QUEEN")) {           // IF ITS A QUEEN, (THIS PARTICULAR MOVE)

                        String s = units[i][y].getColor();
                        availableMoves = units[i][y].availableMoves(units[i][y], units, s);      /// CHECKS A HARDCODED UNIT FOR NOW
                        whichMove = r.nextInt(availableMoves.size());       /// PICKS A RANDOM MOVE FROM AVAILABLE MOVES

                        int newPosX = availableMoves.get(whichMove).getPositionX();       // GETS A MOVES POSITIONS
                        int newPosY = availableMoves.get(whichMove).getPositionY();
                        units = units[i][y].move(newPosX, newPosY, units[i][y], units); /// SET BOARD TO VALUE AFTER MOVE
                        foundUnit = true;           /// CHECKS IF THE UNIT HAS BEEN FOUND
                        break;
                    }
//                    units[i][y].move(-1, 0, units[i][y], units);
//
//                    units[i - 1][y] = units[i][y];
//                    units[i - 1][y].setPositionX(units[i][y].getPositionX());
//                    units[i][y] = null;

                }
            }
            if (foundUnit)
                break;
        }

        int i = 0;
    }

    public String printBoard() {
        List<String> outPut = new ArrayList<>();
        String outPutString = "";
        for (int i = 0; i < units.length; i++) {
            for (int y = 0; y < units.length; y++) {

                if (units[i][y] != null) {
                    if (units[i][y].getType().contains("HORSE"))
                        outPutString += " H";
                    else if (units[i][y].getType().contains("FARMER"))
                        outPutString += " F";
                    else if (units[i][y].getType().contains("TOWER"))
                        outPutString += " T";
                    else if (units[i][y].getType().contains("QUEEN"))
                        outPutString += " Q";
                    else if (units[i][y].getType().contains("KING"))
                        outPutString += " K";
                    else if (units[i][y].getType().contains("RUNNER"))
                        outPutString += " R";
                } else {
                    outPutString += " 0";
                }
                if (y == 7)
                    outPutString += "\n";
            }
        }
//        System.out.println(units);
        return outPutString;
    }
}
