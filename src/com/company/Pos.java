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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (positionX != pos.positionX) return false;
        return positionY == pos.positionY;
    }

    @Override
    public int hashCode() {
        int result = positionX;
        result = 31 * result + positionY;
        return result;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
