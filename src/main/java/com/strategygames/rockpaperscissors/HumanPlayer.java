package com.strategygames.rockpaperscissors;

/**
 * Implementation of HumanPlayer
 */

public class HumanPlayer implements Player {
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;

    HumanPlayer() {
        numberOfWins = 0;
        numberOfLosses = 0;
        numberOfDraws = 0;
    }

    public int GetNumberOfWins() {
        return numberOfWins;
    }

    public int GetNumberOfLosses() {
        return numberOfLosses;
    }

    public int GetNumberOfDraws() {
        return numberOfDraws;
    }

    public void TieMatch() {
        numberOfDraws = numberOfDraws + 1;
    }

    public void WonMatch() {
        numberOfWins = numberOfWins + 1;
    }

    public void LoseMatch() {
        numberOfLosses = numberOfLosses + 1;
    }

    public int GetChoice() {
        System.out.println("Enter your Choice");
        System.out.println("1 => Rock, 2 => Paper, 3 => Scissors");
        return Utils.GetHumanChoice(Constants.MIN_HUMAN_CHOICE, Constants.MAX_HUMAN_CHOICE);
    }

}
