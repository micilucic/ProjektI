package com.company;

import java.util.ArrayList;

public abstract class Player {
    private String name;

    public Player (String name) {
        this.name = name;
    }
   private ArrayList<Card> handCards = new ArrayList<>();

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public static void add(Player player) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
    }


    public String getName() {
        return name;
    }
    public void addCards(Card card) {
        handCards.add(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
    public abstract void playCards();
}




