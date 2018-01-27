package com.company;

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
                units[i][y].pos = new Pos(i, y);
            }
        }
        for (int i = 6; i < 7; i++) {
            for (int y = 0; y < units.length; y++) {
                units[i][y] = new Farmer();
                units[i][y].pos = new Pos(i, y);
            }
        }


        int i = 0;
    }
//    }


    public void checkMovement() {
//        for (int i = 6; i < 7; i++) {
//            for (int y = 0; y < units.length; y++) {
//                if (units[i][y] != null) {
//                    units[i - 1][y] = units[i][y];
//                    units[i - 1][y].setPositionX(  units[i][y].getPositionX());
//                    units[i][y] = null;
//                }
//            }
//        }

        

        int i = 0;
    }

    public String printBoard() {
        List<String> outPut = new ArrayList<>();
        String outPutString = "";
        for (int i = 0; i < units.length; i++) {
            for (int y = 0; y < units.length; y++) {

                if (units[i][y] != null) {
                    outPutString += units[i][y].getPositionX();
                    outPutString += units[i][y].getPositionY();
                } else {
                    outPutString += units[i][y];
                }
                if (y == 7)
                    outPutString += "\n";
            }
        }
//        System.out.println(units);
        return outPutString;
    }

}
