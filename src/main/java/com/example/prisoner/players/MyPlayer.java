package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class MyPlayer implements Player{
    private List<Move> mosse = new ArrayList<Move>();
    private int score;

    /**
     * Ottiene lo score
     *
     * @return
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Ottiene la seguente mossa
     *
     * @return
     */
    @Override
    public Move nextMove() {
        return Move.DEFECT;
        //if(mosse.isEmpty()) return Move.DEFECT;
        //else return Move.COOPERATE;
    }

    /**
     * Riveve la mossa dell'altro giocatore e la mette nella lista
     *
     * @param move
     */
    @Override
    public void receiveOpponentMove(Move move) {
        mosse.add(move);
    }

    /**
     * Aggiunge lo score
     *
     * @param score
     */
    @Override
    public void addScore(Score score) {
        this.score += score.intValue();
    }

    /**
     *
     */
    @Override
    public void onChangeOpponent() {
        this.mosse.clear();
    }

    /**
     *
     */
    @Override
    public void onReset() {
        this.mosse.clear();
        this.score = 0;
    }
}

