package com.company.GUI;

import com.company.Player;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PostgameUI {



    /**
     * Zeigt den Gewinnerbildschirm + ( todo:(dynamisches)Scoreboard )
     */

    public PostgameUI() {

    }
    public void initPostgameUI(){
        System.out.println(" Ab hier funktioniert eigentlich nichts mehr. Ursprünglich war hier nen cooles Scoreboard was dynamisch alle wins/looses der unterschiedlichen player anzeigt. Stattdessen siehst du den prototyp des JTables");
        JFrame postgameUI = new JFrame();
        String[][] data = { {"player","1","1"},
                            {"playername2","1","1"}};
        String[] column = {"Player", "Wins", "Looses"};
        JTable table = new JTable(data,column);
        table.setBounds(20,20,20,20);
        postgameUI.add(new JScrollPane(table));
        postgameUI.setTitle("Postgame Screen");
        postgameUI.setSize(640,640);
        postgameUI.setResizable(false);
        postgameUI.setLocationRelativeTo(null);
        postgameUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        postgameUI.setVisible(true);
    }


}
