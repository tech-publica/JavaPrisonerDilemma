package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class Alberto implements Player{

	private int score;
	private List<Move> opponentMoves = new ArrayList<Move>();
	
	@Override
	public int getScore() {
		return this.score;
	}
	
	@Override
	public Move nextMove() {
	

		boolean sneaky = Math.random() > 0.85; //valore arbitrario. Se true provo a fare defect indipendentemente dal comportamento dell'avversario nel tentativo di fregarlo.
		
		if(opponentMoves.isEmpty() || opponentMoves.size() == 1) { //buone intenzioni iniziali
			return Move.COOPERATE;
		}
		else if(opponentMoves.get(opponentMoves.size() - 1) == Move.DEFECT || 
				opponentMoves.get(opponentMoves.size() - 2) == Move.DEFECT ) { //tende a perdonare un avversario che fa un defect, a patto che non ne faccia ripetuti
			return Move.DEFECT;
		}
		
		else if(sneaky) {
			return Move.DEFECT;
		}
		
		return Move.COOPERATE; //in tutti gli altri casi
		
	}

	@Override
	public void receiveOpponentMove(Move move) {
		opponentMoves.add(move);		
	}

	@Override
	public void addScore(Score score) {
		this.score += score.intValue();
		
	}

	@Override
	public void onChangeOpponent() {
		
		this.opponentMoves.clear();
		
	}

	@Override
	public void onReset() {
	
		this.score = 0;
		this.opponentMoves.clear();
		
	}

}
