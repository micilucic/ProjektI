package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UnoApp {

    private CardDeck deck;                  //first our card deck
    private ArrayList<Player> players = new ArrayList<>();    //player
    private DropPile drop = new DropPile();                  //we need drop pile for the first and other cards that are played
    //for input we need Scanner
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;

    public UnoApp(Scanner input, PrintStream output) {       //constructor is required
        this.input = input;
        this.output = output;
    }

    //adding player to play the game
    public void addPlayers(int numberOfPlayers) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfPlayers; i++) { //4 players are maximum, that is why i<4
            System.out.println("Please enter your name");
            String name = scanner.nextLine();
            System.out.println("Hello " + name);
            Player player1 = new HumanPlayer(name);
            Player.add(player1);

        }

    }

    public void addBots(int numberOfBots) {
        for (int i = 0; i < numberOfBots; i++) {
            String name = "Bot " + (i+1);
            System.out.println(name + " will be joining you as well");
            Player player1 = new BotPlayer(name);
            Player.add(player1);
        }
    }

    //this method should give each player 7 cards
    public void handOut(Player player) {
        for (int i = 0; i < 7; i++) {
            player.playerCards(deck.drawCard());
        }
    }

    public void Run() {
        initialize();
        // printState();

        while (!exit) {
            //     readUserInput();
            //     updateState();
            //     printState(); //Nur die Ausgabe
        }
    }

    public void initialize() {

        //TODO: Initialisierungen hier durchführen
        //Speieler und Karten anlegen !!! - man initialisiert Sachen, die nur einmal intialisert werden müssen
        deck = new CardDeck();
        System.out.println("How many players are playing? Choose 1-4."); //we are hoping that the player will write a number
        int numberOfPlayers = input.nextInt();
        addPlayers(numberOfPlayers);
        addBots(4 - numberOfPlayers);
        deck.createCards();
    }
}
