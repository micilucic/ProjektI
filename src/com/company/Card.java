package com.company;

import java.security.PublicKey;

public class Card {
    private String color;
    private int cardNr;

    public Card(String color, int cardNr) {
        this.color = color;
        this.cardNr = cardNr;

    }

    @Override
    public String toString() {
        return "Card{" +
                "color='" + color + '\'' +
                ", cardNr=" + cardNr +
                '}';
    }
}
