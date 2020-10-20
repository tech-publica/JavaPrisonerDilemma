package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class KillerWhale implements Player {

	private int score;
	private List<Move> mosse = new ArrayList<Move>();
	
	public KillerWhale() {}
	
	public int getScore() {
		return score;
	}

	public Move nextMove() {
		if(mosse.isEmpty()) {
			return Move.DEFECT;
		}
		if((mosse.stream().filter(m -> m == Move.DEFECT).count()) > 
						(mosse.stream().filter(m -> m == Move.COOPERATE).count())) {
			return Move.DEFECT;
		} else {
			return Move.COOPERATE;
		}
	}

	public void receiveOpponentMove(Move move) {
		mosse.add(move);
	}

	public void addScore(Score score) {
		this.score += score.intValue();
	}

	public void onChangeOpponent() {
		mosse.clear();

	}

	public void onReset() {
		this.score = 0;
		mosse.clear();
	}

}
