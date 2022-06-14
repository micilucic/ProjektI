package com.company;

import java.io.*;
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
        System.out.println("4 - players.size() " + (4 - players.size()));
        int botSize = 4 - players.size();
        for (int i = 0; i < botSize; i++) {
          //  System.out.println("hallo " + i);
                String name = "Bot " + (i + 1);
                Player player1 = new BotPlayer(name);
                players.add(player1);
                System.out.println(name + " will be joining you as well");
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

    public static void help() throws IOException {
        // System.out.println("If you want to read the rules of the game, please enter \"help\"");
        //  Scanner scannerHelp = new Scanner(System.in);
        //  String help = scannerHelp.nextLine();
        File rulesOfTheGame = new File("C:\\Users\\s51638\\IdeaProjects\\ProjektI\\src\\UnoSpielregeln.txt");
        FileReader fileReader = new FileReader(rulesOfTheGame);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        //  if (help.equals("help")) {
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
    //}
        bufferedReader.close();
        fileReader.close();
    }

    public void firstCardOpen() {
        Card c = new Card(null, null);
        c = deck.drawCard();
        drop.dropCard(c);
        System.out.println(c);
    }


    public void Run() throws IOException {
        initialize(); // aks players for name, write names for human players, create bots, create handcards
        firstCardOpen();
      //  printState();
        while (!exit) {
            players.get(currentPlayerIndex).playCards(drop, deck);
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
