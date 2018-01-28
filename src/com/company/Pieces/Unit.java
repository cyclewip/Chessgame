package com.company.Pieces;

import com.company.Pos;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit extends Pos {

    public Pos pos;
    String type = "";
    String color = "";
    int killValue;
    List<Pos> availablePos;
    List<Pos> availableKills = new ArrayList<>();

    public List<Pos> getAvailableKills() {
        return availableKills;
    }
    public void setAvailableKills(List<Pos> availableKills) {
        this.availableKills = availableKills;
    }
    public Pos getPos() {
        return pos;
    }
    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public abstract int getKillValue();

    public abstract void setKillValue(int killValue);

    public Unit[][] move(int newPosX, int newPosY, Unit unit, Unit[][] units) {
        int x = unit.pos.getPositionX();
        int y = unit.pos.getPositionY();
        int nextPosX = x + newPosX;
        int nextPosY = y + newPosY;

            units[x + newPosX][y + newPosY] = units[x][y];
            units[x + newPosX][y + newPosY].pos.setPositionX(nextPosX);
            units[x + newPosX][y + newPosY].pos.setPositionY(nextPosY);
            units[x][y] = null;

        return units;
    }

    public boolean inBounds(int x, int y) {
        boolean inBound = false;
        if (x < 8 && x >= 0)
            if (y < 8 && y >= 0)
                inBound = true;
            else
                return false;
            return inBound;
    }


    public List<Pos> availableMoves(Unit unit, Unit[][] units, String type) {   //// CHECK WHICH MOVES ARE AVAILABLE FOR SPECIFIC UNIT
        List<Pos> availablePos = new ArrayList<>();
        int currentPosX = unit.pos.getPositionX();
        int currentPosY = unit.pos.getPositionY();

        List<Pos> potentialMoves = new ArrayList<>();
        potentialMoves = createPotentialMoves(unit, units);    // CHECK ALL POTENTIAL MOVES A UNIT HAS

        for (int i = 0; i < potentialMoves.size(); i++) {
            String potentialColor = "";
            String currentColor = "";
            if (inBounds(potentialMoves.get(i).getPositionX() + currentPosX, potentialMoves.get(i).getPositionY() + currentPosY)) {     // IS THE POSITION WITHING RANGE
                int potentialX = potentialMoves.get(i).getPositionX() + currentPosX;    /// JUST TO SHORTEN DOWN CODE A BIT FOR NEXT IF
                int potentialY = potentialMoves.get(i).getPositionY() + currentPosY;    /// SAVES POTENTIAL MOVE
                if(units[potentialX][potentialY] != null){     // IF THERE IS SOMETHING ON THE SPOT
                     potentialColor = units[potentialX][potentialY].getColor();        /// SAVES POTENTIAL COLOR
                     currentColor = units[currentPosX][currentPosY].getColor();        /// SAVES CURRENT COLOR
                    if (!potentialColor.contains(currentColor))                               /// IF THEY ARE THE SAME COLOR, UNIT CANNOT MOVE INTO THE SAME TYPE
                        availablePos.add(potentialMoves.get(i));            // ADDS A MOVE TO POTENTIAL (WILL CHANGE TO ONLY CONTAIN MOVES THAT ISNT KILLS
                        availableKills.add(potentialMoves.get(i));          // HERE THE KILL SHOULD BE
                }
                else{
                    availablePos.add(potentialMoves.get(i));
                }

                /// FIND WHICH MOVES ARE OKAY TO DO FOR NOW
            }
        }
        return availablePos;    // RETURN THEM MOVES
    }

    public List<Pos> getAvailablePos() {
        return availablePos;
    }

    public void setAvailablePos(List<Pos> availablePos) {
        this.availablePos = availablePos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    public abstract List<Pos> availableMoves(Unit unit, Unit[][] units, String type);

    public abstract List<Pos> createPotentialMoves(Unit unit, Unit[][] units);

    public abstract String getType();

    public abstract void setType(String type);
}
