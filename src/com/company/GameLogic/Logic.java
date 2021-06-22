package com.company.GameLogic;

import com.company.GUI.PostgameUI;
import com.company.Player;

import javax.swing.*;

public class Logic {


    public void blackWins(JFrame chessBoard ){
        System.out.println("Black Wins");
        chessBoard.dispose();
        PostgameUI postgameui = new PostgameUI();
        postgameui.initPostgameUI();

    }
    public void whiteWins(JFrame chessBoard){
        System.out.println("White Wins");
        chessBoard.dispose();
        PostgameUI postgameui = new PostgameUI();
        postgameui.initPostgameUI();
    }
}
