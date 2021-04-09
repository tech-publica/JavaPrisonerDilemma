package com.example.prisoner.players;

import java.util.ArrayList;

public class BastardInside implements Player{
    private ArrayList<Move> moves = new ArrayList<>();
    private int score;
    public int getScore() {
        return score;
    }

    public Move nextMove() {
    	
    	Move first = moves.get(0);
    	Move last = moves.get(moves.size()-1);
    	for(int i = 0; i < moves.size(); i++) {
    		Move m = moves.get(i);
    	}
    	
        return Move.DEFECT;
    }

    public void receiveOpponentMove(Move move) {
        moves.add(move);
    }

    public void addScore(Score score) {
        this.score += score.intValue();
    }

    public void onChangeOpponent() {
        moves.clear();
    }

    public void onReset() {
        this.score = 0;
        moves.clear();
    }
}
