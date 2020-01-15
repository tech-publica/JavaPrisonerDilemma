package com.example.prisoner.players;

public interface Player {
    int getScore();

    Move nextMove();

    void receiveOpponentMove(Move move);

    void addScore(Score score);

    void onChangeOpponent();

    void onReset();
}
