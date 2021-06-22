package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    void movePiece(int[] coordinateXYZV, String[] colors, JPanel[][] tile, JFrame chessBoard) throws RemoteException;
    void getPos(MouseEvent e, int[] coordinates, JPanel[][] tile, JFrame chessBoard) throws RemoteException;

}
