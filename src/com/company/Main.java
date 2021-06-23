package com.company;

import com.company.GUI.EntryUI;
import com.company.GUI.UI;
import java.io.IOException;
import java.rmi.NotBoundException;

public class Main   {
    /**
     *
     * @param args
     * startet das erste UI von dem aus sich der rest des spiels aufbaut
     */
    public static void main(String[] args)  {

        EntryUI options = new EntryUI();
        options.initOptionsUI();
    }
}
