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

    /**
     * fügt die entsprechende spielfigur ein. konkrete implementierung in den klassen der figuren, einziger unterschied der filepath für das entsprechende bild
     * @param x
     * @param y
     * @param tile
     * @param pName
     * @param white
     * @throws IOException
     */
    void addPiece(int x, int y, JPanel [][] tile, String pName, boolean white) throws IOException;



}