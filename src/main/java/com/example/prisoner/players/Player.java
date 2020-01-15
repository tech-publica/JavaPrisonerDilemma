package com.example.prisoner.players;

public interface Player {
    Score getScore();

    Move nextMove();

    void receiveOpponentMove();

    void addScore(Score score);

    void onChangeOpponent();

    void onReset();
}
