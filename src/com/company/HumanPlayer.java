package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {


    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public void playCards(DropPile drop, CardDeck deck) throws IOException {
        Player p = new HumanPlayer(null);
        System.out.println("Please write \"help\" if you want to read rules of the game or write \"play\" to start the game");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("help"))
            UnoApp.help();
        System.out.println();
        System.out.println("Hello from playCards, I am player :" + getName());
        System.out.println("These are my cards: " + getHandCards().size());
        if (drop.getLatestCard().getZeichen() != null && drop.getLatestCard().getZeichen().equals("+2")){
            System.out.println("the last card is +2, so you should take 2 cards and skip");
            System.out.println("+++++++++++++++++++++++++++++++++");
            if (deck.isEmpty()) {
                fillEmptyCardDeck(deck, drop);
            }
            takeCard(deck);
            takeCard(deck);

            System.out.println("These are your current cards" + getHandCards());
            System.out.println("**************************************");
        }
        if (drop.getLatestCard().getZeichen() != null && drop.getLatestCard().getZeichen().equals("*~+4")){
            p.chooseColor();
            System.out.println("the last card is +4, so you should take 4 card");
            System.out.println("+++++++++++++++++++++++++++++++++");
            if (deck.isEmpty()) {
                fillEmptyCardDeck(deck, drop);
            }
            takeCard(deck);
            takeCard(deck);
            takeCard(deck);
            takeCard(deck);
            System.out.println("These are your current cards" + getHandCards());
            System.out.println("**************************************");
        }
        int num = 0;
        for (Card c : getHandCards()) {
            num++;
            System.out.println(num + " " + c.toString() + " ");
        }
        int points = getHandCardPoints();  // These are the points from our handcards
        System.out.println("These are my hand cards points: " + points);
        System.out.println("Please choose one card or write \"help\" if you want to read rules of the game. If you do not need help, please write no");
        String playerInput = scanner.nextLine();
        if (playerInput.equals("help")) {
            UnoApp.help();
            System.out.println();
            System.out.println("You have read the rules.");
        } else {
            if (deck.isEmpty()) {
                fillEmptyCardDeck(deck, drop);
            }
//            takeCard(deck);
//            takeCard(deck);
        }
        System.out.println("These are my cards: " + getHandCards().size());
        System.out.println("**************************************");
        System.out.println("Please choose one card. If you cannot play any card, please type 0");
        int cardIndex = scanner.nextInt() - 1;
        if (cardIndex == 0) {
            System.out.println("You could not play any card. Now you will get another one.");
            if (deck.isEmpty()) {
                fillEmptyCardDeck(deck, drop);
            }
            takeCard(deck);
            System.out.println("These are your current cards" + getHandCards());
        }
        System.out.println("You chose the following card: " + getHandCards().get(cardIndex));
        if (canThisCardBePlayed(drop.getLatestCard(), getHandCards().get(cardIndex)) == true && (getHandCards().get(cardIndex).getZeichen() != null) && (getHandCards().get(cardIndex).getZeichen().equals("~"))) {
            chooseColor();
        }
        if (canThisCardBePlayed(drop.getLatestCard(), getHandCards().get(cardIndex)) == true) {
            drop.dropCard(getHandCards().get(cardIndex)); // Karte von Hand auf Stapel kopieren
            getHandCards().remove(cardIndex); // Karte aus Handkarten entfernen
            System.out.println("Next player??s turn");
        } else { //Karte kann nicht gespielt werden - muss gezogen werden
            System.out.println("This card cannot be played. Now you will get a card from pile. Please enter OK");
            playerInput = scanner.nextLine();
            if (scanner.nextLine().equals("ok") || scanner.nextLine().equals("OK")) {
                if (deck.isEmpty()) {
                    fillEmptyCardDeck(deck, drop);
                }
                takeCard(deck);
                System.out.println("These are your current cards" + getHandCards());
            } else {
                if (deck.isEmpty()) {
                    fillEmptyCardDeck(deck, drop);
                }
                takeCard(deck);
            }
        }
    }


    public boolean handIsEmpty() {
        if (getHandCards().size() == 0) {
            return true;
        } else
            return false;
    }


    public String chooseColor() {
        DropPile d = new DropPile();
        Player p = new HumanPlayer(null);
        Scanner inputColor = new Scanner(System.in);
        String colorInput = null;
        boolean pickedColor = false;
        String chosenColor = null;

        if (colorInput.equals("Yellow")) {
            System.out.println(p.getName() + " chose the following color: " + colorInput);
            pickedColor = true;
        } else if (colorInput.equals("Green")) {
            System.out.println(p.getName() + " chose the following color: " + colorInput);
            pickedColor = true;
        } else if (colorInput.equals("Blue")) {
            System.out.println(p.getName() + " chose the following color: " + colorInput);
            pickedColor = true;
        } else if (colorInput.equals("Red")) {
            System.out.println(p.getName() + " chose the following color: " + colorInput);
            pickedColor = true;
        } else {
            System.out.println("this is a wrong entry! Try again.");
        }
        chosenColor = colorInput;
        d.getLatestCard().setColor(chosenColor);
        System.out.printf("The color of the latest card is: " + chosenColor);
        return chosenColor;
    }
}






