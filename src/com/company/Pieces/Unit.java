package com.company.Pieces;

import com.company.Pos;

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

    public abstract List<Pos> availableMoves(Unit unit, Unit[][] units, String type);

    public abstract List<Pos> createPotentialMoves();

    public abstract String getType();

    public abstract void setType(String type);
}
