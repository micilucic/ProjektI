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
        Scanner scanner = new Scanner(System.in);
        Player p = new HumanPlayer(null);
        System.out.println("Please write \"help\" if you want to read rules of the game or write \"play\" to start the game");
        if (scanner.nextLine().equals("help"))
            UnoApp.help();
        System.out.println();
        System.out.println("Hello from playCards, I am player :" + getName());
        System.out.println("These are my cards: " + getHandCards().size());
        int num = 0;
        for (Card c : getHandCards()) {
            num++;
            System.out.println(num + " " + c.toString() + " ");
        }
        System.out.println("Please choose one card or write \"help\" if you want to read rules of the game. If you do not need help, please write no");
        String playerInput = scanner.nextLine();
        if (playerInput.equals("help")) {
            UnoApp.help();
            System.out.println();
            System.out.println("You have read the rules.");
            System.out.println("Now please choose one card: ");
            int cardIndex = scanner.nextInt()-1;
            System.out.println("You chose the following card: " + getHandCards().get(cardIndex));
            getHandCards().remove(cardIndex);
            System.out.println("Next player´s turn");
        } else if (playerInput.equals("no")) {
          //  System.out.println("Hello from playCards, I am player :" + getName());
          //  System.out.println("These are my cards: " + getHandCards().size() + " " + getHandCards());
            System.out.println("Now please choose one card: ");
            int cardIndex = scanner.nextInt()-1;
            System.out.println("You chose the following card: " + getHandCards().get(cardIndex));
            drop.dropCard(getHandCards().get(cardIndex));
            getHandCards().remove(cardIndex);
            System.out.println("Next player´s turn");
         //   System.out.println("Hello from playCards, I am player :" + getName());
            // Help dort wo der Player nach einer Information gefragt wird und die Frage wiederholen
        }
    }
}

/*
    ArrayList<Card> handCards = new ArrayList<>();


    public void playerCards(Card card) {
        handCards.add(card);
    }



    @Override
    public void playCards() {

    }

 */




