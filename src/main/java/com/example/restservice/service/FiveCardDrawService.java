package com.example.restservice.service;

import com.example.restservice.entity.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class FiveCardDrawService {
    final static Logger LOG = LoggerFactory.getLogger(FiveCardDrawService.class);

    public ArrayList<Hand> evaluateFiveCardDraw(ArrayList<Hand> hands ) {
        for (Hand hand : hands) {
            hand.evaluateHandStrength();
        }
        // Return the ranked hands with strength values
        Collections.sort(hands);
        LOG.debug("Hands sorted by strength = {}", hands);
        return hands;
    }

}
