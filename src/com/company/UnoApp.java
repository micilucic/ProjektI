package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UnoApp {

    private CardDeck deck = new CardDeck();                  //first our card deck
    private ArrayList<HumanPlayer> player = new ArrayList<>();    //player
    private DropPile drop = new DropPile();                  //we need drop pile for the first and other cards that are played
    //for input we need Scanner
    private final Scanner input;
    private final PrintStream output;

    public UnoApp(Scanner input, PrintStream output) {       //constructor is required
        this.input = input;
        this.output = output;
    }
    //adding player to play the game
    public void addPlayer(String name) {
        for (int i = 0; i < 4; i++) {                      //4 players are maximum, that is why i<4
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your name");
            name = scanner.next();

            System.out.println("Hello" + name);

           HumanPlayer player1 = new HumanPlayer(name);
            Player.add(player1);

        }

    }
                                                  //this method should give each player 7 cards
    public void handOut(HumanPlayer player){
        for (int i = 0; i < 7; i++) {
            player.playerCards(deck.drawCard());
        }
    }
     //
    //game loop should begin somewhere here

}
