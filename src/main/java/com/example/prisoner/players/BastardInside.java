package com.example.prisoner.players;

import java.util.ArrayList;

public class BastardInside implements Player{

    private int score;
    public int getScore() {
        return score;
    }

    public Move nextMove() {
    	
        return Move.DEFECT;
    }

    public void receiveOpponentMove(Move move) {

    }

    public void addScore(Score score) {
        this.score += score.intValue();
    }

    public void onChangeOpponent() {

    }

    public void onReset() {
        this.score = 0;

    }
}
