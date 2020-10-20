package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class PlayerA implements Player {

	private int score;
	private List<Move> listMove=new ArrayList<Move>();
	public int getScore() {
		
		return score;
	}


	public Move nextMove() {
		// TODO Auto-generated method stub
		int nMosse=listMove.size();
		int nCop = 0;
		int nDef=0;
		for (Move move : listMove) {
			if(move==move.COOPERATE) {
				nCop++;
			}else {
				nDef++;
			}
			
		}
		if(nCop>=(nMosse/2)) {
			return Move.COOPERATE;
		}else {
			return Move.DEFECT;
		}
	}

	
	public void receiveOpponentMove(Move move) {
		listMove.add(move);
		

	}

	
	public void addScore(Score score) {
		this.score+=score.intValue();

	}

	
	public void onChangeOpponent() {
		listMove.clear();
		

	}

	
	public void onReset() {
		listMove.clear();
		score=0;

	}

}
