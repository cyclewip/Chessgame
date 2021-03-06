package com.company.Pieces;

import com.company.Pos;

import java.util.ArrayList;
import java.util.List;

public class Runner extends Unit {
    String type = "RUNNER";
    int killValue = 4;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getKillValue() {
        return killValue;
    }

    public void setKillValue(int killValue) {
        this.killValue = killValue;
    }
    public Runner() {

    }

//    @Override
//    public List<Pos> availableMoves(Unit unit, Unit[][] units, String type) {   //// CHECK WHICH MOVES ARE AVAILABLE FOR SPECIFIC UNIT
//        List<Pos> availablePos = new ArrayList<>();
//        int currentPosX = unit.pos.getPositionX();
//        int currentPosY = unit.pos.getPositionY();
//
//        List<Pos> potentialMoves = new ArrayList<>();
//        potentialMoves = createPotentialMoves();    // CHECK ALL POTENTIAL MOVES A HORSE HAS
//
//        for (int i = 0; i < potentialMoves.size(); i++) {
//
//            if (inBounds(potentialMoves.get(i).getPositionX() + currentPosX, potentialMoves.get(i).getPositionY() + currentPosY)) {     // IS THE POSITION WITHING RANGE
//                int potentialX = potentialMoves.get(i).getPositionX() + currentPosX;    /// JUST TO SHORTEN DOWN CODE A BIT FOR NEXT IF
//                int potentialY = potentialMoves.get(i).getPositionY() + currentPosY;    /// SAVES POTENTIAL MOVE
//                if(units[potentialX][potentialY] != null){     // IF THERE IS SOMETHING ON THE SPOT
//                    String potentialColor = units[potentialX][potentialY].color;        /// SAVES POTENTIAL COLOR
//                    String currentColor = units[currentPosX][currentPosY].color;        /// SAVES CURRENT COLOR
//                    if (!potentialColor.contains(currentColor))                               /// IF THEY ARE THE SAME COLOR, UNIT CANNOT MOVE INTO THE SAME TYPE
//                        availablePos.add(potentialMoves.get(i));
//                }
//                else{
//                    availablePos.add(potentialMoves.get(i));
//                }
//
//                /// FIND WHICH MOVES ARE OKAY TO DO FOR NOW
//            }
//        }
//
//
//        return availablePos;    // RETURN THEM MOVES
//    }

    @Override
    public List<Pos> createPotentialMoves(Unit unit, Unit[][] units) {
        availablePos = new ArrayList<>();
        int potentialX;
        int potentialY;
        int currentPosX = unit.pos.getPositionX();
        int currentPosY = unit.pos.getPositionY();
        String currentColor = unit.getColor();

        /////////////////////////// FOR RUNNING TO SIDE + UP/DOWN
        for (int i = 1; i < 8; i++) {
            for (int y = 1; y < 8; y++) {
                potentialX = -y;
                potentialY = -i;
                if (inBounds(currentPosX + potentialX, currentPosY + potentialY)) {
                    /// FINNS FÖR ATT SLUTA FÅ KOD O "VARA DUPLICERAD"
                    if (units[currentPosX + potentialX][currentPosY + potentialY] == null) {
                        availablePos.add(new Pos(potentialX, potentialY));
                    } else {
                        String a = "finns  nnar bli d dulicate";
                        String potentialColor = units[currentPosX + potentialX][currentPosY + potentialY].getColor();   /// FÄRG FRÅN POTENTIAL POSITION
                        if (!currentColor.contains(potentialColor)) {   /// OM DE INTE ÄR SAMMA FÄRG
                            availablePos.add(new Pos(potentialX, potentialY));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        /////////////////////////// FOR RUNNING TO SIDE + UP/DOWN
        for (int i = 1; i < 8; i++) {
            for (int y = 1; y < 8; y++) {
                potentialX = -y;
                potentialY = i;
                if (inBounds(currentPosX + potentialX, currentPosY + potentialY)) {
                    /// FINNS FÖR ATT SLUTA FÅ KOD O "VARA DUPLICERAD"
                    if (units[currentPosX + potentialX][currentPosY + potentialY] == null) {
                        availablePos.add(new Pos(potentialX, potentialY));
                    } else {
                        String a = "finns  nnar bli e dulicate";
                        String potentialColor = units[currentPosX + potentialX][currentPosY + potentialY].getColor();   /// FÄRG FRÅN POTENTIAL POSITION
                        if (!currentColor.contains(potentialColor)) {   /// OM DE INTE ÄR SAMMA FÄRG
                            availablePos.add(new Pos(potentialX, potentialY));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        /////////////////////////// FOR RUNNING TO SIDE + UP/DOWN
        for (int i = 1; i < 8; i++) {
            for (int y = 1; y < 8; y++) {
                potentialX = y;
                potentialY = i;
                if (inBounds(currentPosX + potentialX, currentPosY + potentialY)) {
                    /// FINNS FÖR ATT SLUTA FÅ KOD O "VARA DUPLICERAD"
                    if (units[currentPosX + potentialX][currentPosY + potentialY] == null) {
                        availablePos.add(new Pos(potentialX, potentialY));
                    } else {
                        String a = "finns  nar bli de dulicate";
                        String potentialColor = units[currentPosX + potentialX][currentPosY + potentialY].getColor();   /// FÄRG FRÅN POTENTIAL POSITION
                        if (!currentColor.contains(potentialColor)) {   /// OM DE INTE ÄR SAMMA FÄRG
                            availablePos.add(new Pos(potentialX, potentialY));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        /////////////////////////// FOR RUNNING TO SIDE + UP/DOWN
        for (int i = 1; i < 8; i++) {
            for (int y = 1; y < 8; y++) {
                potentialX = y;
                potentialY = -i;
                if (inBounds(currentPosX + potentialX, currentPosY + potentialY)) {
                    /// FINNS FÖR ATT SLUTA FÅ KOD O "VARA DUPLICERAD"
                    if (units[currentPosX + potentialX][currentPosY + potentialY] == null) {
                        availablePos.add(new Pos(potentialX, potentialY));
                    } else {
                        String a = "finns  nna bli de dulicate";
                        String potentialColor = units[currentPosX + potentialX][currentPosY + potentialY].getColor();   /// FÄRG FRÅN POTENTIAL POSITION
                        if (!currentColor.contains(potentialColor)) {   /// OM DE INTE ÄR SAMMA FÄRG
                            availablePos.add(new Pos(potentialX, potentialY));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return availablePos;
    }
}
