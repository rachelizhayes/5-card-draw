package com.example.restservice.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.restservice.entity.Card.*;

public class HandTest {
    private static final Hand FIVE_OF_A_KIND = new Hand(new ArrayList<>(Arrays.asList(ACE_SPADES,ACE_CLUBS,ACE_HEARTS,ACE_DIAMONDS,ACE_CLUBS)));
    private static final Hand STRAIGHT_FLUSH = new Hand(new ArrayList<>(Arrays.asList(JACK_CLUBS,TEN_CLUBS,NINE_CLUBS,EIGHT_CLUBS,SEVEN_CLUBS)));
    private static final Hand FOUR_OF_A_KIND = new Hand(new ArrayList<>(Arrays.asList(FIVE_CLUBS,FIVE_DIAMONDS,FIVE_HEARTS,FIVE_SPADES,TWO_DIAMONDS)));
    private static final Hand FULL_HOUSE = new Hand(new ArrayList<>(Arrays.asList(SIX_SPADES,SIX_HEARTS,SIX_DIAMONDS,KING_SPADES,KING_HEARTS)));
    private static final Hand FLUSH = new Hand(new ArrayList<>(Arrays.asList(JACK_DIAMONDS,NINE_DIAMONDS,EIGHT_DIAMONDS,FOUR_DIAMONDS,THREE_DIAMONDS)));
    private static final Hand STRAIGHT = new Hand(new ArrayList<>(Arrays.asList(TEN_DIAMONDS,NINE_SPADES,EIGHT_HEARTS,SEVEN_DIAMONDS,SIX_CLUBS)));
    private static final Hand STRAIGHT_ACE_LOW = new Hand(new ArrayList<>(Arrays.asList(FIVE_DIAMONDS,FOUR_SPADES,THREE_HEARTS,TWO_DIAMONDS,ACE_CLUBS)));
    private static final Hand THREE_OF_A_KIND = new Hand(new ArrayList<>(Arrays.asList(QUEEN_CLUBS,QUEEN_SPADES,QUEEN_HEARTS,NINE_HEARTS,TWO_SPADES)));
    private static final Hand TWO_PAIR = new Hand(new ArrayList<>(Arrays.asList(JACK_HEARTS,JACK_SPADES,THREE_CLUBS,THREE_SPADES,TWO_HEARTS)));
    private static final Hand ONE_PAIR = new Hand(new ArrayList<>(Arrays.asList(TEN_SPADES,TEN_HEARTS,EIGHT_SPADES,SEVEN_HEARTS,FOUR_CLUBS)));
    private static final Hand HIGH_CARD = new Hand(new ArrayList<>(Arrays.asList(KING_DIAMONDS,QUEEN_DIAMONDS,SEVEN_SPADES,FOUR_SPADES,TWO_HEARTS)));


    @Test
    public void testFiveOfAKind() {
        assertThat(FIVE_OF_A_KIND.evaluateHandStrength()).isEqualTo(10);
    }

    @Test
    public void testStraightFlush() {
        assertThat(STRAIGHT_FLUSH.evaluateHandStrength()).isEqualTo(9);
    }

    @Test
    public void testFourOfAKind() {
        assertThat(FOUR_OF_A_KIND.evaluateHandStrength()).isEqualTo(8);
    }

    @Test
    public void testFullHouse() {
        assertThat(FULL_HOUSE.evaluateHandStrength()).isEqualTo(7);
    }

    @Test
    public void testFlush() {
        assertThat(FLUSH.evaluateHandStrength()).isEqualTo(6);
    }

    @Test
    public void testStraight() {
        assertThat(STRAIGHT.evaluateHandStrength()).isEqualTo(5);
    }

    @Test
    public void testStraightAceLow() {
        assertThat(STRAIGHT_ACE_LOW.evaluateHandStrength()).isEqualTo(5);
    }

    @Test
    public void testThreeOfAKind() {
        assertThat(THREE_OF_A_KIND.evaluateHandStrength()).isEqualTo(4);
    }

    @Test
    public void testTwoPair() {
        assertThat(TWO_PAIR.evaluateHandStrength()).isEqualTo(3);
    }

    @Test
    public void testOnePair() {
        assertThat(ONE_PAIR.evaluateHandStrength()).isEqualTo(2);
    }

    @Test
    public void testHighCard() {
        assertThat(HIGH_CARD.evaluateHandStrength()).isEqualTo(1);
    }


}
