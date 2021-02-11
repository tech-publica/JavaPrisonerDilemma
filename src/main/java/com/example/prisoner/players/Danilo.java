package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class Danilo implements Player{

    private List<Move> mossa= new ArrayList<Move>();

    private int score;

    @Override
    public int getScore() {

        return score;
    }

    @Override
    public Move nextMove() {

        return Move.DEFECT;
    }

    @Override
    public void receiveOpponentMove(Move move) {
        mossa.add(move);
    }

    @Override
    public void addScore(Score score) {

        this.score += score.intValue();
    }

    @Override
    public void onChangeOpponent() {
        this.mossa.clear();
    }

    @Override
    public void onReset() {
        this.mossa.clear();
        score = 0;
    }
}
