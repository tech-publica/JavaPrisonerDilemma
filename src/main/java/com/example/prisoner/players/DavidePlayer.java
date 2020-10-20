package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;



public class DavidePlayer implements Player {
	
	private int collaborateCounter;
	private int defectCounter;
	private Move lastMove;
	private int score;

	
	
    public int getScore() {
       return this.score;
    }
    
    

    public Move nextMove() {
    	if (lastMove != null) {
    		if( (lastMove == Move.COOPERATE) && 
    		 (defectCounter > collaborateCounter) ){
    			return Move.DEFECT;
    		}else {
    			return Move.COOPERATE;
    		}
    	}else {
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
    	score =0;
		defectCounter = 0;
		lastMove = null;
    }
}
