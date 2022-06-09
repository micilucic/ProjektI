package com.company;

import java.util.ArrayList;

public class DropPile {

    ArrayList<Card> dropPile = new ArrayList<>();

    public DropPile() {
        this.dropPile = dropPile;
    }

    public ArrayList<Card> getDropPile() {
        return getDropPile();
    }

     //when one card is thrown it goes on the pile into new Arraylist
    public void dropCard(Card card){
        dropPile.add(card);
    }


}


