package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void playCards() {
        Scanner scanner = new Scanner(System.in);
        Player p = new HumanPlayer(null);
        System.out.println("Hello from playCards, I am player :" + getName());
        System.out.println("These are my cards: " + getHandCards().size());
        int num = 0;
        for(Card c: getHandCards()){
            num++;
            System.out.println(num + " " + c.toString() + " ");
        }
        System.out.println("Please choose one card: " );
        int cardIndex = scanner.nextInt() - 1;
        System.out.println("You chose the following card: " + getHandCards().get(cardIndex));
        getHandCards().remove(cardIndex);

    }

/*
    ArrayList<Card> handCards = new ArrayList<>();


    public void playerCards(Card card) {
        handCards.add(card);
    }



    @Override
    public void playCards() {

    }

 */
}


