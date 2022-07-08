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
        // for (Card c : getHandCards()) {
        //   num++;
        // System.out.println(num + " " + c.toString() + " ");
        int points = getHandCardPoints();  // These are the points from our handcards
        System.out.println("These are my hand cards points: " + points);
        int cardIndex = 0;
        boolean playOrDont = false; //canThisCardBePlayed(drop.getLatestCard(), getHandCards().get(cardIndex));
        //   System.out.println("Play or dont: " + playOrDont);

        for (Card c : getHandCards()) {
            if (canThisCardBePlayed(drop.getLatestCard(), c)) {//wenn die Karte gespielt werden kann -> true
                drop.dropCard(c);// Karte von Hand auf Stapel kopieren

                getHandCards().remove(c); // Karte aus Handkarten entfernen
                System.out.println("You chose the following card: " + c);
                playOrDont = true;
                System.out.println(" ----------- ");
                break;
            }
        }
        if (drop.getLatestCard().getZeichen() != null && drop.getLatestCard().getZeichen().equals("+2")) {
            System.out.println("the last card is +2, so you should take 2 card");
            System.out.println("+++++++++++++++++++++++++++++++++");
            if (deck.isEmpty()) {
                fillEmptyCardDeck(deck, drop);
            }
            takeCard(deck);
            takeCard(deck);
            System.out.println("These are your current cards" + getHandCards());
            System.out.println("**************************************");
        } else {
            if (deck.isEmpty()) {
                fillEmptyCardDeck(deck, drop);
            }
            takeCard(deck);
            takeCard(deck);
        }
        System.out.println("These are my cards: " + getHandCards().size());
        System.out.println("**************************************");
        if (canThisCardBePlayed(drop.getLatestCard(), getHandCards().get(cardIndex)) == true && (getHandCards().get(cardIndex).getZeichen() != null) && (getHandCards().get(cardIndex).getZeichen().equals("~"))) {
            chooseColor();
            if (!playOrDont) {
                if (deck.isEmpty()) {           //wenn Karten stapel leer ist
                    fillEmptyCardDeck(deck, drop);
                }
                takeCard(deck);              // ich habe genug Karten auf meinen Stapel, nehme eine Karte
                System.out.println("You took one card" + getHandCards());
                //break;
                //Karte kann nicht gespielt werden - muss gezogen werden
                System.out.println("Next player´s turn");

                if (getHandCards().size() == 2) {
                    System.out.println("uno!");
                    playCards(drop, deck);
                }
                // Help dort wo der Player nach einer Information gefragt wird und die Frage wiederholen
            }
        }
    }

    public boolean handIsEmpty() {
        if (getHandCards().size() == 0) {
            return true;
        } else
            return false;
    }

    @Override
    public String chooseColor() {
        DropPile d = new DropPile();
        Player p = new BotPlayer(null);

        boolean pickedColor = false;
        String chosenColor = null;

        d.getLatestCard().setColor("Blue");
        System.out.printf("The color of the latest card is: " + chosenColor);
        return chosenColor;
    }
}




