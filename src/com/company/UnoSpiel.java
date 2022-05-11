package com.company;

import java.util.ArrayList;

public class UnoSpiel {

    public static void main(String[] args) {

       CardDeck cd = new CardDeck();
        System.out.print(cd);

        Player player1 = new Player("player 1", 0);
        Player player2 = new Player("player 2", 0);
        Player player3 = new Player("player 3", 0);
        Player player4 = new Player("player 4", 0);

        ArrayList<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        System.out.println("--------");

        System.out.print(players);



    }
}

