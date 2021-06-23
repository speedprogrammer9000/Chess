package com.company.Pieces;



import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.company.Piece;

public class Pawn extends JLabel implements Piece  {

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


    public void addPiece(int y, int x, JPanel [][] tile, String pName, boolean white) throws IOException {
        JLabel label = new JLabel();
        label.setName(pName);
        this.pName = pName;
        if(white) {
            BufferedImage imgw = ImageIO.read(new File("Pictures/PawnWhite.png"));
            label.setIcon(new ImageIcon(imgw));
        }
        else{
            BufferedImage imgb = ImageIO.read(new File("Pictures/PawnBlack.png"));
            label.setIcon(new ImageIcon(imgb));
        }
        tile[y][x].add(label);
        label.setVisible(true);
        label.setOpaque(false);
    }


}
