package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class Timidplayer implements Player {
	List <Move> mosse = new ArrayList <Move>();
	private int score;
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	public Move nextMove() {
		int d = 0;
		int c = 0;		
		for(Move m : mosse) 
			if(m.DEFECT == Move.DEFECT) 
				d++;
		for(Move m : mosse) 
			if(m.COOPERATE == Move.COOPERATE) 
				c++;				
		return d<c? Move.COOPERATE : Move.DEFECT;
	}

	@Override
	public void receiveOpponentMove(Move move) {
		mosse.add(move);
	}

	@Override
	public void addScore(Score score) {
		this.score += score.intValue();
	}

	@Override
	public void onChangeOpponent() {
		mosse.clear();
	}

	@Override
	public void onReset() {
		mosse.clear();
		score = 0;
	}

}
