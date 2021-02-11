package com.example.prisoner.players;

public class AndreaBastardPlayer implements Player {

    private int score;
    private Move nextMove = Move.DEFECT;

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public Move nextMove() {
        return nextMove;
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
