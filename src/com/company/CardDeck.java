package com.company;

import java.util.ArrayList;

public class CardDeck {

    private ArrayList<Card> cards = new ArrayList<>();

    public CardDeck() {
        createCards();
    }

    private void createCards() {
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card c = new Card("red", i);
                cards.add(c);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card c1 = new Card("yellow", i);
                cards.add(c1);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card c2 = new Card("green", i);
                cards.add(c2);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card c3 = new Card("blue", i);
                cards.add(c3);

            }
        }


    }


    @Override
    public String toString() {
        return cards.toString();
    }
}





