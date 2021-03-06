package com.company.Pieces;

import com.company.Pos;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Unit {

    String type = "FARMER";
    int killValue = 1;
    public Pawn() {

    }
    public int getKillValue() {
        return killValue;
    }

    public void setKillValue(int killValue) {
        this.killValue = killValue;
    }


    @Override
    public List<Pos> createPotentialMoves(Unit unit , Unit[][] units) {
        availablePos = new ArrayList<>();

        String color = unit.getColor();
        if (color.contains("BLACK")) {
            int potentialX = -1;
            int potentialY = -1;
            availablePos.add(new Pos(potentialX, potentialY));
            potentialX = -1;
            potentialY = 1;
            availablePos.add(new Pos(potentialX, potentialY));
            potentialX = -1;
            potentialY = 0;
            availablePos.add(new Pos(potentialX, potentialY));
        } else if (color.contains("WHITE")) {
            int potentialX = 1;
            int potentialY = -1;
            availablePos.add(new Pos(potentialX, potentialY));
            potentialX = 1;
            potentialY = 1;
            availablePos.add(new Pos(potentialX, potentialY));
            potentialX = 1;
            potentialY = 0;
            availablePos.add(new Pos(potentialX, potentialY));
        }

        return availablePos;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
