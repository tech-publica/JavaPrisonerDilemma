package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class Eitelplayer implements Player{
	
    private int score;
    
    List<Move> mosse = new ArrayList<Move>() ;
    
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	public Move nextMove() {
		// TODO Auto-generated method stub
		for(Move m : mosse) {
			if(m == Move.COOPERATE) {
				return Move.COOPERATE ;
			}
	
		}
			
			return Move.DEFECT;
		
	}

	@Override
	public void receiveOpponentMove(Move move) {
		// TODO Auto-generated method stub
		mosse.add(move);
		
	}

	@Override
	public void addScore(Score score) {
		// TODO Auto-generated method stub
		this.score += score.intValue();
	}

	@Override
	public void onChangeOpponent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset() {
		score =0;
		mosse.clear();
		
	}

	public void setScore(int score) {
		this.score = score;
	}

}
