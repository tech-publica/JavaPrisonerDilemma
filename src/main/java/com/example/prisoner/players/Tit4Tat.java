package com.example.prisoner.players;

public class Tit4Tat implements Player{
    
	private Move lastMove = Move.COOPERATE;
	private int score;
	@Override
	public int getScore() {
		
		return score;
	}

	@Override
	public Move nextMove() {
		
		return lastMove;
	}

	@Override
	public void receiveOpponentMove(Move move) {
		lastMove = move;
		
	}

	@Override
	public void addScore(Score score) {
		this.score += score.intValue();
		
	}

	@Override
	public void onChangeOpponent() {
		lastMove = Move.COOPERATE;
		
	}

	@Override
	public void onReset() {
		lastMove = Move.COOPERATE;
		score = 0;
		
	}

}
