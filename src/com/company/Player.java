package com.company;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Player {
    private String name;

    public Player(String name) {
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

    public abstract void playCards(DropPile drop, CardDeck deck) throws IOException;


    public boolean canThisCardBePlayed(Card topCard, Card handCard) {
        // if (drop.getDropPile().get(index).equals())
        System.out.println("This is function canThisCardBePlayed: TopCard: " + topCard + " HandCard: " + handCard);
        if (topCard.getColor().equals(handCard.getColor())) {
            return true;
        } else if (topCard.getCardNr() == handCard.getCardNr()) {
            return true;
        } else if (handCard.getColor().equals("black")) {
            return true;
        } else {
            return false;
        }
    }

    public void fillEmptyCardDeck(CardDeck deck, DropPile drop) {      //when CardDeck is empty, we add wih this method all cards from dropPile
        if (deck == null) {
            for (int i = 0; i < drop.getDropPile().size() - 2; i++) {
                deck.addIntoNewCardDeck(drop.getDropPile().remove(i));
                System.out.println("CardDeck is full");
            }
        }
        System.out.println("Droppile is empty");
    }

    public void takeCard(CardDeck deck) {
        Card c = new Card(null, null);
        c = deck.drawCard();
        handCards.add(c);
        System.out.println(c);
    }


}






