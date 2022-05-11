package com.company;

import java.security.PublicKey;

public class Card {
    private String color;
    private int cardNr;
    private String zeichen;

    public Card(String color, int cardNr) {
        this.color = color;
        this.cardNr = cardNr;

    }

    public Card (String color, String zeichen) {
        this.color = color;
        this.zeichen = zeichen;
    }

    @Override
    public String toString() {
        if (zeichen == null) {
            return "Card{" +
                    "color='" + color + '\'' +
                    ", cardNr=" + cardNr +
                    '}';
        } else {
            return "Card{" +
                    "color='" + color + '\'' +
                    ", zeichen=" + zeichen +
                    '}';
        }
    }

}
