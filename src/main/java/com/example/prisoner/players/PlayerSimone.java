package com.example.prisoner.players;

public class PlayerSimone implements Player {

	private int defectCounter;
	private int collaborateCounter;
	private Move lastMove; 
	private int score; 
	public int getScore() {
		return score;
	}

	public Move nextMove() {
		if ( lastMove != null ) {
			if ( (lastMove.equals(Move.COOPERATE)) && (collaborateCounter > defectCounter) ) {
				return Move.COOPERATE;
			} else {
				return Move.DEFECT;
			}
		} else {
			return Move.DEFECT;
		}
	}
	
	public void receiveOpponentMove(Move move) {
		if ( move.equals(Move.COOPERATE)) {
			collaborateCounter++;
		} else { 
			defectCounter++;
		}
		this.lastMove = move; 
		
	}

	public void addScore(Score score) {
		this.score += score.intValue();
		
	}

	public void onChangeOpponent() {
		collaborateCounter = 0;
		defectCounter = 0;
		lastMove = null;
		
	}

	public void onReset() {
		collaborateCounter = 0;
		defectCounter = 0;
		lastMove = null;
		score =0;
		
	}

}
