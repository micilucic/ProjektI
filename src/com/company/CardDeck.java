package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.IntFunction;

public class CardDeck extends ArrayList<Card> {

    private final ArrayList<Card> cards = new ArrayList<>();

    public CardDeck() {
        createCards();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
  public void addIntoNewCardDeck(Card c){
        cards.add(c);
  }


    public void createCards() {
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card cRot = new Card("red", i);
                cards.add(cRot);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card cGelb = new Card("yellow", i);
                cards.add(cGelb);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card cGruen = new Card("green", i);
                cards.add(cGruen);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 2; j++) {
                Card cBlau = new Card("blue", i);
                cards.add(cBlau);

            }
        }

        for (int i = 0; i < 2; i++) {
            Card actRot = new Card("red", "+2");
            cards.add(actRot);
        }
        for (int i = 0; i < 2; i++) {
            Card actYellow = new Card("yellow", "+2");
            cards.add(actYellow);
        }
        for (int i = 0; i < 2; i++) {
            Card actGruen = new Card("green", "+2");
            cards.add(actGruen);
        }
        for (int i = 0; i < 2; i++) {
            Card actBlau = new Card("blue", "+2");
            cards.add(actBlau);
        }
        // Action card reverse
        for (int i = 0; i < 2; i++) {
            Card actRotReverse = new Card("red", "<->");
            cards.add(actRotReverse);
        }
        for (int i = 0; i < 2; i++) {
            Card actGelbReverse = new Card("yellow", "<->");
            cards.add(actGelbReverse);
        }
        for (int i = 0; i < 2; i++) {
            Card actGruenReverse = new Card("green", "<->");
            cards.add(actGruenReverse);
        }
        for (int i = 0; i < 2; i++) {
            Card actBlauReverse = new Card("blue", "<->");
            cards.add(actBlauReverse);
        }
        //Action card Block
        for (int i = 0; i < 2; i++) {
            Card actRotBlock = new Card("red", "Ø");
            cards.add(actRotBlock);
        }
        for (int i = 0; i < 2; i++) {
            Card actGelbBlock = new Card("yellow", "Ø");
            cards.add(actGelbBlock);
        }
        for (int i = 0; i < 2; i++) {
            Card actGruenBlock = new Card("green", "Ø");
            cards.add(actGruenBlock);
        }
        for (int i = 0; i < 2; i++) {
            Card actBLauBlock = new Card("blue", "Ø");
            cards.add(actBLauBlock);
        }
        // Action card change color
        for (int i = 0; i < 4; i++) {
            Card actColor = new Card("black", "~");
            cards.add(actColor);
        }
        // Action card change color +4
        for (int i = 0; i < 4; i++) {
            Card actColorPlus = new Card("black", "~+4");
            cards.add(actColorPlus);
        }
        Collections.shuffle(cards);
    }

    public Card drawCard(){
        return cards.remove(cards.size()-1);
    }
    public boolean isEmpty(){
        if(cards.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }


//    public void skip() {
//        Card c = new Card(null, null);
//        if (c.equals("actRotReverse") )
//    }

    @Override
    public String toString() {
        return cards.toString();
    }


}





