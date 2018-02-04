package com.company;

import com.company.Pieces.*;

import java.util.*;

public class Board {
    //    boolean[][] board = new boolean[8][8];
    Unit[][] units = new Unit[8][8];
    Player playerWhite = new Player();
    Player playerBlack = new Player();
    private String whichPlayer;
    private String printMoves;

    public void populateBoard() {
        playerWhite.setType("WHITE");
        playerWhite.setMyTurn(true);

        playerBlack.setType("BLACK");
        playerBlack.setMyTurn(false);

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

        /////////// KNIGHTS //////////////////
        units[0][1] = new Knight();
        units[0][1].setColor("WHITE");
        units[0][1].pos = new Pos(0, 1);
        units[0][6] = new Knight();
        units[0][6].setColor("WHITE");
        units[0][6].pos = new Pos(0, 6);

        units[7][1] = new Knight();
        units[7][1].setColor("BLACK");
        units[7][1].pos = new Pos(7, 1);
        units[7][6] = new Knight();
        units[7][6].setColor("BLACK");
        units[7][6].pos = new Pos(7, 6);
        /////////// KNIGHTS //////////////////

        /////////// RUNNERS //////////////////
        units[0][2] = new Runner();
        units[0][2].setColor("WHITE");
        units[0][2].pos = new Pos(0, 2);
        units[0][5] = new Runner();
        units[0][5].setColor("WHITE");
        units[0][5].pos = new Pos(0, 5);

        units[7][2] = new Runner();
        units[7][2].setColor("BLACK");
        units[7][2].pos = new Pos(7, 2);
        units[7][5] = new Runner();
        units[7][5].setColor("BLACK");
        units[7][5].pos = new Pos(7, 5);
        /////////// RUNNERS //////////////////

        /////////// TOWERS //////////////////
        units[0][0] = new Tower();
        units[0][0].setColor("WHITE");
        units[0][0].pos = new Pos(0, 0);
        units[0][7] = new Tower();
        units[0][7].setColor("WHITE");
        units[0][7].pos = new Pos(0, 7);

        units[7][7] = new Tower();
        units[7][7].setColor("BLACK");
        units[7][7].pos = new Pos(7, 7);
        units[7][0] = new Tower();
        units[7][0].setColor("BLACK");
        units[7][0].pos = new Pos(7, 0);
        /////////// TOWERS //////////////////

        /////////// QUEENS //////////////////
        units[5][3] = new Queen();
        units[5][3].setColor("BLACK");
        units[5][3].pos = new Pos(5, 3);
        units[2][4] = new Queen();
        units[2][4].setColor("WHITE");
        units[2][4].pos = new Pos(2, 4);
        /////////// QUEENS //////////////////

        /////////// KINGS //////////////////
        units[0][3] = new King();
        units[0][3].setColor("WHITE");
        units[0][3].pos = new Pos(0, 3);
        units[7][4] = new King();
        units[7][4].setColor("BLACK");
        units[7][4].pos = new Pos(7, 4);
        /////////// KINGS //////////////////

        int i = 0;
    }

    public void playerTurn() {
        if (playerWhite.isMyTurn()) {
            whichPlayer = "WHITE";
            checkMovement(whichPlayer);
            playerWhite.setMyTurn(false);
            playerBlack.setMyTurn(true);
        } else if (playerBlack.isMyTurn()) {
            whichPlayer = "BLACK";
            checkMovement(whichPlayer);
            playerBlack.setMyTurn(false);
            playerWhite.setMyTurn(true);
        }
    }

    Map<Pos, List<Pos>> mapOfAvailableMoves = new HashMap<>();
    Map<Pos, List<Pos>> mapOfAvailableKills = new HashMap<>();
    List<Pos> availableMoves = new ArrayList<>();

    public String getPrintMoves() {
        return printMoves;
    }

    public void checkMovement(String whichPlayer) {
        Random r = new Random();
//        int whichMove;
//        for (int i = 0; i < units.length; i++) {
//            boolean foundUnit = false;  /// IF WE FIND THE RIGHT UNIT, WE DONT NEED TO LOOP ANYMORE, WHEN THIS IS TRUE, BREAK OUT OF LOOP (USED FURTHER DOWN)
//            for (int y = 0; y < units.length; y++) {
//                if (units[i][y] != null) {
//                    String type = units[i][y].getType();    // GET TYPE OF UNIT
//                    String color = units[i][y].getColor();    // GET COLOR OF UNIT
//
//                    if (type.contains("QUEEN") && color.contains(whichPlayer)) {           // IF ITS A QUEEN, (THIS PARTICULAR MOVE)
//
//                        String s = units[i][y].getColor();
//                        availableMoves = units[i][y].availableMoves(units[i][y], units, s);      /// CHECKS A HARDCODED UNIT FOR NOW
//                        if (availableMoves.size() > 0) {
//                            whichMove = r.nextInt(availableMoves.size());       /// PICKS A RANDOM MOVE FROM AVAILABLE MOVES
//
//                            int newPosX = availableMoves.get(whichMove).getPositionX();       // GETS A MOVES POSITIONS
//                            int newPosY = availableMoves.get(whichMove).getPositionY();
//                            units = units[i][y].move(newPosX, newPosY, units[i][y], units); /// SET BOARD TO VALUE AFTER MOVE
//                            foundUnit = true;           /// CHECKS IF THE UNIT HAS BEEN FOUND
//                            break;
//                        } else {
//                            System.out.println("No available moves to make");
//                        }
//                    }
//                }
//            }
//            if (foundUnit)
//                break;
//        }

        // OUTCOMMENTED CODE: CREATING POTENTIAL MOVES FOR ALL UNITS AT ONCE

        ///////// FINDING AND SAVING ALL MOVES FROM ALL CHESS PLAYERS
        for (int i = 0; i < units.length; i++) {
            for (int y = 0; y < units.length; y++) {
                if (units[i][y] != null) {
                    if (units[i][y].getColor().contains(whichPlayer)) {
                        String s = units[i][y].getColor();
                        availableMoves = units[i][y].availableMoves(units[i][y], units, s);     // CREATES TEMP LIST OF AVAILABLE MOVES
                        if (availableMoves.size() > 0) {
                            mapOfAvailableMoves.put(new Pos(units[i][y].pos.getPositionX(), units[i][y].pos.getPositionY()), availableMoves);   // FYLL I AVAILABLE MOVES
                        }
                        if (units[i][y].getAvailableKills().size() > 0) {
                            mapOfAvailableKills.put(new Pos(units[i][y].pos.getPositionX(), units[i][y].pos.getPositionY()), units[i][y].getAvailableKills()); // FYLL I AVAILABLE KILLS
                        }
                    }
                }
            }
        }
        int decidedUnitPosX = 0;        /// USED IN MOVE AFTER THE FOR LOOP BELOW!
        int decidedUnitPosY = 0;
        int decidedKillPosX = 0;
        int decidedKillPosY = 0;        /// USED IN MOVE AFTER THE FOR LOOP BELOW!
        int decidedNullPosX = 0;            /// FOR WHEN THERE IS NO KILL POSITION, ONLY NULL ONES AVAILABLE
        int decidedNullPosY = 0;            /// USED JUST LIKE decidedKillPos
        int highestValue = 0; //// SPARAR UNDAN VILKET HIGHEST VALUE ÄR BÄST MOVE, (HÖGST KILL)
        int whichIndexIsHighestValue = 0; //// SPARAR UNDAN VILKET HIGHEST VALUE ÄR BÄST MOVE, (HÖGST KILL)
        if (mapOfAvailableKills.size() > 0) {
            for (Map.Entry<Pos, List<Pos>> entry : mapOfAvailableKills.entrySet()) {

                int killPosX = 0;
                int killPosY = 0;

                for (int x = 0; x < entry.getValue().size(); x++) {         /// ON A SPECIFIC UNIT, CHECK ALL KILL POSITIONS
                    killPosX = entry.getValue().get(x).getPositionX() + entry.getKey().getPositionX();
                    killPosY = entry.getValue().get(x).getPositionY() + entry.getKey().getPositionY();
                    if (units[killPosX][killPosY].getKillValue() > highestValue) { // IS THIS ONE THE HIGHTST KILLVALUE?
                        highestValue = units[killPosX][killPosY].getKillValue();   // SET THIS AS THE NEW HIGHEST VALUE
                        decidedUnitPosX = entry.getKey().getPositionX();                    // SAVE THE UNITS POSITIONS
                        decidedUnitPosY = entry.getKey().getPositionY();                    // SAVE THE UNITS POSITIONS
                        decidedKillPosX = entry.getValue().get(x).getPositionX();            /// WHICH ISNED IS WRONG!!!
                        decidedKillPosY = entry.getValue().get(x).getPositionY();
                        whichIndexIsHighestValue = x;
                    }
                }

            }    // MOVE TO THE BEST KILL POSITION

//            printMoves = printMoves(units[decidedUnitPosX][decidedUnitPosY].getType(), units[decidedUnitPosX][decidedUnitPosY].getColor(),
//                    decidedUnitPosX, decidedUnitPosY,
//                    units[decidedKillPosX][decidedKillPosY].getType(), units[decidedKillPosX][decidedKillPosY].getColor(),
//                    decidedKillPosX, decidedKillPosY);


            units = units[decidedUnitPosX][decidedUnitPosY].move(decidedKillPosX, decidedKillPosY, units[decidedUnitPosX][decidedUnitPosY], units);
        } else if (mapOfAvailableMoves.size() > 0) {
            for (Map.Entry<Pos, List<Pos>> entry : mapOfAvailableMoves.entrySet()) {
                int randIndex = 0; //// SPARAR UNDAN VILKET HIGHEST VALUE ÄR BÄST MOVE, (HÖGST KILL)
                int nullPosX = 0;
                int nullPosY = 0;
                randIndex = r.nextInt(entry.getValue().size());
                for (int x = 0; x < entry.getValue().size(); x++) {         /// ON A SPECIFIC UNIT, CHECK ALL KILL POSITIONS
                    decidedNullPosX = entry.getValue().get(randIndex).getPositionX() + entry.getKey().getPositionX();
                    decidedNullPosY = entry.getValue().get(randIndex).getPositionY() + entry.getKey().getPositionY();
                    decidedUnitPosX = entry.getKey().getPositionX();                    // SAVE THE UNITS POSITIONS
                    decidedUnitPosY = entry.getKey().getPositionY();                    // SAVE THE UNITS POSITIONS
                    break;
                }
            }
            units = units[decidedUnitPosX][decidedUnitPosY].move(decidedNullPosX, decidedNullPosY, units[decidedUnitPosX][decidedUnitPosY], units);
        }    // MOVE TO THE BEST KILL POSITION


        /// EMPTY MAPS FOR THE NEXT CALL
        mapOfAvailableKills.clear();
        mapOfAvailableMoves.clear();
        availableMoves.clear();

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
        return outPutString;
    }

    public String printMoves(String currentType, String currentColor, int decidedUnitPosX, int decidedUnitPosY, String decidedType, String decidedColor, int decidedKillPosX, int decidedKillPosY) {
        String result = "Current type: " + currentType + "current Color: " + currentColor + " Pos X: " + decidedUnitPosX + "Pos Y:" + decidedUnitPosY
                + "Moves to:" + "Decided type: " + decidedType + "Decided Color: " + decidedColor + " Pos X: " + decidedKillPosX + "Pos Y:" + decidedKillPosY;

        return result;
    }
}
