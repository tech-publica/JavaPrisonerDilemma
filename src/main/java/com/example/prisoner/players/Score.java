package com.example.prisoner.players;

public enum Score {
    BOTH_COOPERATE(50),
    BOTH_DEFECT(30),
    ONLY_ONE_COOPERATE(0),
    ONLY_ONE_DEFECT(80);
    private int score;
    private Score(int score) {
        this.score = score;
    }
    public int intValue() {
        return this.score;
    }

}
