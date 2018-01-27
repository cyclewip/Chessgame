package com.company;

public class Pos {

    private int positionX;
    private int positionY;


    public Pos( int positionX,int positionY ) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Pos(){

    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
