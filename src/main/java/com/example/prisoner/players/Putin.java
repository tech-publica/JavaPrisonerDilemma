package com.example.prisoner.players;

public class Putin implements Player {

    private Move personalMove = Move.COOPERATE;
    private int score;

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public Move nextMove() {
        return personalMove;
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
        personalMove =  Move.DEFECT;
    }

    @Override
    public void onReset() {
        this.score = 0;
    }
}
