package com.example.restservice.entity;

import com.example.restservice.service.FiveCardDrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.stream.Collectors;
import static com.example.restservice.entity.Rank.ACE;

public class Hand implements Comparable<Hand> {
    private static final int HAND_SIZE = 5;

    private ArrayList<Card> cards;
    private int strength; //the higher the strength the better the hand
    final static Logger LOG = LoggerFactory.getLogger(FiveCardDrawService.class);

    public Hand() {
        this.cards = new ArrayList<>();
        this.strength = 0;
    }
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int evaluateHandStrength() {
        if (isFiveOfAKind()) {
            this.strength = 10;
        } else if (isStraightFlush()) {
            this.strength = 9;
        } else if (isFourOfAKind()) {
            this.strength = 8;
        } else if (isFullHouse()) {
            this.strength = 7;
        } else if (isFlush()) {
            this.strength = 6;
        } else if (isStraight()) {
            this.strength = 5;
        } else if (isThreeOfAKind()) {
            this.strength = 4;
        } else if (isTwoPair()) {
            this.strength = 3;
        } else if (isOnePair()) {
            this.strength = 2;
        } else {
            // highCard
            this.strength = 1;
        }
        return this.strength;
    }

    private boolean isOnePair() {
        return this.cards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum))
                .containsValue(2);
    }

    protected Set<Integer> duplicates() {
        //code inspired by: https://stackoverflow.com/questions/27677256/java-8-streams-to-find-the-duplicate-elements
        // TODO refactor to determine duplicates by set addition for better performance
        return this.cards.stream().collect( Collectors.collectingAndThen(
                Collectors.groupingBy( Card::getRank, Collectors.counting() ),
                map -> {
                    map.values().removeIf( cnt -> cnt < 2 );
                    return( map.keySet() );
                } ) );  //returns set that just has ranks that had duplicates
    }

    private boolean isTwoPair() {
        return duplicates().size() == 2;
    }

    private boolean isThreeOfAKind() {
        return this.cards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum))
                .containsValue(3);
    }

    private boolean isStraight() {
       sortRanks();
        //check if the top card is an ACE
        if(this.cards.get(0).getRank() == ACE.getRank() ) {
            return isStraightAceHigh() || isStraightAceLow();
        }
       return isStraightAceHigh();
    }

    protected boolean isStraightAceHigh(){
        //confirm the number of ranks between highest card and lowest card is correct
        if ( (this.cards.get(0).getRank()) - (this.cards.get(HAND_SIZE-1).getRank()) == (HAND_SIZE-1)) {
            // make sure no pairs exist
            return !isOnePair();
        }
        return false;
    }

    protected boolean isStraightAceLow() {
        //confirm the number of ranks between highest card and ACE as 1 is correct
        if ( (this.cards.get(1).getRank()) - 1 == (HAND_SIZE-1)) {
            // make sure no pairs exist
            return !isOnePair();
        }
        return false;
    }

    private boolean isFlush() {
        return this.cards.stream()
                .map(Card::getSuit)
                .distinct()
                .count() == 1;
    }

    private boolean isFullHouse() {
        return isThreeOfAKind() && (duplicates().size()==2);
    }

    private boolean isFourOfAKind() {
        return cards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum))
                .containsValue(4);
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private boolean isFiveOfAKind(){
        return this.cards.stream()
                .map(Card::getRank)
                .distinct()
                .count() == 1;
    }

    public void sortRanks() {
        LOG.debug("Hand before sortRanks {}", this.cards);
        Collections.sort(this.cards, (c1, c2) -> {
            Integer c1Rank = Integer.valueOf((c1.getRank()));
            Integer c2Rank = Integer.valueOf((c2.getRank()));
            return c2Rank.compareTo(c1Rank);
        });
        LOG.debug("Hand after sortRanks {}", this.cards);
    }


    @Override
    public int compareTo(Hand handToCompare) {
        int compareHandStrength=handToCompare.evaluateHandStrength();
        int winningStrength = compareHandStrength-this.strength;
        if (winningStrength == 0){
            // TODO add in logic for breaking ties
        }
        return winningStrength;
    }

}
