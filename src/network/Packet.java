package network;

import board.GameBoard;

import java.io.Serializable;

public class Packet implements Serializable {

String message;

public Packet(String message)
{
    this.message = message;
}

/*    GameBoard board;
    public Packet(GameBoard board1){
        board = board1;
    }*/
}
