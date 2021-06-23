package com.company;



import javax.swing.*;
import java.awt.event.MouseEvent;

import java.rmi.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerProgram extends UnicastRemoteObject implements RemoteInterface{

    public ServerProgram() throws RemoteException {
        super();
    }

    @Override
    public void movePiece(int[] coordinateXYZV, String[] colors, JPanel[][] tile, JFrame chessBoard) throws RemoteException {

    }

    @Override
    public void getPos(MouseEvent e, int[] coordinates, JPanel[][] tile, JFrame chessBoard) throws RemoteException {

    }

    /**
     * main caller methode
     */
    public static void mainCaller(){
        main(null);
    }

    /**
     * startet den server
     * @param args
     */
    public static void main(String args[]) {
        try {
            RemoteInterface provider = new ServerProgram();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://" + "localhost" + "/Chess", provider);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
