package com.company;

import java.util.ArrayList;

public abstract class Player {
    private String name;

    public Player (String name) {
        this.name = name;
    }

    public static void add(Player player) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
    }

    public String getName() {
        return name;
    }




    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
    public abstract void playCards();

    
}
