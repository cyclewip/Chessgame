package com.company.Pieces;

import com.company.Pos;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit extends Pos {

    public Pos pos;
    String type = "";
    String color = "";
    List<Pos> availablePos;


    public Unit[][] move(int newPosX, int newPosY, Unit unit, Unit[][] units) {
        int x = unit.pos.getPositionX();
        int y = unit.pos.getPositionY();

        if (units[x + newPosX][y + newPosY] == null) {
            units[x + newPosX][y + newPosY] = units[x][y];

            units[x + newPosX][y + newPosY].setPositionX(units[x][y].pos.getPositionX());
            units[x + newPosX][y + newPosY].setPositionY(units[x][y].pos.getPositionY());
            units[x][y] = null;
        }
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
        potentialMoves = createPotentialMoves(unit);    // CHECK ALL POTENTIAL MOVES A UNIT HAS

        for (int i = 0; i < potentialMoves.size(); i++) {

            if (inBounds(potentialMoves.get(i).getPositionX() + currentPosX, potentialMoves.get(i).getPositionY() + currentPosY)) {     // IS THE POSITION WITHING RANGE
                int potentialX = potentialMoves.get(i).getPositionX() + currentPosX;    /// JUST TO SHORTEN DOWN CODE A BIT FOR NEXT IF
                int potentialY = potentialMoves.get(i).getPositionY() + currentPosY;    /// SAVES POTENTIAL MOVE
                if(units[potentialX][potentialY] != null){     // IF THERE IS SOMETHING ON THE SPOT
                    String potentialColor = units[potentialX][potentialY].color;        /// SAVES POTENTIAL COLOR
                    String currentColor = units[currentPosX][currentPosY].color;        /// SAVES CURRENT COLOR
                    if (!potentialColor.contains(currentColor))                               /// IF THEY ARE THE SAME COLOR, UNIT CANNOT MOVE INTO THE SAME TYPE
                        availablePos.add(potentialMoves.get(i));
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

    public abstract List<Pos> createPotentialMoves(Unit unit);

    public abstract String getType();

    public abstract void setType(String type);
}
