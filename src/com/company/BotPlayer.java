package com.company;

import java.util.Scanner;

public class BotPlayer extends Player {
    public BotPlayer(String name) {
        super(name);
    }

    @Override
    public void playCards(DropPile drop, CardDeck deck) {
        Player p = new BotPlayer(null);
        System.out.println("Hello from playCards, I am player :" + getName());
        System.out.println("These are my cards: " + getHandCards().size() + " " + getHandCards());
        int num = 0;
        for (Card c : getHandCards()) {
            num++;
            System.out.println(num + " " + c.toString() + " ");
        }
        int cardIndex = 0;
        System.out.println("You chose the following card: " + getHandCards().get(cardIndex));
        drop.dropCard(getHandCards().get(cardIndex));
        getHandCards().remove(cardIndex);
        System.out.println("Next player´s turn");
        System.out.println("Hello from playCards, I am player :" + getName());
        // Help dort wo der Player nach einer Information gefragt wird und die Frage wiederholen
    }
}

