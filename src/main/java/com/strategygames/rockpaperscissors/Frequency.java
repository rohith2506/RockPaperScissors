package com.strategygames.rockpaperscissors;

/*
 * Implementation of Frequency model.
 * This is a simple algorithm which counts number of times each item has been chosen by other player
 */

public class Frequency {

    private int RockCounter;
    private int PaperCounter;
    private int ScissorCounter;

    Frequency() {
        RockCounter = 0;
        PaperCounter = 0;
        ScissorCounter = 0;
    }

    public void UpdateFrequencyCounter(int Choice) {
        if(Choice == Constants.ROCK)
            RockCounter = RockCounter + 1;
        else if(Choice == Constants.PAPER)
            PaperCounter = PaperCounter + 1;
        else
            ScissorCounter = ScissorCounter + 1;
    }

    public int GetChoice() {
        if(RockCounter > PaperCounter && RockCounter > ScissorCounter)
            return Constants.PAPER;
        else if(PaperCounter > ScissorCounter)
            return Constants.SCISSORS;
        else
            return Constants.ROCK;
    }
}
