package com.example.restservice.controller;

import com.example.restservice.entity.Hand;
import com.example.restservice.service.FiveCardDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = PokerController.PATH)
public class PokerController {
    public static final String PATH = "poker";
    @Autowired
    private FiveCardDrawService fiveCardDrawService;

    @PostMapping(value = "/evaluate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Hand> fiveCardDraw(@RequestBody ArrayList<Hand> hands) {
       // Allow for any number of hands to be compared
        return fiveCardDrawService.evaluateFiveCardDraw(hands);
    }

    //other endpoints could go here to evaluate 7 card hands
}