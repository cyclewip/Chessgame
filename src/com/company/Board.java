package com.company;

public class Board {
    boolean [][] board = new boolean[8][8];
    Unit farmer = new Farmer();
    public void populateBoard(){
        for(int i = 0; i < board.length; i++){
            for(int y = 0; y < board.length; y++){
                board[i][y] = true;

            }
        }

        farmer.pos = new Unit.Position();
        farmer.pos.setPositionX(0);
        farmer.pos.setPositionY(0);


    }
    public void checkMovement(){
        farmer.move(farmer.pos.getPositionX(), farmer.pos.getPositionY());
    }

}
