package com.company.Pieces;

import com.company.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Rook extends JLabel implements Piece {

    public String pName;

    @Override
    public List<Position> posMoves(Position pos) {
        return null;
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Icon image() {
        return null;
    }

    @Override
    /**
     * fügt die entsprechende spielfigur ein. konkrete implementierung in den klassen der figuren, einziger unterschied der filepath für das entsprechende bild
     * @param x
     * @param y
     * @param tile
     * @param pName
     * @param white
     * @throws IOException
     */
    public void addPiece(int y, int x, JPanel[][] tile, String pName, boolean white) throws IOException {
        JLabel label = new JLabel();
        label.setName(pName);
        this.pName = pName;
        if(white) {
            BufferedImage imgw = ImageIO.read(new File("Pictures/RookWhite.png"));
            label.setIcon(new ImageIcon(imgw));
        }
        else{
            BufferedImage imgb = ImageIO.read(new File("Pictures/RookBlack.png"));
            label.setIcon(new ImageIcon(imgb.getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH)));
        }
        tile[y][x].add(label);
        label.setVisible(true);
        label.setOpaque(false);
    }
}
