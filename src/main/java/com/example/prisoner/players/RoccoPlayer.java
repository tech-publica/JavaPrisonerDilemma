package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;


public class RoccoPlayer implements Player{

    private int score;
    public int getScore() {
        return score;
    }

    @Override
    public Move nextMove() {
        int r = (int)(Math.random()*100);
            if (r < 30) {
                return Move.COOPERATE;
            } else {
                return Move.DEFECT;
            }
        }


    @Override
    public void receiveOpponentMove(Move move) {

    }

    @Override
    public void addScore(Score score) {
        this.score += score.intValue();

    }

    @Override
    public void onChangeOpponent() {

    }

    @Override
    public void onReset() {

        this.score = 0;
    }
}
