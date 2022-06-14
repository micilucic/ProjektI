package com.company;

import java.util.ArrayList;

public class DropPile {

    private ArrayList<Card> dropPile = new ArrayList<>();


    public DropPile() {
        this.dropPile = dropPile;
    }

    public ArrayList<Card> getDropPile() {
        return getDropPile();
    }

    //when one card is thrown it goes on the pile into new Arraylist
    public void dropCard(Card card) {
        dropPile.add(card);
        System.out.println("This is the latest card: " + card);
        System.out.println("All cards in dropPile: " + dropPile);
    }


}


