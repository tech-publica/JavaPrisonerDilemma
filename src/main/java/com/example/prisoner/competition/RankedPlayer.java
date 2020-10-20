package com.example.prisoner.competition;

import com.example.prisoner.players.Move;
import com.example.prisoner.players.Player;
import com.example.prisoner.players.Score;

public class RankedPlayer implements Player{
    private Player player;
    private int trueScore;
    public RankedPlayer(Player player) {
        this.player = player;
    }

    public int getScore() {
        return trueScore;
    }

    public Move nextMove() {
        return player.nextMove();
    }

    public void receiveOpponentMove(Move move) {
        player.receiveOpponentMove(move);
    }

    public void addScore(Score score) {
        player.addScore(score);
        trueScore += score.intValue();
    }

    public void onChangeOpponent() {
         player.onChangeOpponent();
    }

    public void onReset() {
          player.onReset();
          trueScore = 0;
    }
    public boolean hasCheated() {
        return player.getScore() != trueScore;
    }

    @Override
    public String toString() {
        String message = "player=" + player.getClass().getSimpleName() +
                ", trueScore=" + trueScore;
        if(hasCheated()) {
            message += " cheater! true score: " + trueScore + " declared score: " + player.getScore();
        }
        return message;
    }
    
    public RankedPlayer deepClone() {
    	
    	{
    		try
    		{
    			return new RankedPlayer(player.getClass().newInstance());
    		} catch (InstantiationException e)
    		{
    			throw new RuntimeException(e);
    		} catch (IllegalAccessException e)
    		{
    			throw new RuntimeException(e);
    		}
    	
    }
    }
}
