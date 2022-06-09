package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UnoApp {

    private CardDeck deck = new CardDeck();                  //first our card deck
    private ArrayList<Player> players = new ArrayList<>();    //player
    private DropPile drop = new DropPile();                  //we need drop pile for the first and other cards that are played
    //for input we need Scanner
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;
    int currentPlayerIndex = 0;
    int direction = 0;

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
        System.out.println("4 - players.size()" + (4 - players.size()));
        for (int i = 0; i <= (4 - players.size()); i++) {
            System.out.println("hallo " + i);
            if (players.size() != 4) {
                String name = "Bot " + (i + 1);
                Player player1 = new BotPlayer(name);
                players.add(player1);
                System.out.println(name + " will be joining you as well");
            }
        }
            System.out.println(players);
            for (int i = 0; i < players.size(); i++) {
                for (int j = 0; j < 7; j++) {
                    players.get(i).addCards(deck.drawCard());
                }
                System.out.println(players.get(i).getName() + " " + players.get(i).getHandCards());
            }
        }


    public void cicleTroughPlayers() {
        currentPlayerIndex++;
        if (currentPlayerIndex == 4) {
            currentPlayerIndex = 0;
        }

        System.out.println("cicleTroughPlayers, index= " + currentPlayerIndex);
        //todo: direction abrafeg, überlauf
//        for (int i = 0; i < players.size(); i++) {
//            players.get(i).playCards();
//        }
    }

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

    public void playHandCards() {
        Player p = new HumanPlayer(null);
        Card c = new Card(null, null);

    }

    public void Run() {
        initialize(); //nur Karten austeilen, nr of Players
      //  printState();


        while (!exit) {
            players.get(currentPlayerIndex).playCards();
            cicleTroughPlayers();
            //     readUserInput();
            //     updateState();
            //     printState(); //Nur die Ausgabe
        }
    }

    public void initialize() {

        //TODO: Initialisierungen hier durchführen
        //Speieler und Karten anlegen !!! - man initialisiert Sachen, die nur einmal intialisert werden müssen
        addPlayers();
       // addBots();
        deck.createCards();
        currentPlayerIndex = 0;
    }
}
