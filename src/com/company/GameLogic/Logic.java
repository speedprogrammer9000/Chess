package com.company.GameLogic;

import com.company.GUI.PostgameUI;
import com.company.Player;

import javax.swing.*;

public class Logic {

    /**
     * zeigt den gewinner an und startet das postgame ui
     * @param chessBoard
     */
    public void blackWins(JFrame chessBoard ){
        System.out.println("Black Wins");
        chessBoard.dispose();
        PostgameUI postgameui = new PostgameUI();
        postgameui.initPostgameUI();

    }
    /**
     * zeigt den gewinner an und startet das postgame ui
     * @param chessBoard
     */
    public void whiteWins(JFrame chessBoard){
        System.out.println("White Wins");
        chessBoard.dispose();
        PostgameUI postgameui = new PostgameUI();
        postgameui.initPostgameUI();
    }
}
