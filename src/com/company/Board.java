package com.company;

import com.company.Pieces.Farmer;
import com.company.Pieces.Horse;
import com.company.Pieces.Unit;

import java.util.ArrayList;
import java.util.List;

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
                units[i][y] = new Farmer();
                units[i][y].setColor("WHITE");
                units[i][y].pos = new Pos(i, y);

            }
        }
        for (int i = 6; i < 7; i++) {
            for (int y = 0; y < units.length; y++) {
                units[i][y] = new Farmer();
                units[i][y].setColor("BLACK");
                units[i][y].pos = new Pos(i, y);
            }
        }
        units[0][1] = new Horse();
        units[0][1].setColor("WHITE");
        units[0][1].pos = new Pos(0, 1);

        units[2][5] = new Horse();
        units[2][5].setColor("WHITE");
        units[2][5].pos = new Pos(2, 5);

            ////// TESTHORSE
        units[4][4] = new Horse();
        units[4][4].setColor("WHITE");
        units[4][4].pos = new Pos(4, 4);


        units[7][1] = new Horse();
        units[7][1].setColor("WHITE");
        units[7][1].pos = new Pos(7, 1);

        units[7][6] = new Horse();
        units[7][6].setColor("WHITE");
        units[7][6].pos = new Pos(7, 6);

        int i = 0;
    }


    public void checkMovement() {
        for (int i = 6; i < 7; i++) {
            for (int y = 0; y < units.length; y++) {
                if (units[i][y] != null) {
                    units[i][y].move(-1, 0, units[i][y], units);

//                    units[i - 1][y] = units[i][y];
//                    units[i - 1][y].setPositionX(  units[i][y].getPositionX());
//                    units[i][y] = null;

                }
            }
        }

        List<Pos> availablePos = new ArrayList<>();


        String s = units[0][1].getColor();
        units[0][1].availableMoves(units[0][1], units, s);      /// CHECKS A HARDCODED UNIT FOR NOW


        int i = 0;
    }

    public String printBoard() {
        List<String> outPut = new ArrayList<>();
        String outPutString = "";
        for (int i = 0; i < units.length; i++) {
            for (int y = 0; y < units.length; y++) {

                if (units[i][y] != null) {
                    if (units[i][y].getType().contains("HORSE"))
                        outPutString += "H";
                    else if (units[i][y].getType().contains("FARMER"))
                        outPutString += "F";
                } else {
                    outPutString += "0";
                }
                if (y == 7)
                    outPutString += "\n";
            }
        }
//        System.out.println(units);
        return outPutString;
    }

}
