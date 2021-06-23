package com.company.Pieces;



import com.company.GameLogic.Logic;
import com.company.Player;
import com.company.RemoteInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Pieces implements RemoteInterface {

    private RemoteInterface server = null;
    private int c=0;
    private String[] colors = {"",""};
    Logic ref = new Logic();

    /**
     * konstruktor der pieces klasse, verbindet den clienten zum server
     * @throws RemoteException
     */
    public Pieces() throws RemoteException {
try {
    server = (RemoteInterface) Naming.lookup("rmi://" + "localhost" + "/Chess");
    System.out.println("Client Connected");
}catch(Exception e){
    System.out.println("Connection failed");
        }
    }

    /**
     * bewegt die figuren auf dem gameboard
     * funktioniert indem das jlabel der entsprechenden figur zwischengespeichert wird, dieses dann entfernt und an der position des 2. klicks eingefügt wird
     * @param coordinateXYZV
     * @param colors
     * @param tile
     * @param chessBoard
     * @throws RemoteException
     */
    public  void movePiece(int[] coordinateXYZV, String[] colors, JPanel[][] tile, JFrame chessBoard) throws RemoteException{
        //speichert die aktuelle figur zwischen um sie später zu bewegen
        Component label = tile[coordinateXYZV[0]][coordinateXYZV[1]].getComponent(0);


        //Schlagen von Figuren
        if(tile[coordinateXYZV[2]][coordinateXYZV[3]]!=null && !colors[0].equals(colors[1])){
            tile[coordinateXYZV[0]][coordinateXYZV[1]].removeAll();
            try {
                if (tile[coordinateXYZV[2]][coordinateXYZV[3]].getComponent(0).getName().substring(0, 5).equals("WKing")) {
                    ref.blackWins(chessBoard);
                } else if (tile[coordinateXYZV[2]][coordinateXYZV[3]].getComponent(0).getName().substring(0, 5).equals("BKing")) {
                    ref.whiteWins(chessBoard);
                }
            }catch (Exception ignored){

            }
            tile[coordinateXYZV[2]][coordinateXYZV[3]].removeAll();

            tile[coordinateXYZV[2]][coordinateXYZV[3]].add(label);

        }

        SwingUtilities.updateComponentTreeUI(chessBoard);


    }

    //Aktuelle und Neue Koordinaten der gewählten Figur

    /**
     * stellt informationen für die movePiece() methode zur verfügung.
     * diese sind : farbe der spielfiguren, positionen
     * @param e mousehandler
     * @param coordinates
     * @param tile
     * @param chessBoard
     */
    public  void getPos(MouseEvent e, int[] coordinates, JPanel[][] tile, JFrame chessBoard) throws RemoteException {
        Object source = e.getSource();
        JPanel pressed = (JPanel) source;

        int[] coordinateXYZV = coordinates;

            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if (tile[y][x].getName().equals(pressed.getName())) {
                        if (c == 0 && pressed.getComponent(0) != null) {
                            coordinateXYZV[0] = y;
                            coordinateXYZV[1] = x;

                            colors[0] = tile[coordinateXYZV[0]][coordinateXYZV[1]].getComponent(0).getName().substring(0,1);

                            c++;
                        } else if(c == 1){
                            coordinateXYZV[2] = y;
                            coordinateXYZV[3] = x;


                            try {
                                colors[1] = tile[coordinateXYZV[2]][coordinateXYZV[3]].getComponent(0).getName().substring(0, 1);
                            }catch (Exception ignored){

                            }

                            movePiece(coordinateXYZV, colors, tile, chessBoard);

                            colors[0] = "";
                            colors[1] = "";
                            c = 0;
                        }
                    }
                }
            }
    }
}
