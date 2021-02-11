package com.example.prisoner.players;

public class DrJekyll implements Player{


    private int score;
    public int getScore() {
        return score;
    }

    public Move nextMove() {
        return Move.DEFECT;
    }

    public void receiveOpponentMove(Move move) {
        // does not care
    }

    public void addScore(Score score) {
        this.score += score.intValue();
    }

    public void onChangeOpponent() {
        // does not care
    }

    public void onReset() {
        this.score = 0;
    }

}
