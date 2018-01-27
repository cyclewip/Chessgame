package com.company.Pieces;

import com.company.Pos;

import java.util.ArrayList;
import java.util.List;

public class Horse extends Unit {


    String type = "HORSE";
    private Unit unit;
    private Unit[][] units;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Horse() {

    }

    @Override
    public List<Pos> availableMoves(Unit unit, Unit[][] units, String type) {   //// CHECK WHICH MOVES ARE AVAILABLE FOR SPECIFIC UNIT
        this.unit = unit;
        this.units = units;
        this.type = type;
        List<Pos> availablePos = new ArrayList<>();
        int currentPosX = unit.pos.getPositionX();
        int currentPosY = unit.pos.getPositionY();



        List<Pos> potentialMoves = new ArrayList<>();
        potentialMoves = createPotentialMoves();    // CHECK ALL POTENTIAL MOVES A HORSE HAS
        for(int i = 0; i < potentialMoves.size(); i++){
            if(inBounds(potentialMoves.get(i).getPositionX() + currentPosX, potentialMoves.get(i).getPositionY() + currentPosY)){

                availablePos.add(createPotentialMoves().get(i));
                /// FIND WHICH MOVES ARE OKAY TO DO FOR NOW
            }
        }



        return availablePos;    // RETURN THEM MOVES
    }

    @Override
    public List<Pos> createPotentialMoves(){
        availablePos = new ArrayList<>();
        int potentialX = -2;
        int potentialY = -1;
        availablePos.add(new Pos(potentialX, potentialY));

        potentialX = 2;
        potentialY = -1;
        availablePos.add(new Pos(potentialX, potentialY));

        potentialX = -2;
        potentialY = 1;
        availablePos.add(new Pos(potentialX, potentialY));

        potentialX = 2;
        potentialY = 1;
        availablePos.add(new Pos(potentialX, potentialY));


        potentialX = -1;
        potentialY = -2;
        availablePos.add(new Pos(potentialX, potentialY));

        potentialX = 1;
        potentialY = -2;
        availablePos.add(new Pos(potentialX, potentialY));

        potentialX = -1;
        potentialY = 2;
        availablePos.add(new Pos(potentialX, potentialY));

        potentialX = 1;
        potentialY = 2;
        availablePos.add(new Pos(potentialX, potentialY));
        return availablePos;
    }
}