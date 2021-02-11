package com.example.prisoner.players;

public class Michele implements Player{

    private int score;
    private double cooperationMoves = 1;
    private double defectionMoves = 1;
    Move cMove = Move.COOPERATE;
    Move dMove = Move.DEFECT;
    Move nextMove = Move.DEFECT;
    Move lastOpponentMove;



    @Override
    public int getScore() {
        return score;
    }

    @Override
    public Move nextMove() {
        return this.nextMove;
    }

    @Override
    public void receiveOpponentMove(Move move) {
        this.lastOpponentMove = move;
        double p = this.updateProbability(move); // probability of next move respect to the history

        // the player has an inner bastard vein, but not too much

        if(p > 0.65) {
            this.nextMove = this.cMove;
        } else if(p < 0.5) {
            this.nextMove = this.dMove;
        } else {
            this.nextMove = this.lastOpponentMove; //  uncertainty range
        }

    }

    @Override
    public void addScore(Score score) {
        this.score += score.intValue();
    }

    @Override
    public void onChangeOpponent(){
        this.cooperationMoves = 1;
        this.defectionMoves = 1;
    }

    @Override
    public void onReset() {
       this.cooperationMoves = 1;
       this.defectionMoves = 1;
       this.score = 0;

    }

    private double updateProbability(Move move){
        if( move == cMove) {
            this.cooperationMoves++;
        }else{
            this.defectionMoves++;
        }
        return this.cooperationMoves / (this.cooperationMoves + this.defectionMoves);
    }
}
