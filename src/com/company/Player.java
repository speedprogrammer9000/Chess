package com.company;

import java.io.Serializable;

public class Player implements Serializable {
    public String playerName;

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public String getPlayerName() {
        return playerName;
    }


    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    int gamesWon;
    int gamesLost;

    public Player(String playerName){
        this.playerName=playerName;
    }
}
