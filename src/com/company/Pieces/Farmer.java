package com.company.Pieces;

import com.company.Pos;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends Unit {

    String type = "FARMER";

    public Farmer() {

    }


    @Override
    public List<Pos> availableMoves(Unit unit, Unit[][] units, String type) {
        List<Pos> availablePos = new ArrayList<>();
        int x = unit.pos.getPositionX();
        int y = unit.pos.getPositionY();

//        if (units[x + newPosX][y + newPosY] == null) {
////            return availablePos;
////        }

        return availablePos;
    }

    @Override
    public List<Pos> createPotentialMoves(){
        availablePos = new ArrayList<>();
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
