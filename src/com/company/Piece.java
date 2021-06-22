package com.company;
/*
possibly implementation by interface piece for shared methods etc, each piece gets its own class which implements the piece interface
 */
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.text.Position;

public interface Piece {

    List<Position> posMoves ( Position pos);

    int value();

    String name();

    Icon image();

    void addPiece(int x, int y, JPanel [][] tile, String pName, boolean white) throws IOException;



}