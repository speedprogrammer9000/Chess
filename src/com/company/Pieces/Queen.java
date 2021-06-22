package com.company.Pieces;

import com.company.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Queen extends JLabel implements Piece {

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
    public void addPiece(int y, int x, JPanel[][] tile, String pName, boolean white) throws IOException {
        JLabel label = new JLabel();
        label.setName(pName);
        this.pName = pName;
        if(white) {
            BufferedImage imgw = ImageIO.read(new File("QueenWhite.png"));
            label.setIcon(new ImageIcon(imgw));
        }
        else{
            BufferedImage imgb = ImageIO.read(new File("QueenBlack.png"));
            label.setIcon(new ImageIcon(imgb));
        }
        tile[y][x].add(label);
        label.setVisible(true);
        label.setOpaque(false);

    }
}
