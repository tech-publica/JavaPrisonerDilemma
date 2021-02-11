package com.example.prisoner.players;

import java.util.ArrayList;
import java.util.List;

public class FrustratedWithHumanityPlayer implements Player{

    // Lista delle mosse del mio avversario
    private List<Move> mosse = new ArrayList<Move>();

    // Punteggio privato
    private int score;

    // Leggere il punteggio
    @Override
    public int getScore() {
        return score;
    }

    // Trova il numero di DEFECT nella lista di mosse dell'avversario
    public boolean moreDefect() {
        boolean response = false;

        int nrDefect = 0;
        int nrCooperate = 0;
        for(int i = 0; i < mosse.size(); i++) {
            if(mosse.get(i) == Move.DEFECT) {
                nrDefect++;
            } else {
                nrCooperate++;
            }
        }
        if(nrDefect > nrCooperate) {
            response = true;
        }
        return response;
    }

    // La mossa che fa il giocatore in base alla lista di mosse dell'avversario
    @Override
    public Move nextMove() {
        // Di norma, collaboro
        Move myMove = Move.COOPERATE;
        // Se l'avversario ha fatto più mosse defect, anche la mia mossa sarà defect
        if(!mosse.isEmpty()) {
            if(moreDefect() == true) {
                myMove = Move.DEFECT;
            }
        }
        return myMove;
    }

    // Metodo che riceve la mossa dell'altro giocatore e la mette in lista
    @Override
    public void receiveOpponentMove(Move move) {
        mosse.add(move);
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
