package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class Kupang implements Player{


    private List<Move> mosse = new ArrayList<Move>();

    int nu  = 0;
    private int score;

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public Move nextMove() {
        Move mc = Move.COOPERATE;
        Move md = Move.DEFECT;
        Move mr = null;
        Move m = Move.DEFECT;
        if(mosse.contains(m)){
            mr = md;
        }else{
            for(int n = 0; n<10;n++){
                if (n%2 == 0){
                    mr = mc;
                }else {
                    mr = md;
                }
            }

        }
        return mr;

    }

    @Override
    public void receiveOpponentMove(Move move) {
        this.mosse.add(move);
    }

    @Override
    public void addScore(Score score) {
        this.score += score.intValue();
    }

    @Override
    public void onChangeOpponent() {
        this.mosse.clear();
    }

    @Override
    public void onReset() {
        this.mosse.clear();
        this.score = 0;
    }
}
