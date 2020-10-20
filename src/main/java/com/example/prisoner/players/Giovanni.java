package com.example.prisoner.players;

public class Giovanni implements Player {
	private int score, nCoop, nDefect, nLastDefects;
	private static final int DEFECTSLIMIT = 3;
	private Move last = Move.DEFECT;

	public int getScore() {
		return this.score;
	}

	public Move nextMove() {
		Move nextM = Move.DEFECT;
		if ((this.nCoop >= this.nDefect || this.last == Move.COOPERATE) && nLastDefects < DEFECTSLIMIT) {
			nextM = Move.COOPERATE;
		}
		return nextM;
	}

	public void receiveOpponentMove(Move move) {
		switch (move) {
		case COOPERATE:
			if (this.nLastDefects != 0) {
				this.nLastDefects = 0;
			} 
			this.nCoop++;
			break;
		case DEFECT:
			this.nDefect++;
			break;
		default:
			System.out.println("Mossa invalida");
		}
	}

	public void addScore(Score score) {
		this.score += score.intValue();
	}

	public void onChangeOpponent() {
		this.nCoop = 0;
		this.nDefect = 0;
		this.nLastDefects = 0;
		this.last = Move.DEFECT;
	}

	public void onReset() {
		this.nCoop = 0;
		this.nDefect = 0;
		this.nLastDefects = 0;
		this.last = Move.DEFECT;
		this.score = 0;
	}
}
