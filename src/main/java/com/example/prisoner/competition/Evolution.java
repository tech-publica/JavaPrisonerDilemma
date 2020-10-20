package com.example.prisoner.competition;

import java.util.*;

public class Evolution {
	private Tournament tour = new Tournament();
	public final int GENERATION_NUMBER = 2;
	public final int NUMBER_OF_CHANGES =  tour.getPlayers().size() / 5 > 0 ? tour.getPlayers().size() / 5 : 1;

	public void evolve() { 
		for (int i = 0; i < GENERATION_NUMBER; i++) {
			epoch();
		}

		showResults();
	}

	private void epoch() {
		reset();
		tour.giostra();
		tour.sort();
		killAndBreed();

	}

	private void reset() {
		for (RankedPlayer p : tour.getPlayers()) {
			p.onReset();

		}

	}

	private void killAndBreed() {
		List<RankedPlayer> players = tour.getPlayers();
		for (int i = 0; i < NUMBER_OF_CHANGES; i++) {
			players.remove(players.size() - 1);

		}
		for (int i = 0; i < NUMBER_OF_CHANGES; i++) {
			players.add(players.get(i).deepClone());
		}
	}

	private void showResults() {
		tour.showResults();

	}

	public static void main(String[] args) {
		new Evolution().evolve();
	}

}
