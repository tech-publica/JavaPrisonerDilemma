package com.example.prisoner.players;


public class MirrorPlayer implements Player{

    private int score;
    private Move mossaRicevuta;

    public int getScore() { return score;   }

    public Move nextMove() {
        if(this.mossaRicevuta == Move.DEFECT){ return Move.DEFECT; }
        else {  return Move.COOPERATE;  }   //comportamento di default

    }

    public void receiveOpponentMove(Move move) {
        if(move == Move.DEFECT){ this.mossaRicevuta = Move.DEFECT; }
        else if(move == Move.COOPERATE) {  this.mossaRicevuta = Move.COOPERATE;  }
    }

    public void addScore(Score score) { this.score += score.intValue();  }

    public void onChangeOpponent() {    this.mossaRicevuta = null;    }

    public void onReset() { this.score = 0; }

}
