package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class UnoSpiel {

    public static void main(String[] args) {

       CardDeck cd = new CardDeck();
        System.out.print(cd);


        HumanPlayer player1 = new HumanPlayer("player 1", "HP");
        HumanPlayer player2 = new HumanPlayer("player 2", "HP");
        HumanPlayer player3 = new HumanPlayer("player 3", "HP");
        HumanPlayer player4 = new HumanPlayer("player 4", "HP");


        ArrayList<HumanPlayer> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        System.out.println("--------");

        System.out.print(players);





    }
}

