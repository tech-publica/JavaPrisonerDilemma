package com.example.prisoner.players;

public class JackNonMiAvreteMai implements Player{

    private int score;
    private Move mossa = Move.DEFECT;


    public int getScore() {
        return score;
    }


    public Move nextMove() {
        return mossa;
    }


    public void receiveOpponentMove(Move move) {


        if(move == Move.COOPERATE ){
            mossa = Move.DEFECT;
        }else {
            mossa = move;

        }

    }


    public void addScore(Score score) {
        this.score += score.intValue();
    }


    public void onChangeOpponent() {
        mossa = Move.DEFECT;
    }


    public void onReset() {
        this.score = 0;
    }

}

