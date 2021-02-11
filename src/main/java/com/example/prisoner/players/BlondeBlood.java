package com.example.prisoner.players;

public class BlondeBlood implements Player{

    private int score;
    private Move myMove = Move.DEFECT;
    private Move otherMove = Move.COOPERATE;


    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public Move nextMove() {
        return myMove;
    }

    @Override
    public void receiveOpponentMove(Move move) {
        if(move == Move.COOPERATE) {
            myMove = Move.DEFECT;
        } else {
            thinkMove();
        }
    }

    @Override
    public void addScore(Score score) {
        this.score += score.intValue();

    }

    @Override
    public void onChangeOpponent() {
         myMove = Move.DEFECT;

    }

    @Override
    public void onReset() {
        this.score = 0;

    }


    public void thinkMove() {
        if (myMove == this.otherMove) {
            myMove = Move.COOPERATE;
        } else {
            myMove = Move.DEFECT;
        }
    }


}
