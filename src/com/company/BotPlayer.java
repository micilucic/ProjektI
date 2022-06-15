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
        boolean playOrDont = canThisCardBePlayed(drop.getLatestCard(), getHandCards().get(cardIndex));
        System.out.println("Play or dont: " + playOrDont);
        if(playOrDont == true){                         //wenn die Karte gespielt werden kann -> true
            drop.dropCard(getHandCards().get(cardIndex)); // Karte von Hand auf Stapel kopieren
            getHandCards().remove(cardIndex); // Karte aus Handkarten entfernen
            System.out.println("Next player´s turn");
        }
        else{                             //Karte kann nicht gespielt werden - muss gezogen werden
            if(deck.isEmpty()){           //wenn Karten stapel leer ist
                fillEmptyCardDeck(deck, drop);
            }
            takeCard(deck);              // ich habe genug Karten auf meinen Stapel, nehme eine Karte
            System.out.println("You took one card" + getHandCards());
        }

        if (getHandCards().size() == 2) {
            System.out.println("uno!");
            playCards(drop, deck);
        }
        // Help dort wo der Player nach einer Information gefragt wird und die Frage wiederholen
    }
}

