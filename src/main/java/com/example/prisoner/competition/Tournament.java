package com.example.prisoner.competition;

import com.example.prisoner.players.*;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<RankedPlayer> players;
    private static final int NUM_INITIAL_CLONES = 6;
    private static final int NUM_MATCHES = 100;

    public Tournament() {
        players = new ArrayList<RankedPlayer>();
        for (int i = 0; i < NUM_INITIAL_CLONES; i++) {
            players.add(new RankedPlayer(new BastardInside()));
            players.add(new RankedPlayer(new DummyPlayer()));
            players.add(new RankedPlayer(new AndreaBastardPlayer()));
            players.add(new RankedPlayer(new BlondeBlood()));
            players.add(new RankedPlayer(new Danilo()));
            players.add(new RankedPlayer(new DrJekyll()));
            players.add(new RankedPlayer(new FrustratedWithHumanityPlayer()));
            players.add(new RankedPlayer(new JackNonMiAvreteMai()));
            players.add(new RankedPlayer(new Kupang()));
            players.add(new RankedPlayer(new Michele()));
            players.add(new RankedPlayer(new MirrorPlayer()));
            players.add(new RankedPlayer(new MyPlayer()));
            players.add(new RankedPlayer(new Putin()));
            players.add(new RankedPlayer(new RoccoPlayer()));
            players.add(new RankedPlayer(new Tit4Tat()));

 
        }
    }

  
    
    public List<RankedPlayer> getPlayers() {
		return players;
	}



	public void giostra() {
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                giostra(players.get(i), players.get(j));
            }
        }
    }

    private void giostra(Player p1, Player p2) {
        p1.onChangeOpponent();
        p2.onChangeOpponent();
        for (int i = 0; i < NUM_MATCHES; i++) {
            Move m1 = p1.nextMove();
            Move m2 = p2.nextMove();
            p1.receiveOpponentMove(m2);
            p2.receiveOpponentMove(m1);

            if (m1 == Move.COOPERATE && m2 == Move.COOPERATE) {
                p1.addScore(Score.BOTH_COOPERATE);
                p2.addScore(Score.BOTH_COOPERATE);
            } else if (m1 == Move.COOPERATE && m2 == Move.DEFECT) {
                p1.addScore(Score.ONLY_ONE_COOPERATE);
                p2.addScore(Score.ONLY_ONE_DEFECT);
            } else if (m1 == Move.DEFECT && m2 == Move.COOPERATE) {
                p1.addScore(Score.ONLY_ONE_DEFECT);
                p2.addScore(Score.ONLY_ONE_COOPERATE);
            } else if (m1 == Move.DEFECT && m2 == Move.DEFECT) {
                p1.addScore(Score.BOTH_DEFECT);
                p2.addScore(Score.BOTH_DEFECT);
            }

        }
    }

    public void sort() {
        players.sort((p1, p2) -> p2.getScore() - p1.getScore());
    }

    public void showResults() {
    	
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }

//        for (Player p : players) {
//            System.out.println(p);
//        }
//
//        players.forEach(System.out::println);
    }
}

