package com.company;

public abstract class Player {
    private String name;
    private String type;

    public Player (String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
    public abstract void playCards();

    
}
