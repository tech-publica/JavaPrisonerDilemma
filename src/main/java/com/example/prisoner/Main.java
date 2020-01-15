package com.example.prisoner;

import com.example.prisoner.competition.Tournament;

public class Main {
    public static void main(String[] args) {
        Tournament tour = new Tournament();
        tour.giostra();
        tour.sort();
        tour.showResults();
    }
}
