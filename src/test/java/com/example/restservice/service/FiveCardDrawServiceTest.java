package com.example.restservice.service;

import com.example.restservice.entity.Hand;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;


import static com.example.restservice.entity.Card.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiveCardDrawServiceTest {
    FiveCardDrawService fiveCardDrawService = new FiveCardDrawService();
    private static final Hand FIVE_OF_A_KIND = new Hand(new ArrayList<>(Arrays.asList(ACE_SPADES,ACE_CLUBS,ACE_HEARTS,ACE_DIAMONDS,ACE_CLUBS)));
    private static final Hand STRAIGHT_FLUSH = new Hand(new ArrayList<>(Arrays.asList(JACK_CLUBS,TEN_CLUBS,NINE_CLUBS,EIGHT_CLUBS,SEVEN_CLUBS)));
    private static final Hand FOUR_OF_A_KIND = new Hand(new ArrayList<>(Arrays.asList(FIVE_CLUBS,FIVE_DIAMONDS,FIVE_HEARTS,FIVE_SPADES,TWO_DIAMONDS)));
    private static final Hand FULL_HOUSE = new Hand(new ArrayList<>(Arrays.asList(SIX_SPADES,SIX_HEARTS,SIX_DIAMONDS,KING_SPADES,KING_HEARTS)));
    private static final Hand FLUSH = new Hand(new ArrayList<>(Arrays.asList(JACK_DIAMONDS,NINE_DIAMONDS,EIGHT_DIAMONDS,FOUR_DIAMONDS,THREE_DIAMONDS)));
    private static final Hand STRAIGHT = new Hand(new ArrayList<>(Arrays.asList(TEN_DIAMONDS,NINE_SPADES,EIGHT_HEARTS,SEVEN_DIAMONDS,SIX_CLUBS)));
    private static final Hand THREE_OF_A_KIND = new Hand(new ArrayList<>(Arrays.asList(QUEEN_CLUBS,QUEEN_SPADES,QUEEN_HEARTS,NINE_HEARTS,TWO_SPADES)));
    private static final Hand TWO_PAIR = new Hand(new ArrayList<>(Arrays.asList(JACK_HEARTS,JACK_SPADES,THREE_CLUBS,THREE_SPADES,TWO_HEARTS)));
    private static final Hand ONE_PAIR = new Hand(new ArrayList<>(Arrays.asList(TEN_SPADES,TEN_HEARTS,EIGHT_SPADES,SEVEN_HEARTS,FOUR_CLUBS)));
    private static final Hand HIGH_CARD = new Hand(new ArrayList<>(Arrays.asList(KING_DIAMONDS,QUEEN_DIAMONDS,SEVEN_SPADES,FOUR_SPADES,TWO_HEARTS)));


    @Test
    public void testEvaluateFiveCardDraw() {
        ArrayList<Hand> expectedResult = new ArrayList<>(Arrays.asList(
                FIVE_OF_A_KIND,
                STRAIGHT_FLUSH,
                FOUR_OF_A_KIND,
                FULL_HOUSE,
                FLUSH,
                STRAIGHT,
                THREE_OF_A_KIND,
                TWO_PAIR,
                ONE_PAIR,
                HIGH_CARD));
        ArrayList<Hand> reverseStrength = new ArrayList<>(Arrays.asList(
                HIGH_CARD,
                ONE_PAIR,
                TWO_PAIR,
                THREE_OF_A_KIND,
                STRAIGHT,
                FLUSH,
                FULL_HOUSE,
                FOUR_OF_A_KIND,
                STRAIGHT_FLUSH,
                FIVE_OF_A_KIND
        ));
        ArrayList<Hand> strengthSortedResult = fiveCardDrawService.evaluateFiveCardDraw(reverseStrength);
        assertEquals(strengthSortedResult,expectedResult);
    }
}
