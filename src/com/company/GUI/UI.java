package com.company.GUI;
import com.company.Player;
import com.company.Pieces.*;
import com.company.GUI.EntryUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;


public class UI extends JPanel{
    JPanel[][] tile = new JPanel[8][8];

    JFrame chessBoard = new JFrame();

    int[] coordinateXYZV = {0,0,0,0};
    Pieces s = new Pieces();

    public UI() throws IOException {

    }

    /**
     * startet das gameboard
     * @throws IOException
     */
    public void initGameboard() throws IOException {
        MouseHandler mhandler = new MouseHandler();

        chessBoard.setTitle("Chess");
        chessBoard.setLayout(new GridLayout(8,8));
        chessBoard.setSize(640,640);
        chessBoard.setResizable(false);
        chessBoard.setLocationRelativeTo(null);
        chessBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addTiles(chessBoard,mhandler);
        addAllPieces();
        chessBoard.setVisible(true);

    }

    /**
     * ruft die methoden zum zufügen der spielfiguren auf
     * @throws IOException
     */
    public void addAllPieces() throws IOException {
        addWhitePieces();
        addBlackPieces();
    }

    /**
     * fügt alle schwarzen spielfiguren hinzu
     * @throws IOException
     */
    public void addBlackPieces() throws IOException {
        Pawn pb = new Pawn();
        for(int w=0; w<8; w++ ) {
            pb.addPiece(1, w, tile,"BPawn1", false);
        }

        Queen qb = new Queen();
        qb.addPiece(0,3,tile,"BQueen", false);

        King kb = new King();
        kb.addPiece(0,4,tile,"BKing", false);

        Rook rb = new Rook();
        rb.addPiece(0,0,tile,"BRook", false);
        rb.addPiece(0,7,tile,"BRook", false);

        Bishop bb = new Bishop();
        bb.addPiece(0,2,tile,"BBishop", false);
        bb.addPiece(0,5,tile,"BBishop", false);

        Knight knb = new Knight();
        knb.addPiece(0,1,tile,"BKnight", false);
        knb.addPiece(0,6,tile,"BKnight", false);

    }

    /**
     * fügt alle weißen spielfiguren hinzu
     * @throws IOException
     */
    public void addWhitePieces() throws IOException {
        Pawn pw = new Pawn();
        for(int w=0; w<8; w++ ) {
            pw.addPiece(6, w, tile,"WPawn1", true);
        }
        Queen qw = new Queen();
        qw.addPiece(7,3,tile,"WQueen", true);

        King kw = new King();
        kw.addPiece(7,4,tile,"WKing", true);

        Rook rw = new Rook();
        rw.addPiece(7,0,tile,"WRook", true);
        rw.addPiece(7,7,tile,"WRook", true);

        Bishop bw = new Bishop();
        bw.addPiece(7,2,tile,"WBishop", true);
        bw.addPiece(7,5,tile,"WBishop", true);

        Knight knw = new Knight();
        knw.addPiece(7,1,tile,"WKnight", true);
        knw.addPiece(7,6,tile,"WKnight", true);
    }

    /**
     * füllt das gameboard mit den tiles auf denen sich die figuren befinden
     * @param chessBoard
     * @param m
     */
    public void addTiles(JFrame chessBoard , MouseHandler m) {
        String letter;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                tile[i][j] = new JPanel();
                if((i+j)%2 != 0){
                    tile[i][j].setBackground(new Color(235, 235, 208));
                }else{
                    tile[i][j].setBackground(new Color(119, 148, 85));
                }

                if (i == 0) {
                    letter = "H";
                } else if (i== 1) {
                    letter = "G";
                } else if (i== 2) {
                    letter = "F";
                } else if (i== 3) {
                    letter = "E";
                } else if (i== 4) {
                    letter = "D";
                } else if (i== 5) {
                    letter = "C";
                } else if (i== 6) {
                    letter = "B";
                } else {
                    letter = "A";
                }
                tile[i][j].setName(letter+(j+1));

                chessBoard.add(tile[i][j]);
                tile[i][j].addMouseListener(m);
            }
        }
    }

    /**
     * mousehandler, ruft bei klick die getPos methode auf
     */
    public class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e){


        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                try {
                    s.getPos(e, coordinateXYZV, tile,chessBoard);
                }catch (Exception ignored){

                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
