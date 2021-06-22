package com.company;

import com.company.GUI.EntryUI;
import com.company.GUI.UI;
import java.io.IOException;
import java.rmi.NotBoundException;


//fehlende vererbung + interface, aber dann muss man die methoden implementieren die ja nach OOP aspekten woanders hingehgören
public class Main   {
    /**
     *
     * @param args
     * Starts the Option UI
     */
    public static void main(String[] args)  {

        EntryUI options = new EntryUI();
        options.initOptionsUI();


    }
}
