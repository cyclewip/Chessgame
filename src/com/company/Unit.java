package com.company;

public abstract class Unit extends Pos {

    Pos pos;

    public Unit() {

    }

    public abstract Pos move(int positionX, int positionY);


}
