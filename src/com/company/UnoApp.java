package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UnoApp {

    private CardDeck deck = new CardDeck();                  //first our card deck
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
    public void addPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of players: ");
        int num = scanner.nextInt();
        while ((num < 1) || (num > 4)) {
            System.out.println("Maximum 4 players are allowed. Please choose from 1 to 4.");
            num = scanner.nextInt();
            System.out.println("You entered: " + num);
        }
        scanner.nextLine();
        System.out.println("You entered: " + num);
        for (int i = 0; i < num; i++) { //4 players are maximum, that is why i<4
            System.out.println("Please enter your name");
            String name = scanner.nextLine();
            Player player1 = new HumanPlayer(name);
            System.out.println("Hello " + name);
            players.add(player1);
        }
        System.out.println("Anzahl der menschlichen Spieler: " + players.size());
        for (int i = 0; i <= (4 - players.size()); i++) {
            String name = "Bot " + (i + 1);
            Player player1 = new BotPlayer(name);
            players.add(player1);
            System.out.println(name + " will be joining you as well");
        }
        System.out.println(players);
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 7; j++) {
                players.get(i).playerCards(deck.drawCard());
            }
            System.out.println(players.get(i).getName() + " " + players.get(i).handCards);
        }
    }

      public void playingCards () {
        for (Player p : players) {
            while (p.handCards != null) {
                p.;
            }
        }
      }


    /*public void addBots() {
        for (int i = 0; i < players.size(); i++) {
            String name = "Bot " + (i+1);
            Player player1 = new BotPlayer(name);
            Player.add(player1);
            System.out.println(name + " will be joining you as well");

        }
  }  */

    /*this method should give each player 7 cards
    public void handOut(Player player) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 7; j++) {
                players.get(i).playerCards(deck.drawCard());
            }
        }
    }
*/

    public void help() {
        Scanner scannerHelp = new Scanner(System.in);
        String help = scannerHelp.nextLine();
        if (help.equals("help")) {
            System.out.println("Rules of the game");
        }
    }

    public void firstCardOpen() {
        Card c = new Card(null, null);
        c = deck.drawCard();
        drop.dropCard(c);
        System.out.println(c);
    }

    public void Run() {
        initialize();
      //  printState();

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
        addPlayers();
       // addBots();
        deck.createCards();
    }
}
